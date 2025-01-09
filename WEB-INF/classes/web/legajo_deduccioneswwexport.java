package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class legajo_deduccioneswwexport extends GXProcedure
{
   public legajo_deduccioneswwexport( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( legajo_deduccioneswwexport.class ), "" );
   }

   public legajo_deduccioneswwexport( int remoteHandle ,
                                      ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String[] aP0 )
   {
      legajo_deduccioneswwexport.this.aP1 = new String[] {""};
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
      legajo_deduccioneswwexport.this.aP0 = aP0;
      legajo_deduccioneswwexport.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWlegajo_deducciones", GXv_boolean2) ;
      legajo_deduccioneswwexport.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( ! AV8IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV60Pgmname))}, new String[] {"GxObject"}) );
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
         S211 ();
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
         S201 ();
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
      AV12Filename = "legajo_deduccionesWWExport-" + GXutil.trim( GXutil.str( AV16Random, 8, 0)) + ".xlsx" ;
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
      if ( ! ( ( AV38TFLegIdNomApe_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Legajo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         legajo_deduccioneswwexport.this.AV14CellRow = GXv_int5[0] ;
         AV55i = 1 ;
         AV61GXV1 = 1 ;
         while ( AV61GXV1 <= AV38TFLegIdNomApe_Sels.size() )
         {
            AV39TFLegIdNomApe_Sel = (String)AV38TFLegIdNomApe_Sels.elementAt(-1+AV61GXV1) ;
            if ( AV55i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV39TFLegIdNomApe_Sel, GXv_char7) ;
            legajo_deduccioneswwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char6 );
            AV55i = (long)(AV55i+1) ;
            AV61GXV1 = (int)(AV61GXV1+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV37TFLegIdNomApe)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Legajo", "")) ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            legajo_deduccioneswwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV37TFLegIdNomApe, GXv_char7) ;
            legajo_deduccioneswwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (0==AV40TFLegDedAnio) && (0==AV41TFLegDedAnio_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Año", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         legajo_deduccioneswwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV40TFLegDedAnio );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         legajo_deduccioneswwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV41TFLegDedAnio_To );
      }
      if ( ! ( ( AV43TFLegDedMes_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Mes", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         legajo_deduccioneswwexport.this.AV14CellRow = GXv_int5[0] ;
         AV55i = 1 ;
         AV62GXV2 = 1 ;
         while ( AV62GXV2 <= AV43TFLegDedMes_Sels.size() )
         {
            AV44TFLegDedMes_Sel = ((Number) AV43TFLegDedMes_Sels.elementAt(-1+AV62GXV2)).byteValue() ;
            if ( AV55i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+httpContext.getMessage( web.gxdomainmesdeducciones.getDescription(httpContext,(byte)AV44TFLegDedMes_Sel), "") );
            AV55i = (long)(AV55i+1) ;
            AV62GXV2 = (int)(AV62GXV2+1) ;
         }
      }
      if ( ! ( ( AV47TFLegDedConCodYDesc_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Concepto", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         legajo_deduccioneswwexport.this.AV14CellRow = GXv_int5[0] ;
         AV55i = 1 ;
         AV63GXV3 = 1 ;
         while ( AV63GXV3 <= AV47TFLegDedConCodYDesc_Sels.size() )
         {
            AV48TFLegDedConCodYDesc_Sel = (String)AV47TFLegDedConCodYDesc_Sels.elementAt(-1+AV63GXV3) ;
            if ( AV55i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV48TFLegDedConCodYDesc_Sel, GXv_char7) ;
            legajo_deduccioneswwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char6 );
            AV55i = (long)(AV55i+1) ;
            AV63GXV3 = (int)(AV63GXV3+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV46TFLegDedConCodYDesc)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Concepto", "")) ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            legajo_deduccioneswwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV46TFLegDedConCodYDesc, GXv_char7) ;
            legajo_deduccioneswwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( ( AV51TFLegDedDescrip_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Descripción", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         legajo_deduccioneswwexport.this.AV14CellRow = GXv_int5[0] ;
         AV55i = 1 ;
         AV64GXV4 = 1 ;
         while ( AV64GXV4 <= AV51TFLegDedDescrip_Sels.size() )
         {
            AV52TFLegDedDescrip_Sel = (String)AV51TFLegDedDescrip_Sels.elementAt(-1+AV64GXV4) ;
            if ( AV55i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV52TFLegDedDescrip_Sel, GXv_char7) ;
            legajo_deduccioneswwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char6 );
            AV55i = (long)(AV55i+1) ;
            AV64GXV4 = (int)(AV64GXV4+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV50TFLegDedDescrip)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Descripción", "")) ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            legajo_deduccioneswwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV50TFLegDedDescrip, GXv_char7) ;
            legajo_deduccioneswwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV53TFLegDedImporte)==0) && (DecimalUtil.compareTo(DecimalUtil.ZERO, AV54TFLegDedImporte_To)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Importe", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         legajo_deduccioneswwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV53TFLegDedImporte)) );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         legajo_deduccioneswwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV54TFLegDedImporte_To)) );
      }
      AV14CellRow = (int)(AV14CellRow+2) ;
   }

   public void S141( )
   {
      /* 'WRITECOLUMNTITLES' Routine */
      returnInSub = false ;
      AV33VisibleColumnCount = 0 ;
      if ( GXutil.strcmp(AV21Session.getValue("legajo_deduccionesWWColumnsSelector"), "") != 0 )
      {
         AV28ColumnsSelectorXML = AV21Session.getValue("legajo_deduccionesWWColumnsSelector") ;
         AV25ColumnsSelector.fromxml(AV28ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S151 ();
         if (returnInSub) return;
      }
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+7)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+8)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+9)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().sort("Order");
      AV65GXV5 = 1 ;
      while ( AV65GXV5 <= AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
      {
         AV27ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV65GXV5));
         if ( AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setText( httpContext.getMessage( ((GXutil.strcmp("", AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname())==0) ? AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname() : AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname()), "") );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setBold( (short)(1) );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setColor( 11 );
            AV33VisibleColumnCount = (long)(AV33VisibleColumnCount+1) ;
         }
         AV65GXV5 = (int)(AV65GXV5+1) ;
      }
   }

   public void S161( )
   {
      /* 'WRITEDATA' Routine */
      returnInSub = false ;
      AV18FirstDataCellRow = (int)(AV14CellRow+1) ;
      AV67Legajo_deduccioneswwds_1_tflegidnomape = AV37TFLegIdNomApe ;
      AV68Legajo_deduccioneswwds_2_tflegidnomape_sels = AV38TFLegIdNomApe_Sels ;
      AV69Legajo_deduccioneswwds_3_tflegdedanio = AV40TFLegDedAnio ;
      AV70Legajo_deduccioneswwds_4_tflegdedanio_to = AV41TFLegDedAnio_To ;
      AV71Legajo_deduccioneswwds_5_tflegdedmes_sels = AV43TFLegDedMes_Sels ;
      AV72Legajo_deduccioneswwds_6_tflegdedconcodydesc = AV46TFLegDedConCodYDesc ;
      AV73Legajo_deduccioneswwds_7_tflegdedconcodydesc_sels = AV47TFLegDedConCodYDesc_Sels ;
      AV74Legajo_deduccioneswwds_8_tflegdeddescrip = AV50TFLegDedDescrip ;
      AV75Legajo_deduccioneswwds_9_tflegdeddescrip_sels = AV51TFLegDedDescrip_Sels ;
      AV76Legajo_deduccioneswwds_10_tflegdedimporte = AV53TFLegDedImporte ;
      AV77Legajo_deduccioneswwds_11_tflegdedimporte_to = AV54TFLegDedImporte_To ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A570LegDedConCodYDesc ,
                                           AV73Legajo_deduccioneswwds_7_tflegdedconcodydesc_sels ,
                                           A250LegIdNomApe ,
                                           AV68Legajo_deduccioneswwds_2_tflegidnomape_sels ,
                                           Byte.valueOf(A767LegDedMes) ,
                                           AV71Legajo_deduccioneswwds_5_tflegdedmes_sels ,
                                           A568LegDedDescrip ,
                                           AV75Legajo_deduccioneswwds_9_tflegdeddescrip_sels ,
                                           Integer.valueOf(AV68Legajo_deduccioneswwds_2_tflegidnomape_sels.size()) ,
                                           AV67Legajo_deduccioneswwds_1_tflegidnomape ,
                                           Short.valueOf(AV69Legajo_deduccioneswwds_3_tflegdedanio) ,
                                           Short.valueOf(AV70Legajo_deduccioneswwds_4_tflegdedanio_to) ,
                                           Integer.valueOf(AV71Legajo_deduccioneswwds_5_tflegdedmes_sels.size()) ,
                                           Integer.valueOf(AV73Legajo_deduccioneswwds_7_tflegdedconcodydesc_sels.size()) ,
                                           AV72Legajo_deduccioneswwds_6_tflegdedconcodydesc ,
                                           Integer.valueOf(AV75Legajo_deduccioneswwds_9_tflegdeddescrip_sels.size()) ,
                                           AV74Legajo_deduccioneswwds_8_tflegdeddescrip ,
                                           AV76Legajo_deduccioneswwds_10_tflegdedimporte ,
                                           AV77Legajo_deduccioneswwds_11_tflegdedimporte_to ,
                                           Short.valueOf(A768LegDedAnio) ,
                                           A84LegDedConCodigo ,
                                           A559LegDedConDescrip ,
                                           A560LegDedImporte ,
                                           Short.valueOf(AV19OrderedBy) ,
                                           Boolean.valueOf(AV20OrderedDsc) ,
                                           Integer.valueOf(AV56CliCod) ,
                                           Short.valueOf(AV57EmpCod) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.SHORT,
                                           TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT
                                           }
      });
      lV67Legajo_deduccioneswwds_1_tflegidnomape = GXutil.concat( GXutil.rtrim( AV67Legajo_deduccioneswwds_1_tflegidnomape), "%", "") ;
      lV72Legajo_deduccioneswwds_6_tflegdedconcodydesc = GXutil.concat( GXutil.rtrim( AV72Legajo_deduccioneswwds_6_tflegdedconcodydesc), "%", "") ;
      lV74Legajo_deduccioneswwds_8_tflegdeddescrip = GXutil.concat( GXutil.rtrim( AV74Legajo_deduccioneswwds_8_tflegdeddescrip), "%", "") ;
      /* Using cursor P02F22 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV56CliCod), Short.valueOf(AV57EmpCod), Integer.valueOf(AV73Legajo_deduccioneswwds_7_tflegdedconcodydesc_sels.size()), lV67Legajo_deduccioneswwds_1_tflegidnomape, Short.valueOf(AV69Legajo_deduccioneswwds_3_tflegdedanio), Short.valueOf(AV70Legajo_deduccioneswwds_4_tflegdedanio_to), lV72Legajo_deduccioneswwds_6_tflegdedconcodydesc, lV74Legajo_deduccioneswwds_8_tflegdeddescrip, AV76Legajo_deduccioneswwds_10_tflegdedimporte, AV77Legajo_deduccioneswwds_11_tflegdedimporte_to});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A6LegNumero = P02F22_A6LegNumero[0] ;
         A1EmpCod = P02F22_A1EmpCod[0] ;
         A3CliCod = P02F22_A3CliCod[0] ;
         A560LegDedImporte = P02F22_A560LegDedImporte[0] ;
         A568LegDedDescrip = P02F22_A568LegDedDescrip[0] ;
         A570LegDedConCodYDesc = P02F22_A570LegDedConCodYDesc[0] ;
         A767LegDedMes = P02F22_A767LegDedMes[0] ;
         A768LegDedAnio = P02F22_A768LegDedAnio[0] ;
         A250LegIdNomApe = P02F22_A250LegIdNomApe[0] ;
         A84LegDedConCodigo = P02F22_A84LegDedConCodigo[0] ;
         A559LegDedConDescrip = P02F22_A559LegDedConDescrip[0] ;
         A83LegDedSec = P02F22_A83LegDedSec[0] ;
         A250LegIdNomApe = P02F22_A250LegIdNomApe[0] ;
         A559LegDedConDescrip = P02F22_A559LegDedConDescrip[0] ;
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
         AV78GXV6 = 1 ;
         while ( AV78GXV6 <= AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
         {
            AV27ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV78GXV6));
            if ( AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
            {
               if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LegIdNomApe") == 0 )
               {
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A250LegIdNomApe, GXv_char7) ;
                  legajo_deduccioneswwexport.this.GXt_char6 = GXv_char7[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setText( GXt_char6 );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LegDedAnio") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setNumber( A768LegDedAnio );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LegDedMes") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setText( httpContext.getMessage( web.gxdomainmesdeducciones.getDescription(httpContext,(byte)A767LegDedMes), "") );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LegDedConCodYDesc") == 0 )
               {
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A570LegDedConCodYDesc, GXv_char7) ;
                  legajo_deduccioneswwexport.this.GXt_char6 = GXv_char7[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setText( GXt_char6 );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LegDedDescrip") == 0 )
               {
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A568LegDedDescrip, GXv_char7) ;
                  legajo_deduccioneswwexport.this.GXt_char6 = GXv_char7[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setText( GXt_char6 );
               }
               else if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LegDedImporte") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setNumber( (double)(DecimalUtil.decToDouble(A560LegDedImporte)) );
               }
               AV33VisibleColumnCount = (long)(AV33VisibleColumnCount+1) ;
            }
            AV78GXV6 = (int)(AV78GXV6+1) ;
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
      /* Execute user subroutine: 'WRITETOTALIZERS' */
      S191 ();
      if (returnInSub) return;
   }

   public void S191( )
   {
      /* 'WRITETOTALIZERS' Routine */
      returnInSub = false ;
      AV33VisibleColumnCount = 0 ;
      AV79GXV7 = 1 ;
      while ( AV79GXV7 <= AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
      {
         AV27ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV25ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV79GXV7));
         if ( AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            if ( GXutil.strcmp(AV27ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LegDedImporte") == 0 )
            {
               AV11ExcelDocument.Cells(AV14CellRow+1, (int)(AV15FirstColumn+AV33VisibleColumnCount), 1, 1).setText( GXutil.format( "=SUM(%1%2:%1%3)", GXutil.chr( (short)(GXutil.asc( "A")+AV33VisibleColumnCount)), GXutil.trim( GXutil.str( AV18FirstDataCellRow, 8, 0)), GXutil.trim( GXutil.str( AV14CellRow, 8, 0)), "", "", "", "", "", "") );
            }
            AV33VisibleColumnCount = (long)(AV33VisibleColumnCount+1) ;
         }
         AV79GXV7 = (int)(AV79GXV7+1) ;
      }
      AV11ExcelDocument.Cells(AV14CellRow+1, AV15FirstColumn, 1, (int)(AV33VisibleColumnCount)).setItalic( (short)(1) );
      AV11ExcelDocument.Cells(AV14CellRow+1, AV15FirstColumn, 1, (int)(AV33VisibleColumnCount)).setBold( (short)(1) );
   }

   public void S201( )
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
      GXv_SdtWWPColumnsSelector8[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "LegIdNomApe", "", "Legajo", true, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "LegDedAnio", "", "Año", true, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "LegDedMes", "", "Mes", true, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "LegDedConCodYDesc", "", "Concepto", true, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "LegDedDescrip", "", "Descripción", true, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "LegDedImporte", "", "Importe", true, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "&VerSVG", "", "", true, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "&ModificarSVG", "", "", true, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV25ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "&EliminarSVG", "", "", true, "") ;
      AV25ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXt_char6 = AV29UserCustomValue ;
      GXv_char7[0] = GXt_char6 ;
      new web.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "legajo_deduccionesWWColumnsSelector", GXv_char7) ;
      legajo_deduccioneswwexport.this.GXt_char6 = GXv_char7[0] ;
      AV29UserCustomValue = GXt_char6 ;
      if ( ! ( (GXutil.strcmp("", AV29UserCustomValue)==0) ) )
      {
         AV26ColumnsSelectorAux.fromxml(AV29UserCustomValue, null, null);
         GXv_SdtWWPColumnsSelector8[0] = AV26ColumnsSelectorAux;
         GXv_SdtWWPColumnsSelector9[0] = AV25ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnselector_updatecolumns(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, GXv_SdtWWPColumnsSelector9) ;
         AV26ColumnsSelectorAux = GXv_SdtWWPColumnsSelector8[0] ;
         AV25ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      }
   }

   public void S211( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV21Session.getValue("legajo_deduccionesWWGridState"), "") == 0 )
      {
         AV23GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "legajo_deduccionesWWGridState"), null, null);
      }
      else
      {
         AV23GridState.fromxml(AV21Session.getValue("legajo_deduccionesWWGridState"), null, null);
      }
      AV19OrderedBy = AV23GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV20OrderedDsc = AV23GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV80GXV8 = 1 ;
      while ( AV80GXV8 <= AV23GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV24GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV23GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV80GXV8));
         if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGIDNOMAPE") == 0 )
         {
            AV37TFLegIdNomApe = AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGIDNOMAPE_SEL") == 0 )
         {
            AV36TFLegIdNomApe_SelsJson = AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV38TFLegIdNomApe_Sels.fromJSonString(AV36TFLegIdNomApe_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGDEDANIO") == 0 )
         {
            AV40TFLegDedAnio = (short)(GXutil.lval( AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV41TFLegDedAnio_To = (short)(GXutil.lval( AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGDEDMES_SEL") == 0 )
         {
            AV42TFLegDedMes_SelsJson = AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV43TFLegDedMes_Sels.fromJSonString(AV42TFLegDedMes_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGDEDCONCODYDESC") == 0 )
         {
            AV46TFLegDedConCodYDesc = AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGDEDCONCODYDESC_SEL") == 0 )
         {
            AV45TFLegDedConCodYDesc_SelsJson = AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV47TFLegDedConCodYDesc_Sels.fromJSonString(AV45TFLegDedConCodYDesc_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGDEDDESCRIP") == 0 )
         {
            AV50TFLegDedDescrip = AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGDEDDESCRIP_SEL") == 0 )
         {
            AV49TFLegDedDescrip_SelsJson = AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV51TFLegDedDescrip_Sels.fromJSonString(AV49TFLegDedDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGDEDIMPORTE") == 0 )
         {
            AV53TFLegDedImporte = CommonUtil.decimalVal( AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV54TFLegDedImporte_To = CommonUtil.decimalVal( AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV17MenuOpcCod = AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV80GXV8 = (int)(AV80GXV8+1) ;
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
      this.aP0[0] = legajo_deduccioneswwexport.this.AV12Filename;
      this.aP1[0] = legajo_deduccioneswwexport.this.AV13ErrorMessage;
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
      AV60Pgmname = "" ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV11ExcelDocument = new com.genexus.gxoffice.ExcelDoc();
      AV38TFLegIdNomApe_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV39TFLegIdNomApe_Sel = "" ;
      AV37TFLegIdNomApe = "" ;
      AV43TFLegDedMes_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV47TFLegDedConCodYDesc_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV48TFLegDedConCodYDesc_Sel = "" ;
      AV46TFLegDedConCodYDesc = "" ;
      AV51TFLegDedDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV52TFLegDedDescrip_Sel = "" ;
      AV50TFLegDedDescrip = "" ;
      AV53TFLegDedImporte = DecimalUtil.ZERO ;
      AV54TFLegDedImporte_To = DecimalUtil.ZERO ;
      GXv_exceldoc4 = new com.genexus.gxoffice.ExcelDoc[1] ;
      GXv_int5 = new short[1] ;
      AV21Session = httpContext.getWebSession();
      AV28ColumnsSelectorXML = "" ;
      AV25ColumnsSelector = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV27ColumnsSelector_Column = new web.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      A250LegIdNomApe = "" ;
      A570LegDedConCodYDesc = "" ;
      A568LegDedDescrip = "" ;
      A560LegDedImporte = DecimalUtil.ZERO ;
      AV67Legajo_deduccioneswwds_1_tflegidnomape = "" ;
      AV68Legajo_deduccioneswwds_2_tflegidnomape_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV71Legajo_deduccioneswwds_5_tflegdedmes_sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV72Legajo_deduccioneswwds_6_tflegdedconcodydesc = "" ;
      AV73Legajo_deduccioneswwds_7_tflegdedconcodydesc_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV74Legajo_deduccioneswwds_8_tflegdeddescrip = "" ;
      AV75Legajo_deduccioneswwds_9_tflegdeddescrip_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV76Legajo_deduccioneswwds_10_tflegdedimporte = DecimalUtil.ZERO ;
      AV77Legajo_deduccioneswwds_11_tflegdedimporte_to = DecimalUtil.ZERO ;
      scmdbuf = "" ;
      lV67Legajo_deduccioneswwds_1_tflegidnomape = "" ;
      lV72Legajo_deduccioneswwds_6_tflegdedconcodydesc = "" ;
      lV74Legajo_deduccioneswwds_8_tflegdeddescrip = "" ;
      A84LegDedConCodigo = "" ;
      A559LegDedConDescrip = "" ;
      P02F22_A6LegNumero = new int[1] ;
      P02F22_A1EmpCod = new short[1] ;
      P02F22_A3CliCod = new int[1] ;
      P02F22_A560LegDedImporte = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P02F22_A568LegDedDescrip = new String[] {""} ;
      P02F22_A570LegDedConCodYDesc = new String[] {""} ;
      P02F22_A767LegDedMes = new byte[1] ;
      P02F22_A768LegDedAnio = new short[1] ;
      P02F22_A250LegIdNomApe = new String[] {""} ;
      P02F22_A84LegDedConCodigo = new String[] {""} ;
      P02F22_A559LegDedConDescrip = new String[] {""} ;
      P02F22_A83LegDedSec = new int[1] ;
      AV29UserCustomValue = "" ;
      GXt_char6 = "" ;
      GXv_char7 = new String[1] ;
      AV26ColumnsSelectorAux = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector8 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector9 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      AV23GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV24GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV36TFLegIdNomApe_SelsJson = "" ;
      AV42TFLegDedMes_SelsJson = "" ;
      AV45TFLegDedConCodYDesc_SelsJson = "" ;
      AV49TFLegDedDescrip_SelsJson = "" ;
      AV17MenuOpcCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.legajo_deduccioneswwexport__default(),
         new Object[] {
             new Object[] {
            P02F22_A6LegNumero, P02F22_A1EmpCod, P02F22_A3CliCod, P02F22_A560LegDedImporte, P02F22_A568LegDedDescrip, P02F22_A570LegDedConCodYDesc, P02F22_A767LegDedMes, P02F22_A768LegDedAnio, P02F22_A250LegIdNomApe, P02F22_A84LegDedConCodigo,
            P02F22_A559LegDedConDescrip, P02F22_A83LegDedSec
            }
         }
      );
      AV60Pgmname = "legajo_deduccionesWWExport" ;
      /* GeneXus formulas. */
      AV60Pgmname = "legajo_deduccionesWWExport" ;
      Gx_err = (short)(0) ;
   }

   private byte AV44TFLegDedMes_Sel ;
   private byte A767LegDedMes ;
   private short AV40TFLegDedAnio ;
   private short AV41TFLegDedAnio_To ;
   private short GXv_int5[] ;
   private short A768LegDedAnio ;
   private short AV69Legajo_deduccioneswwds_3_tflegdedanio ;
   private short AV70Legajo_deduccioneswwds_4_tflegdedanio_to ;
   private short AV19OrderedBy ;
   private short AV57EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV14CellRow ;
   private int AV15FirstColumn ;
   private int AV16Random ;
   private int AV61GXV1 ;
   private int AV62GXV2 ;
   private int AV63GXV3 ;
   private int AV64GXV4 ;
   private int AV65GXV5 ;
   private int AV18FirstDataCellRow ;
   private int AV68Legajo_deduccioneswwds_2_tflegidnomape_sels_size ;
   private int AV71Legajo_deduccioneswwds_5_tflegdedmes_sels_size ;
   private int AV73Legajo_deduccioneswwds_7_tflegdedconcodydesc_sels_size ;
   private int AV75Legajo_deduccioneswwds_9_tflegdeddescrip_sels_size ;
   private int AV56CliCod ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private int A83LegDedSec ;
   private int AV78GXV6 ;
   private int AV79GXV7 ;
   private int AV80GXV8 ;
   private long AV55i ;
   private long AV33VisibleColumnCount ;
   private java.math.BigDecimal AV53TFLegDedImporte ;
   private java.math.BigDecimal AV54TFLegDedImporte_To ;
   private java.math.BigDecimal A560LegDedImporte ;
   private java.math.BigDecimal AV76Legajo_deduccioneswwds_10_tflegdedimporte ;
   private java.math.BigDecimal AV77Legajo_deduccioneswwds_11_tflegdedimporte_to ;
   private String AV60Pgmname ;
   private String scmdbuf ;
   private String A84LegDedConCodigo ;
   private String GXt_char6 ;
   private String GXv_char7[] ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean AV20OrderedDsc ;
   private String AV28ColumnsSelectorXML ;
   private String AV29UserCustomValue ;
   private String AV36TFLegIdNomApe_SelsJson ;
   private String AV42TFLegDedMes_SelsJson ;
   private String AV45TFLegDedConCodYDesc_SelsJson ;
   private String AV49TFLegDedDescrip_SelsJson ;
   private String AV12Filename ;
   private String AV13ErrorMessage ;
   private String AV39TFLegIdNomApe_Sel ;
   private String AV37TFLegIdNomApe ;
   private String AV48TFLegDedConCodYDesc_Sel ;
   private String AV46TFLegDedConCodYDesc ;
   private String AV52TFLegDedDescrip_Sel ;
   private String AV50TFLegDedDescrip ;
   private String A250LegIdNomApe ;
   private String A570LegDedConCodYDesc ;
   private String A568LegDedDescrip ;
   private String AV67Legajo_deduccioneswwds_1_tflegidnomape ;
   private String AV72Legajo_deduccioneswwds_6_tflegdedconcodydesc ;
   private String AV74Legajo_deduccioneswwds_8_tflegdeddescrip ;
   private String lV67Legajo_deduccioneswwds_1_tflegidnomape ;
   private String lV72Legajo_deduccioneswwds_6_tflegdedconcodydesc ;
   private String lV74Legajo_deduccioneswwds_8_tflegdeddescrip ;
   private String A559LegDedConDescrip ;
   private String AV17MenuOpcCod ;
   private GXSimpleCollection<Byte> AV43TFLegDedMes_Sels ;
   private GXSimpleCollection<Byte> AV71Legajo_deduccioneswwds_5_tflegdedmes_sels ;
   private com.genexus.webpanels.WebSession AV21Session ;
   private GXSimpleCollection<String> AV38TFLegIdNomApe_Sels ;
   private GXSimpleCollection<String> AV47TFLegDedConCodYDesc_Sels ;
   private GXSimpleCollection<String> AV51TFLegDedDescrip_Sels ;
   private String[] aP1 ;
   private String[] aP0 ;
   private IDataStoreProvider pr_default ;
   private int[] P02F22_A6LegNumero ;
   private short[] P02F22_A1EmpCod ;
   private int[] P02F22_A3CliCod ;
   private java.math.BigDecimal[] P02F22_A560LegDedImporte ;
   private String[] P02F22_A568LegDedDescrip ;
   private String[] P02F22_A570LegDedConCodYDesc ;
   private byte[] P02F22_A767LegDedMes ;
   private short[] P02F22_A768LegDedAnio ;
   private String[] P02F22_A250LegIdNomApe ;
   private String[] P02F22_A84LegDedConCodigo ;
   private String[] P02F22_A559LegDedConDescrip ;
   private int[] P02F22_A83LegDedSec ;
   private com.genexus.gxoffice.ExcelDoc AV11ExcelDocument ;
   private com.genexus.gxoffice.ExcelDoc GXv_exceldoc4[] ;
   private GXSimpleCollection<String> AV68Legajo_deduccioneswwds_2_tflegidnomape_sels ;
   private GXSimpleCollection<String> AV73Legajo_deduccioneswwds_7_tflegdedconcodydesc_sels ;
   private GXSimpleCollection<String> AV75Legajo_deduccioneswwds_9_tflegdeddescrip_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV23GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV24GridStateFilterValue ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV25ColumnsSelector ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV26ColumnsSelectorAux ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector8[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector9[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector_Column AV27ColumnsSelector_Column ;
}

final  class legajo_deduccioneswwexport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P02F22( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A570LegDedConCodYDesc ,
                                          GXSimpleCollection<String> AV73Legajo_deduccioneswwds_7_tflegdedconcodydesc_sels ,
                                          String A250LegIdNomApe ,
                                          GXSimpleCollection<String> AV68Legajo_deduccioneswwds_2_tflegidnomape_sels ,
                                          byte A767LegDedMes ,
                                          GXSimpleCollection<Byte> AV71Legajo_deduccioneswwds_5_tflegdedmes_sels ,
                                          String A568LegDedDescrip ,
                                          GXSimpleCollection<String> AV75Legajo_deduccioneswwds_9_tflegdeddescrip_sels ,
                                          int AV68Legajo_deduccioneswwds_2_tflegidnomape_sels_size ,
                                          String AV67Legajo_deduccioneswwds_1_tflegidnomape ,
                                          short AV69Legajo_deduccioneswwds_3_tflegdedanio ,
                                          short AV70Legajo_deduccioneswwds_4_tflegdedanio_to ,
                                          int AV71Legajo_deduccioneswwds_5_tflegdedmes_sels_size ,
                                          int AV73Legajo_deduccioneswwds_7_tflegdedconcodydesc_sels_size ,
                                          String AV72Legajo_deduccioneswwds_6_tflegdedconcodydesc ,
                                          int AV75Legajo_deduccioneswwds_9_tflegdeddescrip_sels_size ,
                                          String AV74Legajo_deduccioneswwds_8_tflegdeddescrip ,
                                          java.math.BigDecimal AV76Legajo_deduccioneswwds_10_tflegdedimporte ,
                                          java.math.BigDecimal AV77Legajo_deduccioneswwds_11_tflegdedimporte_to ,
                                          short A768LegDedAnio ,
                                          String A84LegDedConCodigo ,
                                          String A559LegDedConDescrip ,
                                          java.math.BigDecimal A560LegDedImporte ,
                                          short AV19OrderedBy ,
                                          boolean AV20OrderedDsc ,
                                          int AV56CliCod ,
                                          short AV57EmpCod ,
                                          int A3CliCod ,
                                          short A1EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int10 = new byte[10];
      Object[] GXv_Object11 = new Object[2];
      scmdbuf = "SELECT T1.LegNumero, T1.EmpCod, T1.CliCod, T1.LegDedImporte, T1.LegDedDescrip, RTRIM(LTRIM(T1.LegDedConCodigo)) || ' - ' || RTRIM(LTRIM(T3.ConDescrip)) AS LegDedConCodYDesc," ;
      scmdbuf += " T1.LegDedMes, T1.LegDedAnio, T2.LegIdNomApe, T1.LegDedConCodigo AS LegDedConCodigo, T3.ConDescrip AS LegDedConDescrip, T1.LegDedSec FROM ((legajo_deducciones T1" ;
      scmdbuf += " INNER JOIN Legajo T2 ON T2.CliCod = T1.CliCod AND T2.EmpCod = T1.EmpCod AND T2.LegNumero = T1.LegNumero) INNER JOIN Concepto T3 ON T3.CliCod = T1.CliCod AND T3.ConCodigo" ;
      scmdbuf += " = T1.LegDedConCodigo)" ;
      addWhere(sWhereString, "(T1.CliCod = ? and T1.EmpCod = ?)");
      addWhere(sWhereString, "(? <= 0 or ( "+GXutil.toValueList("postgresql", AV73Legajo_deduccioneswwds_7_tflegdedconcodydesc_sels, "RTRIM(LTRIM(T1.LegDedConCodigo)) || ' - ' || RTRIM(LTRIM(T3.ConDescrip)) IN (", ")")+"))");
      if ( ( AV68Legajo_deduccioneswwds_2_tflegidnomape_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV67Legajo_deduccioneswwds_1_tflegidnomape)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.LegIdNomApe) like LOWER(?))");
      }
      else
      {
         GXv_int10[3] = (byte)(1) ;
      }
      if ( AV68Legajo_deduccioneswwds_2_tflegidnomape_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV68Legajo_deduccioneswwds_2_tflegidnomape_sels, "T2.LegIdNomApe IN (", ")")+")");
      }
      if ( ! (0==AV69Legajo_deduccioneswwds_3_tflegdedanio) )
      {
         addWhere(sWhereString, "(T1.LegDedAnio >= ?)");
      }
      else
      {
         GXv_int10[4] = (byte)(1) ;
      }
      if ( ! (0==AV70Legajo_deduccioneswwds_4_tflegdedanio_to) )
      {
         addWhere(sWhereString, "(T1.LegDedAnio <= ?)");
      }
      else
      {
         GXv_int10[5] = (byte)(1) ;
      }
      if ( AV71Legajo_deduccioneswwds_5_tflegdedmes_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV71Legajo_deduccioneswwds_5_tflegdedmes_sels, "T1.LegDedMes IN (", ")")+")");
      }
      if ( ( AV73Legajo_deduccioneswwds_7_tflegdedconcodydesc_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV72Legajo_deduccioneswwds_6_tflegdedconcodydesc)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(RTRIM(LTRIM(T1.LegDedConCodigo)) || ' - ' || RTRIM(LTRIM(T3.ConDescrip))) like LOWER(?))");
      }
      else
      {
         GXv_int10[6] = (byte)(1) ;
      }
      if ( ( AV75Legajo_deduccioneswwds_9_tflegdeddescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV74Legajo_deduccioneswwds_8_tflegdeddescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.LegDedDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int10[7] = (byte)(1) ;
      }
      if ( AV75Legajo_deduccioneswwds_9_tflegdeddescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV75Legajo_deduccioneswwds_9_tflegdeddescrip_sels, "T1.LegDedDescrip IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV76Legajo_deduccioneswwds_10_tflegdedimporte)==0) )
      {
         addWhere(sWhereString, "(T1.LegDedImporte >= ?)");
      }
      else
      {
         GXv_int10[8] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV77Legajo_deduccioneswwds_11_tflegdedimporte_to)==0) )
      {
         addWhere(sWhereString, "(T1.LegDedImporte <= ?)");
      }
      else
      {
         GXv_int10[9] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      if ( ( AV19OrderedBy == 1 ) && ! AV20OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.LegDedAnio" ;
      }
      else if ( ( AV19OrderedBy == 1 ) && ( AV20OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.LegDedAnio DESC" ;
      }
      else if ( ( AV19OrderedBy == 2 ) && ! AV20OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.LegDedMes" ;
      }
      else if ( ( AV19OrderedBy == 2 ) && ( AV20OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.LegDedMes DESC" ;
      }
      else if ( ( AV19OrderedBy == 3 ) && ! AV20OrderedDsc )
      {
         scmdbuf += " ORDER BY LegDedConCodYDesc" ;
      }
      else if ( ( AV19OrderedBy == 3 ) && ( AV20OrderedDsc ) )
      {
         scmdbuf += " ORDER BY LegDedConCodYDesc DESC" ;
      }
      else if ( ( AV19OrderedBy == 4 ) && ! AV20OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.LegDedDescrip" ;
      }
      else if ( ( AV19OrderedBy == 4 ) && ( AV20OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.LegDedDescrip DESC" ;
      }
      else if ( ( AV19OrderedBy == 5 ) && ! AV20OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.LegDedImporte" ;
      }
      else if ( ( AV19OrderedBy == 5 ) && ( AV20OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.LegDedImporte DESC" ;
      }
      GXv_Object11[0] = scmdbuf ;
      GXv_Object11[1] = GXv_int10 ;
      return GXv_Object11 ;
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
                  return conditional_P02F22(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , ((Number) dynConstraints[4]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , ((Number) dynConstraints[10]).shortValue() , ((Number) dynConstraints[11]).shortValue() , ((Number) dynConstraints[12]).intValue() , ((Number) dynConstraints[13]).intValue() , (String)dynConstraints[14] , ((Number) dynConstraints[15]).intValue() , (String)dynConstraints[16] , (java.math.BigDecimal)dynConstraints[17] , (java.math.BigDecimal)dynConstraints[18] , ((Number) dynConstraints[19]).shortValue() , (String)dynConstraints[20] , (String)dynConstraints[21] , (java.math.BigDecimal)dynConstraints[22] , ((Number) dynConstraints[23]).shortValue() , ((Boolean) dynConstraints[24]).booleanValue() , ((Number) dynConstraints[25]).intValue() , ((Number) dynConstraints[26]).shortValue() , ((Number) dynConstraints[27]).intValue() , ((Number) dynConstraints[28]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02F22", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,2);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((byte[]) buf[6])[0] = rslt.getByte(7);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((String[]) buf[9])[0] = rslt.getString(10, 10);
               ((String[]) buf[10])[0] = rslt.getVarchar(11);
               ((int[]) buf[11])[0] = rslt.getInt(12);
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
                  stmt.setInt(sIdx, ((Number) parms[10]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[11]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[12]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[13], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[14]).shortValue());
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[15]).shortValue());
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[16], 400);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[17], 400);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[18], 2);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[19], 2);
               }
               return;
      }
   }

}

