package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class novedadeventoswwexport extends GXProcedure
{
   public novedadeventoswwexport( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( novedadeventoswwexport.class ), "" );
   }

   public novedadeventoswwexport( int remoteHandle ,
                                  ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String[] aP0 )
   {
      novedadeventoswwexport.this.aP1 = new String[] {""};
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
      novedadeventoswwexport.this.aP0 = aP0;
      novedadeventoswwexport.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWNovedadEventos", GXv_boolean2) ;
      novedadeventoswwexport.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( ! AV8IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV57Pgmname))}, new String[] {"GxObject"}) );
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
      AV12Filename = "NovedadEventosWWExport-" + GXutil.trim( GXutil.str( AV16Random, 8, 0)) + ".xlsx" ;
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
      if ( ! ( (false==AV20SitEsLicencia) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Sit Es Licencia", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         novedadeventoswwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXutil.booltostr( AV20SitEsLicencia) );
      }
      if ( ! ( ( AV38TFLegNomApe_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Legajo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         novedadeventoswwexport.this.AV14CellRow = GXv_int5[0] ;
         AV52i = 1 ;
         AV58GXV1 = 1 ;
         while ( AV58GXV1 <= AV38TFLegNomApe_Sels.size() )
         {
            AV39TFLegNomApe_Sel = (String)AV38TFLegNomApe_Sels.elementAt(-1+AV58GXV1) ;
            if ( AV52i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV39TFLegNomApe_Sel, GXv_char7) ;
            novedadeventoswwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char6 );
            AV52i = (long)(AV52i+1) ;
            AV58GXV1 = (int)(AV58GXV1+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV37TFLegNomApe)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Legajo", "")) ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            novedadeventoswwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV37TFLegNomApe, GXv_char7) ;
            novedadeventoswwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV40TFLegLicenIni)) && GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV41TFLegLicenIni_To)) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Inicio", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         novedadeventoswwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_dtime8 = GXutil.resetTime( AV40TFLegLicenIni );
         AV11ExcelDocument.setDateFormat(localUtil, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " ");
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setDate( GXt_dtime8 );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         novedadeventoswwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_dtime8 = GXutil.resetTime( AV41TFLegLicenIni_To );
         AV11ExcelDocument.setDateFormat(localUtil, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " ");
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setDate( GXt_dtime8 );
      }
      if ( ! ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV42TFLegLicenFin)) && GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV43TFLegLicenFin_To)) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Fin", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         novedadeventoswwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_dtime8 = GXutil.resetTime( AV42TFLegLicenFin );
         AV11ExcelDocument.setDateFormat(localUtil, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " ");
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setDate( GXt_dtime8 );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         novedadeventoswwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_dtime8 = GXutil.resetTime( AV43TFLegLicenFin_To );
         AV11ExcelDocument.setDateFormat(localUtil, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " ");
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setDate( GXt_dtime8 );
      }
      if ( ! ( ( AV46TFLegLicDescrip_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Situación", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         novedadeventoswwexport.this.AV14CellRow = GXv_int5[0] ;
         AV52i = 1 ;
         AV59GXV2 = 1 ;
         while ( AV59GXV2 <= AV46TFLegLicDescrip_Sels.size() )
         {
            AV47TFLegLicDescrip_Sel = (String)AV46TFLegLicDescrip_Sels.elementAt(-1+AV59GXV2) ;
            if ( AV52i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV47TFLegLicDescrip_Sel, GXv_char7) ;
            novedadeventoswwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char6 );
            AV52i = (long)(AV52i+1) ;
            AV59GXV2 = (int)(AV59GXV2+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV45TFLegLicDescrip)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Situación", "")) ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            novedadeventoswwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV45TFLegLicDescrip, GXv_char7) ;
            novedadeventoswwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( ( AV49TFLegLicEstado_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Estado", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         novedadeventoswwexport.this.AV14CellRow = GXv_int5[0] ;
         AV52i = 1 ;
         AV60GXV3 = 1 ;
         while ( AV60GXV3 <= AV49TFLegLicEstado_Sels.size() )
         {
            AV50TFLegLicEstado_Sel = (String)AV49TFLegLicEstado_Sels.elementAt(-1+AV60GXV3) ;
            if ( AV52i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+httpContext.getMessage( web.gxdomainlicencia_estado.getDescription(httpContext,(String)AV50TFLegLicEstado_Sel), "") );
            AV52i = (long)(AV52i+1) ;
            AV60GXV3 = (int)(AV60GXV3+1) ;
         }
      }
      if ( ! ( (0==AV51TFLegLicConPlus_Sel) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Plus", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         novedadeventoswwexport.this.AV14CellRow = GXv_int5[0] ;
         if ( AV51TFLegLicConPlus_Sel == 1 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSChecked", "") );
         }
         else if ( AV51TFLegLicConPlus_Sel == 2 )
         {
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "WWP_TSUnChecked", "") );
         }
      }
      AV14CellRow = (int)(AV14CellRow+2) ;
   }

   public void S141( )
   {
      /* 'WRITECOLUMNTITLES' Routine */
      returnInSub = false ;
      AV33VisibleColumnCount = 0 ;
      if ( GXutil.strcmp(AV21Session.getValue("NovedadEventosWWColumnsSelector"), "") != 0 )
      {
         AV28ColumnsSelectorXML = AV21Session.getValue("NovedadEventosWWColumnsSelector") ;
         AV25ColumnsSelector.fromxml(AV28ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S151 ();
         if (returnInSub) return;
      }
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+1)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      AV27ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)new web.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      AV27ColumnsSelector_Column.setgxTv_SdtWWPColumnsSelector_Column_Isvisible( true );
      AV27ColumnsSelector_Column.setgxTv_SdtWWPColumnsSelector_Column_Columnname( "LegId" );
      AV27ColumnsSelector_Column.setgxTv_SdtWWPColumnsSelector_Column_Displayname( httpContext.getMessage( "Legajo Id.", "") );
      AV27ColumnsSelector_Column.setgxTv_SdtWWPColumnsSelector_Column_Order( (short)(AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size()+1) );
      AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().add(AV27ColumnsSelector_Column, 0);
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+8)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+9)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+10)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().sort("Order");
      AV61GXV4 = 1 ;
      while ( AV61GXV4 <= AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
      {
         AV27ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV61GXV4));
         if ( AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setText( httpContext.getMessage( ((GXutil.strcmp("", AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname())==0) ? AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname() : AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname()), "") );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setBold( (short)(1) );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setColor( 11 );
            AV33VisibleColumnCount = (long)(AV33VisibleColumnCount+1) ;
         }
         AV61GXV4 = (int)(AV61GXV4+1) ;
      }
   }

   public void S161( )
   {
      /* 'WRITEDATA' Routine */
      returnInSub = false ;
      AV63Novedadeventoswwds_1_siteslicencia = AV20SitEsLicencia ;
      AV64Novedadeventoswwds_2_tflegnomape = AV37TFLegNomApe ;
      AV65Novedadeventoswwds_3_tflegnomape_sels = AV38TFLegNomApe_Sels ;
      AV66Novedadeventoswwds_4_tfleglicenini = AV40TFLegLicenIni ;
      AV67Novedadeventoswwds_5_tfleglicenini_to = AV41TFLegLicenIni_To ;
      AV68Novedadeventoswwds_6_tfleglicenfin = AV42TFLegLicenFin ;
      AV69Novedadeventoswwds_7_tfleglicenfin_to = AV43TFLegLicenFin_To ;
      AV70Novedadeventoswwds_8_tfleglicdescrip = AV45TFLegLicDescrip ;
      AV71Novedadeventoswwds_9_tfleglicdescrip_sels = AV46TFLegLicDescrip_Sels ;
      AV72Novedadeventoswwds_10_tfleglicestado_sels = AV49TFLegLicEstado_Sels ;
      AV73Novedadeventoswwds_11_tfleglicconplus_sel = AV51TFLegLicConPlus_Sel ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A591LegNomApe ,
                                           AV65Novedadeventoswwds_3_tflegnomape_sels ,
                                           A914LegLicDescrip ,
                                           AV71Novedadeventoswwds_9_tfleglicdescrip_sels ,
                                           A1497LegLicEstado ,
                                           AV72Novedadeventoswwds_10_tfleglicestado_sels ,
                                           Integer.valueOf(AV65Novedadeventoswwds_3_tflegnomape_sels.size()) ,
                                           AV64Novedadeventoswwds_2_tflegnomape ,
                                           AV66Novedadeventoswwds_4_tfleglicenini ,
                                           AV67Novedadeventoswwds_5_tfleglicenini_to ,
                                           AV68Novedadeventoswwds_6_tfleglicenfin ,
                                           AV69Novedadeventoswwds_7_tfleglicenfin_to ,
                                           Integer.valueOf(AV71Novedadeventoswwds_9_tfleglicdescrip_sels.size()) ,
                                           AV70Novedadeventoswwds_8_tfleglicdescrip ,
                                           Integer.valueOf(AV72Novedadeventoswwds_10_tfleglicestado_sels.size()) ,
                                           Byte.valueOf(AV73Novedadeventoswwds_11_tfleglicconplus_sel) ,
                                           A76LegLicenIni ,
                                           A481LegLicenFin ,
                                           Boolean.valueOf(A1218LegLicConPlus) ,
                                           Short.valueOf(AV18OrderedBy) ,
                                           Boolean.valueOf(AV19OrderedDsc) ,
                                           Boolean.valueOf(A738SitEsLicencia) ,
                                           Integer.valueOf(AV53CliCod) ,
                                           Short.valueOf(AV54EmpCod) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.BYTE, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN,
                                           TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT
                                           }
      });
      lV64Novedadeventoswwds_2_tflegnomape = GXutil.concat( GXutil.rtrim( AV64Novedadeventoswwds_2_tflegnomape), "%", "") ;
      lV70Novedadeventoswwds_8_tfleglicdescrip = GXutil.concat( GXutil.rtrim( AV70Novedadeventoswwds_8_tfleglicdescrip), "%", "") ;
      /* Using cursor P02FA2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV53CliCod), Short.valueOf(AV54EmpCod), lV64Novedadeventoswwds_2_tflegnomape, AV66Novedadeventoswwds_4_tfleglicenini, AV67Novedadeventoswwds_5_tfleglicenini_to, AV68Novedadeventoswwds_6_tfleglicenfin, AV69Novedadeventoswwds_7_tfleglicenfin_to, lV70Novedadeventoswwds_8_tfleglicdescrip});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A6LegNumero = P02FA2_A6LegNumero[0] ;
         A506LegLicSitCodigo = P02FA2_A506LegLicSitCodigo[0] ;
         A1EmpCod = P02FA2_A1EmpCod[0] ;
         A3CliCod = P02FA2_A3CliCod[0] ;
         A1218LegLicConPlus = P02FA2_A1218LegLicConPlus[0] ;
         A1497LegLicEstado = P02FA2_A1497LegLicEstado[0] ;
         A914LegLicDescrip = P02FA2_A914LegLicDescrip[0] ;
         A591LegNomApe = P02FA2_A591LegNomApe[0] ;
         A738SitEsLicencia = P02FA2_A738SitEsLicencia[0] ;
         n738SitEsLicencia = P02FA2_n738SitEsLicencia[0] ;
         A93LegId = P02FA2_A93LegId[0] ;
         n93LegId = P02FA2_n93LegId[0] ;
         A76LegLicenIni = P02FA2_A76LegLicenIni[0] ;
         A481LegLicenFin = P02FA2_A481LegLicenFin[0] ;
         A738SitEsLicencia = P02FA2_A738SitEsLicencia[0] ;
         n738SitEsLicencia = P02FA2_n738SitEsLicencia[0] ;
         A591LegNomApe = P02FA2_A591LegNomApe[0] ;
         A93LegId = P02FA2_A93LegId[0] ;
         n93LegId = P02FA2_n93LegId[0] ;
         if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A481LegLicenFin)) )
         {
            A501LegLicCntDias = (short)(GXutil.ddiff(A481LegLicenFin,A76LegLicenIni)+1) ;
         }
         else
         {
            A501LegLicCntDias = (short)(GXutil.ddiff(GXutil.eomdate( A76LegLicenIni),A76LegLicenIni)+1) ;
         }
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
         AV33VisibleColumnCount = 0 ;
         AV74GXV5 = 1 ;
         while ( AV74GXV5 <= AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
         {
            AV27ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV74GXV5));
            if ( AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
            {
               if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LegId") == 0 )
               {
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A93LegId, GXv_char7) ;
                  novedadeventoswwexport.this.GXt_char6 = GXv_char7[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setText( GXt_char6 );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LegLicenIni") == 0 )
               {
                  GXt_dtime8 = GXutil.resetTime( A76LegLicenIni );
                  AV11ExcelDocument.setDateFormat(localUtil, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " ");
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setDate( GXt_dtime8 );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LegLicenFin") == 0 )
               {
                  GXt_dtime8 = GXutil.resetTime( A481LegLicenFin );
                  AV11ExcelDocument.setDateFormat(localUtil, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " ");
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setDate( GXt_dtime8 );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LegLicCntDias") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setNumber( A501LegLicCntDias );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LegLicDescrip") == 0 )
               {
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A914LegLicDescrip, GXv_char7) ;
                  novedadeventoswwexport.this.GXt_char6 = GXv_char7[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setText( GXt_char6 );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LegLicEstado") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setText( httpContext.getMessage( web.gxdomainlicencia_estado.getDescription(httpContext,(String)A1497LegLicEstado), "") );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LegLicConPlus") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setText( GXutil.booltostr( A1218LegLicConPlus) );
               }
               AV33VisibleColumnCount = (long)(AV33VisibleColumnCount+1) ;
            }
            AV74GXV5 = (int)(AV74GXV5+1) ;
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
      AV25ColumnsSelector = (web.wwpbaseobjects.SdtWWPColumnsSelector)new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector9[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "LegNomApe", "", "Legajo", true, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "LegLicenIni", "", "Inicio", true, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "LegLicenFin", "", "Fin", true, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "LegLicCntDias", "", "Días", true, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "LegLicDescrip", "", "Situación", true, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "LegLicEstado", "", "Estado", true, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "LegLicConPlus", "", "Plus", true, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "&VerSVG", "", "", true, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "&ModificarSVG", "", "", true, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "&EliminarSVG", "", "", true, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXt_char6 = AV29UserCustomValue ;
      GXv_char7[0] = GXt_char6 ;
      new web.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "NovedadEventosWWColumnsSelector", GXv_char7) ;
      novedadeventoswwexport.this.GXt_char6 = GXv_char7[0] ;
      AV29UserCustomValue = GXt_char6 ;
      if ( ! ( (GXutil.strcmp("", AV29UserCustomValue)==0) ) )
      {
         AV26ColumnsSelectorAux.fromxml(AV29UserCustomValue, null, null);
         GXv_SdtWWPColumnsSelector9[0] = AV26ColumnsSelectorAux;
         GXv_SdtWWPColumnsSelector10[0] = AV25ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnselector_updatecolumns(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, GXv_SdtWWPColumnsSelector10) ;
         AV26ColumnsSelectorAux = GXv_SdtWWPColumnsSelector9[0] ;
         AV25ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      }
   }

   public void S201( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV21Session.getValue("NovedadEventosWWGridState"), "") == 0 )
      {
         AV23GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "NovedadEventosWWGridState"), null, null);
      }
      else
      {
         AV23GridState.fromxml(AV21Session.getValue("NovedadEventosWWGridState"), null, null);
      }
      AV18OrderedBy = AV23GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV19OrderedDsc = AV23GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV75GXV6 = 1 ;
      while ( AV75GXV6 <= AV23GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV24GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV23GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV75GXV6));
         if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "SITESLICENCIA") == 0 )
         {
            AV20SitEsLicencia = GXutil.boolval( AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value()) ;
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGNOMAPE") == 0 )
         {
            AV37TFLegNomApe = AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGNOMAPE_SEL") == 0 )
         {
            AV36TFLegNomApe_SelsJson = AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV38TFLegNomApe_Sels.fromJSonString(AV36TFLegNomApe_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGLICENINI") == 0 )
         {
            AV40TFLegLicenIni = localUtil.ctod( AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            AV41TFLegLicenIni_To = localUtil.ctod( AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGLICENFIN") == 0 )
         {
            AV42TFLegLicenFin = localUtil.ctod( AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            AV43TFLegLicenFin_To = localUtil.ctod( AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGLICDESCRIP") == 0 )
         {
            AV45TFLegLicDescrip = AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGLICDESCRIP_SEL") == 0 )
         {
            AV44TFLegLicDescrip_SelsJson = AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV46TFLegLicDescrip_Sels.fromJSonString(AV44TFLegLicDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGLICESTADO_SEL") == 0 )
         {
            AV48TFLegLicEstado_SelsJson = AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV49TFLegLicEstado_Sels.fromJSonString(AV48TFLegLicEstado_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGLICCONPLUS_SEL") == 0 )
         {
            AV51TFLegLicConPlus_Sel = (byte)(GXutil.lval( AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV17MenuOpcCod = AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV75GXV6 = (int)(AV75GXV6+1) ;
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
      this.aP0[0] = novedadeventoswwexport.this.AV12Filename;
      this.aP1[0] = novedadeventoswwexport.this.AV13ErrorMessage;
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
      AV57Pgmname = "" ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV11ExcelDocument = new com.genexus.gxoffice.ExcelDoc();
      AV38TFLegNomApe_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV39TFLegNomApe_Sel = "" ;
      AV37TFLegNomApe = "" ;
      AV40TFLegLicenIni = GXutil.nullDate() ;
      AV41TFLegLicenIni_To = GXutil.nullDate() ;
      AV42TFLegLicenFin = GXutil.nullDate() ;
      AV43TFLegLicenFin_To = GXutil.nullDate() ;
      AV46TFLegLicDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV47TFLegLicDescrip_Sel = "" ;
      AV45TFLegLicDescrip = "" ;
      AV49TFLegLicEstado_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV50TFLegLicEstado_Sel = "" ;
      GXv_exceldoc4 = new com.genexus.gxoffice.ExcelDoc[1] ;
      GXv_int5 = new short[1] ;
      AV21Session = httpContext.getWebSession();
      AV28ColumnsSelectorXML = "" ;
      AV25ColumnsSelector = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV27ColumnsSelector_Column = new web.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      A93LegId = "" ;
      A76LegLicenIni = GXutil.nullDate() ;
      A481LegLicenFin = GXutil.nullDate() ;
      A914LegLicDescrip = "" ;
      A1497LegLicEstado = "" ;
      AV64Novedadeventoswwds_2_tflegnomape = "" ;
      AV65Novedadeventoswwds_3_tflegnomape_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV66Novedadeventoswwds_4_tfleglicenini = GXutil.nullDate() ;
      AV67Novedadeventoswwds_5_tfleglicenini_to = GXutil.nullDate() ;
      AV68Novedadeventoswwds_6_tfleglicenfin = GXutil.nullDate() ;
      AV69Novedadeventoswwds_7_tfleglicenfin_to = GXutil.nullDate() ;
      AV70Novedadeventoswwds_8_tfleglicdescrip = "" ;
      AV71Novedadeventoswwds_9_tfleglicdescrip_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV72Novedadeventoswwds_10_tfleglicestado_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV64Novedadeventoswwds_2_tflegnomape = "" ;
      lV70Novedadeventoswwds_8_tfleglicdescrip = "" ;
      A591LegNomApe = "" ;
      P02FA2_A6LegNumero = new int[1] ;
      P02FA2_A506LegLicSitCodigo = new String[] {""} ;
      P02FA2_A1EmpCod = new short[1] ;
      P02FA2_A3CliCod = new int[1] ;
      P02FA2_A1218LegLicConPlus = new boolean[] {false} ;
      P02FA2_A1497LegLicEstado = new String[] {""} ;
      P02FA2_A914LegLicDescrip = new String[] {""} ;
      P02FA2_A591LegNomApe = new String[] {""} ;
      P02FA2_A738SitEsLicencia = new boolean[] {false} ;
      P02FA2_n738SitEsLicencia = new boolean[] {false} ;
      P02FA2_A93LegId = new String[] {""} ;
      P02FA2_n93LegId = new boolean[] {false} ;
      P02FA2_A76LegLicenIni = new java.util.Date[] {GXutil.nullDate()} ;
      P02FA2_A481LegLicenFin = new java.util.Date[] {GXutil.nullDate()} ;
      A506LegLicSitCodigo = "" ;
      GXt_dtime8 = GXutil.resetTime( GXutil.nullDate() );
      AV29UserCustomValue = "" ;
      GXt_char6 = "" ;
      GXv_char7 = new String[1] ;
      AV26ColumnsSelectorAux = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector9 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector10 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      AV23GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV24GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV36TFLegNomApe_SelsJson = "" ;
      AV44TFLegLicDescrip_SelsJson = "" ;
      AV48TFLegLicEstado_SelsJson = "" ;
      AV17MenuOpcCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.novedadeventoswwexport__default(),
         new Object[] {
             new Object[] {
            P02FA2_A6LegNumero, P02FA2_A506LegLicSitCodigo, P02FA2_A1EmpCod, P02FA2_A3CliCod, P02FA2_A1218LegLicConPlus, P02FA2_A1497LegLicEstado, P02FA2_A914LegLicDescrip, P02FA2_A591LegNomApe, P02FA2_A738SitEsLicencia, P02FA2_n738SitEsLicencia,
            P02FA2_A93LegId, P02FA2_n93LegId, P02FA2_A76LegLicenIni, P02FA2_A481LegLicenFin
            }
         }
      );
      AV57Pgmname = "NovedadEventosWWExport" ;
      /* GeneXus formulas. */
      AV57Pgmname = "NovedadEventosWWExport" ;
      Gx_err = (short)(0) ;
   }

   private byte AV51TFLegLicConPlus_Sel ;
   private byte AV73Novedadeventoswwds_11_tfleglicconplus_sel ;
   private short GXv_int5[] ;
   private short A501LegLicCntDias ;
   private short AV18OrderedBy ;
   private short AV54EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV14CellRow ;
   private int AV15FirstColumn ;
   private int AV16Random ;
   private int AV58GXV1 ;
   private int AV59GXV2 ;
   private int AV60GXV3 ;
   private int AV61GXV4 ;
   private int AV65Novedadeventoswwds_3_tflegnomape_sels_size ;
   private int AV71Novedadeventoswwds_9_tfleglicdescrip_sels_size ;
   private int AV72Novedadeventoswwds_10_tfleglicestado_sels_size ;
   private int AV53CliCod ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private int AV74GXV5 ;
   private int AV75GXV6 ;
   private long AV52i ;
   private long AV33VisibleColumnCount ;
   private String AV57Pgmname ;
   private String AV50TFLegLicEstado_Sel ;
   private String A93LegId ;
   private String A1497LegLicEstado ;
   private String scmdbuf ;
   private String A506LegLicSitCodigo ;
   private String GXt_char6 ;
   private String GXv_char7[] ;
   private java.util.Date GXt_dtime8 ;
   private java.util.Date AV40TFLegLicenIni ;
   private java.util.Date AV41TFLegLicenIni_To ;
   private java.util.Date AV42TFLegLicenFin ;
   private java.util.Date AV43TFLegLicenFin_To ;
   private java.util.Date A76LegLicenIni ;
   private java.util.Date A481LegLicenFin ;
   private java.util.Date AV66Novedadeventoswwds_4_tfleglicenini ;
   private java.util.Date AV67Novedadeventoswwds_5_tfleglicenini_to ;
   private java.util.Date AV68Novedadeventoswwds_6_tfleglicenfin ;
   private java.util.Date AV69Novedadeventoswwds_7_tfleglicenfin_to ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean AV20SitEsLicencia ;
   private boolean A1218LegLicConPlus ;
   private boolean AV63Novedadeventoswwds_1_siteslicencia ;
   private boolean AV19OrderedDsc ;
   private boolean A738SitEsLicencia ;
   private boolean n738SitEsLicencia ;
   private boolean n93LegId ;
   private String AV28ColumnsSelectorXML ;
   private String AV29UserCustomValue ;
   private String AV36TFLegNomApe_SelsJson ;
   private String AV44TFLegLicDescrip_SelsJson ;
   private String AV48TFLegLicEstado_SelsJson ;
   private String AV12Filename ;
   private String AV13ErrorMessage ;
   private String AV39TFLegNomApe_Sel ;
   private String AV37TFLegNomApe ;
   private String AV47TFLegLicDescrip_Sel ;
   private String AV45TFLegLicDescrip ;
   private String A914LegLicDescrip ;
   private String AV64Novedadeventoswwds_2_tflegnomape ;
   private String AV70Novedadeventoswwds_8_tfleglicdescrip ;
   private String lV64Novedadeventoswwds_2_tflegnomape ;
   private String lV70Novedadeventoswwds_8_tfleglicdescrip ;
   private String A591LegNomApe ;
   private String AV17MenuOpcCod ;
   private com.genexus.webpanels.WebSession AV21Session ;
   private GXSimpleCollection<String> AV49TFLegLicEstado_Sels ;
   private GXSimpleCollection<String> AV38TFLegNomApe_Sels ;
   private GXSimpleCollection<String> AV46TFLegLicDescrip_Sels ;
   private String[] aP1 ;
   private String[] aP0 ;
   private IDataStoreProvider pr_default ;
   private int[] P02FA2_A6LegNumero ;
   private String[] P02FA2_A506LegLicSitCodigo ;
   private short[] P02FA2_A1EmpCod ;
   private int[] P02FA2_A3CliCod ;
   private boolean[] P02FA2_A1218LegLicConPlus ;
   private String[] P02FA2_A1497LegLicEstado ;
   private String[] P02FA2_A914LegLicDescrip ;
   private String[] P02FA2_A591LegNomApe ;
   private boolean[] P02FA2_A738SitEsLicencia ;
   private boolean[] P02FA2_n738SitEsLicencia ;
   private String[] P02FA2_A93LegId ;
   private boolean[] P02FA2_n93LegId ;
   private java.util.Date[] P02FA2_A76LegLicenIni ;
   private java.util.Date[] P02FA2_A481LegLicenFin ;
   private com.genexus.gxoffice.ExcelDoc AV11ExcelDocument ;
   private com.genexus.gxoffice.ExcelDoc GXv_exceldoc4[] ;
   private GXSimpleCollection<String> AV72Novedadeventoswwds_10_tfleglicestado_sels ;
   private GXSimpleCollection<String> AV65Novedadeventoswwds_3_tflegnomape_sels ;
   private GXSimpleCollection<String> AV71Novedadeventoswwds_9_tfleglicdescrip_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV23GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV24GridStateFilterValue ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV25ColumnsSelector ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV26ColumnsSelectorAux ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector9[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector10[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector_Column AV27ColumnsSelector_Column ;
}

final  class novedadeventoswwexport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P02FA2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A591LegNomApe ,
                                          GXSimpleCollection<String> AV65Novedadeventoswwds_3_tflegnomape_sels ,
                                          String A914LegLicDescrip ,
                                          GXSimpleCollection<String> AV71Novedadeventoswwds_9_tfleglicdescrip_sels ,
                                          String A1497LegLicEstado ,
                                          GXSimpleCollection<String> AV72Novedadeventoswwds_10_tfleglicestado_sels ,
                                          int AV65Novedadeventoswwds_3_tflegnomape_sels_size ,
                                          String AV64Novedadeventoswwds_2_tflegnomape ,
                                          java.util.Date AV66Novedadeventoswwds_4_tfleglicenini ,
                                          java.util.Date AV67Novedadeventoswwds_5_tfleglicenini_to ,
                                          java.util.Date AV68Novedadeventoswwds_6_tfleglicenfin ,
                                          java.util.Date AV69Novedadeventoswwds_7_tfleglicenfin_to ,
                                          int AV71Novedadeventoswwds_9_tfleglicdescrip_sels_size ,
                                          String AV70Novedadeventoswwds_8_tfleglicdescrip ,
                                          int AV72Novedadeventoswwds_10_tfleglicestado_sels_size ,
                                          byte AV73Novedadeventoswwds_11_tfleglicconplus_sel ,
                                          java.util.Date A76LegLicenIni ,
                                          java.util.Date A481LegLicenFin ,
                                          boolean A1218LegLicConPlus ,
                                          short AV18OrderedBy ,
                                          boolean AV19OrderedDsc ,
                                          boolean A738SitEsLicencia ,
                                          int AV53CliCod ,
                                          short AV54EmpCod ,
                                          int A3CliCod ,
                                          short A1EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int11 = new byte[8];
      Object[] GXv_Object12 = new Object[2];
      scmdbuf = "SELECT T1.LegNumero, T1.LegLicSitCodigo AS LegLicSitCodigo, T1.EmpCod, T1.CliCod, T1.LegLicConPlus, T1.LegLicEstado, T1.LegLicDescrip, T3.LegNomApe, T2.SitEsLicencia," ;
      scmdbuf += " T3.LegId, T1.LegLicenIni, T1.LegLicenFin FROM ((LegajoLicencias T1 INNER JOIN Estado T2 ON T2.SitCodigo = T1.LegLicSitCodigo) INNER JOIN Legajo T3 ON T3.CliCod" ;
      scmdbuf += " = T1.CliCod AND T3.EmpCod = T1.EmpCod AND T3.LegNumero = T1.LegNumero)" ;
      addWhere(sWhereString, "(T1.CliCod = ? and T1.EmpCod = ?)");
      addWhere(sWhereString, "(T2.SitEsLicencia = TRUE)");
      if ( ( AV65Novedadeventoswwds_3_tflegnomape_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV64Novedadeventoswwds_2_tflegnomape)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T3.LegNomApe) like LOWER(?))");
      }
      else
      {
         GXv_int11[2] = (byte)(1) ;
      }
      if ( AV65Novedadeventoswwds_3_tflegnomape_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV65Novedadeventoswwds_3_tflegnomape_sels, "T3.LegNomApe IN (", ")")+")");
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV66Novedadeventoswwds_4_tfleglicenini)) )
      {
         addWhere(sWhereString, "(T1.LegLicenIni >= ?)");
      }
      else
      {
         GXv_int11[3] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV67Novedadeventoswwds_5_tfleglicenini_to)) )
      {
         addWhere(sWhereString, "(T1.LegLicenIni <= ?)");
      }
      else
      {
         GXv_int11[4] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV68Novedadeventoswwds_6_tfleglicenfin)) )
      {
         addWhere(sWhereString, "(T1.LegLicenFin >= ?)");
      }
      else
      {
         GXv_int11[5] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV69Novedadeventoswwds_7_tfleglicenfin_to)) )
      {
         addWhere(sWhereString, "(T1.LegLicenFin <= ?)");
      }
      else
      {
         GXv_int11[6] = (byte)(1) ;
      }
      if ( ( AV71Novedadeventoswwds_9_tfleglicdescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV70Novedadeventoswwds_8_tfleglicdescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.LegLicDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int11[7] = (byte)(1) ;
      }
      if ( AV71Novedadeventoswwds_9_tfleglicdescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV71Novedadeventoswwds_9_tfleglicdescrip_sels, "T1.LegLicDescrip IN (", ")")+")");
      }
      if ( AV72Novedadeventoswwds_10_tfleglicestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV72Novedadeventoswwds_10_tfleglicestado_sels, "T1.LegLicEstado IN (", ")")+")");
      }
      if ( AV73Novedadeventoswwds_11_tfleglicconplus_sel == 1 )
      {
         addWhere(sWhereString, "(T1.LegLicConPlus = TRUE)");
      }
      if ( AV73Novedadeventoswwds_11_tfleglicconplus_sel == 2 )
      {
         addWhere(sWhereString, "(T1.LegLicConPlus = FALSE)");
      }
      scmdbuf += sWhereString ;
      if ( ( AV18OrderedBy == 1 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.LegLicenIni" ;
      }
      else if ( ( AV18OrderedBy == 1 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.LegLicenIni DESC" ;
      }
      else if ( ( AV18OrderedBy == 2 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.LegLicenFin" ;
      }
      else if ( ( AV18OrderedBy == 2 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.LegLicenFin DESC" ;
      }
      else if ( ( AV18OrderedBy == 3 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.LegLicDescrip" ;
      }
      else if ( ( AV18OrderedBy == 3 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.LegLicDescrip DESC" ;
      }
      else if ( ( AV18OrderedBy == 4 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.LegLicEstado" ;
      }
      else if ( ( AV18OrderedBy == 4 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.LegLicEstado DESC" ;
      }
      else if ( ( AV18OrderedBy == 5 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.LegLicConPlus" ;
      }
      else if ( ( AV18OrderedBy == 5 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.LegLicConPlus DESC" ;
      }
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
                  return conditional_P02FA2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , (java.util.Date)dynConstraints[8] , (java.util.Date)dynConstraints[9] , (java.util.Date)dynConstraints[10] , (java.util.Date)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , (String)dynConstraints[13] , ((Number) dynConstraints[14]).intValue() , ((Number) dynConstraints[15]).byteValue() , (java.util.Date)dynConstraints[16] , (java.util.Date)dynConstraints[17] , ((Boolean) dynConstraints[18]).booleanValue() , ((Number) dynConstraints[19]).shortValue() , ((Boolean) dynConstraints[20]).booleanValue() , ((Boolean) dynConstraints[21]).booleanValue() , ((Number) dynConstraints[22]).intValue() , ((Number) dynConstraints[23]).shortValue() , ((Number) dynConstraints[24]).intValue() , ((Number) dynConstraints[25]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02FA2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getString(2, 4);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((boolean[]) buf[8])[0] = rslt.getBoolean(9);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((String[]) buf[10])[0] = rslt.getString(10, 20);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[12])[0] = rslt.getGXDate(11);
               ((java.util.Date[]) buf[13])[0] = rslt.getGXDate(12);
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

