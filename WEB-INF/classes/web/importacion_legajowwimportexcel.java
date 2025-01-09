package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class importacion_legajowwimportexcel extends GXProcedure
{
   public importacion_legajowwimportexcel( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( importacion_legajowwimportexcel.class ), "" );
   }

   public importacion_legajowwimportexcel( int remoteHandle ,
                                           ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( String aP0 ,
                              String aP1 ,
                              GXBaseCollection<com.genexus.SdtMessages_Message>[] aP2 )
   {
      importacion_legajowwimportexcel.this.aP3 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( String aP0 ,
                        String aP1 ,
                        GXBaseCollection<com.genexus.SdtMessages_Message>[] aP2 ,
                        boolean[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( String aP0 ,
                             String aP1 ,
                             GXBaseCollection<com.genexus.SdtMessages_Message>[] aP2 ,
                             boolean[] aP3 )
   {
      importacion_legajowwimportexcel.this.AV22FilePath = aP0;
      importacion_legajowwimportexcel.this.AV29ExtraParmsJson = aP1;
      importacion_legajowwimportexcel.this.aP2 = aP2;
      importacion_legajowwimportexcel.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV26Messages = new GXBaseCollection<com.genexus.SdtMessages_Message>(com.genexus.SdtMessages_Message.class, "Message", "GeneXus", remoteHandle) ;
      GXt_boolean1 = AV46IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "SaveFilterAs", GXv_boolean2) ;
      importacion_legajowwimportexcel.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV46IsAuthorized = GXt_boolean1 ;
      if ( ! AV46IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV51Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      if ( AV46IsAuthorized )
      {
         AV20IsOk = true ;
         /* Execute user subroutine: 'INITIALIZE PARAMETERS' */
         S111 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         /* Execute user subroutine: 'LOAD EXTRA PARMETERS' */
         S271 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         if ( AV14DoDelete )
         {
            /* Execute user subroutine: 'GET ALL RECORDS' */
            S191 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         /* Execute user subroutine: 'PROCESS FILE' */
         S141 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         if ( AV20IsOk || ! AV21StopOnError )
         {
            /* Execute user subroutine: 'DELETE REMAINING RECORDS' */
            S251 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         if ( AV20IsOk )
         {
            /* Execute user subroutine: 'ADD SUCCESS MESSAGES' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
            /* Execute user subroutine: 'COMMIT UPDATES' */
            S131 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      else
      {
         AV20IsOk = false ;
         GXv_objcol_SdtMessages_Message3[0] = AV26Messages ;
         new web.wwpbaseobjects.wwp_addmessage(remoteHandle, context).execute( "WWP_Import_NotAuthorized", (byte)(1), httpContext.getMessage( "WWP_NotAuthorizedTitle", ""), GXv_objcol_SdtMessages_Message3) ;
         AV26Messages = GXv_objcol_SdtMessages_Message3[0] ;
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'INITIALIZE PARAMETERS' Routine */
      returnInSub = false ;
      AV21StopOnError = false ;
      AV14DoDelete = true ;
      AV16DoUpdate = true ;
      AV15DoInsert = true ;
      AV17ErrorIfKeyColumnNotFound = true ;
      AV18ErrorIfUnmachingColumns = true ;
   }

   public void S121( )
   {
      /* 'ADD SUCCESS MESSAGES' Routine */
      returnInSub = false ;
      if ( AV8AddedRecords > 0 )
      {
         GXv_objcol_SdtMessages_Message3[0] = AV26Messages ;
         new web.wwpbaseobjects.wwp_addmessage(remoteHandle, context).execute( "WWP_Import_AddedRecordsCount", (byte)(2), GXutil.format( httpContext.getMessage( "%1 records added.", ""), GXutil.trim( GXutil.str( AV8AddedRecords, 10, 0)), "", "", "", "", "", "", "", ""), GXv_objcol_SdtMessages_Message3) ;
         AV26Messages = GXv_objcol_SdtMessages_Message3[0] ;
      }
      if ( AV10UpdatedRecords > 0 )
      {
         GXv_objcol_SdtMessages_Message3[0] = AV26Messages ;
         new web.wwpbaseobjects.wwp_addmessage(remoteHandle, context).execute( "WWP_Import_UpdatedRecordsCount", (byte)(2), GXutil.format( httpContext.getMessage( "%1 records updated.", ""), GXutil.trim( GXutil.str( AV10UpdatedRecords, 10, 0)), "", "", "", "", "", "", "", ""), GXv_objcol_SdtMessages_Message3) ;
         AV26Messages = GXv_objcol_SdtMessages_Message3[0] ;
      }
      if ( AV9DeletedRecords > 0 )
      {
         GXv_objcol_SdtMessages_Message3[0] = AV26Messages ;
         new web.wwpbaseobjects.wwp_addmessage(remoteHandle, context).execute( "WWP_Import_DeletedRecordsCount", (byte)(2), GXutil.format( httpContext.getMessage( "%1 records deleted.", ""), GXutil.trim( GXutil.str( AV9DeletedRecords, 10, 0)), "", "", "", "", "", "", "", ""), GXv_objcol_SdtMessages_Message3) ;
         AV26Messages = GXv_objcol_SdtMessages_Message3[0] ;
      }
      if ( AV8AddedRecords + AV10UpdatedRecords + AV9DeletedRecords == 0 )
      {
         GXv_objcol_SdtMessages_Message3[0] = AV26Messages ;
         new web.wwpbaseobjects.wwp_addmessage(remoteHandle, context).execute( "WWP_Import_NoRecordsModified", (byte)(2), httpContext.getMessage( "No record was modified.", ""), GXv_objcol_SdtMessages_Message3) ;
         AV26Messages = GXv_objcol_SdtMessages_Message3[0] ;
      }
   }

   public void S131( )
   {
      /* 'COMMIT UPDATES' Routine */
      returnInSub = false ;
      Application.commitDataStores(context, remoteHandle, pr_default, "importacion_legajowwimportexcel");
   }

   public void S141( )
   {
      /* 'PROCESS FILE' Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'OPENDOCUMENT' */
      S151 ();
      if (returnInSub) return;
      AV24LineNumber = 1 ;
      if ( ( GXutil.strcmp(AV40ExcelDocument.Cells((int)(AV24LineNumber), 1, 1, 1).getText(), "") != 0 ) && ( GXutil.strcmp(AV40ExcelDocument.Cells((int)(AV24LineNumber), 2, 1, 1).getText(), "") == 0 ) && ( GXutil.strcmp(AV40ExcelDocument.Cells((int)(AV24LineNumber+1), 1, 1, 1).getText(), "") == 0 ) )
      {
         AV24LineNumber = (long)(AV24LineNumber+2) ;
      }
      AV41ContinueReading = true ;
      AV39ColumnTitlesFound = false ;
      while ( AV41ContinueReading )
      {
         if ( ! AV39ColumnTitlesFound )
         {
            if ( GXutil.strcmp(AV40ExcelDocument.Cells((int)(AV24LineNumber), 1, 1, 1).getText(), "") != 0 )
            {
               /* Execute user subroutine: 'GET TITLES POSITIONS' */
               S161 ();
               if (returnInSub) return;
               AV39ColumnTitlesFound = true ;
            }
            else
            {
               if ( AV24LineNumber > 50 )
               {
                  if ( GXutil.strcmp(AV40ExcelDocument.Cells(1, 1, 1, 1).getText(), "") != 0 )
                  {
                     AV24LineNumber = 0 ;
                  }
                  else
                  {
                     GXv_objcol_SdtMessages_Message3[0] = AV26Messages ;
                     new web.wwpbaseobjects.wwp_addmessage(remoteHandle, context).execute( "WWP_Import_TitlesNotFound", (byte)(1), httpContext.getMessage( "No column title was found.", ""), GXv_objcol_SdtMessages_Message3) ;
                     AV26Messages = GXv_objcol_SdtMessages_Message3[0] ;
                     AV41ContinueReading = false ;
                  }
               }
            }
         }
         else
         {
            AV42RowHasData = false ;
            AV43ColIndex = (short)(1) ;
            while ( AV43ColIndex <= AV11ColumnsCount )
            {
               if ( GXutil.strcmp(AV40ExcelDocument.Cells((int)(AV24LineNumber), AV43ColIndex, 1, 1).getText(), "") != 0 )
               {
                  AV42RowHasData = true ;
                  if (true) break;
               }
               AV43ColIndex = (short)(AV43ColIndex+1) ;
            }
            if ( AV42RowHasData )
            {
               /* Execute user subroutine: 'PROCESS LINE' */
               S171 ();
               if (returnInSub) return;
            }
            else
            {
               AV41ContinueReading = false ;
            }
         }
         AV24LineNumber = (long)(AV24LineNumber+1) ;
      }
      /* Execute user subroutine: 'CLOSEDOCUMENT' */
      S181 ();
      if (returnInSub) return;
   }

   public void S191( )
   {
      /* 'GET ALL RECORDS' Routine */
      returnInSub = false ;
      AV33CliCods = new GXSimpleCollection<Integer>(Integer.class, "internal", "") ;
      AV35EmpCods = new GXSimpleCollection<Short>(Short.class, "internal", "") ;
      AV37MigrLegNumeros = new GXSimpleCollection<Integer>(Integer.class, "internal", "") ;
      /* Using cursor P01TO2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV32CliCod), Short.valueOf(AV34EmpCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1EmpCod = P01TO2_A1EmpCod[0] ;
         A3CliCod = P01TO2_A3CliCod[0] ;
         A87MigrLegNumero = P01TO2_A87MigrLegNumero[0] ;
         AV33CliCods.add((int)(A3CliCod), 0);
         AV35EmpCods.add((short)(A1EmpCod), 0);
         AV37MigrLegNumeros.add((int)(A87MigrLegNumero), 0);
         pr_default.readNext(0);
      }
      pr_default.close(0);
   }

   public void S161( )
   {
      /* 'GET TITLES POSITIONS' Routine */
      returnInSub = false ;
      AV28TitleNames = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV28TitleNames.add(httpContext.getMessage( "Modificar", ""), 0);
      AV28TitleNames.add(httpContext.getMessage( "ID/Código", ""), 0);
      AV28TitleNames.add(httpContext.getMessage( "CUIL", ""), 0);
      AV28TitleNames.add(httpContext.getMessage( "Apellido", ""), 0);
      AV28TitleNames.add(httpContext.getMessage( "Nombres", ""), 0);
      AV28TitleNames.add(httpContext.getMessage( "Relación laboral", ""), 0);
      AV28TitleNames.add(httpContext.getMessage( "Tipo Tarifa", ""), 0);
      AV28TitleNames.add(httpContext.getMessage( "Frecuencia de pago", ""), 0);
      AV28TitleNames.add(httpContext.getMessage( "Fecha de Nacimiento", ""), 0);
      AV28TitleNames.add(httpContext.getMessage( "Fecha de ingreso", ""), 0);
      AV28TitleNames.add(httpContext.getMessage( "Género", ""), 0);
      AV28TitleNames.add(httpContext.getMessage( "Domicilio", ""), 0);
      AV28TitleNames.add(httpContext.getMessage( "Código Postal", ""), 0);
      AV28TitleNames.add(httpContext.getMessage( "Teléfono", ""), 0);
      AV28TitleNames.add(httpContext.getMessage( "Email", ""), 0);
      AV28TitleNames.add(httpContext.getMessage( "Estado Civil", ""), 0);
      AV28TitleNames.add(httpContext.getMessage( "Área", ""), 0);
      AV28TitleNames.add(httpContext.getMessage( "Sueldo fuera de convenio", ""), 0);
      AV28TitleNames.add(httpContext.getMessage( "Convenio", ""), 0);
      AV28TitleNames.add(httpContext.getMessage( "Categoría", ""), 0);
      AV28TitleNames.add(httpContext.getMessage( "Obra Social", ""), 0);
      AV28TitleNames.add(httpContext.getMessage( "CBU", ""), 0);
      AV28TitleNames.add(httpContext.getMessage( "Modalidad", ""), 0);
      AV28TitleNames.add(httpContext.getMessage( "Horas normales semanales", ""), 0);
      AV28TitleNames.add(httpContext.getMessage( "Observaciones", ""), 0);
      AV28TitleNames.add(httpContext.getMessage( "Sindicato", ""), 0);
      GXv_char4[0] = AV13DiscardedColumns ;
      GXv_objcol_int5[0] = AV27TitleIndexes ;
      GXv_int6[0] = AV11ColumnsCount ;
      GXv_int7[0] = AV12ColumnsFound ;
      new web.wwpbaseobjects.wwp_getimportexcelcolumnindexes(remoteHandle, context).execute( AV28TitleNames, AV40ExcelDocument, AV24LineNumber, GXv_char4, GXv_objcol_int5, GXv_int6, GXv_int7) ;
      importacion_legajowwimportexcel.this.AV13DiscardedColumns = GXv_char4[0] ;
      AV27TitleIndexes = GXv_objcol_int5[0] ;
      importacion_legajowwimportexcel.this.AV11ColumnsCount = GXv_int6[0] ;
      importacion_legajowwimportexcel.this.AV12ColumnsFound = GXv_int7[0] ;
      if ( ! (GXutil.strcmp("", AV13DiscardedColumns)==0) )
      {
         GXv_objcol_SdtMessages_Message3[0] = AV26Messages ;
         new web.wwpbaseobjects.wwp_addmessage(remoteHandle, context).execute( "WWP_Import_DiscardedColumns", (byte)((AV18ErrorIfUnmachingColumns ? 1 : 0)), GXutil.format( httpContext.getMessage( "The following columns do not match any column to import: %1.", ""), AV13DiscardedColumns, "", "", "", "", "", "", "", ""), GXv_objcol_SdtMessages_Message3) ;
         AV26Messages = GXv_objcol_SdtMessages_Message3[0] ;
         if ( AV18ErrorIfUnmachingColumns )
         {
            AV20IsOk = false ;
         }
      }
      if ( AV20IsOk && ( AV12ColumnsFound == 0 ) )
      {
         GXv_objcol_SdtMessages_Message3[0] = AV26Messages ;
         new web.wwpbaseobjects.wwp_addmessage(remoteHandle, context).execute( "WWP_Import_NoColumnFound", (byte)(1), httpContext.getMessage( "No column title was found.", ""), GXv_objcol_SdtMessages_Message3) ;
         AV26Messages = GXv_objcol_SdtMessages_Message3[0] ;
         AV20IsOk = false ;
      }
      AV21StopOnError = (boolean)(AV21StopOnError||!AV20IsOk) ;
      AV41ContinueReading = AV20IsOk ;
   }

   public void S171( )
   {
      /* 'PROCESS LINE' Routine */
      returnInSub = false ;
      AV19IsLineOk = true ;
      AV31importacion_legajo = (web.Sdtimportacion_legajo)new web.Sdtimportacion_legajo( remoteHandle, context);
      /* Execute user subroutine: 'LOAD KEY' */
      S201 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'FIND RECORD' */
      S211 ();
      if (returnInSub) return;
      if ( (0==AV23Index) )
      {
         if ( AV15DoInsert )
         {
            AV8AddedRecords = (long)(AV8AddedRecords+1) ;
         }
         else
         {
            GXv_objcol_SdtMessages_Message3[0] = AV26Messages ;
            new web.wwpbaseobjects.wwp_addimporterrormessage(remoteHandle, context).execute( GXv_objcol_SdtMessages_Message3, GXutil.trim( GXutil.str( AV24LineNumber, 10, 0)), "WWP_Import_RecordNotFound", httpContext.getMessage( "WWP_RecordNotFound", "")) ;
            AV26Messages = GXv_objcol_SdtMessages_Message3[0] ;
            AV19IsLineOk = false ;
         }
      }
      else
      {
         if ( AV16DoUpdate )
         {
            AV10UpdatedRecords = (long)(AV10UpdatedRecords+1) ;
            if ( AV14DoDelete )
            {
               /* Execute user subroutine: 'REMOVE RECORD FROM REMAININGS' */
               S221 ();
               if (returnInSub) return;
               AV31importacion_legajo.Load(AV32CliCod, AV34EmpCod, AV36MigrLegNumero);
            }
            if ( ! AV31importacion_legajo.Success() )
            {
               GXv_objcol_SdtMessages_Message3[0] = AV26Messages ;
               new web.wwpbaseobjects.wwp_addimporterrormessages(remoteHandle, context).execute( GXv_objcol_SdtMessages_Message3, GXutil.trim( GXutil.str( AV24LineNumber, 10, 0)), AV31importacion_legajo.GetMessages()) ;
               AV26Messages = GXv_objcol_SdtMessages_Message3[0] ;
               AV19IsLineOk = false ;
            }
         }
         else
         {
            GXv_objcol_SdtMessages_Message3[0] = AV26Messages ;
            new web.wwpbaseobjects.wwp_addimporterrormessage(remoteHandle, context).execute( GXv_objcol_SdtMessages_Message3, GXutil.trim( GXutil.str( AV24LineNumber, 10, 0)), "WWP_Import_RecordFound_NoUpdate", httpContext.getMessage( "Matching record found and Update not allowed.", "")) ;
            AV26Messages = GXv_objcol_SdtMessages_Message3[0] ;
            AV19IsLineOk = false ;
         }
      }
      if ( AV19IsLineOk )
      {
         /* Execute user subroutine: 'SET RECORD VALUES' */
         S231 ();
         if (returnInSub) return;
         /* Execute user subroutine: 'VALIDATE BEFORE SAVE' */
         S241 ();
         if (returnInSub) return;
         if ( AV19IsLineOk )
         {
            AV31importacion_legajo.Save();
            if ( ! AV31importacion_legajo.Success() )
            {
               GXv_objcol_SdtMessages_Message3[0] = AV26Messages ;
               new web.wwpbaseobjects.wwp_addimporterrormessages(remoteHandle, context).execute( GXv_objcol_SdtMessages_Message3, GXutil.trim( GXutil.str( AV24LineNumber, 10, 0)), AV31importacion_legajo.GetMessages()) ;
               AV26Messages = GXv_objcol_SdtMessages_Message3[0] ;
               AV19IsLineOk = false ;
            }
         }
      }
      AV20IsOk = (boolean)(AV20IsOk&&AV19IsLineOk) ;
      AV41ContinueReading = (boolean)((!AV21StopOnError||AV20IsOk)) ;
   }

   public void S231( )
   {
      /* 'SET RECORD VALUES' Routine */
      returnInSub = false ;
      if ( ((Number) AV27TitleIndexes.elementAt(-1+2)).shortValue() > 0 )
      {
         GXt_char8 = "" ;
         GXv_char4[0] = GXt_char8 ;
         new web.wwpbaseobjects.wwp_export_undosecuretext(remoteHandle, context).execute( AV40ExcelDocument.Cells((int)(AV24LineNumber), ((Number) AV27TitleIndexes.elementAt(-1+2)).shortValue(), 1, 1).getText(), GXv_char4) ;
         importacion_legajowwimportexcel.this.GXt_char8 = GXv_char4[0] ;
         AV31importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegid( GXt_char8 );
      }
      if ( ((Number) AV27TitleIndexes.elementAt(-1+3)).shortValue() > 0 )
      {
         GXt_char8 = "" ;
         GXv_char4[0] = GXt_char8 ;
         new web.wwpbaseobjects.wwp_export_undosecuretext(remoteHandle, context).execute( AV40ExcelDocument.Cells((int)(AV24LineNumber), ((Number) AV27TitleIndexes.elementAt(-1+3)).shortValue(), 1, 1).getText(), GXv_char4) ;
         importacion_legajowwimportexcel.this.GXt_char8 = GXv_char4[0] ;
         AV31importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegcuil( GXt_char8 );
      }
      if ( ((Number) AV27TitleIndexes.elementAt(-1+4)).shortValue() > 0 )
      {
         GXt_char8 = "" ;
         GXv_char4[0] = GXt_char8 ;
         new web.wwpbaseobjects.wwp_export_undosecuretext(remoteHandle, context).execute( AV40ExcelDocument.Cells((int)(AV24LineNumber), ((Number) AV27TitleIndexes.elementAt(-1+4)).shortValue(), 1, 1).getText(), GXv_char4) ;
         importacion_legajowwimportexcel.this.GXt_char8 = GXv_char4[0] ;
         AV31importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegapellido( GXt_char8 );
      }
      if ( ((Number) AV27TitleIndexes.elementAt(-1+5)).shortValue() > 0 )
      {
         GXt_char8 = "" ;
         GXv_char4[0] = GXt_char8 ;
         new web.wwpbaseobjects.wwp_export_undosecuretext(remoteHandle, context).execute( AV40ExcelDocument.Cells((int)(AV24LineNumber), ((Number) AV27TitleIndexes.elementAt(-1+5)).shortValue(), 1, 1).getText(), GXv_char4) ;
         importacion_legajowwimportexcel.this.GXt_char8 = GXv_char4[0] ;
         AV31importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegnombre( GXt_char8 );
      }
      if ( ((Number) AV27TitleIndexes.elementAt(-1+6)).shortValue() > 0 )
      {
         GXt_char8 = "" ;
         GXv_char4[0] = GXt_char8 ;
         new web.wwpbaseobjects.wwp_export_undosecuretext(remoteHandle, context).execute( AV40ExcelDocument.Cells((int)(AV24LineNumber), ((Number) AV27TitleIndexes.elementAt(-1+6)).shortValue(), 1, 1).getText(), GXv_char4) ;
         importacion_legajowwimportexcel.this.GXt_char8 = GXv_char4[0] ;
         AV31importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegmodtra( GXt_char8 );
      }
      if ( ((Number) AV27TitleIndexes.elementAt(-1+7)).shortValue() > 0 )
      {
         GXt_char8 = "" ;
         GXv_char4[0] = GXt_char8 ;
         new web.wwpbaseobjects.wwp_export_undosecuretext(remoteHandle, context).execute( AV40ExcelDocument.Cells((int)(AV24LineNumber), ((Number) AV27TitleIndexes.elementAt(-1+7)).shortValue(), 1, 1).getText(), GXv_char4) ;
         importacion_legajowwimportexcel.this.GXt_char8 = GXv_char4[0] ;
         AV31importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegtipotarifa( GXt_char8 );
      }
      if ( ((Number) AV27TitleIndexes.elementAt(-1+8)).shortValue() > 0 )
      {
         GXt_char8 = "" ;
         GXv_char4[0] = GXt_char8 ;
         new web.wwpbaseobjects.wwp_export_undosecuretext(remoteHandle, context).execute( AV40ExcelDocument.Cells((int)(AV24LineNumber), ((Number) AV27TitleIndexes.elementAt(-1+8)).shortValue(), 1, 1).getText(), GXv_char4) ;
         importacion_legajowwimportexcel.this.GXt_char8 = GXv_char4[0] ;
         AV31importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegclase( GXt_char8 );
      }
      if ( ((Number) AV27TitleIndexes.elementAt(-1+9)).shortValue() > 0 )
      {
         AV31importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegfecnac( AV40ExcelDocument.Cells((int)(AV24LineNumber), ((Number) AV27TitleIndexes.elementAt(-1+9)).shortValue(), 1, 1).getDate() );
      }
      if ( ((Number) AV27TitleIndexes.elementAt(-1+10)).shortValue() > 0 )
      {
         AV31importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegfecingreso( AV40ExcelDocument.Cells((int)(AV24LineNumber), ((Number) AV27TitleIndexes.elementAt(-1+10)).shortValue(), 1, 1).getDate() );
      }
      if ( ((Number) AV27TitleIndexes.elementAt(-1+11)).shortValue() > 0 )
      {
         GXt_char8 = "" ;
         GXv_char4[0] = GXt_char8 ;
         new web.wwpbaseobjects.wwp_export_undosecuretext(remoteHandle, context).execute( AV40ExcelDocument.Cells((int)(AV24LineNumber), ((Number) AV27TitleIndexes.elementAt(-1+11)).shortValue(), 1, 1).getText(), GXv_char4) ;
         importacion_legajowwimportexcel.this.GXt_char8 = GXv_char4[0] ;
         AV31importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegsexo( GXt_char8 );
      }
      if ( ((Number) AV27TitleIndexes.elementAt(-1+12)).shortValue() > 0 )
      {
         GXt_char8 = "" ;
         GXv_char4[0] = GXt_char8 ;
         new web.wwpbaseobjects.wwp_export_undosecuretext(remoteHandle, context).execute( AV40ExcelDocument.Cells((int)(AV24LineNumber), ((Number) AV27TitleIndexes.elementAt(-1+12)).shortValue(), 1, 1).getText(), GXv_char4) ;
         importacion_legajowwimportexcel.this.GXt_char8 = GXv_char4[0] ;
         AV31importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegdomici( GXt_char8 );
      }
      if ( ((Number) AV27TitleIndexes.elementAt(-1+13)).shortValue() > 0 )
      {
         GXt_char8 = "" ;
         GXv_char4[0] = GXt_char8 ;
         new web.wwpbaseobjects.wwp_export_undosecuretext(remoteHandle, context).execute( AV40ExcelDocument.Cells((int)(AV24LineNumber), ((Number) AV27TitleIndexes.elementAt(-1+13)).shortValue(), 1, 1).getText(), GXv_char4) ;
         importacion_legajowwimportexcel.this.GXt_char8 = GXv_char4[0] ;
         AV31importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegcodpos( GXt_char8 );
      }
      if ( ((Number) AV27TitleIndexes.elementAt(-1+14)).shortValue() > 0 )
      {
         GXt_char8 = "" ;
         GXv_char4[0] = GXt_char8 ;
         new web.wwpbaseobjects.wwp_export_undosecuretext(remoteHandle, context).execute( AV40ExcelDocument.Cells((int)(AV24LineNumber), ((Number) AV27TitleIndexes.elementAt(-1+14)).shortValue(), 1, 1).getText(), GXv_char4) ;
         importacion_legajowwimportexcel.this.GXt_char8 = GXv_char4[0] ;
         AV31importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegtelefono( GXt_char8 );
      }
      if ( ((Number) AV27TitleIndexes.elementAt(-1+15)).shortValue() > 0 )
      {
         GXt_char8 = "" ;
         GXv_char4[0] = GXt_char8 ;
         new web.wwpbaseobjects.wwp_export_undosecuretext(remoteHandle, context).execute( AV40ExcelDocument.Cells((int)(AV24LineNumber), ((Number) AV27TitleIndexes.elementAt(-1+15)).shortValue(), 1, 1).getText(), GXv_char4) ;
         importacion_legajowwimportexcel.this.GXt_char8 = GXv_char4[0] ;
         AV31importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegemail( GXt_char8 );
      }
      if ( ((Number) AV27TitleIndexes.elementAt(-1+16)).shortValue() > 0 )
      {
         GXt_char8 = "" ;
         GXv_char4[0] = GXt_char8 ;
         new web.wwpbaseobjects.wwp_export_undosecuretext(remoteHandle, context).execute( AV40ExcelDocument.Cells((int)(AV24LineNumber), ((Number) AV27TitleIndexes.elementAt(-1+16)).shortValue(), 1, 1).getText(), GXv_char4) ;
         importacion_legajowwimportexcel.this.GXt_char8 = GXv_char4[0] ;
         AV31importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegestadocivil( GXt_char8 );
      }
      if ( ((Number) AV27TitleIndexes.elementAt(-1+17)).shortValue() > 0 )
      {
         GXt_char8 = "" ;
         GXv_char4[0] = GXt_char8 ;
         new web.wwpbaseobjects.wwp_export_undosecuretext(remoteHandle, context).execute( AV40ExcelDocument.Cells((int)(AV24LineNumber), ((Number) AV27TitleIndexes.elementAt(-1+17)).shortValue(), 1, 1).getText(), GXv_char4) ;
         importacion_legajowwimportexcel.this.GXt_char8 = GXv_char4[0] ;
         AV31importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegarea( GXt_char8 );
      }
      if ( ((Number) AV27TitleIndexes.elementAt(-1+18)).shortValue() > 0 )
      {
         AV31importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegbasico( CommonUtil.decimalVal( AV40ExcelDocument.Cells((int)(AV24LineNumber), ((Number) AV27TitleIndexes.elementAt(-1+18)).shortValue(), 1, 1).getText(), ".") );
      }
      if ( ((Number) AV27TitleIndexes.elementAt(-1+19)).shortValue() > 0 )
      {
         GXt_char8 = "" ;
         GXv_char4[0] = GXt_char8 ;
         new web.wwpbaseobjects.wwp_export_undosecuretext(remoteHandle, context).execute( AV40ExcelDocument.Cells((int)(AV24LineNumber), ((Number) AV27TitleIndexes.elementAt(-1+19)).shortValue(), 1, 1).getText(), GXv_char4) ;
         importacion_legajowwimportexcel.this.GXt_char8 = GXv_char4[0] ;
         AV31importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegconvenio( GXt_char8 );
      }
      if ( ((Number) AV27TitleIndexes.elementAt(-1+20)).shortValue() > 0 )
      {
         GXt_char8 = "" ;
         GXv_char4[0] = GXt_char8 ;
         new web.wwpbaseobjects.wwp_export_undosecuretext(remoteHandle, context).execute( AV40ExcelDocument.Cells((int)(AV24LineNumber), ((Number) AV27TitleIndexes.elementAt(-1+20)).shortValue(), 1, 1).getText(), GXv_char4) ;
         importacion_legajowwimportexcel.this.GXt_char8 = GXv_char4[0] ;
         AV31importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegcategoria( GXt_char8 );
      }
      if ( ((Number) AV27TitleIndexes.elementAt(-1+21)).shortValue() > 0 )
      {
         GXt_char8 = "" ;
         GXv_char4[0] = GXt_char8 ;
         new web.wwpbaseobjects.wwp_export_undosecuretext(remoteHandle, context).execute( AV40ExcelDocument.Cells((int)(AV24LineNumber), ((Number) AV27TitleIndexes.elementAt(-1+21)).shortValue(), 1, 1).getText(), GXv_char4) ;
         importacion_legajowwimportexcel.this.GXt_char8 = GXv_char4[0] ;
         AV31importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegobrasocial( GXt_char8 );
      }
      if ( ((Number) AV27TitleIndexes.elementAt(-1+22)).shortValue() > 0 )
      {
         GXt_char8 = "" ;
         GXv_char4[0] = GXt_char8 ;
         new web.wwpbaseobjects.wwp_export_undosecuretext(remoteHandle, context).execute( AV40ExcelDocument.Cells((int)(AV24LineNumber), ((Number) AV27TitleIndexes.elementAt(-1+22)).shortValue(), 1, 1).getText(), GXv_char4) ;
         importacion_legajowwimportexcel.this.GXt_char8 = GXv_char4[0] ;
         AV31importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegcbu( GXt_char8 );
      }
      if ( ((Number) AV27TitleIndexes.elementAt(-1+23)).shortValue() > 0 )
      {
         GXt_char8 = "" ;
         GXv_char4[0] = GXt_char8 ;
         new web.wwpbaseobjects.wwp_export_undosecuretext(remoteHandle, context).execute( AV40ExcelDocument.Cells((int)(AV24LineNumber), ((Number) AV27TitleIndexes.elementAt(-1+23)).shortValue(), 1, 1).getText(), GXv_char4) ;
         importacion_legajowwimportexcel.this.GXt_char8 = GXv_char4[0] ;
         AV31importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegmodalidad( GXt_char8 );
      }
      if ( ((Number) AV27TitleIndexes.elementAt(-1+24)).shortValue() > 0 )
      {
         AV31importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrleghorsem( CommonUtil.decimalVal( AV40ExcelDocument.Cells((int)(AV24LineNumber), ((Number) AV27TitleIndexes.elementAt(-1+24)).shortValue(), 1, 1).getText(), ".") );
      }
      if ( ((Number) AV27TitleIndexes.elementAt(-1+25)).shortValue() > 0 )
      {
         GXt_char8 = "" ;
         GXv_char4[0] = GXt_char8 ;
         new web.wwpbaseobjects.wwp_export_undosecuretext(remoteHandle, context).execute( AV40ExcelDocument.Cells((int)(AV24LineNumber), ((Number) AV27TitleIndexes.elementAt(-1+25)).shortValue(), 1, 1).getText(), GXv_char4) ;
         importacion_legajowwimportexcel.this.GXt_char8 = GXv_char4[0] ;
         AV31importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegobs( GXt_char8 );
      }
      if ( ((Number) AV27TitleIndexes.elementAt(-1+26)).shortValue() > 0 )
      {
         GXt_char8 = "" ;
         GXv_char4[0] = GXt_char8 ;
         new web.wwpbaseobjects.wwp_export_undosecuretext(remoteHandle, context).execute( AV40ExcelDocument.Cells((int)(AV24LineNumber), ((Number) AV27TitleIndexes.elementAt(-1+26)).shortValue(), 1, 1).getText(), GXv_char4) ;
         importacion_legajowwimportexcel.this.GXt_char8 = GXv_char4[0] ;
         AV31importacion_legajo.setgxTv_Sdtimportacion_legajo_Migrlegsindicato( GXt_char8 );
      }
   }

   public void S221( )
   {
      /* 'REMOVE RECORD FROM REMAININGS' Routine */
      returnInSub = false ;
      AV33CliCods.removeItem((int)(AV23Index));
      AV35EmpCods.removeItem((int)(AV23Index));
      AV37MigrLegNumeros.removeItem((int)(AV23Index));
   }

   public void S201( )
   {
      /* 'LOAD KEY' Routine */
      returnInSub = false ;
   }

   public void S211( )
   {
      /* 'FIND RECORD' Routine */
      returnInSub = false ;
      if ( AV14DoDelete )
      {
         AV23Index = 0 ;
         AV38i = 1 ;
         while ( AV38i <= AV33CliCods.size() )
         {
            if ( ( ((Number) AV33CliCods.elementAt(-1+(int)(AV38i))).intValue() == AV32CliCod ) && ( ((Number) AV35EmpCods.elementAt(-1+(int)(AV38i))).shortValue() == AV34EmpCod ) && ( ((Number) AV37MigrLegNumeros.elementAt(-1+(int)(AV38i))).intValue() == AV36MigrLegNumero ) )
            {
               AV23Index = AV38i ;
               if (true) break;
            }
            AV38i = (long)(AV38i+1) ;
         }
      }
      else
      {
         AV31importacion_legajo.Load(AV32CliCod, AV34EmpCod, AV36MigrLegNumero);
         if ( AV31importacion_legajo.Success() )
         {
            AV23Index = 1 ;
         }
         else
         {
            AV23Index = 0 ;
         }
      }
   }

   public void S241( )
   {
      /* 'VALIDATE BEFORE SAVE' Routine */
      returnInSub = false ;
   }

   public void S251( )
   {
      /* 'DELETE REMAINING RECORDS' Routine */
      returnInSub = false ;
      AV9DeletedRecords = AV33CliCods.size() ;
      AV38i = 1 ;
      while ( AV38i <= AV33CliCods.size() )
      {
         AV32CliCod = ((Number) AV33CliCods.elementAt(-1+(int)(AV38i))).intValue() ;
         AV34EmpCod = ((Number) AV35EmpCods.elementAt(-1+(int)(AV38i))).shortValue() ;
         AV36MigrLegNumero = ((Number) AV37MigrLegNumeros.elementAt(-1+(int)(AV38i))).intValue() ;
         AV31importacion_legajo.Load(AV32CliCod, AV34EmpCod, AV36MigrLegNumero);
         if ( AV31importacion_legajo.Success() )
         {
            AV31importacion_legajo.Delete();
         }
         if ( ! AV31importacion_legajo.Success() )
         {
            GXv_objcol_SdtMessages_Message3[0] = AV26Messages ;
            new web.wwpbaseobjects.wwp_addimporterrormessages(remoteHandle, context).execute( GXv_objcol_SdtMessages_Message3, GXutil.format( httpContext.getMessage( "(Deleting %1)", ""), httpContext.getMessage( "Cli Cod", "")+": "+GXutil.trim( GXutil.str( AV32CliCod, 6, 0))+", "+httpContext.getMessage( "Empresa", "")+": "+GXutil.trim( GXutil.str( AV34EmpCod, 4, 0))+", "+httpContext.getMessage( "Migr Leg Numero", "")+": "+GXutil.trim( GXutil.str( AV36MigrLegNumero, 8, 0)), "", "", "", "", "", "", "", ""), AV31importacion_legajo.GetMessages()) ;
            AV26Messages = GXv_objcol_SdtMessages_Message3[0] ;
            AV20IsOk = false ;
            if ( AV21StopOnError )
            {
               if (true) break;
            }
         }
         AV38i = (long)(AV38i+1) ;
      }
   }

   public void S151( )
   {
      /* 'OPENDOCUMENT' Routine */
      returnInSub = false ;
      AV40ExcelDocument.Open(AV22FilePath);
      /* Execute user subroutine: 'CHECKSTATUS' */
      S261 ();
      if (returnInSub) return;
   }

   public void S181( )
   {
      /* 'CLOSEDOCUMENT' Routine */
      returnInSub = false ;
      AV40ExcelDocument.Close();
   }

   public void S261( )
   {
      /* 'CHECKSTATUS' Routine */
      returnInSub = false ;
      if ( AV40ExcelDocument.getErrCode() != 0 )
      {
         GXv_objcol_SdtMessages_Message3[0] = AV26Messages ;
         new web.wwpbaseobjects.wwp_addmessage(remoteHandle, context).execute( httpContext.getMessage( "WWP_ErrorExcelDocument", ""), (byte)(1), AV40ExcelDocument.getErrDescription(), GXv_objcol_SdtMessages_Message3) ;
         AV26Messages = GXv_objcol_SdtMessages_Message3[0] ;
         AV40ExcelDocument.Close();
         returnInSub = true;
         if (true) return;
      }
   }

   public void S271( )
   {
      /* 'LOAD EXTRA PARMETERS' Routine */
      returnInSub = false ;
      AV30ExtraParms.fromJSonString(AV29ExtraParmsJson, null);
      if ( AV30ExtraParms.size() == 1 )
      {
         AV45MenuOpcCod = (String)AV30ExtraParms.elementAt(-1+1) ;
      }
   }

   protected void cleanup( )
   {
      this.aP2[0] = importacion_legajowwimportexcel.this.AV26Messages;
      this.aP3[0] = importacion_legajowwimportexcel.this.AV20IsOk;
      CloseOpenCursors();
      AV40ExcelDocument.cleanup();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV26Messages = new GXBaseCollection<com.genexus.SdtMessages_Message>(com.genexus.SdtMessages_Message.class, "Message", "GeneXus", remoteHandle);
      GXv_boolean2 = new boolean[1] ;
      AV51Pgmname = "" ;
      AV40ExcelDocument = new com.genexus.gxoffice.ExcelDoc();
      AV33CliCods = new GXSimpleCollection<Integer>(Integer.class, "internal", "");
      AV35EmpCods = new GXSimpleCollection<Short>(Short.class, "internal", "");
      AV37MigrLegNumeros = new GXSimpleCollection<Integer>(Integer.class, "internal", "");
      scmdbuf = "" ;
      P01TO2_A1EmpCod = new short[1] ;
      P01TO2_A3CliCod = new int[1] ;
      P01TO2_A87MigrLegNumero = new int[1] ;
      AV28TitleNames = new GXSimpleCollection<String>(String.class, "internal", "");
      AV13DiscardedColumns = "" ;
      AV27TitleIndexes = new GXSimpleCollection<Short>(Short.class, "internal", "");
      GXv_objcol_int5 = new GXSimpleCollection[1] ;
      GXv_int6 = new short[1] ;
      GXv_int7 = new short[1] ;
      AV31importacion_legajo = new web.Sdtimportacion_legajo(remoteHandle);
      GXt_char8 = "" ;
      GXv_char4 = new String[1] ;
      GXv_objcol_SdtMessages_Message3 = new GXBaseCollection[1] ;
      AV30ExtraParms = new GXSimpleCollection<String>(String.class, "internal", "");
      AV45MenuOpcCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.importacion_legajowwimportexcel__default(),
         new Object[] {
             new Object[] {
            P01TO2_A1EmpCod, P01TO2_A3CliCod, P01TO2_A87MigrLegNumero
            }
         }
      );
      AV51Pgmname = "importacion_legajoWWImportExcel" ;
      /* GeneXus formulas. */
      AV51Pgmname = "importacion_legajoWWImportExcel" ;
      Gx_err = (short)(0) ;
   }

   private short AV43ColIndex ;
   private short AV11ColumnsCount ;
   private short AV34EmpCod ;
   private short A1EmpCod ;
   private short GXv_int6[] ;
   private short AV12ColumnsFound ;
   private short GXv_int7[] ;
   private short Gx_err ;
   private int AV32CliCod ;
   private int A3CliCod ;
   private int A87MigrLegNumero ;
   private int AV36MigrLegNumero ;
   private long AV8AddedRecords ;
   private long AV10UpdatedRecords ;
   private long AV9DeletedRecords ;
   private long AV24LineNumber ;
   private long AV23Index ;
   private long AV38i ;
   private String AV51Pgmname ;
   private String scmdbuf ;
   private String GXt_char8 ;
   private String GXv_char4[] ;
   private boolean AV20IsOk ;
   private boolean AV46IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean AV14DoDelete ;
   private boolean AV21StopOnError ;
   private boolean AV16DoUpdate ;
   private boolean AV15DoInsert ;
   private boolean AV17ErrorIfKeyColumnNotFound ;
   private boolean AV18ErrorIfUnmachingColumns ;
   private boolean AV41ContinueReading ;
   private boolean AV39ColumnTitlesFound ;
   private boolean AV42RowHasData ;
   private boolean AV19IsLineOk ;
   private String AV22FilePath ;
   private String AV29ExtraParmsJson ;
   private String AV13DiscardedColumns ;
   private String AV45MenuOpcCod ;
   private GXSimpleCollection<Short> AV35EmpCods ;
   private GXSimpleCollection<Short> AV27TitleIndexes ;
   private GXSimpleCollection<Short> GXv_objcol_int5[] ;
   private GXSimpleCollection<Integer> AV33CliCods ;
   private GXSimpleCollection<Integer> AV37MigrLegNumeros ;
   private boolean[] aP3 ;
   private GXBaseCollection<com.genexus.SdtMessages_Message>[] aP2 ;
   private IDataStoreProvider pr_default ;
   private short[] P01TO2_A1EmpCod ;
   private int[] P01TO2_A3CliCod ;
   private int[] P01TO2_A87MigrLegNumero ;
   private com.genexus.gxoffice.ExcelDoc AV40ExcelDocument ;
   private GXSimpleCollection<String> AV28TitleNames ;
   private GXSimpleCollection<String> AV30ExtraParms ;
   private GXBaseCollection<com.genexus.SdtMessages_Message> AV26Messages ;
   private GXBaseCollection<com.genexus.SdtMessages_Message> GXv_objcol_SdtMessages_Message3[] ;
   private web.Sdtimportacion_legajo AV31importacion_legajo ;
}

final  class importacion_legajowwimportexcel__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01TO2", "SELECT EmpCod, CliCod, MigrLegNumero FROM importacion_legajo WHERE CliCod = ? and EmpCod = ? ORDER BY CliCod, EmpCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
      }
   }

}

