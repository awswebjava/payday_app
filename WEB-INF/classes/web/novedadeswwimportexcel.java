package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class novedadeswwimportexcel extends GXProcedure
{
   public novedadeswwimportexcel( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( novedadeswwimportexcel.class ), "" );
   }

   public novedadeswwimportexcel( int remoteHandle ,
                                  ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( String aP0 ,
                              String aP1 ,
                              GXBaseCollection<com.genexus.SdtMessages_Message>[] aP2 )
   {
      novedadeswwimportexcel.this.aP3 = new boolean[] {false};
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
      novedadeswwimportexcel.this.AV22FilePath = aP0;
      novedadeswwimportexcel.this.AV29ExtraParmsJson = aP1;
      novedadeswwimportexcel.this.aP2 = aP2;
      novedadeswwimportexcel.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV32CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      novedadeswwimportexcel.this.GXt_int1 = GXv_int2[0] ;
      AV32CliCod = GXt_int1 ;
      GXt_int3 = AV34EmpCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getempcod(remoteHandle, context).execute( GXv_int4) ;
      novedadeswwimportexcel.this.GXt_int3 = GXv_int4[0] ;
      AV34EmpCod = GXt_int3 ;
      new web.msgdebug7(remoteHandle, context).execute( AV61Pgmname, httpContext.getMessage( "hola mundo", "")) ;
      AV26Messages = new GXBaseCollection<com.genexus.SdtMessages_Message>(com.genexus.SdtMessages_Message.class, "Message", "GeneXus", remoteHandle) ;
      GXt_boolean5 = AV47IsAuthorized ;
      GXv_boolean6[0] = GXt_boolean5 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "SaveFilterAs", GXv_boolean6) ;
      novedadeswwimportexcel.this.GXt_boolean5 = GXv_boolean6[0] ;
      AV47IsAuthorized = GXt_boolean5 ;
      if ( ! AV47IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV61Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      if ( AV47IsAuthorized )
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
         GXv_objcol_SdtMessages_Message7[0] = AV26Messages ;
         new web.wwpbaseobjects.wwp_addmessage(remoteHandle, context).execute( "WWP_Import_NotAuthorized", (byte)(1), httpContext.getMessage( "WWP_NotAuthorizedTitle", ""), GXv_objcol_SdtMessages_Message7) ;
         AV26Messages = GXv_objcol_SdtMessages_Message7[0] ;
      }
      AV40i = 1 ;
      while ( AV40i <= AV37LegNumeros.size() )
      {
         new web.recalcularlegsuelbasicaporlegupd(remoteHandle, context).execute( (short)(0), AV32CliCod, AV34EmpCod, ((Number) AV37LegNumeros.elementAt(-1+(int)(AV40i))).intValue(), httpContext.getMessage( "NOVEDADES", "")) ;
         AV40i = (long)(AV40i+1) ;
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
      AV14DoDelete = false ;
   }

   public void S121( )
   {
      /* 'ADD SUCCESS MESSAGES' Routine */
      returnInSub = false ;
      if ( AV8AddedRecords > 0 )
      {
         GXv_objcol_SdtMessages_Message7[0] = AV26Messages ;
         new web.wwpbaseobjects.wwp_addmessage(remoteHandle, context).execute( "WWP_Import_AddedRecordsCount", (byte)(2), GXutil.format( httpContext.getMessage( "%1 records added.", ""), GXutil.trim( GXutil.str( AV8AddedRecords, 10, 0)), "", "", "", "", "", "", "", ""), GXv_objcol_SdtMessages_Message7) ;
         AV26Messages = GXv_objcol_SdtMessages_Message7[0] ;
      }
      if ( AV10UpdatedRecords > 0 )
      {
         GXv_objcol_SdtMessages_Message7[0] = AV26Messages ;
         new web.wwpbaseobjects.wwp_addmessage(remoteHandle, context).execute( "WWP_Import_UpdatedRecordsCount", (byte)(2), GXutil.format( httpContext.getMessage( "%1 records updated.", ""), GXutil.trim( GXutil.str( AV10UpdatedRecords, 10, 0)), "", "", "", "", "", "", "", ""), GXv_objcol_SdtMessages_Message7) ;
         AV26Messages = GXv_objcol_SdtMessages_Message7[0] ;
      }
      if ( AV9DeletedRecords > 0 )
      {
         GXv_objcol_SdtMessages_Message7[0] = AV26Messages ;
         new web.wwpbaseobjects.wwp_addmessage(remoteHandle, context).execute( "WWP_Import_DeletedRecordsCount", (byte)(2), GXutil.format( httpContext.getMessage( "%1 records deleted.", ""), GXutil.trim( GXutil.str( AV9DeletedRecords, 10, 0)), "", "", "", "", "", "", "", ""), GXv_objcol_SdtMessages_Message7) ;
         AV26Messages = GXv_objcol_SdtMessages_Message7[0] ;
      }
      if ( AV8AddedRecords + AV10UpdatedRecords + AV9DeletedRecords == 0 )
      {
         GXv_objcol_SdtMessages_Message7[0] = AV26Messages ;
         new web.wwpbaseobjects.wwp_addmessage(remoteHandle, context).execute( "WWP_Import_NoRecordsModified", (byte)(2), httpContext.getMessage( "No record was modified.", ""), GXv_objcol_SdtMessages_Message7) ;
         AV26Messages = GXv_objcol_SdtMessages_Message7[0] ;
      }
   }

   public void S131( )
   {
      /* 'COMMIT UPDATES' Routine */
      returnInSub = false ;
      Application.commitDataStores(context, remoteHandle, pr_default, "novedadeswwimportexcel");
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
                     GXv_objcol_SdtMessages_Message7[0] = AV26Messages ;
                     new web.wwpbaseobjects.wwp_addmessage(remoteHandle, context).execute( "WWP_Import_TitlesNotFound", (byte)(1), httpContext.getMessage( "No column title was found.", ""), GXv_objcol_SdtMessages_Message7) ;
                     AV26Messages = GXv_objcol_SdtMessages_Message7[0] ;
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
      /* Using cursor P008Y2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV32CliCod), Short.valueOf(AV34EmpCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1EmpCod = P008Y2_A1EmpCod[0] ;
         A3CliCod = P008Y2_A3CliCod[0] ;
         A6LegNumero = P008Y2_A6LegNumero[0] ;
         A25AgeOrden = P008Y2_A25AgeOrden[0] ;
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
      AV28TitleNames.add(httpContext.getMessage( "CUIL", ""), 0);
      AV28TitleNames.add(httpContext.getMessage( "Legajo Id.", ""), 0);
      AV28TitleNames.add(httpContext.getMessage( "Concepto", ""), 0);
      AV28TitleNames.add(httpContext.getMessage( "Cantidad", ""), 0);
      AV28TitleNames.add(httpContext.getMessage( "Importe", ""), 0);
      AV28TitleNames.add(httpContext.getMessage( "Desde", ""), 0);
      AV28TitleNames.add(httpContext.getMessage( "Hasta", ""), 0);
      GXv_char8[0] = AV13DiscardedColumns ;
      GXv_objcol_int9[0] = AV27TitleIndexes ;
      GXv_int4[0] = AV11ColumnsCount ;
      GXv_int10[0] = AV12ColumnsFound ;
      new web.wwpbaseobjects.wwp_getimportexcelcolumnindexes(remoteHandle, context).execute( AV28TitleNames, AV42ExcelDocument, AV24LineNumber, GXv_char8, GXv_objcol_int9, GXv_int4, GXv_int10) ;
      novedadeswwimportexcel.this.AV13DiscardedColumns = GXv_char8[0] ;
      AV27TitleIndexes = GXv_objcol_int9[0] ;
      novedadeswwimportexcel.this.AV11ColumnsCount = GXv_int4[0] ;
      novedadeswwimportexcel.this.AV12ColumnsFound = GXv_int10[0] ;
      if ( ! (GXutil.strcmp("", AV13DiscardedColumns)==0) )
      {
         GXv_objcol_SdtMessages_Message7[0] = AV26Messages ;
         new web.wwpbaseobjects.wwp_addmessage(remoteHandle, context).execute( "WWP_Import_DiscardedColumns", (byte)((AV18ErrorIfUnmachingColumns ? 1 : 0)), GXutil.format( httpContext.getMessage( "The following columns do not match any column to import: %1.", ""), AV13DiscardedColumns, "", "", "", "", "", "", "", ""), GXv_objcol_SdtMessages_Message7) ;
         AV26Messages = GXv_objcol_SdtMessages_Message7[0] ;
         if ( AV18ErrorIfUnmachingColumns )
         {
            AV20IsOk = false ;
         }
      }
      if ( AV20IsOk && ( AV12ColumnsFound == 0 ) )
      {
         GXv_objcol_SdtMessages_Message7[0] = AV26Messages ;
         new web.wwpbaseobjects.wwp_addmessage(remoteHandle, context).execute( "WWP_Import_NoColumnFound", (byte)(1), httpContext.getMessage( "No column title was found.", ""), GXv_objcol_SdtMessages_Message7) ;
         AV26Messages = GXv_objcol_SdtMessages_Message7[0] ;
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
      AV31Novedades = (web.SdtNovedades)new web.SdtNovedades( remoteHandle, context);
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
            GXv_objcol_SdtMessages_Message7[0] = AV26Messages ;
            new web.wwpbaseobjects.wwp_addimporterrormessage(remoteHandle, context).execute( GXv_objcol_SdtMessages_Message7, GXutil.trim( GXutil.str( AV24LineNumber, 10, 0)), "WWP_Import_RecordNotFound", httpContext.getMessage( "WWP_RecordNotFound", "")) ;
            AV26Messages = GXv_objcol_SdtMessages_Message7[0] ;
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
               AV31Novedades.Load(AV32CliCod, AV34EmpCod, AV36LegNumero, AV38AgeOrden);
            }
            if ( ! AV31Novedades.Success() )
            {
               GXv_objcol_SdtMessages_Message7[0] = AV26Messages ;
               new web.wwpbaseobjects.wwp_addimporterrormessages(remoteHandle, context).execute( GXv_objcol_SdtMessages_Message7, GXutil.trim( GXutil.str( AV24LineNumber, 10, 0)), AV31Novedades.GetMessages()) ;
               AV26Messages = GXv_objcol_SdtMessages_Message7[0] ;
               AV19IsLineOk = false ;
            }
         }
         else
         {
            GXv_objcol_SdtMessages_Message7[0] = AV26Messages ;
            new web.wwpbaseobjects.wwp_addimporterrormessage(remoteHandle, context).execute( GXv_objcol_SdtMessages_Message7, GXutil.trim( GXutil.str( AV24LineNumber, 10, 0)), "WWP_Import_RecordFound_NoUpdate", httpContext.getMessage( "Matching record found and Update not allowed.", "")) ;
            AV26Messages = GXv_objcol_SdtMessages_Message7[0] ;
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
            AV31Novedades.Save();
            if ( ! AV31Novedades.Success() )
            {
               GXv_objcol_SdtMessages_Message7[0] = AV26Messages ;
               new web.wwpbaseobjects.wwp_addimporterrormessages(remoteHandle, context).execute( GXv_objcol_SdtMessages_Message7, GXutil.trim( GXutil.str( AV24LineNumber, 10, 0)), AV31Novedades.GetMessages()) ;
               AV26Messages = GXv_objcol_SdtMessages_Message7[0] ;
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
      AV31Novedades.setgxTv_SdtNovedades_Clicod( AV32CliCod );
      AV31Novedades.setgxTv_SdtNovedades_Empcod( AV34EmpCod );
      AV31Novedades.setgxTv_SdtNovedades_Legnumero( AV36LegNumero );
      GXt_int3 = (short)(0) ;
      GXv_int10[0] = GXt_int3 ;
      new web.getnextorden(remoteHandle, context).execute( AV34EmpCod, AV36LegNumero, GXv_int10) ;
      novedadeswwimportexcel.this.GXt_int3 = GXv_int10[0] ;
      AV31Novedades.setgxTv_SdtNovedades_Ageorden( GXt_int3 );
      AV31Novedades.setgxTv_SdtNovedades_Ageliqnro_SetNull();
      new web.msgdebug_prod(remoteHandle, context).execute( AV61Pgmname, httpContext.getMessage( "setea null &LegNumero ", "")+GXutil.trim( GXutil.str( AV36LegNumero, 8, 0))) ;
      if ( ((Number) AV27TitleIndexes.elementAt(-1+3)).shortValue() > 0 )
      {
         GXt_char11 = "" ;
         GXv_char8[0] = GXt_char11 ;
         new web.wwpbaseobjects.wwp_export_undosecuretext(remoteHandle, context).execute( AV42ExcelDocument.Cells((int)(AV24LineNumber), ((Number) AV27TitleIndexes.elementAt(-1+3)).shortValue(), 1, 1).getText(), GXv_char8) ;
         novedadeswwimportexcel.this.GXt_char11 = GXv_char8[0] ;
         AV31Novedades.setgxTv_SdtNovedades_Concodigo( GXt_char11 );
      }
      if ( ((Number) AV27TitleIndexes.elementAt(-1+4)).shortValue() > 0 )
      {
         AV31Novedades.setgxTv_SdtNovedades_Agecanti( CommonUtil.decimalVal( AV42ExcelDocument.Cells((int)(AV24LineNumber), ((Number) AV27TitleIndexes.elementAt(-1+4)).shortValue(), 1, 1).getText(), ".") );
      }
      if ( ((Number) AV27TitleIndexes.elementAt(-1+5)).shortValue() > 0 )
      {
         AV31Novedades.setgxTv_SdtNovedades_Ageimporte( CommonUtil.decimalVal( AV42ExcelDocument.Cells((int)(AV24LineNumber), ((Number) AV27TitleIndexes.elementAt(-1+5)).shortValue(), 1, 1).getText(), ".") );
      }
      if ( ((Number) AV27TitleIndexes.elementAt(-1+6)).shortValue() > 0 )
      {
         AV31Novedades.setgxTv_SdtNovedades_Agefecdes( AV42ExcelDocument.Cells((int)(AV24LineNumber), ((Number) AV27TitleIndexes.elementAt(-1+6)).shortValue(), 1, 1).getDate() );
      }
      if ( ((Number) AV27TitleIndexes.elementAt(-1+7)).shortValue() > 0 )
      {
         AV31Novedades.setgxTv_SdtNovedades_Agefechas( AV42ExcelDocument.Cells((int)(AV24LineNumber), ((Number) AV27TitleIndexes.elementAt(-1+7)).shortValue(), 1, 1).getDate() );
      }
      if ( GXutil.day( AV31Novedades.getgxTv_SdtNovedades_Agefechas()) <= 15 )
      {
         GXt_char11 = AV55TLiqCod ;
         GXt_char12 = AV55TLiqCod ;
         GXv_char8[0] = GXt_char12 ;
         new web.tipoliqquincena_codigoparam(remoteHandle, context).execute( GXv_char8) ;
         novedadeswwimportexcel.this.GXt_char12 = GXv_char8[0] ;
         GXv_char13[0] = GXt_char11 ;
         new web.getparametro(remoteHandle, context).execute( AV32CliCod, GXt_char12, GXv_char13) ;
         novedadeswwimportexcel.this.GXt_char11 = GXv_char13[0] ;
         AV55TLiqCod = GXt_char11 ;
      }
      else
      {
         GXt_char12 = AV55TLiqCod ;
         GXt_char11 = AV55TLiqCod ;
         GXv_char13[0] = GXt_char11 ;
         new web.tipoliqmensual_codigoparam(remoteHandle, context).execute( GXv_char13) ;
         novedadeswwimportexcel.this.GXt_char11 = GXv_char13[0] ;
         GXv_char8[0] = GXt_char12 ;
         new web.getparametro(remoteHandle, context).execute( AV32CliCod, GXt_char11, GXv_char8) ;
         novedadeswwimportexcel.this.GXt_char12 = GXv_char8[0] ;
         AV55TLiqCod = GXt_char12 ;
      }
      GXv_char13[0] = "" ;
      GXv_char8[0] = AV31Novedades.getgxTv_SdtNovedades_Ageperdescrip() ;
      new web.armaliqnombre(remoteHandle, context).execute( AV32CliCod, AV31Novedades.getgxTv_SdtNovedades_Agefecdes(), GXv_char13, AV55TLiqCod, AV58LiqModTra, AV57LegClase, GXv_char8) ;
      AV31Novedades.setgxTv_SdtNovedades_Ageperdescrip( GXv_char8[0] );
      GXv_char13[0] = "" ;
      GXv_boolean6[0] = AV53existe ;
      new web.conceptogetdescri2(remoteHandle, context).execute( AV32CliCod, AV31Novedades.getgxTv_SdtNovedades_Concodigo(), GXv_char13, GXv_boolean6) ;
      novedadeswwimportexcel.this.AV53existe = GXv_boolean6[0] ;
      if ( ! AV53existe )
      {
         AV54ConDescrip = AV31Novedades.getgxTv_SdtNovedades_Concodigo() ;
         GXv_char13[0] = AV31Novedades.getgxTv_SdtNovedades_Concodigo() ;
         new web.getconceptopordesc(remoteHandle, context).execute( AV32CliCod, AV54ConDescrip, GXv_char13) ;
         AV31Novedades.setgxTv_SdtNovedades_Concodigo( GXv_char13[0] );
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
      new web.msgdebug_prod(remoteHandle, context).execute( AV61Pgmname, httpContext.getMessage( "&TitleIndexes.Item(1) ", "")+GXutil.str( ((Number) AV27TitleIndexes.elementAt(-1+1)).shortValue(), 4, 0)) ;
      if ( ((Number) AV27TitleIndexes.elementAt(-1+1)).shortValue() > 0 )
      {
         GXt_char12 = AV48lEGiD ;
         GXv_char13[0] = GXt_char12 ;
         new web.wwpbaseobjects.wwp_export_undosecuretext(remoteHandle, context).execute( AV42ExcelDocument.Cells((int)(AV24LineNumber), ((Number) AV27TitleIndexes.elementAt(-1+1)).shortValue(), 1, 1).getText(), GXv_char13) ;
         novedadeswwimportexcel.this.GXt_char12 = GXv_char13[0] ;
         AV48lEGiD = GXt_char12 ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV61Pgmname, httpContext.getMessage( "&lEGiD ", "")+AV48lEGiD) ;
         if ( ! (GXutil.strcmp("", AV48lEGiD)==0) )
         {
            GXt_int1 = AV36LegNumero ;
            GXv_int2[0] = GXt_int1 ;
            new web.getlegnumerobyid(remoteHandle, context).execute( AV32CliCod, AV34EmpCod, AV48lEGiD, GXv_int2) ;
            novedadeswwimportexcel.this.GXt_int1 = GXv_int2[0] ;
            AV36LegNumero = GXt_int1 ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV61Pgmname, httpContext.getMessage( "&LegNumero ", "")+GXutil.trim( GXutil.str( AV36LegNumero, 8, 0))) ;
         }
         else
         {
            if ( ((Number) AV27TitleIndexes.elementAt(-1+2)).shortValue() > 0 )
            {
               GXt_char12 = AV50palabra ;
               GXv_char13[0] = GXt_char12 ;
               new web.wwpbaseobjects.wwp_export_undosecuretext(remoteHandle, context).execute( AV42ExcelDocument.Cells((int)(AV24LineNumber), ((Number) AV27TitleIndexes.elementAt(-1+2)).shortValue(), 1, 1).getText(), GXv_char13) ;
               novedadeswwimportexcel.this.GXt_char12 = GXv_char13[0] ;
               AV50palabra = GXt_char12 ;
               AV49LegCUIL = GXutil.lval( AV50palabra) ;
               new web.msgdebug_prod(remoteHandle, context).execute( AV61Pgmname, httpContext.getMessage( "&LegCUIL ", "")+GXutil.trim( GXutil.str( AV49LegCUIL, 11, 0))) ;
               GXv_int2[0] = AV36LegNumero ;
               GXv_char13[0] = "" ;
               new web.getlegnumeroynomidporcuil(remoteHandle, context).execute( AV32CliCod, AV34EmpCod, AV49LegCUIL, GXv_int2, GXv_char13) ;
               novedadeswwimportexcel.this.AV36LegNumero = GXv_int2[0] ;
               new web.msgdebug_prod(remoteHandle, context).execute( AV61Pgmname, httpContext.getMessage( "&LegNumero ", "")+GXutil.trim( GXutil.str( AV36LegNumero, 8, 0))) ;
            }
         }
      }
      else
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV61Pgmname, httpContext.getMessage( "&TitleIndexes.Item(2) ", "")+GXutil.str( ((Number) AV27TitleIndexes.elementAt(-1+2)).shortValue(), 4, 0)) ;
         if ( ((Number) AV27TitleIndexes.elementAt(-1+2)).shortValue() > 0 )
         {
            AV51auxPalabra = AV42ExcelDocument.Cells((int)(AV24LineNumber), ((Number) AV27TitleIndexes.elementAt(-1+2)).shortValue(), 1, 1).getText() ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV61Pgmname, httpContext.getMessage( "&auxPalabra ", "")+AV51auxPalabra) ;
            AV51auxPalabra = GXutil.strReplace( AV51auxPalabra, "-", "") ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV61Pgmname, httpContext.getMessage( "sin guiones &auxPalabra ", "")+AV51auxPalabra) ;
            GXt_char12 = AV50palabra ;
            GXv_char13[0] = GXt_char12 ;
            new web.wwpbaseobjects.wwp_export_undosecuretext(remoteHandle, context).execute( AV51auxPalabra, GXv_char13) ;
            novedadeswwimportexcel.this.GXt_char12 = GXv_char13[0] ;
            AV50palabra = GXt_char12 ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV61Pgmname, httpContext.getMessage( "secure palabra ", "")+AV50palabra) ;
            AV49LegCUIL = GXutil.lval( AV50palabra) ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV61Pgmname, httpContext.getMessage( "&LegCUIL ", "")+GXutil.trim( GXutil.str( AV49LegCUIL, 11, 0))) ;
            GXv_int2[0] = AV36LegNumero ;
            GXv_char13[0] = "" ;
            new web.getlegnumeroynomidporcuil(remoteHandle, context).execute( AV32CliCod, AV34EmpCod, AV49LegCUIL, GXv_int2, GXv_char13) ;
            novedadeswwimportexcel.this.AV36LegNumero = GXv_int2[0] ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV61Pgmname, httpContext.getMessage( "&LegNumero ", "")+GXutil.trim( GXutil.str( AV36LegNumero, 8, 0))) ;
         }
      }
      GXv_int14[0] = AV57LegClase ;
      GXv_char13[0] = AV58LiqModTra ;
      new web.getlegajoclaseymodtra(remoteHandle, context).execute( AV32CliCod, AV34EmpCod, AV36LegNumero, GXv_int14, GXv_char13) ;
      novedadeswwimportexcel.this.AV57LegClase = GXv_int14[0] ;
      novedadeswwimportexcel.this.AV58LiqModTra = GXv_char13[0] ;
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
         AV31Novedades.Load(AV32CliCod, AV34EmpCod, AV36LegNumero, AV38AgeOrden);
         if ( AV31Novedades.Success() )
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
         AV31Novedades.Load(AV32CliCod, AV34EmpCod, AV36LegNumero, AV38AgeOrden);
         if ( AV31Novedades.Success() )
         {
            AV31Novedades.Delete();
         }
         if ( ! AV31Novedades.Success() )
         {
            GXv_objcol_SdtMessages_Message7[0] = AV26Messages ;
            new web.wwpbaseobjects.wwp_addimporterrormessages(remoteHandle, context).execute( GXv_objcol_SdtMessages_Message7, GXutil.format( httpContext.getMessage( "(Deleting %1)", ""), httpContext.getMessage( "Cli Cod", "")+": "+GXutil.trim( GXutil.str( AV32CliCod, 6, 0))+", "+httpContext.getMessage( "Empresa", "")+": "+GXutil.trim( GXutil.str( AV34EmpCod, 4, 0))+", "+httpContext.getMessage( "Legajo", "")+": "+GXutil.trim( GXutil.str( AV36LegNumero, 8, 0))+", "+httpContext.getMessage( "Orden", "")+": "+GXutil.trim( GXutil.str( AV38AgeOrden, 4, 0)), "", "", "", "", "", "", "", ""), AV31Novedades.GetMessages()) ;
            AV26Messages = GXv_objcol_SdtMessages_Message7[0] ;
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
      if ( false )
      {
         if ( AV42ExcelDocument.getErrCode() != 0 )
         {
            GXv_objcol_SdtMessages_Message7[0] = AV26Messages ;
            new web.wwpbaseobjects.wwp_addmessage(remoteHandle, context).execute( httpContext.getMessage( "WWP_ErrorExcelDocument", ""), (byte)(1), AV42ExcelDocument.getErrDescription(), GXv_objcol_SdtMessages_Message7) ;
            AV26Messages = GXv_objcol_SdtMessages_Message7[0] ;
            AV42ExcelDocument.Close();
            returnInSub = true;
            if (true) return;
         }
      }
   }

   public void S271( )
   {
      /* 'LOAD EXTRA PARMETERS' Routine */
      returnInSub = false ;
      AV30ExtraParms.fromJSonString(AV29ExtraParmsJson, null);
      if ( AV30ExtraParms.size() == 1 )
      {
         AV52MenuOpcCod = (String)AV30ExtraParms.elementAt(-1+1) ;
      }
   }

   protected void cleanup( )
   {
      this.aP2[0] = novedadeswwimportexcel.this.AV26Messages;
      this.aP3[0] = novedadeswwimportexcel.this.AV20IsOk;
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
      AV61Pgmname = "" ;
      AV37LegNumeros = new GXSimpleCollection<Integer>(Integer.class, "internal", "");
      AV42ExcelDocument = new com.genexus.gxoffice.ExcelDoc();
      AV33CliCods = new GXSimpleCollection<Integer>(Integer.class, "internal", "");
      AV35EmpCods = new GXSimpleCollection<Short>(Short.class, "internal", "");
      AV39AgeOrdens = new GXSimpleCollection<Short>(Short.class, "internal", "");
      scmdbuf = "" ;
      P008Y2_A1EmpCod = new short[1] ;
      P008Y2_A3CliCod = new int[1] ;
      P008Y2_A6LegNumero = new int[1] ;
      P008Y2_A25AgeOrden = new short[1] ;
      AV28TitleNames = new GXSimpleCollection<String>(String.class, "internal", "");
      AV13DiscardedColumns = "" ;
      AV27TitleIndexes = new GXSimpleCollection<Short>(Short.class, "internal", "");
      GXv_objcol_int9 = new GXSimpleCollection[1] ;
      GXv_int4 = new short[1] ;
      AV31Novedades = new web.SdtNovedades(remoteHandle);
      GXv_int10 = new short[1] ;
      AV55TLiqCod = "" ;
      GXt_char11 = "" ;
      AV58LiqModTra = "" ;
      GXv_char8 = new String[1] ;
      GXv_boolean6 = new boolean[1] ;
      AV54ConDescrip = "" ;
      AV48lEGiD = "" ;
      AV50palabra = "" ;
      AV51auxPalabra = "" ;
      GXt_char12 = "" ;
      GXv_int2 = new int[1] ;
      GXv_int14 = new byte[1] ;
      GXv_char13 = new String[1] ;
      GXv_objcol_SdtMessages_Message7 = new GXBaseCollection[1] ;
      AV30ExtraParms = new GXSimpleCollection<String>(String.class, "internal", "");
      AV52MenuOpcCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.novedadeswwimportexcel__default(),
         new Object[] {
             new Object[] {
            P008Y2_A1EmpCod, P008Y2_A3CliCod, P008Y2_A6LegNumero, P008Y2_A25AgeOrden
            }
         }
      );
      AV61Pgmname = "NovedadesWWImportExcel" ;
      /* GeneXus formulas. */
      AV61Pgmname = "NovedadesWWImportExcel" ;
      Gx_err = (short)(0) ;
   }

   private byte AV57LegClase ;
   private byte GXv_int14[] ;
   private short AV34EmpCod ;
   private short AV45ColIndex ;
   private short AV11ColumnsCount ;
   private short A1EmpCod ;
   private short A25AgeOrden ;
   private short GXv_int4[] ;
   private short AV12ColumnsFound ;
   private short AV38AgeOrden ;
   private short GXt_int3 ;
   private short GXv_int10[] ;
   private short Gx_err ;
   private int AV32CliCod ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private int AV36LegNumero ;
   private int GXt_int1 ;
   private int GXv_int2[] ;
   private long AV40i ;
   private long AV8AddedRecords ;
   private long AV10UpdatedRecords ;
   private long AV9DeletedRecords ;
   private long AV24LineNumber ;
   private long AV23Index ;
   private long AV49LegCUIL ;
   private String AV61Pgmname ;
   private String scmdbuf ;
   private String AV55TLiqCod ;
   private String GXt_char11 ;
   private String AV58LiqModTra ;
   private String GXv_char8[] ;
   private String AV48lEGiD ;
   private String AV50palabra ;
   private String AV51auxPalabra ;
   private String GXt_char12 ;
   private String GXv_char13[] ;
   private boolean AV20IsOk ;
   private boolean AV47IsAuthorized ;
   private boolean GXt_boolean5 ;
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
   private boolean AV53existe ;
   private boolean GXv_boolean6[] ;
   private String AV22FilePath ;
   private String AV29ExtraParmsJson ;
   private String AV13DiscardedColumns ;
   private String AV54ConDescrip ;
   private String AV52MenuOpcCod ;
   private GXSimpleCollection<Integer> AV37LegNumeros ;
   private GXSimpleCollection<Short> AV35EmpCods ;
   private GXSimpleCollection<Short> AV39AgeOrdens ;
   private GXSimpleCollection<Short> AV27TitleIndexes ;
   private GXSimpleCollection<Short> GXv_objcol_int9[] ;
   private GXSimpleCollection<Integer> AV33CliCods ;
   private boolean[] aP3 ;
   private GXBaseCollection<com.genexus.SdtMessages_Message>[] aP2 ;
   private IDataStoreProvider pr_default ;
   private short[] P008Y2_A1EmpCod ;
   private int[] P008Y2_A3CliCod ;
   private int[] P008Y2_A6LegNumero ;
   private short[] P008Y2_A25AgeOrden ;
   private com.genexus.gxoffice.ExcelDoc AV42ExcelDocument ;
   private GXSimpleCollection<String> AV28TitleNames ;
   private GXSimpleCollection<String> AV30ExtraParms ;
   private GXBaseCollection<com.genexus.SdtMessages_Message> AV26Messages ;
   private GXBaseCollection<com.genexus.SdtMessages_Message> GXv_objcol_SdtMessages_Message7[] ;
   private web.SdtNovedades AV31Novedades ;
}

final  class novedadeswwimportexcel__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P008Y2", "SELECT EmpCod, CliCod, LegNumero, AgeOrden FROM AgendaNovedades WHERE CliCod = ? and EmpCod = ? ORDER BY CliCod, EmpCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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

