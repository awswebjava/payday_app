package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class importlsd2importexcel extends GXProcedure
{
   public importlsd2importexcel( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( importlsd2importexcel.class ), "" );
   }

   public importlsd2importexcel( int remoteHandle ,
                                 ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( String aP0 ,
                              String aP1 ,
                              GXBaseCollection<com.genexus.SdtMessages_Message>[] aP2 )
   {
      importlsd2importexcel.this.aP3 = new boolean[] {false};
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
      importlsd2importexcel.this.AV22FilePath = aP0;
      importlsd2importexcel.this.AV29ExtraParmsJson = aP1;
      importlsd2importexcel.this.aP2 = aP2;
      importlsd2importexcel.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV26Messages = new GXBaseCollection<com.genexus.SdtMessages_Message>(com.genexus.SdtMessages_Message.class, "Message", "GeneXus", remoteHandle) ;
      GXt_boolean1 = AV48Isauthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "SaveFilterAs", GXv_boolean2) ;
      importlsd2importexcel.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV48Isauthorized = GXt_boolean1 ;
      if ( ! AV48Isauthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV49Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      if ( AV48Isauthorized )
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
      Application.commitDataStores(context, remoteHandle, pr_default, "importlsd2importexcel");
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
      AV37ImpLiqSecs = new GXSimpleCollection<Short>(Short.class, "internal", "") ;
      AV39ImpLiqDetSecs = new GXSimpleCollection<Short>(Short.class, "internal", "") ;
      /* Using cursor P00OD2 */
      pr_default.execute(0);
      while ( (pr_default.getStatus(0) != 101) )
      {
         A3CliCod = P00OD2_A3CliCod[0] ;
         A1EmpCod = P00OD2_A1EmpCod[0] ;
         A88ImpLiqSec = P00OD2_A88ImpLiqSec[0] ;
         A90ImpLiqDetSec = P00OD2_A90ImpLiqDetSec[0] ;
         AV33CliCods.add((int)(A3CliCod), 0);
         AV35EmpCods.add((short)(A1EmpCod), 0);
         AV37ImpLiqSecs.add((short)(A88ImpLiqSec), 0);
         AV39ImpLiqDetSecs.add((short)(A90ImpLiqDetSec), 0);
         pr_default.readNext(0);
      }
      pr_default.close(0);
   }

   public void S161( )
   {
      /* 'GET TITLES POSITIONS' Routine */
      returnInSub = false ;
      AV28TitleNames = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV28TitleNames.add(httpContext.getMessage( "Estado", ""), 0);
      AV28TitleNames.add(httpContext.getMessage( "Periodo", ""), 0);
      AV28TitleNames.add(httpContext.getMessage( "CUIL", ""), 0);
      AV28TitleNames.add(httpContext.getMessage( "Legajo", ""), 0);
      AV28TitleNames.add(httpContext.getMessage( "Concepto Externo", ""), 0);
      AV28TitleNames.add(" ", 0);
      AV28TitleNames.add(httpContext.getMessage( "Concepto Sistema", ""), 0);
      AV28TitleNames.add(httpContext.getMessage( "Cantidad", ""), 0);
      AV28TitleNames.add(httpContext.getMessage( "Importe", ""), 0);
      AV28TitleNames.add(httpContext.getMessage( "Signo", ""), 0);
      GXv_char4[0] = AV13DiscardedColumns ;
      GXv_objcol_int5[0] = AV27TitleIndexes ;
      GXv_int6[0] = AV11ColumnsCount ;
      GXv_int7[0] = AV12ColumnsFound ;
      new web.wwpbaseobjects.wwp_getimportexcelcolumnindexes(remoteHandle, context).execute( AV28TitleNames, AV42ExcelDocument, AV24LineNumber, GXv_char4, GXv_objcol_int5, GXv_int6, GXv_int7) ;
      importlsd2importexcel.this.AV13DiscardedColumns = GXv_char4[0] ;
      AV27TitleIndexes = GXv_objcol_int5[0] ;
      importlsd2importexcel.this.AV11ColumnsCount = GXv_int6[0] ;
      importlsd2importexcel.this.AV12ColumnsFound = GXv_int7[0] ;
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
      AV31importacion_liquidacion_detalle = (web.Sdtimportacion_liquidacion_detalle)new web.Sdtimportacion_liquidacion_detalle( remoteHandle, context);
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
               AV31importacion_liquidacion_detalle.Load(AV32CliCod, AV34EmpCod, AV36ImpLiqSec, AV38ImpLiqDetSec);
            }
            if ( ! AV31importacion_liquidacion_detalle.Success() )
            {
               GXv_objcol_SdtMessages_Message3[0] = AV26Messages ;
               new web.wwpbaseobjects.wwp_addimporterrormessages(remoteHandle, context).execute( GXv_objcol_SdtMessages_Message3, GXutil.trim( GXutil.str( AV24LineNumber, 10, 0)), AV31importacion_liquidacion_detalle.GetMessages()) ;
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
            AV31importacion_liquidacion_detalle.Save();
            if ( ! AV31importacion_liquidacion_detalle.Success() )
            {
               GXv_objcol_SdtMessages_Message3[0] = AV26Messages ;
               new web.wwpbaseobjects.wwp_addimporterrormessages(remoteHandle, context).execute( GXv_objcol_SdtMessages_Message3, GXutil.trim( GXutil.str( AV24LineNumber, 10, 0)), AV31importacion_liquidacion_detalle.GetMessages()) ;
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
         importlsd2importexcel.this.GXt_char8 = GXv_char4[0] ;
         AV31importacion_liquidacion_detalle.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetper( GXt_char8 );
      }
      if ( ((Number) AV27TitleIndexes.elementAt(-1+3)).shortValue() > 0 )
      {
         GXt_char8 = "" ;
         GXv_char4[0] = GXt_char8 ;
         new web.wwpbaseobjects.wwp_export_undosecuretext(remoteHandle, context).execute( AV42ExcelDocument.Cells((int)(AV24LineNumber), ((Number) AV27TitleIndexes.elementAt(-1+3)).shortValue(), 1, 1).getText(), GXv_char4) ;
         importlsd2importexcel.this.GXt_char8 = GXv_char4[0] ;
         AV31importacion_liquidacion_detalle.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcuil( GXt_char8 );
      }
      if ( ((Number) AV27TitleIndexes.elementAt(-1+4)).shortValue() > 0 )
      {
         GXt_char8 = "" ;
         GXv_char4[0] = GXt_char8 ;
         new web.wwpbaseobjects.wwp_export_undosecuretext(remoteHandle, context).execute( AV42ExcelDocument.Cells((int)(AV24LineNumber), ((Number) AV27TitleIndexes.elementAt(-1+4)).shortValue(), 1, 1).getText(), GXv_char4) ;
         importlsd2importexcel.this.GXt_char8 = GXv_char4[0] ;
         AV31importacion_liquidacion_detalle.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetlegsis( GXt_char8 );
      }
      if ( ((Number) AV27TitleIndexes.elementAt(-1+5)).shortValue() > 0 )
      {
         GXt_char8 = "" ;
         GXv_char4[0] = GXt_char8 ;
         new web.wwpbaseobjects.wwp_export_undosecuretext(remoteHandle, context).execute( AV42ExcelDocument.Cells((int)(AV24LineNumber), ((Number) AV27TitleIndexes.elementAt(-1+5)).shortValue(), 1, 1).getText(), GXv_char4) ;
         importlsd2importexcel.this.GXt_char8 = GXv_char4[0] ;
         AV31importacion_liquidacion_detalle.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconcod( GXt_char8 );
      }
      if ( ((Number) AV27TitleIndexes.elementAt(-1+7)).shortValue() > 0 )
      {
         GXt_char8 = "" ;
         GXv_char4[0] = GXt_char8 ;
         new web.wwpbaseobjects.wwp_export_undosecuretext(remoteHandle, context).execute( AV42ExcelDocument.Cells((int)(AV24LineNumber), ((Number) AV27TitleIndexes.elementAt(-1+7)).shortValue(), 1, 1).getText(), GXv_char4) ;
         importlsd2importexcel.this.GXt_char8 = GXv_char4[0] ;
         AV31importacion_liquidacion_detalle.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconsisydes( GXt_char8 );
      }
      if ( ((Number) AV27TitleIndexes.elementAt(-1+8)).shortValue() > 0 )
      {
         AV31importacion_liquidacion_detalle.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcantnum( CommonUtil.decimalVal( AV42ExcelDocument.Cells((int)(AV24LineNumber), ((Number) AV27TitleIndexes.elementAt(-1+8)).shortValue(), 1, 1).getText(), ".") );
      }
      if ( ((Number) AV27TitleIndexes.elementAt(-1+9)).shortValue() > 0 )
      {
         AV31importacion_liquidacion_detalle.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetimpnum( CommonUtil.decimalVal( AV42ExcelDocument.Cells((int)(AV24LineNumber), ((Number) AV27TitleIndexes.elementAt(-1+9)).shortValue(), 1, 1).getText(), ".") );
      }
      if ( ((Number) AV27TitleIndexes.elementAt(-1+10)).shortValue() > 0 )
      {
         GXt_char8 = "" ;
         GXv_char4[0] = GXt_char8 ;
         new web.wwpbaseobjects.wwp_export_undosecuretext(remoteHandle, context).execute( AV42ExcelDocument.Cells((int)(AV24LineNumber), ((Number) AV27TitleIndexes.elementAt(-1+10)).shortValue(), 1, 1).getText(), GXv_char4) ;
         importlsd2importexcel.this.GXt_char8 = GXv_char4[0] ;
         AV31importacion_liquidacion_detalle.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetsigno( GXt_char8 );
      }
   }

   public void S221( )
   {
      /* 'REMOVE RECORD FROM REMAININGS' Routine */
      returnInSub = false ;
      AV33CliCods.removeItem((int)(AV23Index));
      AV35EmpCods.removeItem((int)(AV23Index));
      AV37ImpLiqSecs.removeItem((int)(AV23Index));
      AV39ImpLiqDetSecs.removeItem((int)(AV23Index));
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
            if ( ( ((Number) AV33CliCods.elementAt(-1+(int)(AV40i))).intValue() == AV32CliCod ) && ( ((Number) AV35EmpCods.elementAt(-1+(int)(AV40i))).shortValue() == AV34EmpCod ) && ( ((Number) AV37ImpLiqSecs.elementAt(-1+(int)(AV40i))).shortValue() == AV36ImpLiqSec ) && ( ((Number) AV39ImpLiqDetSecs.elementAt(-1+(int)(AV40i))).shortValue() == AV38ImpLiqDetSec ) )
            {
               AV23Index = AV40i ;
               if (true) break;
            }
            AV40i = (long)(AV40i+1) ;
         }
      }
      else
      {
         AV31importacion_liquidacion_detalle.Load(AV32CliCod, AV34EmpCod, AV36ImpLiqSec, AV38ImpLiqDetSec);
         if ( AV31importacion_liquidacion_detalle.Success() )
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
         AV36ImpLiqSec = ((Number) AV37ImpLiqSecs.elementAt(-1+(int)(AV40i))).shortValue() ;
         AV38ImpLiqDetSec = ((Number) AV39ImpLiqDetSecs.elementAt(-1+(int)(AV40i))).shortValue() ;
         AV31importacion_liquidacion_detalle.Load(AV32CliCod, AV34EmpCod, AV36ImpLiqSec, AV38ImpLiqDetSec);
         if ( AV31importacion_liquidacion_detalle.Success() )
         {
            AV31importacion_liquidacion_detalle.Delete();
         }
         if ( ! AV31importacion_liquidacion_detalle.Success() )
         {
            GXv_objcol_SdtMessages_Message3[0] = AV26Messages ;
            new web.wwpbaseobjects.wwp_addimporterrormessages(remoteHandle, context).execute( GXv_objcol_SdtMessages_Message3, GXutil.format( httpContext.getMessage( "(Deleting %1)", ""), httpContext.getMessage( "Cli Cod", "")+": "+GXutil.trim( GXutil.str( AV32CliCod, 6, 0))+", "+httpContext.getMessage( "Empresa", "")+": "+GXutil.trim( GXutil.str( AV34EmpCod, 4, 0))+", "+httpContext.getMessage( "Imp Liq Sec", "")+": "+GXutil.trim( GXutil.str( AV36ImpLiqSec, 4, 0))+", "+httpContext.getMessage( "Imp Liq Det Sec", "")+": "+GXutil.trim( GXutil.str( AV38ImpLiqDetSec, 4, 0)), "", "", "", "", "", "", "", ""), AV31importacion_liquidacion_detalle.GetMessages()) ;
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
      if ( AV30ExtraParms.size() == 2 )
      {
         AV32CliCod = (int)(GXutil.lval( (String)AV30ExtraParms.elementAt(-1+1))) ;
         AV34EmpCod = (short)(GXutil.lval( (String)AV30ExtraParms.elementAt(-1+2))) ;
      }
   }

   protected void cleanup( )
   {
      this.aP2[0] = importlsd2importexcel.this.AV26Messages;
      this.aP3[0] = importlsd2importexcel.this.AV20IsOk;
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
      AV49Pgmname = "" ;
      AV42ExcelDocument = new com.genexus.gxoffice.ExcelDoc();
      AV33CliCods = new GXSimpleCollection<Integer>(Integer.class, "internal", "");
      AV35EmpCods = new GXSimpleCollection<Short>(Short.class, "internal", "");
      AV37ImpLiqSecs = new GXSimpleCollection<Short>(Short.class, "internal", "");
      AV39ImpLiqDetSecs = new GXSimpleCollection<Short>(Short.class, "internal", "");
      scmdbuf = "" ;
      P00OD2_A3CliCod = new int[1] ;
      P00OD2_A1EmpCod = new short[1] ;
      P00OD2_A88ImpLiqSec = new short[1] ;
      P00OD2_A90ImpLiqDetSec = new short[1] ;
      AV28TitleNames = new GXSimpleCollection<String>(String.class, "internal", "");
      AV13DiscardedColumns = "" ;
      AV27TitleIndexes = new GXSimpleCollection<Short>(Short.class, "internal", "");
      GXv_objcol_int5 = new GXSimpleCollection[1] ;
      GXv_int6 = new short[1] ;
      GXv_int7 = new short[1] ;
      AV31importacion_liquidacion_detalle = new web.Sdtimportacion_liquidacion_detalle(remoteHandle);
      GXt_char8 = "" ;
      GXv_char4 = new String[1] ;
      GXv_objcol_SdtMessages_Message3 = new GXBaseCollection[1] ;
      AV30ExtraParms = new GXSimpleCollection<String>(String.class, "internal", "");
      pr_default = new DataStoreProvider(context, remoteHandle, new web.importlsd2importexcel__default(),
         new Object[] {
             new Object[] {
            P00OD2_A3CliCod, P00OD2_A1EmpCod, P00OD2_A88ImpLiqSec, P00OD2_A90ImpLiqDetSec
            }
         }
      );
      AV49Pgmname = "ImportLSD2ImportExcel" ;
      /* GeneXus formulas. */
      AV49Pgmname = "ImportLSD2ImportExcel" ;
      Gx_err = (short)(0) ;
   }

   private short AV45ColIndex ;
   private short AV11ColumnsCount ;
   private short A1EmpCod ;
   private short A88ImpLiqSec ;
   private short A90ImpLiqDetSec ;
   private short GXv_int6[] ;
   private short AV12ColumnsFound ;
   private short GXv_int7[] ;
   private short AV34EmpCod ;
   private short AV36ImpLiqSec ;
   private short AV38ImpLiqDetSec ;
   private short Gx_err ;
   private int A3CliCod ;
   private int AV32CliCod ;
   private long AV8AddedRecords ;
   private long AV10UpdatedRecords ;
   private long AV9DeletedRecords ;
   private long AV24LineNumber ;
   private long AV23Index ;
   private long AV40i ;
   private String AV49Pgmname ;
   private String scmdbuf ;
   private String GXt_char8 ;
   private String GXv_char4[] ;
   private boolean AV20IsOk ;
   private boolean AV48Isauthorized ;
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
   private GXSimpleCollection<Short> AV35EmpCods ;
   private GXSimpleCollection<Short> AV37ImpLiqSecs ;
   private GXSimpleCollection<Short> AV39ImpLiqDetSecs ;
   private GXSimpleCollection<Short> AV27TitleIndexes ;
   private GXSimpleCollection<Short> GXv_objcol_int5[] ;
   private GXSimpleCollection<Integer> AV33CliCods ;
   private boolean[] aP3 ;
   private GXBaseCollection<com.genexus.SdtMessages_Message>[] aP2 ;
   private IDataStoreProvider pr_default ;
   private int[] P00OD2_A3CliCod ;
   private short[] P00OD2_A1EmpCod ;
   private short[] P00OD2_A88ImpLiqSec ;
   private short[] P00OD2_A90ImpLiqDetSec ;
   private com.genexus.gxoffice.ExcelDoc AV42ExcelDocument ;
   private GXSimpleCollection<String> AV28TitleNames ;
   private GXSimpleCollection<String> AV30ExtraParms ;
   private GXBaseCollection<com.genexus.SdtMessages_Message> AV26Messages ;
   private GXBaseCollection<com.genexus.SdtMessages_Message> GXv_objcol_SdtMessages_Message3[] ;
   private web.Sdtimportacion_liquidacion_detalle AV31importacion_liquidacion_detalle ;
}

final  class importlsd2importexcel__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00OD2", "SELECT CliCod, EmpCod, ImpLiqSec, ImpLiqDetSec FROM importacion_liquidacion_detalle ORDER BY CliCod, EmpCod, ImpLiqSec, ImpLiqDetSec ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
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
      }
   }

}

