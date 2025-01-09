package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class faltas_y_tardeswwexport extends GXProcedure
{
   public faltas_y_tardeswwexport( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( faltas_y_tardeswwexport.class ), "" );
   }

   public faltas_y_tardeswwexport( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String[] aP0 )
   {
      faltas_y_tardeswwexport.this.aP1 = new String[] {""};
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
      faltas_y_tardeswwexport.this.aP0 = aP0;
      faltas_y_tardeswwexport.this.aP1 = aP1;
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
      faltas_y_tardeswwexport.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( ! AV8IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV58Pgmname))}, new String[] {"GxObject"}) );
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
      AV12Filename = "faltas_y_tardesWWExport-" + GXutil.trim( GXutil.str( AV16Random, 8, 0)) + ".xlsx" ;
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
      if ( ! ( (false==AV20SitLicCuentaTrab) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Es remunerada", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         faltas_y_tardeswwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXutil.booltostr( AV20SitLicCuentaTrab) );
      }
      if ( ! ( (false==AV21SitEsLicencia) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Sit Es Licencia", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         faltas_y_tardeswwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXutil.booltostr( AV21SitEsLicencia) );
      }
      if ( ! ( ( AV39TFLegId_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Legajo Id.", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         faltas_y_tardeswwexport.this.AV14CellRow = GXv_int5[0] ;
         AV53i = 1 ;
         AV59GXV1 = 1 ;
         while ( AV59GXV1 <= AV39TFLegId_Sels.size() )
         {
            AV40TFLegId_Sel = (String)AV39TFLegId_Sels.elementAt(-1+AV59GXV1) ;
            if ( AV53i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV40TFLegId_Sel, GXv_char7) ;
            faltas_y_tardeswwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char6 );
            AV53i = (long)(AV53i+1) ;
            AV59GXV1 = (int)(AV59GXV1+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV38TFLegId)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Legajo Id.", "")) ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            faltas_y_tardeswwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV38TFLegId, GXv_char7) ;
            faltas_y_tardeswwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( ( AV43TFLegNomApe_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Legajo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         faltas_y_tardeswwexport.this.AV14CellRow = GXv_int5[0] ;
         AV53i = 1 ;
         AV60GXV2 = 1 ;
         while ( AV60GXV2 <= AV43TFLegNomApe_Sels.size() )
         {
            AV44TFLegNomApe_Sel = (String)AV43TFLegNomApe_Sels.elementAt(-1+AV60GXV2) ;
            if ( AV53i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV44TFLegNomApe_Sel, GXv_char7) ;
            faltas_y_tardeswwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char6 );
            AV53i = (long)(AV53i+1) ;
            AV60GXV2 = (int)(AV60GXV2+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV42TFLegNomApe)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Legajo", "")) ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            faltas_y_tardeswwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV42TFLegNomApe, GXv_char7) ;
            faltas_y_tardeswwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV45TFLegLicenIni)) && GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV46TFLegLicenIni_To)) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Inicio", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         faltas_y_tardeswwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_dtime8 = GXutil.resetTime( AV45TFLegLicenIni );
         AV11ExcelDocument.setDateFormat(localUtil, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " ");
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setDate( GXt_dtime8 );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         faltas_y_tardeswwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_dtime8 = GXutil.resetTime( AV46TFLegLicenIni_To );
         AV11ExcelDocument.setDateFormat(localUtil, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " ");
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setDate( GXt_dtime8 );
      }
      if ( ! ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV47TFLegLicenFin)) && GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV48TFLegLicenFin_To)) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Fin", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         faltas_y_tardeswwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_dtime8 = GXutil.resetTime( AV47TFLegLicenFin );
         AV11ExcelDocument.setDateFormat(localUtil, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " ");
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setDate( GXt_dtime8 );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         faltas_y_tardeswwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_dtime8 = GXutil.resetTime( AV48TFLegLicenFin_To );
         AV11ExcelDocument.setDateFormat(localUtil, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " ");
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setDate( GXt_dtime8 );
      }
      if ( ! ( ( AV51TFLegLicDescrip_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Situación", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         faltas_y_tardeswwexport.this.AV14CellRow = GXv_int5[0] ;
         AV53i = 1 ;
         AV61GXV3 = 1 ;
         while ( AV61GXV3 <= AV51TFLegLicDescrip_Sels.size() )
         {
            AV52TFLegLicDescrip_Sel = (String)AV51TFLegLicDescrip_Sels.elementAt(-1+AV61GXV3) ;
            if ( AV53i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV52TFLegLicDescrip_Sel, GXv_char7) ;
            faltas_y_tardeswwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char6 );
            AV53i = (long)(AV53i+1) ;
            AV61GXV3 = (int)(AV61GXV3+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV50TFLegLicDescrip)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Situación", "")) ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            faltas_y_tardeswwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV50TFLegLicDescrip, GXv_char7) ;
            faltas_y_tardeswwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      AV14CellRow = (int)(AV14CellRow+2) ;
   }

   public void S141( )
   {
      /* 'WRITECOLUMNTITLES' Routine */
      returnInSub = false ;
      AV34VisibleColumnCount = 0 ;
      if ( GXutil.strcmp(AV22Session.getValue("faltas_y_tardesWWColumnsSelector"), "") != 0 )
      {
         AV29ColumnsSelectorXML = AV22Session.getValue("faltas_y_tardesWWColumnsSelector") ;
         AV26ColumnsSelector.fromxml(AV29ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S151 ();
         if (returnInSub) return;
      }
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV26ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+2)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV26ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+7)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV26ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+8)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV26ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+9)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      AV26ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().sort("Order");
      AV62GXV4 = 1 ;
      while ( AV62GXV4 <= AV26ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
      {
         AV28ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV26ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV62GXV4));
         if ( AV28ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV34VisibleColumnCount), 1, 1).setText( httpContext.getMessage( ((GXutil.strcmp("", AV28ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname())==0) ? AV28ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname() : AV28ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname()), "") );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV34VisibleColumnCount), 1, 1).setBold( (short)(1) );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV34VisibleColumnCount), 1, 1).setColor( 11 );
            AV34VisibleColumnCount = (long)(AV34VisibleColumnCount+1) ;
         }
         AV62GXV4 = (int)(AV62GXV4+1) ;
      }
   }

   public void S161( )
   {
      /* 'WRITEDATA' Routine */
      returnInSub = false ;
      AV64Faltas_y_tardeswwds_1_sitliccuentatrab = AV20SitLicCuentaTrab ;
      AV65Faltas_y_tardeswwds_2_siteslicencia = AV21SitEsLicencia ;
      AV66Faltas_y_tardeswwds_3_tflegid = AV38TFLegId ;
      AV67Faltas_y_tardeswwds_4_tflegid_sels = AV39TFLegId_Sels ;
      AV68Faltas_y_tardeswwds_5_tflegnomape = AV42TFLegNomApe ;
      AV69Faltas_y_tardeswwds_6_tflegnomape_sels = AV43TFLegNomApe_Sels ;
      AV70Faltas_y_tardeswwds_7_tfleglicenini = AV45TFLegLicenIni ;
      AV71Faltas_y_tardeswwds_8_tfleglicenini_to = AV46TFLegLicenIni_To ;
      AV72Faltas_y_tardeswwds_9_tfleglicenfin = AV47TFLegLicenFin ;
      AV73Faltas_y_tardeswwds_10_tfleglicenfin_to = AV48TFLegLicenFin_To ;
      AV74Faltas_y_tardeswwds_11_tfleglicdescrip = AV50TFLegLicDescrip ;
      AV75Faltas_y_tardeswwds_12_tfleglicdescrip_sels = AV51TFLegLicDescrip_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A93LegId ,
                                           AV67Faltas_y_tardeswwds_4_tflegid_sels ,
                                           A591LegNomApe ,
                                           AV69Faltas_y_tardeswwds_6_tflegnomape_sels ,
                                           A914LegLicDescrip ,
                                           AV75Faltas_y_tardeswwds_12_tfleglicdescrip_sels ,
                                           Integer.valueOf(AV67Faltas_y_tardeswwds_4_tflegid_sels.size()) ,
                                           AV66Faltas_y_tardeswwds_3_tflegid ,
                                           Integer.valueOf(AV69Faltas_y_tardeswwds_6_tflegnomape_sels.size()) ,
                                           AV68Faltas_y_tardeswwds_5_tflegnomape ,
                                           AV70Faltas_y_tardeswwds_7_tfleglicenini ,
                                           AV71Faltas_y_tardeswwds_8_tfleglicenini_to ,
                                           AV72Faltas_y_tardeswwds_9_tfleglicenfin ,
                                           AV73Faltas_y_tardeswwds_10_tfleglicenfin_to ,
                                           Integer.valueOf(AV75Faltas_y_tardeswwds_12_tfleglicdescrip_sels.size()) ,
                                           AV74Faltas_y_tardeswwds_11_tfleglicdescrip ,
                                           A76LegLicenIni ,
                                           A481LegLicenFin ,
                                           Short.valueOf(AV18OrderedBy) ,
                                           Boolean.valueOf(AV19OrderedDsc) ,
                                           Byte.valueOf(A1643LegSitCuenTrab) ,
                                           Byte.valueOf(A1287LegSitEsLic) ,
                                           Integer.valueOf(AV54CliCod) ,
                                           Short.valueOf(AV55EmpCod) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE,
                                           TypeConstants.DATE, TypeConstants.DATE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.BYTE, TypeConstants.BYTE,
                                           TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT
                                           }
      });
      lV66Faltas_y_tardeswwds_3_tflegid = GXutil.padr( GXutil.rtrim( AV66Faltas_y_tardeswwds_3_tflegid), 20, "%") ;
      lV68Faltas_y_tardeswwds_5_tflegnomape = GXutil.concat( GXutil.rtrim( AV68Faltas_y_tardeswwds_5_tflegnomape), "%", "") ;
      lV74Faltas_y_tardeswwds_11_tfleglicdescrip = GXutil.concat( GXutil.rtrim( AV74Faltas_y_tardeswwds_11_tfleglicdescrip), "%", "") ;
      /* Using cursor P02FD2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV54CliCod), Short.valueOf(AV55EmpCod), lV66Faltas_y_tardeswwds_3_tflegid, lV68Faltas_y_tardeswwds_5_tflegnomape, AV70Faltas_y_tardeswwds_7_tfleglicenini, AV71Faltas_y_tardeswwds_8_tfleglicenini_to, AV72Faltas_y_tardeswwds_9_tfleglicenfin, AV73Faltas_y_tardeswwds_10_tfleglicenfin_to, lV74Faltas_y_tardeswwds_11_tfleglicdescrip});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A6LegNumero = P02FD2_A6LegNumero[0] ;
         A1EmpCod = P02FD2_A1EmpCod[0] ;
         A3CliCod = P02FD2_A3CliCod[0] ;
         A914LegLicDescrip = P02FD2_A914LegLicDescrip[0] ;
         A591LegNomApe = P02FD2_A591LegNomApe[0] ;
         A93LegId = P02FD2_A93LegId[0] ;
         n93LegId = P02FD2_n93LegId[0] ;
         A1287LegSitEsLic = P02FD2_A1287LegSitEsLic[0] ;
         A1643LegSitCuenTrab = P02FD2_A1643LegSitCuenTrab[0] ;
         A76LegLicenIni = P02FD2_A76LegLicenIni[0] ;
         A481LegLicenFin = P02FD2_A481LegLicenFin[0] ;
         A591LegNomApe = P02FD2_A591LegNomApe[0] ;
         A93LegId = P02FD2_A93LegId[0] ;
         n93LegId = P02FD2_n93LegId[0] ;
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
            returnInSub = true;
            if (true) return;
         }
         AV34VisibleColumnCount = 0 ;
         AV76GXV5 = 1 ;
         while ( AV76GXV5 <= AV26ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
         {
            AV28ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV26ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV76GXV5));
            if ( AV28ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
            {
               if ( GXutil.strcmp(AV28ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LegId") == 0 )
               {
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A93LegId, GXv_char7) ;
                  faltas_y_tardeswwexport.this.GXt_char6 = GXv_char7[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV34VisibleColumnCount), 1, 1).setText( GXt_char6 );
               }
               else if ( GXutil.strcmp(AV28ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LegLicenIni") == 0 )
               {
                  GXt_dtime8 = GXutil.resetTime( A76LegLicenIni );
                  AV11ExcelDocument.setDateFormat(localUtil, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " ");
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV34VisibleColumnCount), 1, 1).setDate( GXt_dtime8 );
               }
               else if ( GXutil.strcmp(AV28ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LegLicenFin") == 0 )
               {
                  GXt_dtime8 = GXutil.resetTime( A481LegLicenFin );
                  AV11ExcelDocument.setDateFormat(localUtil, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " ");
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV34VisibleColumnCount), 1, 1).setDate( GXt_dtime8 );
               }
               else if ( GXutil.strcmp(AV28ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LegLicCntDias") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV34VisibleColumnCount), 1, 1).setNumber( A501LegLicCntDias );
               }
               else if ( GXutil.strcmp(AV28ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LegLicDescrip") == 0 )
               {
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A914LegLicDescrip, GXv_char7) ;
                  faltas_y_tardeswwexport.this.GXt_char6 = GXv_char7[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV34VisibleColumnCount), 1, 1).setText( GXt_char6 );
               }
               AV34VisibleColumnCount = (long)(AV34VisibleColumnCount+1) ;
            }
            AV76GXV5 = (int)(AV76GXV5+1) ;
         }
         /* Execute user subroutine: 'AFTERWRITELINE' */
         S182 ();
         if ( returnInSub )
         {
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
      AV26ColumnsSelector = (web.wwpbaseobjects.SdtWWPColumnsSelector)new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector9[0] = AV26ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "LegId", "", "Legajo Id.", true, "") ;
      AV26ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV26ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "LegNomApe", "", "Legajo", true, "") ;
      AV26ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV26ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "LegLicenIni", "", "Inicio", true, "") ;
      AV26ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV26ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "LegLicenFin", "", "Fin", true, "") ;
      AV26ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV26ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "LegLicCntDias", "", "Días", true, "") ;
      AV26ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV26ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "LegLicDescrip", "", "Situación", true, "") ;
      AV26ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV26ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "&VerSVG", "", "", true, "") ;
      AV26ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV26ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "&ModificarSVG", "", "", true, "") ;
      AV26ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV26ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "&EliminarSVG", "", "", true, "") ;
      AV26ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXt_char6 = AV30UserCustomValue ;
      GXv_char7[0] = GXt_char6 ;
      new web.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "faltas_y_tardesWWColumnsSelector", GXv_char7) ;
      faltas_y_tardeswwexport.this.GXt_char6 = GXv_char7[0] ;
      AV30UserCustomValue = GXt_char6 ;
      if ( ! ( (GXutil.strcmp("", AV30UserCustomValue)==0) ) )
      {
         AV27ColumnsSelectorAux.fromxml(AV30UserCustomValue, null, null);
         GXv_SdtWWPColumnsSelector9[0] = AV27ColumnsSelectorAux;
         GXv_SdtWWPColumnsSelector10[0] = AV26ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnselector_updatecolumns(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, GXv_SdtWWPColumnsSelector10) ;
         AV27ColumnsSelectorAux = GXv_SdtWWPColumnsSelector9[0] ;
         AV26ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      }
   }

   public void S201( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV22Session.getValue("faltas_y_tardesWWGridState"), "") == 0 )
      {
         AV24GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "faltas_y_tardesWWGridState"), null, null);
      }
      else
      {
         AV24GridState.fromxml(AV22Session.getValue("faltas_y_tardesWWGridState"), null, null);
      }
      AV18OrderedBy = AV24GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV19OrderedDsc = AV24GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV77GXV6 = 1 ;
      while ( AV77GXV6 <= AV24GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV25GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV24GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV77GXV6));
         if ( GXutil.strcmp(AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "SITLICCUENTATRAB") == 0 )
         {
            AV20SitLicCuentaTrab = GXutil.boolval( AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value()) ;
         }
         else if ( GXutil.strcmp(AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "SITESLICENCIA") == 0 )
         {
            AV21SitEsLicencia = GXutil.boolval( AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value()) ;
         }
         else if ( GXutil.strcmp(AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGID") == 0 )
         {
            AV38TFLegId = AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGID_SEL") == 0 )
         {
            AV37TFLegId_SelsJson = AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV39TFLegId_Sels.fromJSonString(AV37TFLegId_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGNOMAPE") == 0 )
         {
            AV42TFLegNomApe = AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGNOMAPE_SEL") == 0 )
         {
            AV41TFLegNomApe_SelsJson = AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV43TFLegNomApe_Sels.fromJSonString(AV41TFLegNomApe_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGLICENINI") == 0 )
         {
            AV45TFLegLicenIni = localUtil.ctod( AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            AV46TFLegLicenIni_To = localUtil.ctod( AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
         }
         else if ( GXutil.strcmp(AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGLICENFIN") == 0 )
         {
            AV47TFLegLicenFin = localUtil.ctod( AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            AV48TFLegLicenFin_To = localUtil.ctod( AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
         }
         else if ( GXutil.strcmp(AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGLICDESCRIP") == 0 )
         {
            AV50TFLegLicDescrip = AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGLICDESCRIP_SEL") == 0 )
         {
            AV49TFLegLicDescrip_SelsJson = AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV51TFLegLicDescrip_Sels.fromJSonString(AV49TFLegLicDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV17MenuOpcCod = AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV77GXV6 = (int)(AV77GXV6+1) ;
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
      this.aP0[0] = faltas_y_tardeswwexport.this.AV12Filename;
      this.aP1[0] = faltas_y_tardeswwexport.this.AV13ErrorMessage;
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
      AV58Pgmname = "" ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV11ExcelDocument = new com.genexus.gxoffice.ExcelDoc();
      AV39TFLegId_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV40TFLegId_Sel = "" ;
      AV38TFLegId = "" ;
      AV43TFLegNomApe_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV44TFLegNomApe_Sel = "" ;
      AV42TFLegNomApe = "" ;
      AV45TFLegLicenIni = GXutil.nullDate() ;
      AV46TFLegLicenIni_To = GXutil.nullDate() ;
      AV47TFLegLicenFin = GXutil.nullDate() ;
      AV48TFLegLicenFin_To = GXutil.nullDate() ;
      AV51TFLegLicDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV52TFLegLicDescrip_Sel = "" ;
      AV50TFLegLicDescrip = "" ;
      GXv_exceldoc4 = new com.genexus.gxoffice.ExcelDoc[1] ;
      GXv_int5 = new short[1] ;
      AV22Session = httpContext.getWebSession();
      AV29ColumnsSelectorXML = "" ;
      AV26ColumnsSelector = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV28ColumnsSelector_Column = new web.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      A93LegId = "" ;
      A76LegLicenIni = GXutil.nullDate() ;
      A481LegLicenFin = GXutil.nullDate() ;
      A914LegLicDescrip = "" ;
      AV66Faltas_y_tardeswwds_3_tflegid = "" ;
      AV67Faltas_y_tardeswwds_4_tflegid_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV68Faltas_y_tardeswwds_5_tflegnomape = "" ;
      AV69Faltas_y_tardeswwds_6_tflegnomape_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV70Faltas_y_tardeswwds_7_tfleglicenini = GXutil.nullDate() ;
      AV71Faltas_y_tardeswwds_8_tfleglicenini_to = GXutil.nullDate() ;
      AV72Faltas_y_tardeswwds_9_tfleglicenfin = GXutil.nullDate() ;
      AV73Faltas_y_tardeswwds_10_tfleglicenfin_to = GXutil.nullDate() ;
      AV74Faltas_y_tardeswwds_11_tfleglicdescrip = "" ;
      AV75Faltas_y_tardeswwds_12_tfleglicdescrip_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV66Faltas_y_tardeswwds_3_tflegid = "" ;
      lV68Faltas_y_tardeswwds_5_tflegnomape = "" ;
      lV74Faltas_y_tardeswwds_11_tfleglicdescrip = "" ;
      A591LegNomApe = "" ;
      P02FD2_A6LegNumero = new int[1] ;
      P02FD2_A1EmpCod = new short[1] ;
      P02FD2_A3CliCod = new int[1] ;
      P02FD2_A914LegLicDescrip = new String[] {""} ;
      P02FD2_A591LegNomApe = new String[] {""} ;
      P02FD2_A93LegId = new String[] {""} ;
      P02FD2_n93LegId = new boolean[] {false} ;
      P02FD2_A1287LegSitEsLic = new byte[1] ;
      P02FD2_A1643LegSitCuenTrab = new byte[1] ;
      P02FD2_A76LegLicenIni = new java.util.Date[] {GXutil.nullDate()} ;
      P02FD2_A481LegLicenFin = new java.util.Date[] {GXutil.nullDate()} ;
      GXt_dtime8 = GXutil.resetTime( GXutil.nullDate() );
      AV30UserCustomValue = "" ;
      GXt_char6 = "" ;
      GXv_char7 = new String[1] ;
      AV27ColumnsSelectorAux = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector9 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector10 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      AV24GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV25GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV37TFLegId_SelsJson = "" ;
      AV41TFLegNomApe_SelsJson = "" ;
      AV49TFLegLicDescrip_SelsJson = "" ;
      AV17MenuOpcCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.faltas_y_tardeswwexport__default(),
         new Object[] {
             new Object[] {
            P02FD2_A6LegNumero, P02FD2_A1EmpCod, P02FD2_A3CliCod, P02FD2_A914LegLicDescrip, P02FD2_A591LegNomApe, P02FD2_A93LegId, P02FD2_n93LegId, P02FD2_A1287LegSitEsLic, P02FD2_A1643LegSitCuenTrab, P02FD2_A76LegLicenIni,
            P02FD2_A481LegLicenFin
            }
         }
      );
      AV58Pgmname = "faltas_y_tardesWWExport" ;
      /* GeneXus formulas. */
      AV58Pgmname = "faltas_y_tardesWWExport" ;
      Gx_err = (short)(0) ;
   }

   private byte A1643LegSitCuenTrab ;
   private byte A1287LegSitEsLic ;
   private short GXv_int5[] ;
   private short A501LegLicCntDias ;
   private short AV18OrderedBy ;
   private short AV55EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV14CellRow ;
   private int AV15FirstColumn ;
   private int AV16Random ;
   private int AV59GXV1 ;
   private int AV60GXV2 ;
   private int AV61GXV3 ;
   private int AV62GXV4 ;
   private int AV67Faltas_y_tardeswwds_4_tflegid_sels_size ;
   private int AV69Faltas_y_tardeswwds_6_tflegnomape_sels_size ;
   private int AV75Faltas_y_tardeswwds_12_tfleglicdescrip_sels_size ;
   private int AV54CliCod ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private int AV76GXV5 ;
   private int AV77GXV6 ;
   private long AV53i ;
   private long AV34VisibleColumnCount ;
   private String AV58Pgmname ;
   private String AV40TFLegId_Sel ;
   private String AV38TFLegId ;
   private String A93LegId ;
   private String AV66Faltas_y_tardeswwds_3_tflegid ;
   private String scmdbuf ;
   private String lV66Faltas_y_tardeswwds_3_tflegid ;
   private String GXt_char6 ;
   private String GXv_char7[] ;
   private java.util.Date GXt_dtime8 ;
   private java.util.Date AV45TFLegLicenIni ;
   private java.util.Date AV46TFLegLicenIni_To ;
   private java.util.Date AV47TFLegLicenFin ;
   private java.util.Date AV48TFLegLicenFin_To ;
   private java.util.Date A76LegLicenIni ;
   private java.util.Date A481LegLicenFin ;
   private java.util.Date AV70Faltas_y_tardeswwds_7_tfleglicenini ;
   private java.util.Date AV71Faltas_y_tardeswwds_8_tfleglicenini_to ;
   private java.util.Date AV72Faltas_y_tardeswwds_9_tfleglicenfin ;
   private java.util.Date AV73Faltas_y_tardeswwds_10_tfleglicenfin_to ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean AV20SitLicCuentaTrab ;
   private boolean AV21SitEsLicencia ;
   private boolean AV64Faltas_y_tardeswwds_1_sitliccuentatrab ;
   private boolean AV65Faltas_y_tardeswwds_2_siteslicencia ;
   private boolean AV19OrderedDsc ;
   private boolean n93LegId ;
   private String AV29ColumnsSelectorXML ;
   private String AV30UserCustomValue ;
   private String AV37TFLegId_SelsJson ;
   private String AV41TFLegNomApe_SelsJson ;
   private String AV49TFLegLicDescrip_SelsJson ;
   private String AV12Filename ;
   private String AV13ErrorMessage ;
   private String AV44TFLegNomApe_Sel ;
   private String AV42TFLegNomApe ;
   private String AV52TFLegLicDescrip_Sel ;
   private String AV50TFLegLicDescrip ;
   private String A914LegLicDescrip ;
   private String AV68Faltas_y_tardeswwds_5_tflegnomape ;
   private String AV74Faltas_y_tardeswwds_11_tfleglicdescrip ;
   private String lV68Faltas_y_tardeswwds_5_tflegnomape ;
   private String lV74Faltas_y_tardeswwds_11_tfleglicdescrip ;
   private String A591LegNomApe ;
   private String AV17MenuOpcCod ;
   private com.genexus.webpanels.WebSession AV22Session ;
   private GXSimpleCollection<String> AV39TFLegId_Sels ;
   private GXSimpleCollection<String> AV43TFLegNomApe_Sels ;
   private GXSimpleCollection<String> AV51TFLegLicDescrip_Sels ;
   private String[] aP1 ;
   private String[] aP0 ;
   private IDataStoreProvider pr_default ;
   private int[] P02FD2_A6LegNumero ;
   private short[] P02FD2_A1EmpCod ;
   private int[] P02FD2_A3CliCod ;
   private String[] P02FD2_A914LegLicDescrip ;
   private String[] P02FD2_A591LegNomApe ;
   private String[] P02FD2_A93LegId ;
   private boolean[] P02FD2_n93LegId ;
   private byte[] P02FD2_A1287LegSitEsLic ;
   private byte[] P02FD2_A1643LegSitCuenTrab ;
   private java.util.Date[] P02FD2_A76LegLicenIni ;
   private java.util.Date[] P02FD2_A481LegLicenFin ;
   private com.genexus.gxoffice.ExcelDoc AV11ExcelDocument ;
   private com.genexus.gxoffice.ExcelDoc GXv_exceldoc4[] ;
   private GXSimpleCollection<String> AV67Faltas_y_tardeswwds_4_tflegid_sels ;
   private GXSimpleCollection<String> AV69Faltas_y_tardeswwds_6_tflegnomape_sels ;
   private GXSimpleCollection<String> AV75Faltas_y_tardeswwds_12_tfleglicdescrip_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV24GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV25GridStateFilterValue ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV26ColumnsSelector ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV27ColumnsSelectorAux ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector9[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector10[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector_Column AV28ColumnsSelector_Column ;
}

final  class faltas_y_tardeswwexport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P02FD2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A93LegId ,
                                          GXSimpleCollection<String> AV67Faltas_y_tardeswwds_4_tflegid_sels ,
                                          String A591LegNomApe ,
                                          GXSimpleCollection<String> AV69Faltas_y_tardeswwds_6_tflegnomape_sels ,
                                          String A914LegLicDescrip ,
                                          GXSimpleCollection<String> AV75Faltas_y_tardeswwds_12_tfleglicdescrip_sels ,
                                          int AV67Faltas_y_tardeswwds_4_tflegid_sels_size ,
                                          String AV66Faltas_y_tardeswwds_3_tflegid ,
                                          int AV69Faltas_y_tardeswwds_6_tflegnomape_sels_size ,
                                          String AV68Faltas_y_tardeswwds_5_tflegnomape ,
                                          java.util.Date AV70Faltas_y_tardeswwds_7_tfleglicenini ,
                                          java.util.Date AV71Faltas_y_tardeswwds_8_tfleglicenini_to ,
                                          java.util.Date AV72Faltas_y_tardeswwds_9_tfleglicenfin ,
                                          java.util.Date AV73Faltas_y_tardeswwds_10_tfleglicenfin_to ,
                                          int AV75Faltas_y_tardeswwds_12_tfleglicdescrip_sels_size ,
                                          String AV74Faltas_y_tardeswwds_11_tfleglicdescrip ,
                                          java.util.Date A76LegLicenIni ,
                                          java.util.Date A481LegLicenFin ,
                                          short AV18OrderedBy ,
                                          boolean AV19OrderedDsc ,
                                          byte A1643LegSitCuenTrab ,
                                          byte A1287LegSitEsLic ,
                                          int AV54CliCod ,
                                          short AV55EmpCod ,
                                          int A3CliCod ,
                                          short A1EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int11 = new byte[9];
      Object[] GXv_Object12 = new Object[2];
      scmdbuf = "SELECT T1.LegNumero, T1.EmpCod, T1.CliCod, T1.LegLicDescrip, T2.LegNomApe, T2.LegId, T1.LegSitEsLic, T1.LegSitCuenTrab, T1.LegLicenIni, T1.LegLicenFin FROM (LegajoLicencias" ;
      scmdbuf += " T1 INNER JOIN Legajo T2 ON T2.CliCod = T1.CliCod AND T2.EmpCod = T1.EmpCod AND T2.LegNumero = T1.LegNumero)" ;
      addWhere(sWhereString, "(T1.CliCod = ? and T1.EmpCod = ?)");
      addWhere(sWhereString, "(T1.LegSitCuenTrab = 0)");
      addWhere(sWhereString, "(T1.LegSitEsLic = 0)");
      if ( ( AV67Faltas_y_tardeswwds_4_tflegid_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV66Faltas_y_tardeswwds_3_tflegid)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.LegId) like LOWER(?))");
      }
      else
      {
         GXv_int11[2] = (byte)(1) ;
      }
      if ( AV67Faltas_y_tardeswwds_4_tflegid_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV67Faltas_y_tardeswwds_4_tflegid_sels, "T2.LegId IN (", ")")+")");
      }
      if ( ( AV69Faltas_y_tardeswwds_6_tflegnomape_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV68Faltas_y_tardeswwds_5_tflegnomape)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.LegNomApe) like LOWER(?))");
      }
      else
      {
         GXv_int11[3] = (byte)(1) ;
      }
      if ( AV69Faltas_y_tardeswwds_6_tflegnomape_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV69Faltas_y_tardeswwds_6_tflegnomape_sels, "T2.LegNomApe IN (", ")")+")");
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV70Faltas_y_tardeswwds_7_tfleglicenini)) )
      {
         addWhere(sWhereString, "(T1.LegLicenIni >= ?)");
      }
      else
      {
         GXv_int11[4] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV71Faltas_y_tardeswwds_8_tfleglicenini_to)) )
      {
         addWhere(sWhereString, "(T1.LegLicenIni <= ?)");
      }
      else
      {
         GXv_int11[5] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV72Faltas_y_tardeswwds_9_tfleglicenfin)) )
      {
         addWhere(sWhereString, "(T1.LegLicenFin >= ?)");
      }
      else
      {
         GXv_int11[6] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV73Faltas_y_tardeswwds_10_tfleglicenfin_to)) )
      {
         addWhere(sWhereString, "(T1.LegLicenFin <= ?)");
      }
      else
      {
         GXv_int11[7] = (byte)(1) ;
      }
      if ( ( AV75Faltas_y_tardeswwds_12_tfleglicdescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV74Faltas_y_tardeswwds_11_tfleglicdescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.LegLicDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int11[8] = (byte)(1) ;
      }
      if ( AV75Faltas_y_tardeswwds_12_tfleglicdescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV75Faltas_y_tardeswwds_12_tfleglicdescrip_sels, "T1.LegLicDescrip IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      if ( ( AV18OrderedBy == 1 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY T2.LegId" ;
      }
      else if ( ( AV18OrderedBy == 1 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T2.LegId DESC" ;
      }
      else if ( ( AV18OrderedBy == 2 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.LegLicenIni" ;
      }
      else if ( ( AV18OrderedBy == 2 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.LegLicenIni DESC" ;
      }
      else if ( ( AV18OrderedBy == 3 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.LegLicenFin" ;
      }
      else if ( ( AV18OrderedBy == 3 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.LegLicenFin DESC" ;
      }
      else if ( ( AV18OrderedBy == 4 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.LegLicDescrip" ;
      }
      else if ( ( AV18OrderedBy == 4 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.LegLicDescrip DESC" ;
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
                  return conditional_P02FD2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , (java.util.Date)dynConstraints[10] , (java.util.Date)dynConstraints[11] , (java.util.Date)dynConstraints[12] , (java.util.Date)dynConstraints[13] , ((Number) dynConstraints[14]).intValue() , (String)dynConstraints[15] , (java.util.Date)dynConstraints[16] , (java.util.Date)dynConstraints[17] , ((Number) dynConstraints[18]).shortValue() , ((Boolean) dynConstraints[19]).booleanValue() , ((Number) dynConstraints[20]).byteValue() , ((Number) dynConstraints[21]).byteValue() , ((Number) dynConstraints[22]).intValue() , ((Number) dynConstraints[23]).shortValue() , ((Number) dynConstraints[24]).intValue() , ((Number) dynConstraints[25]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02FD2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((byte[]) buf[7])[0] = rslt.getByte(7);
               ((byte[]) buf[8])[0] = rslt.getByte(8);
               ((java.util.Date[]) buf[9])[0] = rslt.getGXDate(9);
               ((java.util.Date[]) buf[10])[0] = rslt.getGXDate(10);
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
                  stmt.setInt(sIdx, ((Number) parms[9]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[10]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[11], 20);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[12], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[13]);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[14]);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[15]);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[16]);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[17], 400);
               }
               return;
      }
   }

}

