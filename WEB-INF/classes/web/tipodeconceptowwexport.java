package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class tipodeconceptowwexport extends GXProcedure
{
   public tipodeconceptowwexport( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( tipodeconceptowwexport.class ), "" );
   }

   public tipodeconceptowwexport( int remoteHandle ,
                                  ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String[] aP0 )
   {
      tipodeconceptowwexport.this.aP1 = new String[] {""};
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
      tipodeconceptowwexport.this.aP0 = aP0;
      tipodeconceptowwexport.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWTipoDeConcepto", GXv_boolean2) ;
      tipodeconceptowwexport.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( ! AV8IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV62Pgmname))}, new String[] {"GxObject"}) );
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
      AV12Filename = "TipoDeConceptoWWExport-" + GXutil.trim( GXutil.str( AV16Random, 8, 0)) + ".xlsx" ;
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
      if ( ! ( ( AV36TFTipoConCod_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Tipo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         tipodeconceptowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV57i = 1 ;
         AV63GXV1 = 1 ;
         while ( AV63GXV1 <= AV36TFTipoConCod_Sels.size() )
         {
            AV37TFTipoConCod_Sel = (String)AV36TFTipoConCod_Sels.elementAt(-1+AV63GXV1) ;
            if ( AV57i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+httpContext.getMessage( web.gxdomainconceptotipo.getDescription(httpContext,(String)AV37TFTipoConCod_Sel), "") );
            AV57i = (long)(AV57i+1) ;
            AV63GXV1 = (int)(AV63GXV1+1) ;
         }
      }
      if ( ! ( ( AV40TFTipoConDescrip_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Descripción", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         tipodeconceptowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV57i = 1 ;
         AV64GXV2 = 1 ;
         while ( AV64GXV2 <= AV40TFTipoConDescrip_Sels.size() )
         {
            AV41TFTipoConDescrip_Sel = (String)AV40TFTipoConDescrip_Sels.elementAt(-1+AV64GXV2) ;
            if ( AV57i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV41TFTipoConDescrip_Sel, GXv_char7) ;
            tipodeconceptowwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char6 );
            AV57i = (long)(AV57i+1) ;
            AV64GXV2 = (int)(AV64GXV2+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV39TFTipoConDescrip)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Descripción", "")) ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            tipodeconceptowwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV39TFTipoConDescrip, GXv_char7) ;
            tipodeconceptowwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (0==AV42TFTRangoDesde) && (0==AV43TFTRangoDesde_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Rango de códigos de AFIP Desde", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         tipodeconceptowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV42TFTRangoDesde );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         tipodeconceptowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV43TFTRangoDesde_To );
      }
      if ( ! ( (0==AV44TFTRangoHasta) && (0==AV45TFTRangoHasta_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Rango de códigos de AFIP Hasta", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         tipodeconceptowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV44TFTRangoHasta );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         tipodeconceptowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV45TFTRangoHasta_To );
      }
      if ( ! ( (0==AV46TFTipoConOrden) && (0==AV47TFTipoConOrden_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Orden", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         tipodeconceptowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV46TFTipoConOrden );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         tipodeconceptowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV47TFTipoConOrden_To );
      }
      if ( ! ( ( AV50TFTipoConPalabra_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Palabra para parámetro de cálculo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         tipodeconceptowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV57i = 1 ;
         AV65GXV3 = 1 ;
         while ( AV65GXV3 <= AV50TFTipoConPalabra_Sels.size() )
         {
            AV51TFTipoConPalabra_Sel = (String)AV50TFTipoConPalabra_Sels.elementAt(-1+AV65GXV3) ;
            if ( AV57i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV51TFTipoConPalabra_Sel, GXv_char7) ;
            tipodeconceptowwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char6 );
            AV57i = (long)(AV57i+1) ;
            AV65GXV3 = (int)(AV65GXV3+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV49TFTipoConPalabra)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Palabra para parámetro de cálculo", "")) ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            tipodeconceptowwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV49TFTipoConPalabra, GXv_char7) ;
            tipodeconceptowwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( ( AV53TFTipoConTipo_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "genérico", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         tipodeconceptowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV57i = 1 ;
         AV66GXV4 = 1 ;
         while ( AV66GXV4 <= AV53TFTipoConTipo_Sels.size() )
         {
            AV54TFTipoConTipo_Sel = (String)AV53TFTipoConTipo_Sels.elementAt(-1+AV66GXV4) ;
            if ( AV57i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+httpContext.getMessage( web.gxdomainconceptotipogenerico.getDescription(httpContext,(String)AV54TFTipoConTipo_Sel), "") );
            AV57i = (long)(AV57i+1) ;
            AV66GXV4 = (int)(AV66GXV4+1) ;
         }
      }
      if ( ! ( (0==AV55TFTipoConPai) && (0==AV56TFTipoConPai_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "País", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         tipodeconceptowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV55TFTipoConPai );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         tipodeconceptowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV56TFTipoConPai_To );
      }
      AV14CellRow = (int)(AV14CellRow+2) ;
   }

   public void S141( )
   {
      /* 'WRITECOLUMNTITLES' Routine */
      returnInSub = false ;
      AV32VisibleColumnCount = 0 ;
      if ( GXutil.strcmp(AV20Session.getValue("TipoDeConceptoWWColumnsSelector"), "") != 0 )
      {
         AV27ColumnsSelectorXML = AV20Session.getValue("TipoDeConceptoWWColumnsSelector") ;
         AV24ColumnsSelector.fromxml(AV27ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S151 ();
         if (returnInSub) return;
      }
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+9)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().sort("Order");
      AV67GXV5 = 1 ;
      while ( AV67GXV5 <= AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
      {
         AV26ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV67GXV5));
         if ( AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( httpContext.getMessage( ((GXutil.strcmp("", AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname())==0) ? AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname() : AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname()), "") );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setBold( (short)(1) );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setColor( 11 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         AV67GXV5 = (int)(AV67GXV5+1) ;
      }
   }

   public void S161( )
   {
      /* 'WRITEDATA' Routine */
      returnInSub = false ;
      AV69Tipodeconceptowwds_1_tftipoconcod_sels = AV36TFTipoConCod_Sels ;
      AV70Tipodeconceptowwds_2_tftipocondescrip = AV39TFTipoConDescrip ;
      AV71Tipodeconceptowwds_3_tftipocondescrip_sels = AV40TFTipoConDescrip_Sels ;
      AV72Tipodeconceptowwds_4_tftrangodesde = AV42TFTRangoDesde ;
      AV73Tipodeconceptowwds_5_tftrangodesde_to = AV43TFTRangoDesde_To ;
      AV74Tipodeconceptowwds_6_tftrangohasta = AV44TFTRangoHasta ;
      AV75Tipodeconceptowwds_7_tftrangohasta_to = AV45TFTRangoHasta_To ;
      AV76Tipodeconceptowwds_8_tftipoconorden = AV46TFTipoConOrden ;
      AV77Tipodeconceptowwds_9_tftipoconorden_to = AV47TFTipoConOrden_To ;
      AV78Tipodeconceptowwds_10_tftipoconpalabra = AV49TFTipoConPalabra ;
      AV79Tipodeconceptowwds_11_tftipoconpalabra_sels = AV50TFTipoConPalabra_Sels ;
      AV80Tipodeconceptowwds_12_tftipocontipo_sels = AV53TFTipoConTipo_Sels ;
      AV81Tipodeconceptowwds_13_tftipoconpai = AV55TFTipoConPai ;
      AV82Tipodeconceptowwds_14_tftipoconpai_to = AV56TFTipoConPai_To ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A37TipoConCod ,
                                           AV69Tipodeconceptowwds_1_tftipoconcod_sels ,
                                           A370TipoConDescrip ,
                                           AV71Tipodeconceptowwds_3_tftipocondescrip_sels ,
                                           A2102TipoConPalabra ,
                                           AV79Tipodeconceptowwds_11_tftipoconpalabra_sels ,
                                           A2157TipoConTipo ,
                                           AV80Tipodeconceptowwds_12_tftipocontipo_sels ,
                                           Integer.valueOf(AV69Tipodeconceptowwds_1_tftipoconcod_sels.size()) ,
                                           Integer.valueOf(AV71Tipodeconceptowwds_3_tftipocondescrip_sels.size()) ,
                                           AV70Tipodeconceptowwds_2_tftipocondescrip ,
                                           Integer.valueOf(AV72Tipodeconceptowwds_4_tftrangodesde) ,
                                           Integer.valueOf(AV73Tipodeconceptowwds_5_tftrangodesde_to) ,
                                           Integer.valueOf(AV74Tipodeconceptowwds_6_tftrangohasta) ,
                                           Integer.valueOf(AV75Tipodeconceptowwds_7_tftrangohasta_to) ,
                                           Short.valueOf(AV76Tipodeconceptowwds_8_tftipoconorden) ,
                                           Short.valueOf(AV77Tipodeconceptowwds_9_tftipoconorden_to) ,
                                           Integer.valueOf(AV79Tipodeconceptowwds_11_tftipoconpalabra_sels.size()) ,
                                           AV78Tipodeconceptowwds_10_tftipoconpalabra ,
                                           Integer.valueOf(AV80Tipodeconceptowwds_12_tftipocontipo_sels.size()) ,
                                           Short.valueOf(AV81Tipodeconceptowwds_13_tftipoconpai) ,
                                           Short.valueOf(AV82Tipodeconceptowwds_14_tftipoconpai_to) ,
                                           Integer.valueOf(A377TRangoDesde) ,
                                           Integer.valueOf(A378TRangoHasta) ,
                                           Short.valueOf(A384TipoConOrden) ,
                                           Short.valueOf(A2120TipoConPai) ,
                                           Short.valueOf(AV18OrderedBy) ,
                                           Boolean.valueOf(AV19OrderedDsc) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.INT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.BOOLEAN
                                           }
      });
      lV70Tipodeconceptowwds_2_tftipocondescrip = GXutil.concat( GXutil.rtrim( AV70Tipodeconceptowwds_2_tftipocondescrip), "%", "") ;
      lV78Tipodeconceptowwds_10_tftipoconpalabra = GXutil.padr( GXutil.rtrim( AV78Tipodeconceptowwds_10_tftipoconpalabra), 20, "%") ;
      /* Using cursor P02G32 */
      pr_default.execute(0, new Object[] {lV70Tipodeconceptowwds_2_tftipocondescrip, Integer.valueOf(AV72Tipodeconceptowwds_4_tftrangodesde), Integer.valueOf(AV73Tipodeconceptowwds_5_tftrangodesde_to), Integer.valueOf(AV74Tipodeconceptowwds_6_tftrangohasta), Integer.valueOf(AV75Tipodeconceptowwds_7_tftrangohasta_to), Short.valueOf(AV76Tipodeconceptowwds_8_tftipoconorden), Short.valueOf(AV77Tipodeconceptowwds_9_tftipoconorden_to), lV78Tipodeconceptowwds_10_tftipoconpalabra, Short.valueOf(AV81Tipodeconceptowwds_13_tftipoconpai), Short.valueOf(AV82Tipodeconceptowwds_14_tftipoconpai_to)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A2120TipoConPai = P02G32_A2120TipoConPai[0] ;
         A2157TipoConTipo = P02G32_A2157TipoConTipo[0] ;
         A2102TipoConPalabra = P02G32_A2102TipoConPalabra[0] ;
         A384TipoConOrden = P02G32_A384TipoConOrden[0] ;
         A378TRangoHasta = P02G32_A378TRangoHasta[0] ;
         A377TRangoDesde = P02G32_A377TRangoDesde[0] ;
         A370TipoConDescrip = P02G32_A370TipoConDescrip[0] ;
         A37TipoConCod = P02G32_A37TipoConCod[0] ;
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
         AV83GXV6 = 1 ;
         while ( AV83GXV6 <= AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
         {
            AV26ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV83GXV6));
            if ( AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
            {
               if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "TipoConCod") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( httpContext.getMessage( web.gxdomainconceptotipo.getDescription(httpContext,(String)A37TipoConCod), "") );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "TipoConDescrip") == 0 )
               {
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A370TipoConDescrip, GXv_char7) ;
                  tipodeconceptowwexport.this.GXt_char6 = GXv_char7[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "TRangoDesde") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A377TRangoDesde );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "TRangoHasta") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A378TRangoHasta );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "TipoConOrden") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A384TipoConOrden );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "TipoConPalabra") == 0 )
               {
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A2102TipoConPalabra, GXv_char7) ;
                  tipodeconceptowwexport.this.GXt_char6 = GXv_char7[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "TipoConTipo") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( httpContext.getMessage( web.gxdomainconceptotipogenerico.getDescription(httpContext,(String)A2157TipoConTipo), "") );
               }
               else if ( GXutil.strcmp(AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "TipoConPai") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A2120TipoConPai );
               }
               AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
            }
            AV83GXV6 = (int)(AV83GXV6+1) ;
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
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "TipoConCod", "", "Tipo", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "TipoConDescrip", "", "Descripción", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "TRangoDesde", "", "Rango de códigos de AFIP Desde", false, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "TRangoHasta", "", "Rango de códigos de AFIP Hasta", false, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "TipoConOrden", "", "Orden", false, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "TipoConPalabra", "", "Palabra para parámetro de cálculo", false, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "TipoConTipo", "", "genérico", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "TipoConPai", "", "País", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "&VerSVG", "", "", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXt_char6 = AV28UserCustomValue ;
      GXv_char7[0] = GXt_char6 ;
      new web.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "TipoDeConceptoWWColumnsSelector", GXv_char7) ;
      tipodeconceptowwexport.this.GXt_char6 = GXv_char7[0] ;
      AV28UserCustomValue = GXt_char6 ;
      if ( ! ( (GXutil.strcmp("", AV28UserCustomValue)==0) ) )
      {
         AV25ColumnsSelectorAux.fromxml(AV28UserCustomValue, null, null);
         GXv_SdtWWPColumnsSelector8[0] = AV25ColumnsSelectorAux;
         GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnselector_updatecolumns(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, GXv_SdtWWPColumnsSelector9) ;
         AV25ColumnsSelectorAux = GXv_SdtWWPColumnsSelector8[0] ;
         AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      }
   }

   public void S201( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV20Session.getValue("TipoDeConceptoWWGridState"), "") == 0 )
      {
         AV22GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "TipoDeConceptoWWGridState"), null, null);
      }
      else
      {
         AV22GridState.fromxml(AV20Session.getValue("TipoDeConceptoWWGridState"), null, null);
      }
      AV18OrderedBy = AV22GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV19OrderedDsc = AV22GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV84GXV7 = 1 ;
      while ( AV84GXV7 <= AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV23GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV84GXV7));
         if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFTIPOCONCOD_SEL") == 0 )
         {
            AV35TFTipoConCod_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV36TFTipoConCod_Sels.fromJSonString(AV35TFTipoConCod_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFTIPOCONDESCRIP") == 0 )
         {
            AV39TFTipoConDescrip = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFTIPOCONDESCRIP_SEL") == 0 )
         {
            AV38TFTipoConDescrip_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV40TFTipoConDescrip_Sels.fromJSonString(AV38TFTipoConDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFTRANGODESDE") == 0 )
         {
            AV42TFTRangoDesde = (int)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV43TFTRangoDesde_To = (int)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFTRANGOHASTA") == 0 )
         {
            AV44TFTRangoHasta = (int)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV45TFTRangoHasta_To = (int)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFTIPOCONORDEN") == 0 )
         {
            AV46TFTipoConOrden = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV47TFTipoConOrden_To = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFTIPOCONPALABRA") == 0 )
         {
            AV49TFTipoConPalabra = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFTIPOCONPALABRA_SEL") == 0 )
         {
            AV48TFTipoConPalabra_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV50TFTipoConPalabra_Sels.fromJSonString(AV48TFTipoConPalabra_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFTIPOCONTIPO_SEL") == 0 )
         {
            AV52TFTipoConTipo_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV53TFTipoConTipo_Sels.fromJSonString(AV52TFTipoConTipo_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFTIPOCONPAI") == 0 )
         {
            AV55TFTipoConPai = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV56TFTipoConPai_To = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV17MenuOpcCod = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV84GXV7 = (int)(AV84GXV7+1) ;
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
      this.aP0[0] = tipodeconceptowwexport.this.AV12Filename;
      this.aP1[0] = tipodeconceptowwexport.this.AV13ErrorMessage;
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
      AV62Pgmname = "" ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV11ExcelDocument = new com.genexus.gxoffice.ExcelDoc();
      AV36TFTipoConCod_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV37TFTipoConCod_Sel = "" ;
      AV40TFTipoConDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV41TFTipoConDescrip_Sel = "" ;
      AV39TFTipoConDescrip = "" ;
      AV50TFTipoConPalabra_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV51TFTipoConPalabra_Sel = "" ;
      AV49TFTipoConPalabra = "" ;
      AV53TFTipoConTipo_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV54TFTipoConTipo_Sel = "" ;
      GXv_exceldoc4 = new com.genexus.gxoffice.ExcelDoc[1] ;
      GXv_int5 = new short[1] ;
      AV20Session = httpContext.getWebSession();
      AV27ColumnsSelectorXML = "" ;
      AV24ColumnsSelector = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV26ColumnsSelector_Column = new web.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      A37TipoConCod = "" ;
      A370TipoConDescrip = "" ;
      A2102TipoConPalabra = "" ;
      A2157TipoConTipo = "" ;
      AV69Tipodeconceptowwds_1_tftipoconcod_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV70Tipodeconceptowwds_2_tftipocondescrip = "" ;
      AV71Tipodeconceptowwds_3_tftipocondescrip_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV78Tipodeconceptowwds_10_tftipoconpalabra = "" ;
      AV79Tipodeconceptowwds_11_tftipoconpalabra_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV80Tipodeconceptowwds_12_tftipocontipo_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV70Tipodeconceptowwds_2_tftipocondescrip = "" ;
      lV78Tipodeconceptowwds_10_tftipoconpalabra = "" ;
      P02G32_A2120TipoConPai = new short[1] ;
      P02G32_A2157TipoConTipo = new String[] {""} ;
      P02G32_A2102TipoConPalabra = new String[] {""} ;
      P02G32_A384TipoConOrden = new short[1] ;
      P02G32_A378TRangoHasta = new int[1] ;
      P02G32_A377TRangoDesde = new int[1] ;
      P02G32_A370TipoConDescrip = new String[] {""} ;
      P02G32_A37TipoConCod = new String[] {""} ;
      AV28UserCustomValue = "" ;
      GXt_char6 = "" ;
      GXv_char7 = new String[1] ;
      AV25ColumnsSelectorAux = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector8 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector9 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      AV22GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV23GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV35TFTipoConCod_SelsJson = "" ;
      AV38TFTipoConDescrip_SelsJson = "" ;
      AV48TFTipoConPalabra_SelsJson = "" ;
      AV52TFTipoConTipo_SelsJson = "" ;
      AV17MenuOpcCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.tipodeconceptowwexport__default(),
         new Object[] {
             new Object[] {
            P02G32_A2120TipoConPai, P02G32_A2157TipoConTipo, P02G32_A2102TipoConPalabra, P02G32_A384TipoConOrden, P02G32_A378TRangoHasta, P02G32_A377TRangoDesde, P02G32_A370TipoConDescrip, P02G32_A37TipoConCod
            }
         }
      );
      AV62Pgmname = "TipoDeConceptoWWExport" ;
      /* GeneXus formulas. */
      AV62Pgmname = "TipoDeConceptoWWExport" ;
      Gx_err = (short)(0) ;
   }

   private short AV46TFTipoConOrden ;
   private short AV47TFTipoConOrden_To ;
   private short AV55TFTipoConPai ;
   private short AV56TFTipoConPai_To ;
   private short GXv_int5[] ;
   private short A384TipoConOrden ;
   private short A2120TipoConPai ;
   private short AV76Tipodeconceptowwds_8_tftipoconorden ;
   private short AV77Tipodeconceptowwds_9_tftipoconorden_to ;
   private short AV81Tipodeconceptowwds_13_tftipoconpai ;
   private short AV82Tipodeconceptowwds_14_tftipoconpai_to ;
   private short AV18OrderedBy ;
   private short Gx_err ;
   private int AV14CellRow ;
   private int AV15FirstColumn ;
   private int AV16Random ;
   private int AV63GXV1 ;
   private int AV64GXV2 ;
   private int AV42TFTRangoDesde ;
   private int AV43TFTRangoDesde_To ;
   private int AV44TFTRangoHasta ;
   private int AV45TFTRangoHasta_To ;
   private int AV65GXV3 ;
   private int AV66GXV4 ;
   private int AV67GXV5 ;
   private int A377TRangoDesde ;
   private int A378TRangoHasta ;
   private int AV72Tipodeconceptowwds_4_tftrangodesde ;
   private int AV73Tipodeconceptowwds_5_tftrangodesde_to ;
   private int AV74Tipodeconceptowwds_6_tftrangohasta ;
   private int AV75Tipodeconceptowwds_7_tftrangohasta_to ;
   private int AV69Tipodeconceptowwds_1_tftipoconcod_sels_size ;
   private int AV71Tipodeconceptowwds_3_tftipocondescrip_sels_size ;
   private int AV79Tipodeconceptowwds_11_tftipoconpalabra_sels_size ;
   private int AV80Tipodeconceptowwds_12_tftipocontipo_sels_size ;
   private int AV83GXV6 ;
   private int AV84GXV7 ;
   private long AV57i ;
   private long AV32VisibleColumnCount ;
   private String AV62Pgmname ;
   private String AV37TFTipoConCod_Sel ;
   private String AV51TFTipoConPalabra_Sel ;
   private String AV49TFTipoConPalabra ;
   private String AV54TFTipoConTipo_Sel ;
   private String A37TipoConCod ;
   private String A2102TipoConPalabra ;
   private String A2157TipoConTipo ;
   private String AV78Tipodeconceptowwds_10_tftipoconpalabra ;
   private String scmdbuf ;
   private String lV78Tipodeconceptowwds_10_tftipoconpalabra ;
   private String GXt_char6 ;
   private String GXv_char7[] ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean AV19OrderedDsc ;
   private String AV27ColumnsSelectorXML ;
   private String AV28UserCustomValue ;
   private String AV35TFTipoConCod_SelsJson ;
   private String AV38TFTipoConDescrip_SelsJson ;
   private String AV48TFTipoConPalabra_SelsJson ;
   private String AV52TFTipoConTipo_SelsJson ;
   private String AV12Filename ;
   private String AV13ErrorMessage ;
   private String AV41TFTipoConDescrip_Sel ;
   private String AV39TFTipoConDescrip ;
   private String A370TipoConDescrip ;
   private String AV70Tipodeconceptowwds_2_tftipocondescrip ;
   private String lV70Tipodeconceptowwds_2_tftipocondescrip ;
   private String AV17MenuOpcCod ;
   private com.genexus.webpanels.WebSession AV20Session ;
   private GXSimpleCollection<String> AV36TFTipoConCod_Sels ;
   private GXSimpleCollection<String> AV50TFTipoConPalabra_Sels ;
   private GXSimpleCollection<String> AV53TFTipoConTipo_Sels ;
   private GXSimpleCollection<String> AV40TFTipoConDescrip_Sels ;
   private String[] aP1 ;
   private String[] aP0 ;
   private IDataStoreProvider pr_default ;
   private short[] P02G32_A2120TipoConPai ;
   private String[] P02G32_A2157TipoConTipo ;
   private String[] P02G32_A2102TipoConPalabra ;
   private short[] P02G32_A384TipoConOrden ;
   private int[] P02G32_A378TRangoHasta ;
   private int[] P02G32_A377TRangoDesde ;
   private String[] P02G32_A370TipoConDescrip ;
   private String[] P02G32_A37TipoConCod ;
   private com.genexus.gxoffice.ExcelDoc AV11ExcelDocument ;
   private com.genexus.gxoffice.ExcelDoc GXv_exceldoc4[] ;
   private GXSimpleCollection<String> AV69Tipodeconceptowwds_1_tftipoconcod_sels ;
   private GXSimpleCollection<String> AV79Tipodeconceptowwds_11_tftipoconpalabra_sels ;
   private GXSimpleCollection<String> AV80Tipodeconceptowwds_12_tftipocontipo_sels ;
   private GXSimpleCollection<String> AV71Tipodeconceptowwds_3_tftipocondescrip_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV22GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV23GridStateFilterValue ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV24ColumnsSelector ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV25ColumnsSelectorAux ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector8[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector9[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector_Column AV26ColumnsSelector_Column ;
}

final  class tipodeconceptowwexport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P02G32( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A37TipoConCod ,
                                          GXSimpleCollection<String> AV69Tipodeconceptowwds_1_tftipoconcod_sels ,
                                          String A370TipoConDescrip ,
                                          GXSimpleCollection<String> AV71Tipodeconceptowwds_3_tftipocondescrip_sels ,
                                          String A2102TipoConPalabra ,
                                          GXSimpleCollection<String> AV79Tipodeconceptowwds_11_tftipoconpalabra_sels ,
                                          String A2157TipoConTipo ,
                                          GXSimpleCollection<String> AV80Tipodeconceptowwds_12_tftipocontipo_sels ,
                                          int AV69Tipodeconceptowwds_1_tftipoconcod_sels_size ,
                                          int AV71Tipodeconceptowwds_3_tftipocondescrip_sels_size ,
                                          String AV70Tipodeconceptowwds_2_tftipocondescrip ,
                                          int AV72Tipodeconceptowwds_4_tftrangodesde ,
                                          int AV73Tipodeconceptowwds_5_tftrangodesde_to ,
                                          int AV74Tipodeconceptowwds_6_tftrangohasta ,
                                          int AV75Tipodeconceptowwds_7_tftrangohasta_to ,
                                          short AV76Tipodeconceptowwds_8_tftipoconorden ,
                                          short AV77Tipodeconceptowwds_9_tftipoconorden_to ,
                                          int AV79Tipodeconceptowwds_11_tftipoconpalabra_sels_size ,
                                          String AV78Tipodeconceptowwds_10_tftipoconpalabra ,
                                          int AV80Tipodeconceptowwds_12_tftipocontipo_sels_size ,
                                          short AV81Tipodeconceptowwds_13_tftipoconpai ,
                                          short AV82Tipodeconceptowwds_14_tftipoconpai_to ,
                                          int A377TRangoDesde ,
                                          int A378TRangoHasta ,
                                          short A384TipoConOrden ,
                                          short A2120TipoConPai ,
                                          short AV18OrderedBy ,
                                          boolean AV19OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int10 = new byte[10];
      Object[] GXv_Object11 = new Object[2];
      scmdbuf = "SELECT TipoConPai, TipoConTipo, TipoConPalabra, TipoConOrden, TRangoHasta, TRangoDesde, TipoConDescrip, TipoConCod FROM TipoDeConcepto" ;
      if ( AV69Tipodeconceptowwds_1_tftipoconcod_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV69Tipodeconceptowwds_1_tftipoconcod_sels, "TipoConCod IN (", ")")+")");
      }
      if ( ( AV71Tipodeconceptowwds_3_tftipocondescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV70Tipodeconceptowwds_2_tftipocondescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(TipoConDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int10[0] = (byte)(1) ;
      }
      if ( AV71Tipodeconceptowwds_3_tftipocondescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV71Tipodeconceptowwds_3_tftipocondescrip_sels, "TipoConDescrip IN (", ")")+")");
      }
      if ( ! (0==AV72Tipodeconceptowwds_4_tftrangodesde) )
      {
         addWhere(sWhereString, "(TRangoDesde >= ?)");
      }
      else
      {
         GXv_int10[1] = (byte)(1) ;
      }
      if ( ! (0==AV73Tipodeconceptowwds_5_tftrangodesde_to) )
      {
         addWhere(sWhereString, "(TRangoDesde <= ?)");
      }
      else
      {
         GXv_int10[2] = (byte)(1) ;
      }
      if ( ! (0==AV74Tipodeconceptowwds_6_tftrangohasta) )
      {
         addWhere(sWhereString, "(TRangoHasta >= ?)");
      }
      else
      {
         GXv_int10[3] = (byte)(1) ;
      }
      if ( ! (0==AV75Tipodeconceptowwds_7_tftrangohasta_to) )
      {
         addWhere(sWhereString, "(TRangoHasta <= ?)");
      }
      else
      {
         GXv_int10[4] = (byte)(1) ;
      }
      if ( ! (0==AV76Tipodeconceptowwds_8_tftipoconorden) )
      {
         addWhere(sWhereString, "(TipoConOrden >= ?)");
      }
      else
      {
         GXv_int10[5] = (byte)(1) ;
      }
      if ( ! (0==AV77Tipodeconceptowwds_9_tftipoconorden_to) )
      {
         addWhere(sWhereString, "(TipoConOrden <= ?)");
      }
      else
      {
         GXv_int10[6] = (byte)(1) ;
      }
      if ( ( AV79Tipodeconceptowwds_11_tftipoconpalabra_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV78Tipodeconceptowwds_10_tftipoconpalabra)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(TipoConPalabra) like LOWER(?))");
      }
      else
      {
         GXv_int10[7] = (byte)(1) ;
      }
      if ( AV79Tipodeconceptowwds_11_tftipoconpalabra_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV79Tipodeconceptowwds_11_tftipoconpalabra_sels, "TipoConPalabra IN (", ")")+")");
      }
      if ( AV80Tipodeconceptowwds_12_tftipocontipo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV80Tipodeconceptowwds_12_tftipocontipo_sels, "TipoConTipo IN (", ")")+")");
      }
      if ( ! (0==AV81Tipodeconceptowwds_13_tftipoconpai) )
      {
         addWhere(sWhereString, "(TipoConPai >= ?)");
      }
      else
      {
         GXv_int10[8] = (byte)(1) ;
      }
      if ( ! (0==AV82Tipodeconceptowwds_14_tftipoconpai_to) )
      {
         addWhere(sWhereString, "(TipoConPai <= ?)");
      }
      else
      {
         GXv_int10[9] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      if ( ( AV18OrderedBy == 1 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY TipoConCod" ;
      }
      else if ( ( AV18OrderedBy == 1 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY TipoConCod DESC" ;
      }
      else if ( ( AV18OrderedBy == 2 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY TipoConDescrip" ;
      }
      else if ( ( AV18OrderedBy == 2 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY TipoConDescrip DESC" ;
      }
      else if ( ( AV18OrderedBy == 3 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY TRangoDesde" ;
      }
      else if ( ( AV18OrderedBy == 3 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY TRangoDesde DESC" ;
      }
      else if ( ( AV18OrderedBy == 4 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY TRangoHasta" ;
      }
      else if ( ( AV18OrderedBy == 4 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY TRangoHasta DESC" ;
      }
      else if ( ( AV18OrderedBy == 5 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY TipoConOrden" ;
      }
      else if ( ( AV18OrderedBy == 5 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY TipoConOrden DESC" ;
      }
      else if ( ( AV18OrderedBy == 6 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY TipoConPalabra" ;
      }
      else if ( ( AV18OrderedBy == 6 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY TipoConPalabra DESC" ;
      }
      else if ( ( AV18OrderedBy == 7 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY TipoConTipo" ;
      }
      else if ( ( AV18OrderedBy == 7 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY TipoConTipo DESC" ;
      }
      else if ( ( AV18OrderedBy == 8 ) && ! AV19OrderedDsc )
      {
         scmdbuf += " ORDER BY TipoConPai" ;
      }
      else if ( ( AV18OrderedBy == 8 ) && ( AV19OrderedDsc ) )
      {
         scmdbuf += " ORDER BY TipoConPai DESC" ;
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
                  return conditional_P02G32(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , ((Number) dynConstraints[9]).intValue() , (String)dynConstraints[10] , ((Number) dynConstraints[11]).intValue() , ((Number) dynConstraints[12]).intValue() , ((Number) dynConstraints[13]).intValue() , ((Number) dynConstraints[14]).intValue() , ((Number) dynConstraints[15]).shortValue() , ((Number) dynConstraints[16]).shortValue() , ((Number) dynConstraints[17]).intValue() , (String)dynConstraints[18] , ((Number) dynConstraints[19]).intValue() , ((Number) dynConstraints[20]).shortValue() , ((Number) dynConstraints[21]).shortValue() , ((Number) dynConstraints[22]).intValue() , ((Number) dynConstraints[23]).intValue() , ((Number) dynConstraints[24]).shortValue() , ((Number) dynConstraints[25]).shortValue() , ((Number) dynConstraints[26]).shortValue() , ((Boolean) dynConstraints[27]).booleanValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02G32", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((String[]) buf[7])[0] = rslt.getString(8, 20);
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
                  stmt.setVarchar(sIdx, (String)parms[10], 400);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[11]).intValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[12]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[13]).intValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[14]).intValue());
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[15]).shortValue());
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[16]).shortValue());
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[17], 20);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[18]).shortValue());
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[19]).shortValue());
               }
               return;
      }
   }

}

