package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class agendanovedadeswwimportexcel extends GXProcedure
{
   public agendanovedadeswwimportexcel( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( agendanovedadeswwimportexcel.class ), "" );
   }

   public agendanovedadeswwimportexcel( int remoteHandle ,
                                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( String aP0 ,
                              String aP1 ,
                              GXBaseCollection<com.genexus.SdtMessages_Message>[] aP2 )
   {
      agendanovedadeswwimportexcel.this.aP3 = new boolean[] {false};
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
      agendanovedadeswwimportexcel.this.AV22FilePath = aP0;
      agendanovedadeswwimportexcel.this.AV29ExtraParmsJson = aP1;
      agendanovedadeswwimportexcel.this.aP2 = aP2;
      agendanovedadeswwimportexcel.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV26Messages = new GXBaseCollection<com.genexus.SdtMessages_Message>(com.genexus.SdtMessages_Message.class, "Message", "GeneXus", remoteHandle) ;
      GXt_boolean1 = AV50Isauthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "SaveFilterAs", GXv_boolean2) ;
      agendanovedadeswwimportexcel.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV50Isauthorized = GXt_boolean1 ;
      if ( ! AV50Isauthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV51Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      if ( AV50Isauthorized )
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
      Application.commitDataStores(context, remoteHandle, pr_default, "agendanovedadeswwimportexcel");
   }

   public void S141( )
   {
      /* 'PROCESS FILE' Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'OPENDOCUMENT' */
      S151 ();
      if (returnInSub) return;
      AV24LineNumber = 1 ;
      if ( ( GXutil.strcmp(AV42ExcelDocument.Cells((int)(AV24LineNumber), 1, 1, 1).getText(), "") != 0 ) && ( GXutil.strcmp(AV42ExcelDocument.Cells((int)(AV24LineNumber), 2, 1, 1).getText(), "") == 0 ) && ( GXutil.strcmp(AV42ExcelDocument.Cells((int)(AV24LineNumber+1), 1, 1, 1).getText(), "") == 0 ) )
      {
         AV24LineNumber = (long)(AV24LineNumber+2) ;
      }
      AV43ContinueReading = true ;
      AV41ColumnTitlesFound = false ;
      while ( AV43ContinueReading )
      {
         if ( ! AV41ColumnTitlesFound )
         {
            if ( GXutil.strcmp(AV42ExcelDocument.Cells((int)(AV24LineNumber), 1, 1, 1).getText(), "") != 0 )
            {
               /* Execute user subroutine: 'GET TITLES POSITIONS' */
               S161 ();
               if (returnInSub) return;
               AV41ColumnTitlesFound = true ;
            }
            else
            {
               if ( AV24LineNumber > 50 )
               {
                  if ( GXutil.strcmp(AV42ExcelDocument.Cells(1, 1, 1, 1).getText(), "") != 0 )
                  {
                     AV24LineNumber = 0 ;
                  }
                  else
                  {
                     GXv_objcol_SdtMessages_Message3[0] = AV26Messages ;
                     new web.wwpbaseobjects.wwp_addmessage(remoteHandle, context).execute( "WWP_Import_TitlesNotFound", (byte)(1), httpContext.getMessage( "No column title was found.", ""), GXv_objcol_SdtMessages_Message3) ;
                     AV26Messages = GXv_objcol_SdtMessages_Message3[0] ;
                     AV43ContinueReading = false ;
                  }
               }
            }
         }
         else
         {
            AV44RowHasData = false ;
            AV45ColIndex = (short)(1) ;
            while ( AV45ColIndex <= AV11ColumnsCount )
            {
               if ( GXutil.strcmp(AV42ExcelDocument.Cells((int)(AV24LineNumber), AV45ColIndex, 1, 1).getText(), "") != 0 )
               {
                  AV44RowHasData = true ;
                  if (true) break;
               }
               AV45ColIndex = (short)(AV45ColIndex+1) ;
            }
            if ( AV44RowHasData )
            {
               /* Execute user subroutine: 'PROCESS LINE' */
               S171 ();
               if (returnInSub) return;
            }
            else
            {
               AV43ContinueReading = false ;
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
      AV37LegNumeros = new GXSimpleCollection<Integer>(Integer.class, "internal", "") ;
      AV39AgeOrdens = new GXSimpleCollection<Short>(Short.class, "internal", "") ;
      /* Using cursor P008X2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV32CliCod), Short.valueOf(AV34EmpCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1EmpCod = P008X2_A1EmpCod[0] ;
         A3CliCod = P008X2_A3CliCod[0] ;
         A6LegNumero = P008X2_A6LegNumero[0] ;
         A25AgeOrden = P008X2_A25AgeOrden[0] ;
         AV33CliCods.add((int)(A3CliCod), 0);
         AV35EmpCods.add((short)(A1EmpCod), 0);
         AV37LegNumeros.add((int)(A6LegNumero), 0);
         AV39AgeOrdens.add((short)(A25AgeOrden), 0);
         pr_default.readNext(0);
      }
      pr_default.close(0);
   }

   public void S161( )
   {
      /* 'GET TITLES POSITIONS' Routine */
      returnInSub = false ;
      AV28TitleNames = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV28TitleNames.add(httpContext.getMessage( "Legajo", ""), 0);
      AV28TitleNames.add(httpContext.getMessage( "Concepto", ""), 0);
      AV28TitleNames.add("", 0);
      AV28TitleNames.add(httpContext.getMessage( "Cantidad", ""), 0);
      AV28TitleNames.add(httpContext.getMessage( "Valor Unitario", ""), 0);
      AV28TitleNames.add(httpContext.getMessage( "Importe", ""), 0);
      AV28TitleNames.add(httpContext.getMessage( "Desde", ""), 0);
      AV28TitleNames.add(httpContext.getMessage( "Hasta", ""), 0);
      GXv_char4[0] = AV13DiscardedColumns ;
      GXv_objcol_int5[0] = AV27TitleIndexes ;
      GXv_int6[0] = AV11ColumnsCount ;
      GXv_int7[0] = AV12ColumnsFound ;
      new web.wwpbaseobjects.wwp_getimportexcelcolumnindexes(remoteHandle, context).execute( AV28TitleNames, AV42ExcelDocument, AV24LineNumber, GXv_char4, GXv_objcol_int5, GXv_int6, GXv_int7) ;
      agendanovedadeswwimportexcel.this.AV13DiscardedColumns = GXv_char4[0] ;
      AV27TitleIndexes = GXv_objcol_int5[0] ;
      agendanovedadeswwimportexcel.this.AV11ColumnsCount = GXv_int6[0] ;
      agendanovedadeswwimportexcel.this.AV12ColumnsFound = GXv_int7[0] ;
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
      AV43ContinueReading = AV20IsOk ;
   }

   public void S171( )
   {
      /* 'PROCESS LINE' Routine */
      returnInSub = false ;
      AV19IsLineOk = true ;
      AV31AgendaNovedades = (web.SdtAgendaNovedades)new web.SdtAgendaNovedades( remoteHandle, context);
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
               AV31AgendaNovedades.Load(AV32CliCod, AV34EmpCod, AV36LegNumero, AV38AgeOrden);
            }
            if ( ! AV31AgendaNovedades.Success() )
            {
               GXv_objcol_SdtMessages_Message3[0] = AV26Messages ;
               new web.wwpbaseobjects.wwp_addimporterrormessages(remoteHandle, context).execute( GXv_objcol_SdtMessages_Message3, GXutil.trim( GXutil.str( AV24LineNumber, 10, 0)), AV31AgendaNovedades.GetMessages()) ;
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
            AV31AgendaNovedades.Save();
            if ( ! AV31AgendaNovedades.Success() )
            {
               GXv_objcol_SdtMessages_Message3[0] = AV26Messages ;
               new web.wwpbaseobjects.wwp_addimporterrormessages(remoteHandle, context).execute( GXv_objcol_SdtMessages_Message3, GXutil.trim( GXutil.str( AV24LineNumber, 10, 0)), AV31AgendaNovedades.GetMessages()) ;
               AV26Messages = GXv_objcol_SdtMessages_Message3[0] ;
               AV19IsLineOk = false ;
            }
         }
      }
      AV20IsOk = (boolean)(AV20IsOk&&AV19IsLineOk) ;
      AV43ContinueReading = (boolean)((!AV21StopOnError||AV20IsOk)) ;
   }

   public void S231( )
   {
      /* 'SET RECORD VALUES' Routine */
      returnInSub = false ;
      if ( ((Number) AV27TitleIndexes.elementAt(-1+2)).shortValue() > 0 )
      {
         GXt_char8 = "" ;
         GXv_char4[0] = GXt_char8 ;
         new web.wwpbaseobjects.wwp_export_undosecuretext(remoteHandle, context).execute( AV42ExcelDocument.Cells((int)(AV24LineNumber), ((Number) AV27TitleIndexes.elementAt(-1+2)).shortValue(), 1, 1).getText(), GXv_char4) ;
         agendanovedadeswwimportexcel.this.GXt_char8 = GXv_char4[0] ;
         AV31AgendaNovedades.setgxTv_SdtAgendaNovedades_Concodigo( GXt_char8 );
      }
      if ( ((Number) AV27TitleIndexes.elementAt(-1+4)).shortValue() > 0 )
      {
         AV31AgendaNovedades.setgxTv_SdtAgendaNovedades_Agecanti( CommonUtil.decimalVal( AV42ExcelDocument.Cells((int)(AV24LineNumber), ((Number) AV27TitleIndexes.elementAt(-1+4)).shortValue(), 1, 1).getText(), ".") );
      }
      if ( ((Number) AV27TitleIndexes.elementAt(-1+5)).shortValue() > 0 )
      {
         AV31AgendaNovedades.setgxTv_SdtAgendaNovedades_Agevunit( CommonUtil.decimalVal( AV42ExcelDocument.Cells((int)(AV24LineNumber), ((Number) AV27TitleIndexes.elementAt(-1+5)).shortValue(), 1, 1).getText(), ".") );
      }
      if ( ((Number) AV27TitleIndexes.elementAt(-1+6)).shortValue() > 0 )
      {
         AV31AgendaNovedades.setgxTv_SdtAgendaNovedades_Ageimporte( CommonUtil.decimalVal( AV42ExcelDocument.Cells((int)(AV24LineNumber), ((Number) AV27TitleIndexes.elementAt(-1+6)).shortValue(), 1, 1).getText(), ".") );
      }
      if ( ((Number) AV27TitleIndexes.elementAt(-1+7)).shortValue() > 0 )
      {
         AV31AgendaNovedades.setgxTv_SdtAgendaNovedades_Agefecdes( AV42ExcelDocument.Cells((int)(AV24LineNumber), ((Number) AV27TitleIndexes.elementAt(-1+7)).shortValue(), 1, 1).getDate() );
      }
      if ( ((Number) AV27TitleIndexes.elementAt(-1+8)).shortValue() > 0 )
      {
         AV31AgendaNovedades.setgxTv_SdtAgendaNovedades_Agefechas( AV42ExcelDocument.Cells((int)(AV24LineNumber), ((Number) AV27TitleIndexes.elementAt(-1+8)).shortValue(), 1, 1).getDate() );
      }
   }

   public void S221( )
   {
      /* 'REMOVE RECORD FROM REMAININGS' Routine */
      returnInSub = false ;
      AV33CliCods.removeItem((int)(AV23Index));
      AV35EmpCods.removeItem((int)(AV23Index));
      AV37LegNumeros.removeItem((int)(AV23Index));
      AV39AgeOrdens.removeItem((int)(AV23Index));
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
         AV40i = 1 ;
         while ( AV40i <= AV33CliCods.size() )
         {
            if ( ( ((Number) AV33CliCods.elementAt(-1+(int)(AV40i))).intValue() == AV32CliCod ) && ( ((Number) AV35EmpCods.elementAt(-1+(int)(AV40i))).shortValue() == AV34EmpCod ) && ( ((Number) AV37LegNumeros.elementAt(-1+(int)(AV40i))).intValue() == AV36LegNumero ) && ( ((Number) AV39AgeOrdens.elementAt(-1+(int)(AV40i))).shortValue() == AV38AgeOrden ) )
            {
               AV23Index = AV40i ;
               if (true) break;
            }
            AV40i = (long)(AV40i+1) ;
         }
      }
      else
      {
         AV31AgendaNovedades.Load(AV32CliCod, AV34EmpCod, AV36LegNumero, AV38AgeOrden);
         if ( AV31AgendaNovedades.Success() )
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
      AV40i = 1 ;
      while ( AV40i <= AV33CliCods.size() )
      {
         AV32CliCod = ((Number) AV33CliCods.elementAt(-1+(int)(AV40i))).intValue() ;
         AV34EmpCod = ((Number) AV35EmpCods.elementAt(-1+(int)(AV40i))).shortValue() ;
         AV36LegNumero = ((Number) AV37LegNumeros.elementAt(-1+(int)(AV40i))).intValue() ;
         AV38AgeOrden = ((Number) AV39AgeOrdens.elementAt(-1+(int)(AV40i))).shortValue() ;
         AV31AgendaNovedades.Load(AV32CliCod, AV34EmpCod, AV36LegNumero, AV38AgeOrden);
         if ( AV31AgendaNovedades.Success() )
         {
            AV31AgendaNovedades.Delete();
         }
         if ( ! AV31AgendaNovedades.Success() )
         {
            GXv_objcol_SdtMessages_Message3[0] = AV26Messages ;
            new web.wwpbaseobjects.wwp_addimporterrormessages(remoteHandle, context).execute( GXv_objcol_SdtMessages_Message3, GXutil.format( httpContext.getMessage( "(Deleting %1)", ""), httpContext.getMessage( "Cli Cod", "")+": "+GXutil.trim( GXutil.str( AV32CliCod, 6, 0))+", "+httpContext.getMessage( "Empresa", "")+": "+GXutil.trim( GXutil.str( AV34EmpCod, 4, 0))+", "+httpContext.getMessage( "Legajo", "")+": "+GXutil.trim( GXutil.str( AV36LegNumero, 8, 0))+", "+httpContext.getMessage( "Orden", "")+": "+GXutil.trim( GXutil.str( AV38AgeOrden, 4, 0)), "", "", "", "", "", "", "", ""), AV31AgendaNovedades.GetMessages()) ;
            AV26Messages = GXv_objcol_SdtMessages_Message3[0] ;
            AV20IsOk = false ;
            if ( AV21StopOnError )
            {
               if (true) break;
            }
         }
         AV40i = (long)(AV40i+1) ;
      }
   }

   public void S151( )
   {
      /* 'OPENDOCUMENT' Routine */
      returnInSub = false ;
      AV42ExcelDocument.Open(AV22FilePath);
      /* Execute user subroutine: 'CHECKSTATUS' */
      S261 ();
      if (returnInSub) return;
   }

   public void S181( )
   {
      /* 'CLOSEDOCUMENT' Routine */
      returnInSub = false ;
      AV42ExcelDocument.Close();
   }

   public void S261( )
   {
      /* 'CHECKSTATUS' Routine */
      returnInSub = false ;
      if ( AV42ExcelDocument.getErrCode() != 0 )
      {
         GXv_objcol_SdtMessages_Message3[0] = AV26Messages ;
         new web.wwpbaseobjects.wwp_addmessage(remoteHandle, context).execute( httpContext.getMessage( "WWP_ErrorExcelDocument", ""), (byte)(1), AV42ExcelDocument.getErrDescription(), GXv_objcol_SdtMessages_Message3) ;
         AV26Messages = GXv_objcol_SdtMessages_Message3[0] ;
         AV42ExcelDocument.Close();
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
         AV47MenuOpcCod = (String)AV30ExtraParms.elementAt(-1+1) ;
      }
   }

   protected void cleanup( )
   {
      this.aP2[0] = agendanovedadeswwimportexcel.this.AV26Messages;
      this.aP3[0] = agendanovedadeswwimportexcel.this.AV20IsOk;
      CloseOpenCursors();
      AV42ExcelDocument.cleanup();
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
      AV42ExcelDocument = new com.genexus.gxoffice.ExcelDoc();
      AV33CliCods = new GXSimpleCollection<Integer>(Integer.class, "internal", "");
      AV35EmpCods = new GXSimpleCollection<Short>(Short.class, "internal", "");
      AV37LegNumeros = new GXSimpleCollection<Integer>(Integer.class, "internal", "");
      AV39AgeOrdens = new GXSimpleCollection<Short>(Short.class, "internal", "");
      scmdbuf = "" ;
      P008X2_A1EmpCod = new short[1] ;
      P008X2_A3CliCod = new int[1] ;
      P008X2_A6LegNumero = new int[1] ;
      P008X2_A25AgeOrden = new short[1] ;
      AV28TitleNames = new GXSimpleCollection<String>(String.class, "internal", "");
      AV13DiscardedColumns = "" ;
      AV27TitleIndexes = new GXSimpleCollection<Short>(Short.class, "internal", "");
      GXv_objcol_int5 = new GXSimpleCollection[1] ;
      GXv_int6 = new short[1] ;
      GXv_int7 = new short[1] ;
      AV31AgendaNovedades = new web.SdtAgendaNovedades(remoteHandle);
      GXt_char8 = "" ;
      GXv_char4 = new String[1] ;
      GXv_objcol_SdtMessages_Message3 = new GXBaseCollection[1] ;
      AV30ExtraParms = new GXSimpleCollection<String>(String.class, "internal", "");
      AV47MenuOpcCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.agendanovedadeswwimportexcel__default(),
         new Object[] {
             new Object[] {
            P008X2_A1EmpCod, P008X2_A3CliCod, P008X2_A6LegNumero, P008X2_A25AgeOrden
            }
         }
      );
      AV51Pgmname = "AgendaNovedadesWWImportExcel" ;
      /* GeneXus formulas. */
      AV51Pgmname = "AgendaNovedadesWWImportExcel" ;
      Gx_err = (short)(0) ;
   }

   private short AV45ColIndex ;
   private short AV11ColumnsCount ;
   private short AV34EmpCod ;
   private short A1EmpCod ;
   private short A25AgeOrden ;
   private short GXv_int6[] ;
   private short AV12ColumnsFound ;
   private short GXv_int7[] ;
   private short AV38AgeOrden ;
   private short Gx_err ;
   private int AV32CliCod ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private int AV36LegNumero ;
   private long AV8AddedRecords ;
   private long AV10UpdatedRecords ;
   private long AV9DeletedRecords ;
   private long AV24LineNumber ;
   private long AV23Index ;
   private long AV40i ;
   private String AV51Pgmname ;
   private String scmdbuf ;
   private String GXt_char8 ;
   private String GXv_char4[] ;
   private boolean AV20IsOk ;
   private boolean AV50Isauthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean AV14DoDelete ;
   private boolean AV21StopOnError ;
   private boolean AV16DoUpdate ;
   private boolean AV15DoInsert ;
   private boolean AV17ErrorIfKeyColumnNotFound ;
   private boolean AV18ErrorIfUnmachingColumns ;
   private boolean AV43ContinueReading ;
   private boolean AV41ColumnTitlesFound ;
   private boolean AV44RowHasData ;
   private boolean AV19IsLineOk ;
   private String AV22FilePath ;
   private String AV29ExtraParmsJson ;
   private String AV13DiscardedColumns ;
   private String AV47MenuOpcCod ;
   private GXSimpleCollection<Short> AV35EmpCods ;
   private GXSimpleCollection<Short> AV39AgeOrdens ;
   private GXSimpleCollection<Short> AV27TitleIndexes ;
   private GXSimpleCollection<Short> GXv_objcol_int5[] ;
   private GXSimpleCollection<Integer> AV33CliCods ;
   private GXSimpleCollection<Integer> AV37LegNumeros ;
   private boolean[] aP3 ;
   private GXBaseCollection<com.genexus.SdtMessages_Message>[] aP2 ;
   private IDataStoreProvider pr_default ;
   private short[] P008X2_A1EmpCod ;
   private int[] P008X2_A3CliCod ;
   private int[] P008X2_A6LegNumero ;
   private short[] P008X2_A25AgeOrden ;
   private com.genexus.gxoffice.ExcelDoc AV42ExcelDocument ;
   private GXSimpleCollection<String> AV28TitleNames ;
   private GXSimpleCollection<String> AV30ExtraParms ;
   private GXBaseCollection<com.genexus.SdtMessages_Message> AV26Messages ;
   private GXBaseCollection<com.genexus.SdtMessages_Message> GXv_objcol_SdtMessages_Message3[] ;
   private web.SdtAgendaNovedades AV31AgendaNovedades ;
}

final  class agendanovedadeswwimportexcel__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P008X2", "SELECT EmpCod, CliCod, LegNumero, AgeOrden FROM AgendaNovedades WHERE CliCod = ? and EmpCod = ? ORDER BY CliCod, EmpCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((short[]) buf[3])[0] = rslt.getShort(4);
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

