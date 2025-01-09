package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class legajo_permanenciawwexport extends GXProcedure
{
   public legajo_permanenciawwexport( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( legajo_permanenciawwexport.class ), "" );
   }

   public legajo_permanenciawwexport( int remoteHandle ,
                                      ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String[] aP0 )
   {
      legajo_permanenciawwexport.this.aP1 = new String[] {""};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( String[] aP0 ,
                        String[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( String[] aP0 ,
                             String[] aP1 )
   {
      legajo_permanenciawwexport.this.aP0 = aP0;
      legajo_permanenciawwexport.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWlegajo_permanencia", GXv_boolean2) ;
      legajo_permanenciawwexport.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( ! AV8IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV51Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      if ( AV8IsAuthorized )
      {
         GXv_SdtWWPContext3[0] = AV9WWPContext;
         new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext3) ;
         AV9WWPContext = GXv_SdtWWPContext3[0] ;
         /* Execute user subroutine: 'OPENDOCUMENT' */
         S111 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         AV14CellRow = 1 ;
         AV15FirstColumn = 1 ;
         /* Execute user subroutine: 'LOADGRIDSTATE' */
         S201 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         /* Execute user subroutine: 'WRITEFILTERS' */
         S131 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         /* Execute user subroutine: 'WRITECOLUMNTITLES' */
         S141 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         /* Execute user subroutine: 'WRITEDATA' */
         S161 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         /* Execute user subroutine: 'CLOSEDOCUMENT' */
         S191 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'OPENDOCUMENT' Routine */
      returnInSub = false ;
      AV16Random = (int)(GXutil.random( )*10000) ;
      AV12Filename = "legajo_permanenciaWWExport-" + GXutil.trim( GXutil.str( AV16Random, 8, 0)) + ".xlsx" ;
      AV11ExcelDocument.Open(AV12Filename);
      /* Execute user subroutine: 'CHECKSTATUS' */
      S121 ();
      if (returnInSub) return;
      AV11ExcelDocument.Clear();
   }

   public void S131( )
   {
      /* 'WRITEFILTERS' Routine */
      returnInSub = false ;
      if ( ! ( ( AV35TFLegIdNomApe_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Legajo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         legajo_permanenciawwexport.this.AV14CellRow = GXv_int5[0] ;
         AV46i = 1 ;
         AV52GXV1 = 1 ;
         while ( AV52GXV1 <= AV35TFLegIdNomApe_Sels.size() )
         {
            AV36TFLegIdNomApe_Sel = (String)AV35TFLegIdNomApe_Sels.elementAt(-1+AV52GXV1) ;
            if ( AV46i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV36TFLegIdNomApe_Sel, GXv_char7) ;
            legajo_permanenciawwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char6 );
            AV46i = (long)(AV46i+1) ;
            AV52GXV1 = (int)(AV52GXV1+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV34TFLegIdNomApe)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Legajo", "")) ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            legajo_permanenciawwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV34TFLegIdNomApe, GXv_char7) ;
            legajo_permanenciawwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV37TFLegHisFecIng)) && GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV38TFLegHisFecIng_To)) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Ingreso", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         legajo_permanenciawwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_dtime8 = GXutil.resetTime( AV37TFLegHisFecIng );
         AV11ExcelDocument.setDateFormat(localUtil, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " ");
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setDate( GXt_dtime8 );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         legajo_permanenciawwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_dtime8 = GXutil.resetTime( AV38TFLegHisFecIng_To );
         AV11ExcelDocument.setDateFormat(localUtil, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " ");
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setDate( GXt_dtime8 );
      }
      if ( ! ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV39TFLegHisFecEgr)) && GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV40TFLegHisFecEgr_To)) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Egreso", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         legajo_permanenciawwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_dtime8 = GXutil.resetTime( AV39TFLegHisFecEgr );
         AV11ExcelDocument.setDateFormat(localUtil, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " ");
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setDate( GXt_dtime8 );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         legajo_permanenciawwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_dtime8 = GXutil.resetTime( AV40TFLegHisFecEgr_To );
         AV11ExcelDocument.setDateFormat(localUtil, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " ");
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setDate( GXt_dtime8 );
      }
      if ( ! ( (0==AV41TFLegHisAfecAnt_Sel) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Afecta antiguedad", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         legajo_permanenciawwexport.this.AV14CellRow = GXv_int5[0] ;
         if ( AV41TFLegHisAfecAnt_Sel == 1 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSChecked", "") );
         }
         else if ( AV41TFLegHisAfecAnt_Sel == 2 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSUnChecked", "") );
         }
      }
      if ( ! ( ( AV44TFLegHisMotivo_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Motivo de egreso", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         legajo_permanenciawwexport.this.AV14CellRow = GXv_int5[0] ;
         AV46i = 1 ;
         AV53GXV2 = 1 ;
         while ( AV53GXV2 <= AV44TFLegHisMotivo_Sels.size() )
         {
            AV45TFLegHisMotivo_Sel = (String)AV44TFLegHisMotivo_Sels.elementAt(-1+AV53GXV2) ;
            if ( AV46i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV45TFLegHisMotivo_Sel, GXv_char7) ;
            legajo_permanenciawwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char6 );
            AV46i = (long)(AV46i+1) ;
            AV53GXV2 = (int)(AV53GXV2+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV43TFLegHisMotivo)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Motivo de egreso", "")) ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            legajo_permanenciawwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV43TFLegHisMotivo, GXv_char7) ;
            legajo_permanenciawwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      AV14CellRow = (int)(AV14CellRow+2) ;
   }

   public void S141( )
   {
      /* 'WRITECOLUMNTITLES' Routine */
      returnInSub = false ;
      AV30VisibleColumnCount = 0 ;
      if ( GXutil.strcmp(AV18Session.getValue("legajo_permanenciaWWColumnsSelector"), "") != 0 )
      {
         AV25ColumnsSelectorXML = AV18Session.getValue("legajo_permanenciaWWColumnsSelector") ;
         AV22ColumnsSelector.fromxml(AV25ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S151 ();
         if (returnInSub) return;
      }
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV22ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+4)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV22ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+5)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV22ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+8)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV22ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+9)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV22ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+10)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV22ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+11)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      AV22ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().sort("Order");
      AV54GXV3 = 1 ;
      while ( AV54GXV3 <= AV22ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
      {
         AV24ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV22ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV54GXV3));
         if ( AV24ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV30VisibleColumnCount), 1, 1).setText( httpContext.getMessage( ((GXutil.strcmp("", AV24ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname())==0) ? AV24ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname() : AV24ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname()), "") );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV30VisibleColumnCount), 1, 1).setBold( (short)(1) );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV30VisibleColumnCount), 1, 1).setColor( 11 );
            AV30VisibleColumnCount = (long)(AV30VisibleColumnCount+1) ;
         }
         AV54GXV3 = (int)(AV54GXV3+1) ;
      }
   }

   public void S161( )
   {
      /* 'WRITEDATA' Routine */
      returnInSub = false ;
      AV56Legajo_permanenciawwds_1_tflegidnomape = AV34TFLegIdNomApe ;
      AV57Legajo_permanenciawwds_2_tflegidnomape_sels = AV35TFLegIdNomApe_Sels ;
      AV58Legajo_permanenciawwds_3_tfleghisfecing = AV37TFLegHisFecIng ;
      AV59Legajo_permanenciawwds_4_tfleghisfecing_to = AV38TFLegHisFecIng_To ;
      AV60Legajo_permanenciawwds_5_tfleghisfecegr = AV39TFLegHisFecEgr ;
      AV61Legajo_permanenciawwds_6_tfleghisfecegr_to = AV40TFLegHisFecEgr_To ;
      AV62Legajo_permanenciawwds_7_tfleghisafecant_sel = AV41TFLegHisAfecAnt_Sel ;
      AV63Legajo_permanenciawwds_8_tfleghismotivo = AV43TFLegHisMotivo ;
      AV64Legajo_permanenciawwds_9_tfleghismotivo_sels = AV44TFLegHisMotivo_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A250LegIdNomApe ,
                                           AV57Legajo_permanenciawwds_2_tflegidnomape_sels ,
                                           A2256LegHisMotivo ,
                                           AV64Legajo_permanenciawwds_9_tfleghismotivo_sels ,
                                           Integer.valueOf(AV57Legajo_permanenciawwds_2_tflegidnomape_sels.size()) ,
                                           AV56Legajo_permanenciawwds_1_tflegidnomape ,
                                           AV58Legajo_permanenciawwds_3_tfleghisfecing ,
                                           AV59Legajo_permanenciawwds_4_tfleghisfecing_to ,
                                           AV60Legajo_permanenciawwds_5_tfleghisfecegr ,
                                           AV61Legajo_permanenciawwds_6_tfleghisfecegr_to ,
                                           Byte.valueOf(AV62Legajo_permanenciawwds_7_tfleghisafecant_sel) ,
                                           Integer.valueOf(AV64Legajo_permanenciawwds_9_tfleghismotivo_sels.size()) ,
                                           AV63Legajo_permanenciawwds_8_tfleghismotivo ,
                                           A2253LegHisFecIng ,
                                           A2254LegHisFecEgr ,
                                           Boolean.valueOf(A2258LegHisAfecAnt) ,
                                           Integer.valueOf(AV47CliCod) ,
                                           Short.valueOf(AV48EmpCod) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.BYTE, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT
                                           }
      });
      lV56Legajo_permanenciawwds_1_tflegidnomape = GXutil.concat( GXutil.rtrim( AV56Legajo_permanenciawwds_1_tflegidnomape), "%", "") ;
      lV63Legajo_permanenciawwds_8_tfleghismotivo = GXutil.concat( GXutil.rtrim( AV63Legajo_permanenciawwds_8_tfleghismotivo), "%", "") ;
      /* Using cursor P02G12 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV47CliCod), Short.valueOf(AV48EmpCod), lV56Legajo_permanenciawwds_1_tflegidnomape, AV58Legajo_permanenciawwds_3_tfleghisfecing, AV59Legajo_permanenciawwds_4_tfleghisfecing_to, AV60Legajo_permanenciawwds_5_tfleghisfecegr, AV61Legajo_permanenciawwds_6_tfleghisfecegr_to, lV63Legajo_permanenciawwds_8_tfleghismotivo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A2330LegHisMotCod = P02G12_A2330LegHisMotCod[0] ;
         n2330LegHisMotCod = P02G12_n2330LegHisMotCod[0] ;
         A3CliCod = P02G12_A3CliCod[0] ;
         A1EmpCod = P02G12_A1EmpCod[0] ;
         A2256LegHisMotivo = P02G12_A2256LegHisMotivo[0] ;
         A2258LegHisAfecAnt = P02G12_A2258LegHisAfecAnt[0] ;
         A2254LegHisFecEgr = P02G12_A2254LegHisFecEgr[0] ;
         A2253LegHisFecIng = P02G12_A2253LegHisFecIng[0] ;
         A250LegIdNomApe = P02G12_A250LegIdNomApe[0] ;
         A6LegNumero = P02G12_A6LegNumero[0] ;
         A2256LegHisMotivo = P02G12_A2256LegHisMotivo[0] ;
         A250LegIdNomApe = P02G12_A250LegIdNomApe[0] ;
         AV14CellRow = (int)(AV14CellRow+1) ;
         /* Execute user subroutine: 'BEFOREWRITELINE' */
         S172 ();
         if ( returnInSub )
         {
            pr_default.close(0);
            pr_default.close(0);
            pr_default.close(0);
            returnInSub = true;
            if (true) return;
         }
         AV30VisibleColumnCount = 0 ;
         AV65GXV4 = 1 ;
         while ( AV65GXV4 <= AV22ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
         {
            AV24ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV22ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV65GXV4));
            if ( AV24ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
            {
               if ( GXutil.strcmp(AV24ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LegIdNomApe") == 0 )
               {
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A250LegIdNomApe, GXv_char7) ;
                  legajo_permanenciawwexport.this.GXt_char6 = GXv_char7[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV30VisibleColumnCount), 1, 1).setText( GXt_char6 );
               }
               else if ( GXutil.strcmp(AV24ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LegHisFecIng") == 0 )
               {
                  GXt_dtime8 = GXutil.resetTime( A2253LegHisFecIng );
                  AV11ExcelDocument.setDateFormat(localUtil, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " ");
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV30VisibleColumnCount), 1, 1).setDate( GXt_dtime8 );
               }
               else if ( GXutil.strcmp(AV24ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LegHisFecEgr") == 0 )
               {
                  GXt_dtime8 = GXutil.resetTime( A2254LegHisFecEgr );
                  AV11ExcelDocument.setDateFormat(localUtil, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " ");
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV30VisibleColumnCount), 1, 1).setDate( GXt_dtime8 );
               }
               else if ( GXutil.strcmp(AV24ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LegHisAfecAnt") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV30VisibleColumnCount), 1, 1).setText( GXutil.booltostr( A2258LegHisAfecAnt) );
               }
               else if ( GXutil.strcmp(AV24ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LegHisMotivo") == 0 )
               {
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A2256LegHisMotivo, GXv_char7) ;
                  legajo_permanenciawwexport.this.GXt_char6 = GXv_char7[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV30VisibleColumnCount), 1, 1).setText( GXt_char6 );
               }
               AV30VisibleColumnCount = (long)(AV30VisibleColumnCount+1) ;
            }
            AV65GXV4 = (int)(AV65GXV4+1) ;
         }
         /* Execute user subroutine: 'AFTERWRITELINE' */
         S182 ();
         if ( returnInSub )
         {
            pr_default.close(0);
            pr_default.close(0);
            pr_default.close(0);
            returnInSub = true;
            if (true) return;
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
   }

   public void S191( )
   {
      /* 'CLOSEDOCUMENT' Routine */
      returnInSub = false ;
      AV11ExcelDocument.Save();
      /* Execute user subroutine: 'CHECKSTATUS' */
      S121 ();
      if (returnInSub) return;
      AV11ExcelDocument.Close();
   }

   public void S121( )
   {
      /* 'CHECKSTATUS' Routine */
      returnInSub = false ;
      if ( AV11ExcelDocument.getErrCode() != 0 )
      {
         AV12Filename = "" ;
         AV13ErrorMessage = AV11ExcelDocument.getErrDescription() ;
         AV11ExcelDocument.Close();
         returnInSub = true;
         if (true) return;
      }
   }

   public void S151( )
   {
      /* 'INITIALIZECOLUMNSSELECTOR' Routine */
      returnInSub = false ;
      AV22ColumnsSelector = (web.wwpbaseobjects.SdtWWPColumnsSelector)new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector9[0] = AV22ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "LegIdNomApe", "", "Legajo", true, "") ;
      AV22ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV22ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "LegHisFecIng", "", "Ingreso", true, "") ;
      AV22ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV22ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "LegHisFecEgr", "", "Egreso", true, "") ;
      AV22ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV22ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "&LegHisAntTxtAbr", "", "Permanencia", true, "") ;
      AV22ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV22ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "&LegHisAntTexto", "", "Antiguedad", true, "") ;
      AV22ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV22ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "LegHisAfecAnt", "", "Afecta antiguedad", true, "") ;
      AV22ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV22ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "LegHisMotivo", "", "Motivo de egreso", true, "") ;
      AV22ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV22ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "&Origen", "", "Origen", true, "") ;
      AV22ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV22ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "&VerSVG", "", "", true, "") ;
      AV22ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV22ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "&ModificarSVG", "", "", true, "") ;
      AV22ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV22ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "&EliminarSVG", "", "", true, "") ;
      AV22ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXt_char6 = AV26UserCustomValue ;
      GXv_char7[0] = GXt_char6 ;
      new web.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "legajo_permanenciaWWColumnsSelector", GXv_char7) ;
      legajo_permanenciawwexport.this.GXt_char6 = GXv_char7[0] ;
      AV26UserCustomValue = GXt_char6 ;
      if ( ! ( (GXutil.strcmp("", AV26UserCustomValue)==0) ) )
      {
         AV23ColumnsSelectorAux.fromxml(AV26UserCustomValue, null, null);
         GXv_SdtWWPColumnsSelector9[0] = AV23ColumnsSelectorAux;
         GXv_SdtWWPColumnsSelector10[0] = AV22ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnselector_updatecolumns(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, GXv_SdtWWPColumnsSelector10) ;
         AV23ColumnsSelectorAux = GXv_SdtWWPColumnsSelector9[0] ;
         AV22ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      }
   }

   public void S201( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV18Session.getValue("legajo_permanenciaWWGridState"), "") == 0 )
      {
         AV20GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "legajo_permanenciaWWGridState"), null, null);
      }
      else
      {
         AV20GridState.fromxml(AV18Session.getValue("legajo_permanenciaWWGridState"), null, null);
      }
      AV66GXV5 = 1 ;
      while ( AV66GXV5 <= AV20GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV21GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV20GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV66GXV5));
         if ( GXutil.strcmp(AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGIDNOMAPE") == 0 )
         {
            AV34TFLegIdNomApe = AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGIDNOMAPE_SEL") == 0 )
         {
            AV33TFLegIdNomApe_SelsJson = AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV35TFLegIdNomApe_Sels.fromJSonString(AV33TFLegIdNomApe_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGHISFECING") == 0 )
         {
            AV37TFLegHisFecIng = localUtil.ctod( AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            AV38TFLegHisFecIng_To = localUtil.ctod( AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
         }
         else if ( GXutil.strcmp(AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGHISFECEGR") == 0 )
         {
            AV39TFLegHisFecEgr = localUtil.ctod( AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            AV40TFLegHisFecEgr_To = localUtil.ctod( AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
         }
         else if ( GXutil.strcmp(AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGHISAFECANT_SEL") == 0 )
         {
            AV41TFLegHisAfecAnt_Sel = (byte)(GXutil.lval( AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGHISMOTIVO") == 0 )
         {
            AV43TFLegHisMotivo = AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGHISMOTIVO_SEL") == 0 )
         {
            AV42TFLegHisMotivo_SelsJson = AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV44TFLegHisMotivo_Sels.fromJSonString(AV42TFLegHisMotivo_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV17MenuOpcCod = AV21GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV66GXV5 = (int)(AV66GXV5+1) ;
      }
   }

   public void S172( )
   {
      /* 'BEFOREWRITELINE' Routine */
      returnInSub = false ;
   }

   public void S182( )
   {
      /* 'AFTERWRITELINE' Routine */
      returnInSub = false ;
   }

   protected void cleanup( )
   {
      this.aP0[0] = legajo_permanenciawwexport.this.AV12Filename;
      this.aP1[0] = legajo_permanenciawwexport.this.AV13ErrorMessage;
      CloseOpenCursors();
      AV11ExcelDocument.cleanup();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV12Filename = "" ;
      AV13ErrorMessage = "" ;
      GXv_boolean2 = new boolean[1] ;
      AV51Pgmname = "" ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV11ExcelDocument = new com.genexus.gxoffice.ExcelDoc();
      AV35TFLegIdNomApe_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV36TFLegIdNomApe_Sel = "" ;
      AV34TFLegIdNomApe = "" ;
      AV37TFLegHisFecIng = GXutil.nullDate() ;
      AV38TFLegHisFecIng_To = GXutil.nullDate() ;
      AV39TFLegHisFecEgr = GXutil.nullDate() ;
      AV40TFLegHisFecEgr_To = GXutil.nullDate() ;
      AV44TFLegHisMotivo_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV45TFLegHisMotivo_Sel = "" ;
      AV43TFLegHisMotivo = "" ;
      GXv_exceldoc4 = new com.genexus.gxoffice.ExcelDoc[1] ;
      GXv_int5 = new short[1] ;
      AV18Session = httpContext.getWebSession();
      AV25ColumnsSelectorXML = "" ;
      AV22ColumnsSelector = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV24ColumnsSelector_Column = new web.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      A250LegIdNomApe = "" ;
      A2253LegHisFecIng = GXutil.nullDate() ;
      A2254LegHisFecEgr = GXutil.nullDate() ;
      A2256LegHisMotivo = "" ;
      AV56Legajo_permanenciawwds_1_tflegidnomape = "" ;
      AV57Legajo_permanenciawwds_2_tflegidnomape_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV58Legajo_permanenciawwds_3_tfleghisfecing = GXutil.nullDate() ;
      AV59Legajo_permanenciawwds_4_tfleghisfecing_to = GXutil.nullDate() ;
      AV60Legajo_permanenciawwds_5_tfleghisfecegr = GXutil.nullDate() ;
      AV61Legajo_permanenciawwds_6_tfleghisfecegr_to = GXutil.nullDate() ;
      AV63Legajo_permanenciawwds_8_tfleghismotivo = "" ;
      AV64Legajo_permanenciawwds_9_tfleghismotivo_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV56Legajo_permanenciawwds_1_tflegidnomape = "" ;
      lV63Legajo_permanenciawwds_8_tfleghismotivo = "" ;
      P02G12_A2330LegHisMotCod = new String[] {""} ;
      P02G12_n2330LegHisMotCod = new boolean[] {false} ;
      P02G12_A3CliCod = new int[1] ;
      P02G12_A1EmpCod = new short[1] ;
      P02G12_A2256LegHisMotivo = new String[] {""} ;
      P02G12_A2258LegHisAfecAnt = new boolean[] {false} ;
      P02G12_A2254LegHisFecEgr = new java.util.Date[] {GXutil.nullDate()} ;
      P02G12_A2253LegHisFecIng = new java.util.Date[] {GXutil.nullDate()} ;
      P02G12_A250LegIdNomApe = new String[] {""} ;
      P02G12_A6LegNumero = new int[1] ;
      A2330LegHisMotCod = "" ;
      GXt_dtime8 = GXutil.resetTime( GXutil.nullDate() );
      AV26UserCustomValue = "" ;
      GXt_char6 = "" ;
      GXv_char7 = new String[1] ;
      AV23ColumnsSelectorAux = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector9 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector10 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      AV20GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV21GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV33TFLegIdNomApe_SelsJson = "" ;
      AV42TFLegHisMotivo_SelsJson = "" ;
      AV17MenuOpcCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.legajo_permanenciawwexport__default(),
         new Object[] {
             new Object[] {
            P02G12_A2330LegHisMotCod, P02G12_n2330LegHisMotCod, P02G12_A3CliCod, P02G12_A1EmpCod, P02G12_A2256LegHisMotivo, P02G12_A2258LegHisAfecAnt, P02G12_A2254LegHisFecEgr, P02G12_A2253LegHisFecIng, P02G12_A250LegIdNomApe, P02G12_A6LegNumero
            }
         }
      );
      AV51Pgmname = "legajo_permanenciaWWExport" ;
      /* GeneXus formulas. */
      AV51Pgmname = "legajo_permanenciaWWExport" ;
      Gx_err = (short)(0) ;
   }

   private byte AV41TFLegHisAfecAnt_Sel ;
   private byte AV62Legajo_permanenciawwds_7_tfleghisafecant_sel ;
   private short GXv_int5[] ;
   private short AV48EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV14CellRow ;
   private int AV15FirstColumn ;
   private int AV16Random ;
   private int AV52GXV1 ;
   private int AV53GXV2 ;
   private int AV54GXV3 ;
   private int AV57Legajo_permanenciawwds_2_tflegidnomape_sels_size ;
   private int AV64Legajo_permanenciawwds_9_tfleghismotivo_sels_size ;
   private int AV47CliCod ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private int AV65GXV4 ;
   private int AV66GXV5 ;
   private long AV46i ;
   private long AV30VisibleColumnCount ;
   private String AV51Pgmname ;
   private String scmdbuf ;
   private String A2330LegHisMotCod ;
   private String GXt_char6 ;
   private String GXv_char7[] ;
   private java.util.Date GXt_dtime8 ;
   private java.util.Date AV37TFLegHisFecIng ;
   private java.util.Date AV38TFLegHisFecIng_To ;
   private java.util.Date AV39TFLegHisFecEgr ;
   private java.util.Date AV40TFLegHisFecEgr_To ;
   private java.util.Date A2253LegHisFecIng ;
   private java.util.Date A2254LegHisFecEgr ;
   private java.util.Date AV58Legajo_permanenciawwds_3_tfleghisfecing ;
   private java.util.Date AV59Legajo_permanenciawwds_4_tfleghisfecing_to ;
   private java.util.Date AV60Legajo_permanenciawwds_5_tfleghisfecegr ;
   private java.util.Date AV61Legajo_permanenciawwds_6_tfleghisfecegr_to ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean A2258LegHisAfecAnt ;
   private boolean n2330LegHisMotCod ;
   private String AV25ColumnsSelectorXML ;
   private String AV26UserCustomValue ;
   private String AV33TFLegIdNomApe_SelsJson ;
   private String AV42TFLegHisMotivo_SelsJson ;
   private String AV12Filename ;
   private String AV13ErrorMessage ;
   private String AV36TFLegIdNomApe_Sel ;
   private String AV34TFLegIdNomApe ;
   private String AV45TFLegHisMotivo_Sel ;
   private String AV43TFLegHisMotivo ;
   private String A250LegIdNomApe ;
   private String A2256LegHisMotivo ;
   private String AV56Legajo_permanenciawwds_1_tflegidnomape ;
   private String AV63Legajo_permanenciawwds_8_tfleghismotivo ;
   private String lV56Legajo_permanenciawwds_1_tflegidnomape ;
   private String lV63Legajo_permanenciawwds_8_tfleghismotivo ;
   private String AV17MenuOpcCod ;
   private com.genexus.webpanels.WebSession AV18Session ;
   private GXSimpleCollection<String> AV35TFLegIdNomApe_Sels ;
   private GXSimpleCollection<String> AV44TFLegHisMotivo_Sels ;
   private String[] aP1 ;
   private String[] aP0 ;
   private IDataStoreProvider pr_default ;
   private String[] P02G12_A2330LegHisMotCod ;
   private boolean[] P02G12_n2330LegHisMotCod ;
   private int[] P02G12_A3CliCod ;
   private short[] P02G12_A1EmpCod ;
   private String[] P02G12_A2256LegHisMotivo ;
   private boolean[] P02G12_A2258LegHisAfecAnt ;
   private java.util.Date[] P02G12_A2254LegHisFecEgr ;
   private java.util.Date[] P02G12_A2253LegHisFecIng ;
   private String[] P02G12_A250LegIdNomApe ;
   private int[] P02G12_A6LegNumero ;
   private com.genexus.gxoffice.ExcelDoc AV11ExcelDocument ;
   private com.genexus.gxoffice.ExcelDoc GXv_exceldoc4[] ;
   private GXSimpleCollection<String> AV57Legajo_permanenciawwds_2_tflegidnomape_sels ;
   private GXSimpleCollection<String> AV64Legajo_permanenciawwds_9_tfleghismotivo_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV20GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV21GridStateFilterValue ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV22ColumnsSelector ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV23ColumnsSelectorAux ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector9[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector10[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector_Column AV24ColumnsSelector_Column ;
}

final  class legajo_permanenciawwexport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P02G12( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A250LegIdNomApe ,
                                          GXSimpleCollection<String> AV57Legajo_permanenciawwds_2_tflegidnomape_sels ,
                                          String A2256LegHisMotivo ,
                                          GXSimpleCollection<String> AV64Legajo_permanenciawwds_9_tfleghismotivo_sels ,
                                          int AV57Legajo_permanenciawwds_2_tflegidnomape_sels_size ,
                                          String AV56Legajo_permanenciawwds_1_tflegidnomape ,
                                          java.util.Date AV58Legajo_permanenciawwds_3_tfleghisfecing ,
                                          java.util.Date AV59Legajo_permanenciawwds_4_tfleghisfecing_to ,
                                          java.util.Date AV60Legajo_permanenciawwds_5_tfleghisfecegr ,
                                          java.util.Date AV61Legajo_permanenciawwds_6_tfleghisfecegr_to ,
                                          byte AV62Legajo_permanenciawwds_7_tfleghisafecant_sel ,
                                          int AV64Legajo_permanenciawwds_9_tfleghismotivo_sels_size ,
                                          String AV63Legajo_permanenciawwds_8_tfleghismotivo ,
                                          java.util.Date A2253LegHisFecIng ,
                                          java.util.Date A2254LegHisFecEgr ,
                                          boolean A2258LegHisAfecAnt ,
                                          int AV47CliCod ,
                                          short AV48EmpCod ,
                                          int A3CliCod ,
                                          short A1EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int11 = new byte[8];
      Object[] GXv_Object12 = new Object[2];
      scmdbuf = "SELECT T1.LegHisMotCod AS LegHisMotCod, T1.CliCod, T1.EmpCod, T2.MegDescrip AS LegHisMotivo, T1.LegHisAfecAnt, T1.LegHisFecEgr, T1.LegHisFecIng, T3.LegIdNomApe," ;
      scmdbuf += " T1.LegNumero FROM ((legajo_permanencia T1 LEFT JOIN MotivoEgreso T2 ON T2.CliCod = T1.CliCod AND T2.MegCodigo = T1.LegHisMotCod) INNER JOIN Legajo T3 ON T3.CliCod" ;
      scmdbuf += " = T1.CliCod AND T3.EmpCod = T1.EmpCod AND T3.LegNumero = T1.LegNumero)" ;
      addWhere(sWhereString, "(T1.CliCod = ? and T1.EmpCod = ?)");
      if ( ( AV57Legajo_permanenciawwds_2_tflegidnomape_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV56Legajo_permanenciawwds_1_tflegidnomape)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T3.LegIdNomApe) like LOWER(?))");
      }
      else
      {
         GXv_int11[2] = (byte)(1) ;
      }
      if ( AV57Legajo_permanenciawwds_2_tflegidnomape_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV57Legajo_permanenciawwds_2_tflegidnomape_sels, "T3.LegIdNomApe IN (", ")")+")");
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV58Legajo_permanenciawwds_3_tfleghisfecing)) )
      {
         addWhere(sWhereString, "(T1.LegHisFecIng >= ?)");
      }
      else
      {
         GXv_int11[3] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV59Legajo_permanenciawwds_4_tfleghisfecing_to)) )
      {
         addWhere(sWhereString, "(T1.LegHisFecIng <= ?)");
      }
      else
      {
         GXv_int11[4] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV60Legajo_permanenciawwds_5_tfleghisfecegr)) )
      {
         addWhere(sWhereString, "(T1.LegHisFecEgr >= ?)");
      }
      else
      {
         GXv_int11[5] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV61Legajo_permanenciawwds_6_tfleghisfecegr_to)) )
      {
         addWhere(sWhereString, "(T1.LegHisFecEgr <= ?)");
      }
      else
      {
         GXv_int11[6] = (byte)(1) ;
      }
      if ( AV62Legajo_permanenciawwds_7_tfleghisafecant_sel == 1 )
      {
         addWhere(sWhereString, "(T1.LegHisAfecAnt = TRUE)");
      }
      if ( AV62Legajo_permanenciawwds_7_tfleghisafecant_sel == 2 )
      {
         addWhere(sWhereString, "(T1.LegHisAfecAnt = FALSE)");
      }
      if ( ( AV64Legajo_permanenciawwds_9_tfleghismotivo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV63Legajo_permanenciawwds_8_tfleghismotivo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.MegDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int11[7] = (byte)(1) ;
      }
      if ( AV64Legajo_permanenciawwds_9_tfleghismotivo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV64Legajo_permanenciawwds_9_tfleghismotivo_sels, "T2.MegDescrip IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.CliCod, T1.EmpCod, T1.LegNumero, T1.LegHisFecIng DESC" ;
      GXv_Object12[0] = scmdbuf ;
      GXv_Object12[1] = GXv_int11 ;
      return GXv_Object12 ;
   }

   public Object [] getDynamicStatement( int cursor ,
                                         ModelContext context ,
                                         int remoteHandle ,
                                         com.genexus.IHttpContext httpContext ,
                                         Object [] dynConstraints )
   {
      switch ( cursor )
      {
            case 0 :
                  return conditional_P02G12(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , ((Number) dynConstraints[4]).intValue() , (String)dynConstraints[5] , (java.util.Date)dynConstraints[6] , (java.util.Date)dynConstraints[7] , (java.util.Date)dynConstraints[8] , (java.util.Date)dynConstraints[9] , ((Number) dynConstraints[10]).byteValue() , ((Number) dynConstraints[11]).intValue() , (String)dynConstraints[12] , (java.util.Date)dynConstraints[13] , (java.util.Date)dynConstraints[14] , ((Boolean) dynConstraints[15]).booleanValue() , ((Number) dynConstraints[16]).intValue() , ((Number) dynConstraints[17]).shortValue() , ((Number) dynConstraints[18]).intValue() , ((Number) dynConstraints[19]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02G12", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((int[]) buf[2])[0] = rslt.getInt(2);
               ((short[]) buf[3])[0] = rslt.getShort(3);
               ((String[]) buf[4])[0] = rslt.getVarchar(4);
               ((boolean[]) buf[5])[0] = rslt.getBoolean(5);
               ((java.util.Date[]) buf[6])[0] = rslt.getGXDate(6);
               ((java.util.Date[]) buf[7])[0] = rslt.getGXDate(7);
               ((String[]) buf[8])[0] = rslt.getVarchar(8);
               ((int[]) buf[9])[0] = rslt.getInt(9);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      short sIdx;
      switch ( cursor )
      {
            case 0 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[8]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[9]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[10], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[11]);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[12]);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[13]);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[14]);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[15], 400);
               }
               return;
      }
   }

}

