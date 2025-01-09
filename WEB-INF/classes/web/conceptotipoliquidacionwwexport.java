package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class conceptotipoliquidacionwwexport extends GXProcedure
{
   public conceptotipoliquidacionwwexport( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( conceptotipoliquidacionwwexport.class ), "" );
   }

   public conceptotipoliquidacionwwexport( int remoteHandle ,
                                           ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String[] aP0 )
   {
      conceptotipoliquidacionwwexport.this.aP1 = new String[] {""};
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
      conceptotipoliquidacionwwexport.this.aP0 = aP0;
      conceptotipoliquidacionwwexport.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV56CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      conceptotipoliquidacionwwexport.this.GXt_int1 = GXv_int2[0] ;
      AV56CliCod = GXt_int1 ;
      GXt_boolean3 = AV8IsAuthorized ;
      GXv_boolean4[0] = GXt_boolean3 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWConceptoTipoLiquidacion", GXv_boolean4) ;
      conceptotipoliquidacionwwexport.this.GXt_boolean3 = GXv_boolean4[0] ;
      AV8IsAuthorized = GXt_boolean3 ;
      if ( ! AV8IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV67Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      if ( AV8IsAuthorized )
      {
         GXv_SdtWWPContext5[0] = AV9WWPContext;
         new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext5) ;
         AV9WWPContext = GXv_SdtWWPContext5[0] ;
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
      AV12Filename = "ConceptoTipoLiquidacionWWExport-" + GXutil.trim( GXutil.str( AV16Random, 8, 0)) + ".xlsx" ;
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
      if ( ! ( (0==AV35TFCliCod) && (0==AV36TFCliCod_To) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Cod", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         conceptotipoliquidacionwwexport.this.AV14CellRow = GXv_int7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV35TFCliCod );
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, false, GXv_int7, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         conceptotipoliquidacionwwexport.this.AV14CellRow = GXv_int7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV36TFCliCod_To );
      }
      if ( ! ( ( AV39TFConCodigo_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Código", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         conceptotipoliquidacionwwexport.this.AV14CellRow = GXv_int7[0] ;
         AV55i = 1 ;
         AV68GXV1 = 1 ;
         while ( AV68GXV1 <= AV39TFConCodigo_Sels.size() )
         {
            AV40TFConCodigo_Sel = (String)AV39TFConCodigo_Sels.elementAt(-1+AV68GXV1) ;
            if ( AV55i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char8 = "" ;
            GXv_char9[0] = GXt_char8 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV40TFConCodigo_Sel, GXv_char9) ;
            conceptotipoliquidacionwwexport.this.GXt_char8 = GXv_char9[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char8 );
            AV55i = (long)(AV55i+1) ;
            AV68GXV1 = (int)(AV68GXV1+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV38TFConCodigo)==0) ) )
         {
            GXv_exceldoc6[0] = AV11ExcelDocument ;
            GXv_int7[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Código", "")) ;
            AV11ExcelDocument = GXv_exceldoc6[0] ;
            conceptotipoliquidacionwwexport.this.AV14CellRow = GXv_int7[0] ;
            GXt_char8 = "" ;
            GXv_char9[0] = GXt_char8 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV38TFConCodigo, GXv_char9) ;
            conceptotipoliquidacionwwexport.this.GXt_char8 = GXv_char9[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char8 );
         }
      }
      if ( ! ( ( AV43TFTLiqCod_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Tipo de Liquidación", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         conceptotipoliquidacionwwexport.this.AV14CellRow = GXv_int7[0] ;
         AV55i = 1 ;
         AV69GXV2 = 1 ;
         while ( AV69GXV2 <= AV43TFTLiqCod_Sels.size() )
         {
            AV44TFTLiqCod_Sel = (String)AV43TFTLiqCod_Sels.elementAt(-1+AV69GXV2) ;
            if ( AV55i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char8 = "" ;
            GXv_char9[0] = GXt_char8 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV44TFTLiqCod_Sel, GXv_char9) ;
            conceptotipoliquidacionwwexport.this.GXt_char8 = GXv_char9[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char8 );
            AV55i = (long)(AV55i+1) ;
            AV69GXV2 = (int)(AV69GXV2+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV42TFTLiqCod)==0) ) )
         {
            GXv_exceldoc6[0] = AV11ExcelDocument ;
            GXv_int7[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "Tipo de Liquidación", "")) ;
            AV11ExcelDocument = GXv_exceldoc6[0] ;
            conceptotipoliquidacionwwexport.this.AV14CellRow = GXv_int7[0] ;
            GXt_char8 = "" ;
            GXv_char9[0] = GXt_char8 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV42TFTLiqCod, GXv_char9) ;
            conceptotipoliquidacionwwexport.this.GXt_char8 = GXv_char9[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char8 );
         }
      }
      if ( ! ( (0==AV45TFConTLOrdejec) && (0==AV46TFConTLOrdejec_To) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "TLOrdejec", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         conceptotipoliquidacionwwexport.this.AV14CellRow = GXv_int7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV45TFConTLOrdejec );
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, false, GXv_int7, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         conceptotipoliquidacionwwexport.this.AV14CellRow = GXv_int7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV46TFConTLOrdejec_To );
      }
      if ( ! ( ( AV51TFConTLCondicion_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "TLCondicion", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         conceptotipoliquidacionwwexport.this.AV14CellRow = GXv_int7[0] ;
         AV55i = 1 ;
         AV70GXV3 = 1 ;
         while ( AV70GXV3 <= AV51TFConTLCondicion_Sels.size() )
         {
            AV52TFConTLCondicion_Sel = (String)AV51TFConTLCondicion_Sels.elementAt(-1+AV70GXV3) ;
            if ( AV55i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char8 = "" ;
            GXv_char9[0] = GXt_char8 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV52TFConTLCondicion_Sel, GXv_char9) ;
            conceptotipoliquidacionwwexport.this.GXt_char8 = GXv_char9[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char8 );
            AV55i = (long)(AV55i+1) ;
            AV70GXV3 = (int)(AV70GXV3+1) ;
         }
      }
      if ( ! ( (0==AV53TFConTLConHab) && (0==AV54TFConTLConHab_To) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "TLCon Hab", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         conceptotipoliquidacionwwexport.this.AV14CellRow = GXv_int7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV53TFConTLConHab );
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, false, GXv_int7, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         conceptotipoliquidacionwwexport.this.AV14CellRow = GXv_int7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV54TFConTLConHab_To );
      }
      if ( ! ( ( AV59TFConTLTipoCon_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc6[0] = AV11ExcelDocument ;
         GXv_int7[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV15FirstColumn), httpContext.getMessage( "TLTipo Con", "")) ;
         AV11ExcelDocument = GXv_exceldoc6[0] ;
         conceptotipoliquidacionwwexport.this.AV14CellRow = GXv_int7[0] ;
         AV55i = 1 ;
         AV71GXV4 = 1 ;
         while ( AV71GXV4 <= AV59TFConTLTipoCon_Sels.size() )
         {
            AV60TFConTLTipoCon_Sel = (String)AV59TFConTLTipoCon_Sels.elementAt(-1+AV71GXV4) ;
            if ( AV55i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char8 = "" ;
            GXv_char9[0] = GXt_char8 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV60TFConTLTipoCon_Sel, GXv_char9) ;
            conceptotipoliquidacionwwexport.this.GXt_char8 = GXv_char9[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char8 );
            AV55i = (long)(AV55i+1) ;
            AV71GXV4 = (int)(AV71GXV4+1) ;
         }
      }
      AV14CellRow = (int)(AV14CellRow+2) ;
   }

   public void S141( )
   {
      /* 'WRITECOLUMNTITLES' Routine */
      returnInSub = false ;
      AV32VisibleColumnCount = 0 ;
      if ( GXutil.strcmp(AV20Session.getValue("ConceptoTipoLiquidacionWWColumnsSelector"), "") != 0 )
      {
         AV27ColumnsSelectorXML = AV20Session.getValue("ConceptoTipoLiquidacionWWColumnsSelector") ;
         AV24ColumnsSelector.fromxml(AV27ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S151 ();
         if (returnInSub) return;
      }
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+10)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().sort("Order");
      AV72GXV5 = 1 ;
      while ( AV72GXV5 <= AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
      {
         AV26ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV72GXV5));
         if ( AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( httpContext.getMessage( ((GXutil.strcmp("", AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname())==0) ? AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname() : AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname()), "") );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setBold( (short)(1) );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setColor( 11 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         AV72GXV5 = (int)(AV72GXV5+1) ;
      }
   }

   public void S161( )
   {
      /* 'WRITEDATA' Routine */
      returnInSub = false ;
      AV74Conceptotipoliquidacionwwds_1_tfclicod = AV35TFCliCod ;
      AV75Conceptotipoliquidacionwwds_2_tfclicod_to = AV36TFCliCod_To ;
      AV76Conceptotipoliquidacionwwds_3_tfconcodigo = AV38TFConCodigo ;
      AV77Conceptotipoliquidacionwwds_4_tfconcodigo_sels = AV39TFConCodigo_Sels ;
      AV78Conceptotipoliquidacionwwds_5_tftliqcod = AV42TFTLiqCod ;
      AV79Conceptotipoliquidacionwwds_6_tftliqcod_sels = AV43TFTLiqCod_Sels ;
      AV80Conceptotipoliquidacionwwds_7_tfcontlordejec = AV45TFConTLOrdejec ;
      AV81Conceptotipoliquidacionwwds_8_tfcontlordejec_to = AV46TFConTLOrdejec_To ;
      AV82Conceptotipoliquidacionwwds_9_tfcontlcondicion_sels = AV51TFConTLCondicion_Sels ;
      AV83Conceptotipoliquidacionwwds_10_tfcontlconhab = AV53TFConTLConHab ;
      AV84Conceptotipoliquidacionwwds_11_tfcontlconhab_to = AV54TFConTLConHab_To ;
      AV85Conceptotipoliquidacionwwds_12_tfcontltipocon_sels = AV59TFConTLTipoCon_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A26ConCodigo ,
                                           AV77Conceptotipoliquidacionwwds_4_tfconcodigo_sels ,
                                           A32TLiqCod ,
                                           AV79Conceptotipoliquidacionwwds_6_tftliqcod_sels ,
                                           A1410ConTLCondicion ,
                                           AV82Conceptotipoliquidacionwwds_9_tfcontlcondicion_sels ,
                                           A1788ConTLTipoCon ,
                                           AV85Conceptotipoliquidacionwwds_12_tfcontltipocon_sels ,
                                           Integer.valueOf(AV74Conceptotipoliquidacionwwds_1_tfclicod) ,
                                           Integer.valueOf(AV75Conceptotipoliquidacionwwds_2_tfclicod_to) ,
                                           Integer.valueOf(AV77Conceptotipoliquidacionwwds_4_tfconcodigo_sels.size()) ,
                                           AV76Conceptotipoliquidacionwwds_3_tfconcodigo ,
                                           Integer.valueOf(AV79Conceptotipoliquidacionwwds_6_tftliqcod_sels.size()) ,
                                           AV78Conceptotipoliquidacionwwds_5_tftliqcod ,
                                           Long.valueOf(AV80Conceptotipoliquidacionwwds_7_tfcontlordejec) ,
                                           Long.valueOf(AV81Conceptotipoliquidacionwwds_8_tfcontlordejec_to) ,
                                           Integer.valueOf(AV82Conceptotipoliquidacionwwds_9_tfcontlcondicion_sels.size()) ,
                                           Byte.valueOf(AV83Conceptotipoliquidacionwwds_10_tfcontlconhab) ,
                                           Byte.valueOf(AV84Conceptotipoliquidacionwwds_11_tfcontlconhab_to) ,
                                           Integer.valueOf(AV85Conceptotipoliquidacionwwds_12_tfcontltipocon_sels.size()) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Long.valueOf(A1406ConTLOrdejec) ,
                                           Byte.valueOf(A1470ConTLConHab) ,
                                           Short.valueOf(AV18OrderedBy) ,
                                           Boolean.valueOf(AV19OrderedDsc) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.LONG, TypeConstants.LONG, TypeConstants.INT, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.INT, TypeConstants.LONG,
                                           TypeConstants.BYTE, TypeConstants.SHORT, TypeConstants.BOOLEAN
                                           }
      });
      lV76Conceptotipoliquidacionwwds_3_tfconcodigo = GXutil.padr( GXutil.rtrim( AV76Conceptotipoliquidacionwwds_3_tfconcodigo), 10, "%") ;
      lV78Conceptotipoliquidacionwwds_5_tftliqcod = GXutil.padr( GXutil.rtrim( AV78Conceptotipoliquidacionwwds_5_tftliqcod), 20, "%") ;
      /* Using cursor P01KQ2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV74Conceptotipoliquidacionwwds_1_tfclicod), Integer.valueOf(AV75Conceptotipoliquidacionwwds_2_tfclicod_to), lV76Conceptotipoliquidacionwwds_3_tfconcodigo, lV78Conceptotipoliquidacionwwds_5_tftliqcod, Long.valueOf(AV80Conceptotipoliquidacionwwds_7_tfcontlordejec), Long.valueOf(AV81Conceptotipoliquidacionwwds_8_tfcontlordejec_to), Byte.valueOf(AV83Conceptotipoliquidacionwwds_10_tfcontlconhab), Byte.valueOf(AV84Conceptotipoliquidacionwwds_11_tfcontlconhab_to)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1788ConTLTipoCon = P01KQ2_A1788ConTLTipoCon[0] ;
         n1788ConTLTipoCon = P01KQ2_n1788ConTLTipoCon[0] ;
         A1470ConTLConHab = P01KQ2_A1470ConTLConHab[0] ;
         A1410ConTLCondicion = P01KQ2_A1410ConTLCondicion[0] ;
         n1410ConTLCondicion = P01KQ2_n1410ConTLCondicion[0] ;
         A1406ConTLOrdejec = P01KQ2_A1406ConTLOrdejec[0] ;
         A32TLiqCod = P01KQ2_A32TLiqCod[0] ;
         A26ConCodigo = P01KQ2_A26ConCodigo[0] ;
         A3CliCod = P01KQ2_A3CliCod[0] ;
         A1789CONTLSegPla = P01KQ2_A1789CONTLSegPla[0] ;
         n1789CONTLSegPla = P01KQ2_n1789CONTLSegPla[0] ;
         A1409ConTLVigencia = P01KQ2_A1409ConTLVigencia[0] ;
         n1409ConTLVigencia = P01KQ2_n1409ConTLVigencia[0] ;
         AV14CellRow = (int)(AV14CellRow+1) ;
         /* Execute user subroutine: 'BEFOREWRITELINE' */
         S172 ();
         if ( returnInSub )
         {
            pr_default.close(0);
            returnInSub = true;
            if (true) return;
         }
         AV32VisibleColumnCount = 0 ;
         AV86GXV6 = 1 ;
         while ( AV86GXV6 <= AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
         {
            AV26ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV86GXV6));
            if ( AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
            {
               if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "CliCod") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A3CliCod );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConCodigo") == 0 )
               {
                  GXt_char8 = "" ;
                  GXv_char9[0] = GXt_char8 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A26ConCodigo, GXv_char9) ;
                  conceptotipoliquidacionwwexport.this.GXt_char8 = GXv_char9[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char8 );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "TLiqCod") == 0 )
               {
                  GXt_char8 = "" ;
                  GXv_char9[0] = GXt_char8 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A32TLiqCod, GXv_char9) ;
                  conceptotipoliquidacionwwexport.this.GXt_char8 = GXv_char9[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char8 );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConTLOrdejec") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A1406ConTLOrdejec );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConTLVigencia") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A1409ConTLVigencia );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConTLCondicion") == 0 )
               {
                  GXt_char8 = "" ;
                  GXv_char9[0] = GXt_char8 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A1410ConTLCondicion, GXv_char9) ;
                  conceptotipoliquidacionwwexport.this.GXt_char8 = GXv_char9[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char8 );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConTLConHab") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A1470ConTLConHab );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "ConTLTipoCon") == 0 )
               {
                  GXt_char8 = "" ;
                  GXv_char9[0] = GXt_char8 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A1788ConTLTipoCon, GXv_char9) ;
                  conceptotipoliquidacionwwexport.this.GXt_char8 = GXv_char9[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char8 );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "CONTLSegPla") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A1789CONTLSegPla );
               }
               AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
            }
            AV86GXV6 = (int)(AV86GXV6+1) ;
         }
         /* Execute user subroutine: 'AFTERWRITELINE' */
         S182 ();
         if ( returnInSub )
         {
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
      AV24ColumnsSelector = (web.wwpbaseobjects.SdtWWPColumnsSelector)new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "CliCod", "", "Cod", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "ConCodigo", "", "Código", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "TLiqCod", "", "Tipo de Liquidación", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "ConTLOrdejec", "", "TLOrdejec", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "ConTLVigencia", "", "TLVigencia", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "ConTLCondicion", "", "TLCondicion", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "ConTLConHab", "", "TLCon Hab", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "ConTLTipoCon", "", "TLTipo Con", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "CONTLSegPla", "", "Pla", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "&VerSVG", "", "", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXt_char8 = AV28UserCustomValue ;
      GXv_char9[0] = GXt_char8 ;
      new web.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "ConceptoTipoLiquidacionWWColumnsSelector", GXv_char9) ;
      conceptotipoliquidacionwwexport.this.GXt_char8 = GXv_char9[0] ;
      AV28UserCustomValue = GXt_char8 ;
      if ( ! ( (GXutil.strcmp("", AV28UserCustomValue)==0) ) )
      {
         AV25ColumnsSelectorAux.fromxml(AV28UserCustomValue, null, null);
         GXv_SdtWWPColumnsSelector10[0] = AV25ColumnsSelectorAux;
         GXv_SdtWWPColumnsSelector11[0] = AV24ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnselector_updatecolumns(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, GXv_SdtWWPColumnsSelector11) ;
         AV25ColumnsSelectorAux = GXv_SdtWWPColumnsSelector10[0] ;
         AV24ColumnsSelector = GXv_SdtWWPColumnsSelector11[0] ;
      }
   }

   public void S201( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV20Session.getValue("ConceptoTipoLiquidacionWWGridState"), "") == 0 )
      {
         AV22GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "ConceptoTipoLiquidacionWWGridState"), null, null);
      }
      else
      {
         AV22GridState.fromxml(AV20Session.getValue("ConceptoTipoLiquidacionWWGridState"), null, null);
      }
      AV18OrderedBy = AV22GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV19OrderedDsc = AV22GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV87GXV7 = 1 ;
      while ( AV87GXV7 <= AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV23GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV87GXV7));
         if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLICOD") == 0 )
         {
            AV35TFCliCod = (int)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV36TFCliCod_To = (int)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONCODIGO") == 0 )
         {
            AV38TFConCodigo = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONCODIGO_SEL") == 0 )
         {
            AV37TFConCodigo_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV39TFConCodigo_Sels.fromJSonString(AV37TFConCodigo_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFTLIQCOD") == 0 )
         {
            AV42TFTLiqCod = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFTLIQCOD_SEL") == 0 )
         {
            AV41TFTLiqCod_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV43TFTLiqCod_Sels.fromJSonString(AV41TFTLiqCod_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONTLORDEJEC") == 0 )
         {
            AV45TFConTLOrdejec = GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value()) ;
            AV46TFConTLOrdejec_To = GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto()) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONTLCONDICION_SEL") == 0 )
         {
            AV50TFConTLCondicion_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV51TFConTLCondicion_Sels.fromJSonString(AV50TFConTLCondicion_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONTLCONHAB") == 0 )
         {
            AV53TFConTLConHab = (byte)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV54TFConTLConHab_To = (byte)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONTLTIPOCON_SEL") == 0 )
         {
            AV58TFConTLTipoCon_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV59TFConTLTipoCon_Sels.fromJSonString(AV58TFConTLTipoCon_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV64MenuOpcCod = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV87GXV7 = (int)(AV87GXV7+1) ;
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
      this.aP0[0] = conceptotipoliquidacionwwexport.this.AV12Filename;
      this.aP1[0] = conceptotipoliquidacionwwexport.this.AV13ErrorMessage;
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
      GXv_int2 = new int[1] ;
      GXv_boolean4 = new boolean[1] ;
      AV67Pgmname = "" ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext5 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV11ExcelDocument = new com.genexus.gxoffice.ExcelDoc();
      AV39TFConCodigo_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV40TFConCodigo_Sel = "" ;
      AV38TFConCodigo = "" ;
      AV43TFTLiqCod_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV44TFTLiqCod_Sel = "" ;
      AV42TFTLiqCod = "" ;
      AV51TFConTLCondicion_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV52TFConTLCondicion_Sel = "" ;
      AV59TFConTLTipoCon_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_exceldoc6 = new com.genexus.gxoffice.ExcelDoc[1] ;
      GXv_int7 = new short[1] ;
      AV60TFConTLTipoCon_Sel = "" ;
      AV20Session = httpContext.getWebSession();
      AV27ColumnsSelectorXML = "" ;
      AV24ColumnsSelector = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV26ColumnsSelector_Column = new web.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      A26ConCodigo = "" ;
      A32TLiqCod = "" ;
      A1410ConTLCondicion = "" ;
      A1788ConTLTipoCon = "" ;
      AV76Conceptotipoliquidacionwwds_3_tfconcodigo = "" ;
      AV77Conceptotipoliquidacionwwds_4_tfconcodigo_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV78Conceptotipoliquidacionwwds_5_tftliqcod = "" ;
      AV79Conceptotipoliquidacionwwds_6_tftliqcod_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV82Conceptotipoliquidacionwwds_9_tfcontlcondicion_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV85Conceptotipoliquidacionwwds_12_tfcontltipocon_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV76Conceptotipoliquidacionwwds_3_tfconcodigo = "" ;
      lV78Conceptotipoliquidacionwwds_5_tftliqcod = "" ;
      P01KQ2_A1788ConTLTipoCon = new String[] {""} ;
      P01KQ2_n1788ConTLTipoCon = new boolean[] {false} ;
      P01KQ2_A1470ConTLConHab = new byte[1] ;
      P01KQ2_A1410ConTLCondicion = new String[] {""} ;
      P01KQ2_n1410ConTLCondicion = new boolean[] {false} ;
      P01KQ2_A1406ConTLOrdejec = new long[1] ;
      P01KQ2_A32TLiqCod = new String[] {""} ;
      P01KQ2_A26ConCodigo = new String[] {""} ;
      P01KQ2_A3CliCod = new int[1] ;
      P01KQ2_A1789CONTLSegPla = new byte[1] ;
      P01KQ2_n1789CONTLSegPla = new boolean[] {false} ;
      P01KQ2_A1409ConTLVigencia = new byte[1] ;
      P01KQ2_n1409ConTLVigencia = new boolean[] {false} ;
      AV28UserCustomValue = "" ;
      GXt_char8 = "" ;
      GXv_char9 = new String[1] ;
      AV25ColumnsSelectorAux = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector10 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector11 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      AV22GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV23GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV37TFConCodigo_SelsJson = "" ;
      AV41TFTLiqCod_SelsJson = "" ;
      AV50TFConTLCondicion_SelsJson = "" ;
      AV58TFConTLTipoCon_SelsJson = "" ;
      AV64MenuOpcCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.conceptotipoliquidacionwwexport__default(),
         new Object[] {
             new Object[] {
            P01KQ2_A1788ConTLTipoCon, P01KQ2_n1788ConTLTipoCon, P01KQ2_A1470ConTLConHab, P01KQ2_A1410ConTLCondicion, P01KQ2_n1410ConTLCondicion, P01KQ2_A1406ConTLOrdejec, P01KQ2_A32TLiqCod, P01KQ2_A26ConCodigo, P01KQ2_A3CliCod, P01KQ2_A1789CONTLSegPla,
            P01KQ2_n1789CONTLSegPla, P01KQ2_A1409ConTLVigencia, P01KQ2_n1409ConTLVigencia
            }
         }
      );
      AV67Pgmname = "ConceptoTipoLiquidacionWWExport" ;
      /* GeneXus formulas. */
      AV67Pgmname = "ConceptoTipoLiquidacionWWExport" ;
      Gx_err = (short)(0) ;
   }

   private byte AV53TFConTLConHab ;
   private byte AV54TFConTLConHab_To ;
   private byte A1409ConTLVigencia ;
   private byte A1470ConTLConHab ;
   private byte A1789CONTLSegPla ;
   private byte AV83Conceptotipoliquidacionwwds_10_tfcontlconhab ;
   private byte AV84Conceptotipoliquidacionwwds_11_tfcontlconhab_to ;
   private short GXv_int7[] ;
   private short AV18OrderedBy ;
   private short Gx_err ;
   private int AV56CliCod ;
   private int GXt_int1 ;
   private int GXv_int2[] ;
   private int AV14CellRow ;
   private int AV15FirstColumn ;
   private int AV16Random ;
   private int AV35TFCliCod ;
   private int AV36TFCliCod_To ;
   private int AV68GXV1 ;
   private int AV69GXV2 ;
   private int AV70GXV3 ;
   private int AV71GXV4 ;
   private int AV72GXV5 ;
   private int A3CliCod ;
   private int AV74Conceptotipoliquidacionwwds_1_tfclicod ;
   private int AV75Conceptotipoliquidacionwwds_2_tfclicod_to ;
   private int AV77Conceptotipoliquidacionwwds_4_tfconcodigo_sels_size ;
   private int AV79Conceptotipoliquidacionwwds_6_tftliqcod_sels_size ;
   private int AV82Conceptotipoliquidacionwwds_9_tfcontlcondicion_sels_size ;
   private int AV85Conceptotipoliquidacionwwds_12_tfcontltipocon_sels_size ;
   private int AV86GXV6 ;
   private int AV87GXV7 ;
   private long AV55i ;
   private long AV45TFConTLOrdejec ;
   private long AV46TFConTLOrdejec_To ;
   private long AV32VisibleColumnCount ;
   private long A1406ConTLOrdejec ;
   private long AV80Conceptotipoliquidacionwwds_7_tfcontlordejec ;
   private long AV81Conceptotipoliquidacionwwds_8_tfcontlordejec_to ;
   private String AV67Pgmname ;
   private String AV40TFConCodigo_Sel ;
   private String AV38TFConCodigo ;
   private String AV44TFTLiqCod_Sel ;
   private String AV42TFTLiqCod ;
   private String AV52TFConTLCondicion_Sel ;
   private String AV60TFConTLTipoCon_Sel ;
   private String A26ConCodigo ;
   private String A32TLiqCod ;
   private String A1410ConTLCondicion ;
   private String A1788ConTLTipoCon ;
   private String AV76Conceptotipoliquidacionwwds_3_tfconcodigo ;
   private String AV78Conceptotipoliquidacionwwds_5_tftliqcod ;
   private String scmdbuf ;
   private String lV76Conceptotipoliquidacionwwds_3_tfconcodigo ;
   private String lV78Conceptotipoliquidacionwwds_5_tftliqcod ;
   private String GXt_char8 ;
   private String GXv_char9[] ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean3 ;
   private boolean GXv_boolean4[] ;
   private boolean returnInSub ;
   private boolean AV19OrderedDsc ;
   private boolean n1788ConTLTipoCon ;
   private boolean n1410ConTLCondicion ;
   private boolean n1789CONTLSegPla ;
   private boolean n1409ConTLVigencia ;
   private String AV27ColumnsSelectorXML ;
   private String AV28UserCustomValue ;
   private String AV37TFConCodigo_SelsJson ;
   private String AV41TFTLiqCod_SelsJson ;
   private String AV50TFConTLCondicion_SelsJson ;
   private String AV58TFConTLTipoCon_SelsJson ;
   private String AV12Filename ;
   private String AV13ErrorMessage ;
   private String AV64MenuOpcCod ;
   private com.genexus.webpanels.WebSession AV20Session ;
   private GXSimpleCollection<String> AV39TFConCodigo_Sels ;
   private GXSimpleCollection<String> AV43TFTLiqCod_Sels ;
   private GXSimpleCollection<String> AV51TFConTLCondicion_Sels ;
   private GXSimpleCollection<String> AV59TFConTLTipoCon_Sels ;
   private String[] aP1 ;
   private String[] aP0 ;
   private IDataStoreProvider pr_default ;
   private String[] P01KQ2_A1788ConTLTipoCon ;
   private boolean[] P01KQ2_n1788ConTLTipoCon ;
   private byte[] P01KQ2_A1470ConTLConHab ;
   private String[] P01KQ2_A1410ConTLCondicion ;
   private boolean[] P01KQ2_n1410ConTLCondicion ;
   private long[] P01KQ2_A1406ConTLOrdejec ;
   private String[] P01KQ2_A32TLiqCod ;
   private String[] P01KQ2_A26ConCodigo ;
   private int[] P01KQ2_A3CliCod ;
   private byte[] P01KQ2_A1789CONTLSegPla ;
   private boolean[] P01KQ2_n1789CONTLSegPla ;
   private byte[] P01KQ2_A1409ConTLVigencia ;
   private boolean[] P01KQ2_n1409ConTLVigencia ;
   private com.genexus.gxoffice.ExcelDoc AV11ExcelDocument ;
   private com.genexus.gxoffice.ExcelDoc GXv_exceldoc6[] ;
   private GXSimpleCollection<String> AV77Conceptotipoliquidacionwwds_4_tfconcodigo_sels ;
   private GXSimpleCollection<String> AV79Conceptotipoliquidacionwwds_6_tftliqcod_sels ;
   private GXSimpleCollection<String> AV82Conceptotipoliquidacionwwds_9_tfcontlcondicion_sels ;
   private GXSimpleCollection<String> AV85Conceptotipoliquidacionwwds_12_tfcontltipocon_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext5[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV22GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV23GridStateFilterValue ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV24ColumnsSelector ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV25ColumnsSelectorAux ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector10[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector11[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector_Column AV26ColumnsSelector_Column ;
}

final  class conceptotipoliquidacionwwexport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01KQ2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A26ConCodigo ,
                                          GXSimpleCollection<String> AV77Conceptotipoliquidacionwwds_4_tfconcodigo_sels ,
                                          String A32TLiqCod ,
                                          GXSimpleCollection<String> AV79Conceptotipoliquidacionwwds_6_tftliqcod_sels ,
                                          String A1410ConTLCondicion ,
                                          GXSimpleCollection<String> AV82Conceptotipoliquidacionwwds_9_tfcontlcondicion_sels ,
                                          String A1788ConTLTipoCon ,
                                          GXSimpleCollection<String> AV85Conceptotipoliquidacionwwds_12_tfcontltipocon_sels ,
                                          int AV74Conceptotipoliquidacionwwds_1_tfclicod ,
                                          int AV75Conceptotipoliquidacionwwds_2_tfclicod_to ,
                                          int AV77Conceptotipoliquidacionwwds_4_tfconcodigo_sels_size ,
                                          String AV76Conceptotipoliquidacionwwds_3_tfconcodigo ,
                                          int AV79Conceptotipoliquidacionwwds_6_tftliqcod_sels_size ,
                                          String AV78Conceptotipoliquidacionwwds_5_tftliqcod ,
                                          long AV80Conceptotipoliquidacionwwds_7_tfcontlordejec ,
                                          long AV81Conceptotipoliquidacionwwds_8_tfcontlordejec_to ,
                                          int AV82Conceptotipoliquidacionwwds_9_tfcontlcondicion_sels_size ,
                                          byte AV83Conceptotipoliquidacionwwds_10_tfcontlconhab ,
                                          byte AV84Conceptotipoliquidacionwwds_11_tfcontlconhab_to ,
                                          int AV85Conceptotipoliquidacionwwds_12_tfcontltipocon_sels_size ,
                                          int A3CliCod ,
                                          long A1406ConTLOrdejec ,
                                          byte A1470ConTLConHab ,
                                          short AV18OrderedBy ,
                                          boolean AV19OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int12 = new byte[8];
      Object[] GXv_Object13 = new Object[2];
      scmdbuf = "SELECT ConTLTipoCon, ConTLConHab, ConTLCondicion, ConTLOrdejec, TLiqCod, ConCodigo, CliCod, CONTLSegPla, ConTLVigencia FROM ConceptoTipoLiquidacion" ;
      if ( ! (0==AV74Conceptotipoliquidacionwwds_1_tfclicod) )
      {
         addWhere(sWhereString, "(CliCod >= ?)");
      }
      else
      {
         GXv_int12[0] = (byte)(1) ;
      }
      if ( ! (0==AV75Conceptotipoliquidacionwwds_2_tfclicod_to) )
      {
         addWhere(sWhereString, "(CliCod <= ?)");
      }
      else
      {
         GXv_int12[1] = (byte)(1) ;
      }
      if ( ( AV77Conceptotipoliquidacionwwds_4_tfconcodigo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV76Conceptotipoliquidacionwwds_3_tfconcodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ConCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int12[2] = (byte)(1) ;
      }
      if ( AV77Conceptotipoliquidacionwwds_4_tfconcodigo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV77Conceptotipoliquidacionwwds_4_tfconcodigo_sels, "ConCodigo IN (", ")")+")");
      }
      if ( ( AV79Conceptotipoliquidacionwwds_6_tftliqcod_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV78Conceptotipoliquidacionwwds_5_tftliqcod)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(TLiqCod) like LOWER(?))");
      }
      else
      {
         GXv_int12[3] = (byte)(1) ;
      }
      if ( AV79Conceptotipoliquidacionwwds_6_tftliqcod_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV79Conceptotipoliquidacionwwds_6_tftliqcod_sels, "TLiqCod IN (", ")")+")");
      }
      if ( ! (0==AV80Conceptotipoliquidacionwwds_7_tfcontlordejec) )
      {
         addWhere(sWhereString, "(ConTLOrdejec >= ?)");
      }
      else
      {
         GXv_int12[4] = (byte)(1) ;
      }
      if ( ! (0==AV81Conceptotipoliquidacionwwds_8_tfcontlordejec_to) )
      {
         addWhere(sWhereString, "(ConTLOrdejec <= ?)");
      }
      else
      {
         GXv_int12[5] = (byte)(1) ;
      }
      if ( AV82Conceptotipoliquidacionwwds_9_tfcontlcondicion_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV82Conceptotipoliquidacionwwds_9_tfcontlcondicion_sels, "ConTLCondicion IN (", ")")+")");
      }
      if ( ! (0==AV83Conceptotipoliquidacionwwds_10_tfcontlconhab) )
      {
         addWhere(sWhereString, "(ConTLConHab >= ?)");
      }
      else
      {
         GXv_int12[6] = (byte)(1) ;
      }
      if ( ! (0==AV84Conceptotipoliquidacionwwds_11_tfcontlconhab_to) )
      {
         addWhere(sWhereString, "(ConTLConHab <= ?)");
      }
      else
      {
         GXv_int12[7] = (byte)(1) ;
      }
      if ( AV85Conceptotipoliquidacionwwds_12_tfcontltipocon_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV85Conceptotipoliquidacionwwds_12_tfcontltipocon_sels, "ConTLTipoCon IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      if ( ( AV18OrderedBy == 1 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY CliCod" ;
      }
      else if ( ( AV18OrderedBy == 1 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY CliCod DESC" ;
      }
      else if ( ( AV18OrderedBy == 2 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY ConCodigo" ;
      }
      else if ( ( AV18OrderedBy == 2 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ConCodigo DESC" ;
      }
      else if ( ( AV18OrderedBy == 3 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY TLiqCod" ;
      }
      else if ( ( AV18OrderedBy == 3 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY TLiqCod DESC" ;
      }
      else if ( ( AV18OrderedBy == 4 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY ConTLOrdejec" ;
      }
      else if ( ( AV18OrderedBy == 4 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ConTLOrdejec DESC" ;
      }
      else if ( ( AV18OrderedBy == 5 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY ConTLVigencia" ;
      }
      else if ( ( AV18OrderedBy == 5 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ConTLVigencia DESC" ;
      }
      else if ( ( AV18OrderedBy == 6 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY ConTLCondicion" ;
      }
      else if ( ( AV18OrderedBy == 6 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ConTLCondicion DESC" ;
      }
      else if ( ( AV18OrderedBy == 7 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY ConTLConHab" ;
      }
      else if ( ( AV18OrderedBy == 7 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ConTLConHab DESC" ;
      }
      else if ( ( AV18OrderedBy == 8 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY ConTLTipoCon" ;
      }
      else if ( ( AV18OrderedBy == 8 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY ConTLTipoCon DESC" ;
      }
      else if ( ( AV18OrderedBy == 9 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY CONTLSegPla" ;
      }
      else if ( ( AV18OrderedBy == 9 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY CONTLSegPla DESC" ;
      }
      GXv_Object13[0] = scmdbuf ;
      GXv_Object13[1] = GXv_int12 ;
      return GXv_Object13 ;
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
                  return conditional_P01KQ2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , ((Number) dynConstraints[9]).intValue() , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , (String)dynConstraints[13] , ((Number) dynConstraints[14]).longValue() , ((Number) dynConstraints[15]).longValue() , ((Number) dynConstraints[16]).intValue() , ((Number) dynConstraints[17]).byteValue() , ((Number) dynConstraints[18]).byteValue() , ((Number) dynConstraints[19]).intValue() , ((Number) dynConstraints[20]).intValue() , ((Number) dynConstraints[21]).longValue() , ((Number) dynConstraints[22]).byteValue() , ((Number) dynConstraints[23]).shortValue() , ((Boolean) dynConstraints[24]).booleanValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01KQ2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((byte[]) buf[2])[0] = rslt.getByte(2);
               ((String[]) buf[3])[0] = rslt.getString(3, 20);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((long[]) buf[5])[0] = rslt.getLong(4);
               ((String[]) buf[6])[0] = rslt.getString(5, 20);
               ((String[]) buf[7])[0] = rslt.getString(6, 10);
               ((int[]) buf[8])[0] = rslt.getInt(7);
               ((byte[]) buf[9])[0] = rslt.getByte(8);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((byte[]) buf[11])[0] = rslt.getByte(9);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
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
                  stmt.setInt(sIdx, ((Number) parms[9]).intValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[10], 10);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[11], 20);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLong(sIdx, ((Number) parms[12]).longValue());
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLong(sIdx, ((Number) parms[13]).longValue());
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[14]).byteValue());
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[15]).byteValue());
               }
               return;
      }
   }

}

