package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class lsd_reg1wwexport extends GXProcedure
{
   public lsd_reg1wwexport( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( lsd_reg1wwexport.class ), "" );
   }

   public lsd_reg1wwexport( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String[] aP0 )
   {
      lsd_reg1wwexport.this.aP1 = new String[] {""};
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
      lsd_reg1wwexport.this.aP0 = aP0;
      lsd_reg1wwexport.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWLSD_reg1", GXv_boolean2) ;
      lsd_reg1wwexport.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( ! AV8IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV61Pgmname))}, new String[] {"GxObject"}) );
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
      AV12Filename = "LSD_reg1WWExport-" + GXutil.trim( GXutil.str( AV16Random, 8, 0)) + ".xlsx" ;
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
      if ( ! ( (0==AV40TFLSD1CuitEmpl_3_11) && (0==AV41TFLSD1CuitEmpl_3_11_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "CUIT", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         lsd_reg1wwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV40TFLSD1CuitEmpl_3_11 );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         lsd_reg1wwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV41TFLSD1CuitEmpl_3_11_To );
      }
      if ( ! ( ( AV44TFLSD1IdentificacionEnvio_14_2_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Identif. envío", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         lsd_reg1wwexport.this.AV14CellRow = GXv_int5[0] ;
         AV58i = 1 ;
         AV62GXV1 = 1 ;
         while ( AV62GXV1 <= AV44TFLSD1IdentificacionEnvio_14_2_Sels.size() )
         {
            AV45TFLSD1IdentificacionEnvio_14_2_Sel = (String)AV44TFLSD1IdentificacionEnvio_14_2_Sels.elementAt(-1+AV62GXV1) ;
            if ( AV58i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV45TFLSD1IdentificacionEnvio_14_2_Sel, GXv_char7) ;
            lsd_reg1wwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char6 );
            AV58i = (long)(AV58i+1) ;
            AV62GXV1 = (int)(AV62GXV1+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV43TFLSD1IdentificacionEnvio_14_2)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Identif. envío", "")) ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            lsd_reg1wwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV43TFLSD1IdentificacionEnvio_14_2, GXv_char7) ;
            lsd_reg1wwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (0==AV46TFLSD1periodoLiquidacion_16_6) && (0==AV47TFLSD1periodoLiquidacion_16_6_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Período", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         lsd_reg1wwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV46TFLSD1periodoLiquidacion_16_6 );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         lsd_reg1wwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV47TFLSD1periodoLiquidacion_16_6_To );
      }
      if ( ! ( ( AV50TFLSD1tipoLiquidacion_22_1_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Tipo de liquidación", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         lsd_reg1wwexport.this.AV14CellRow = GXv_int5[0] ;
         AV58i = 1 ;
         AV63GXV2 = 1 ;
         while ( AV63GXV2 <= AV50TFLSD1tipoLiquidacion_22_1_Sels.size() )
         {
            AV51TFLSD1tipoLiquidacion_22_1_Sel = (String)AV50TFLSD1tipoLiquidacion_22_1_Sels.elementAt(-1+AV63GXV2) ;
            if ( AV58i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV51TFLSD1tipoLiquidacion_22_1_Sel, GXv_char7) ;
            lsd_reg1wwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char6 );
            AV58i = (long)(AV58i+1) ;
            AV63GXV2 = (int)(AV63GXV2+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV49TFLSD1tipoLiquidacion_22_1)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Tipo de liquidación", "")) ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            lsd_reg1wwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV49TFLSD1tipoLiquidacion_22_1, GXv_char7) ;
            lsd_reg1wwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (0==AV52TFLSD1numeroLiquidacion_23_5) && (0==AV53TFLSD1numeroLiquidacion_23_5_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Nro. Liq.", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         lsd_reg1wwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV52TFLSD1numeroLiquidacion_23_5 );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         lsd_reg1wwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV53TFLSD1numeroLiquidacion_23_5_To );
      }
      if ( ! ( (0==AV54TFLSD1diasBase_28_2) && (0==AV55TFLSD1diasBase_28_2_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Días base", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         lsd_reg1wwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV54TFLSD1diasBase_28_2 );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         lsd_reg1wwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV55TFLSD1diasBase_28_2_To );
      }
      if ( ! ( (0==AV56TFLSD1cantidadRegistrosTipo04_30_6) && (0==AV57TFLSD1cantidadRegistrosTipo04_30_6_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Cantidad de registros tipo 04", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         lsd_reg1wwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV56TFLSD1cantidadRegistrosTipo04_30_6 );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         lsd_reg1wwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV57TFLSD1cantidadRegistrosTipo04_30_6_To );
      }
      AV14CellRow = (int)(AV14CellRow+2) ;
   }

   public void S141( )
   {
      /* 'WRITECOLUMNTITLES' Routine */
      returnInSub = false ;
      AV37VisibleColumnCount = 0 ;
      if ( GXutil.strcmp(AV24Session.getValue("LSD_reg1WWColumnsSelector"), "") != 0 )
      {
         AV32ColumnsSelectorXML = AV24Session.getValue("LSD_reg1WWColumnsSelector") ;
         AV29ColumnsSelector.fromxml(AV32ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S151 ();
         if (returnInSub) return;
      }
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV29ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+9)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV29ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+10)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      AV29ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().sort("Order");
      AV64GXV3 = 1 ;
      while ( AV64GXV3 <= AV29ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
      {
         AV31ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV29ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV64GXV3));
         if ( AV31ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV37VisibleColumnCount), 1, 1).setText( httpContext.getMessage( ((GXutil.strcmp("", AV31ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname())==0) ? AV31ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname() : AV31ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname()), "") );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV37VisibleColumnCount), 1, 1).setBold( (short)(1) );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV37VisibleColumnCount), 1, 1).setColor( 11 );
            AV37VisibleColumnCount = (long)(AV37VisibleColumnCount+1) ;
         }
         AV64GXV3 = (int)(AV64GXV3+1) ;
      }
   }

   public void S161( )
   {
      /* 'WRITEDATA' Routine */
      returnInSub = false ;
      AV66Lsd_reg1wwds_1_clicod = AV18CliCod ;
      AV67Lsd_reg1wwds_2_empcod = AV19EmpCod ;
      AV68Lsd_reg1wwds_3_tflsd1cuitempl_3_11 = AV40TFLSD1CuitEmpl_3_11 ;
      AV69Lsd_reg1wwds_4_tflsd1cuitempl_3_11_to = AV41TFLSD1CuitEmpl_3_11_To ;
      AV70Lsd_reg1wwds_5_tflsd1identificacionenvio_14_2 = AV43TFLSD1IdentificacionEnvio_14_2 ;
      AV71Lsd_reg1wwds_6_tflsd1identificacionenvio_14_2_sels = AV44TFLSD1IdentificacionEnvio_14_2_Sels ;
      AV72Lsd_reg1wwds_7_tflsd1periodoliquidacion_16_6 = AV46TFLSD1periodoLiquidacion_16_6 ;
      AV73Lsd_reg1wwds_8_tflsd1periodoliquidacion_16_6_to = AV47TFLSD1periodoLiquidacion_16_6_To ;
      AV74Lsd_reg1wwds_9_tflsd1tipoliquidacion_22_1 = AV49TFLSD1tipoLiquidacion_22_1 ;
      AV75Lsd_reg1wwds_10_tflsd1tipoliquidacion_22_1_sels = AV50TFLSD1tipoLiquidacion_22_1_Sels ;
      AV76Lsd_reg1wwds_11_tflsd1numeroliquidacion_23_5 = AV52TFLSD1numeroLiquidacion_23_5 ;
      AV77Lsd_reg1wwds_12_tflsd1numeroliquidacion_23_5_to = AV53TFLSD1numeroLiquidacion_23_5_To ;
      AV78Lsd_reg1wwds_13_tflsd1diasbase_28_2 = AV54TFLSD1diasBase_28_2 ;
      AV79Lsd_reg1wwds_14_tflsd1diasbase_28_2_to = AV55TFLSD1diasBase_28_2_To ;
      AV80Lsd_reg1wwds_15_tflsd1cantidadregistrostipo04_30_6 = AV56TFLSD1cantidadRegistrosTipo04_30_6 ;
      AV81Lsd_reg1wwds_16_tflsd1cantidadregistrostipo04_30_6_to = AV57TFLSD1cantidadRegistrosTipo04_30_6_To ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A1651LSD1IdentificacionEnvio_14_2 ,
                                           AV71Lsd_reg1wwds_6_tflsd1identificacionenvio_14_2_sels ,
                                           A1653LSD1tipoLiquidacion_22_1 ,
                                           AV75Lsd_reg1wwds_10_tflsd1tipoliquidacion_22_1_sels ,
                                           Long.valueOf(AV68Lsd_reg1wwds_3_tflsd1cuitempl_3_11) ,
                                           Long.valueOf(AV69Lsd_reg1wwds_4_tflsd1cuitempl_3_11_to) ,
                                           Integer.valueOf(AV71Lsd_reg1wwds_6_tflsd1identificacionenvio_14_2_sels.size()) ,
                                           AV70Lsd_reg1wwds_5_tflsd1identificacionenvio_14_2 ,
                                           Integer.valueOf(AV72Lsd_reg1wwds_7_tflsd1periodoliquidacion_16_6) ,
                                           Integer.valueOf(AV73Lsd_reg1wwds_8_tflsd1periodoliquidacion_16_6_to) ,
                                           Integer.valueOf(AV75Lsd_reg1wwds_10_tflsd1tipoliquidacion_22_1_sels.size()) ,
                                           AV74Lsd_reg1wwds_9_tflsd1tipoliquidacion_22_1 ,
                                           Integer.valueOf(AV76Lsd_reg1wwds_11_tflsd1numeroliquidacion_23_5) ,
                                           Integer.valueOf(AV77Lsd_reg1wwds_12_tflsd1numeroliquidacion_23_5_to) ,
                                           Byte.valueOf(AV78Lsd_reg1wwds_13_tflsd1diasbase_28_2) ,
                                           Byte.valueOf(AV79Lsd_reg1wwds_14_tflsd1diasbase_28_2_to) ,
                                           Integer.valueOf(AV80Lsd_reg1wwds_15_tflsd1cantidadregistrostipo04_30_6) ,
                                           Integer.valueOf(AV81Lsd_reg1wwds_16_tflsd1cantidadregistrostipo04_30_6_to) ,
                                           Integer.valueOf(AV21parmNroLiq) ,
                                           AV20parmPeriodo ,
                                           Long.valueOf(A1650LSD1CuitEmpl_3_11) ,
                                           Integer.valueOf(A1652LSD1periodoLiquidacion_16_6) ,
                                           Integer.valueOf(A1654LSD1numeroLiquidacion_23_5) ,
                                           Byte.valueOf(A1655LSD1diasBase_28_2) ,
                                           Integer.valueOf(A1656LSD1cantidadRegistrosTipo04_30) ,
                                           Integer.valueOf(A1733LSD1LiqNro) ,
                                           A1734LSD1LiqPeriodo ,
                                           Short.valueOf(AV22OrderedBy) ,
                                           Boolean.valueOf(AV23OrderedDsc) ,
                                           Integer.valueOf(AV66Lsd_reg1wwds_1_clicod) ,
                                           Short.valueOf(AV67Lsd_reg1wwds_2_empcod) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.LONG, TypeConstants.LONG, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.DATE, TypeConstants.LONG, TypeConstants.INT,
                                           TypeConstants.INT, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.INT, TypeConstants.DATE, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT,
                                           TypeConstants.SHORT
                                           }
      });
      lV70Lsd_reg1wwds_5_tflsd1identificacionenvio_14_2 = GXutil.padr( GXutil.rtrim( AV70Lsd_reg1wwds_5_tflsd1identificacionenvio_14_2), 2, "%") ;
      lV74Lsd_reg1wwds_9_tflsd1tipoliquidacion_22_1 = GXutil.padr( GXutil.rtrim( AV74Lsd_reg1wwds_9_tflsd1tipoliquidacion_22_1), 1, "%") ;
      /* Using cursor P02FN2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV66Lsd_reg1wwds_1_clicod), Short.valueOf(AV67Lsd_reg1wwds_2_empcod), Long.valueOf(AV68Lsd_reg1wwds_3_tflsd1cuitempl_3_11), Long.valueOf(AV69Lsd_reg1wwds_4_tflsd1cuitempl_3_11_to), lV70Lsd_reg1wwds_5_tflsd1identificacionenvio_14_2, Integer.valueOf(AV72Lsd_reg1wwds_7_tflsd1periodoliquidacion_16_6), Integer.valueOf(AV73Lsd_reg1wwds_8_tflsd1periodoliquidacion_16_6_to), lV74Lsd_reg1wwds_9_tflsd1tipoliquidacion_22_1, Integer.valueOf(AV76Lsd_reg1wwds_11_tflsd1numeroliquidacion_23_5), Integer.valueOf(AV77Lsd_reg1wwds_12_tflsd1numeroliquidacion_23_5_to), Byte.valueOf(AV78Lsd_reg1wwds_13_tflsd1diasbase_28_2), Byte.valueOf(AV79Lsd_reg1wwds_14_tflsd1diasbase_28_2_to), Integer.valueOf(AV80Lsd_reg1wwds_15_tflsd1cantidadregistrostipo04_30_6), Integer.valueOf(AV81Lsd_reg1wwds_16_tflsd1cantidadregistrostipo04_30_6_to), Integer.valueOf(AV21parmNroLiq), AV20parmPeriodo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1734LSD1LiqPeriodo = P02FN2_A1734LSD1LiqPeriodo[0] ;
         A1733LSD1LiqNro = P02FN2_A1733LSD1LiqNro[0] ;
         A1656LSD1cantidadRegistrosTipo04_30 = P02FN2_A1656LSD1cantidadRegistrosTipo04_30[0] ;
         A1655LSD1diasBase_28_2 = P02FN2_A1655LSD1diasBase_28_2[0] ;
         A1654LSD1numeroLiquidacion_23_5 = P02FN2_A1654LSD1numeroLiquidacion_23_5[0] ;
         A1653LSD1tipoLiquidacion_22_1 = P02FN2_A1653LSD1tipoLiquidacion_22_1[0] ;
         A1652LSD1periodoLiquidacion_16_6 = P02FN2_A1652LSD1periodoLiquidacion_16_6[0] ;
         A1651LSD1IdentificacionEnvio_14_2 = P02FN2_A1651LSD1IdentificacionEnvio_14_2[0] ;
         A1650LSD1CuitEmpl_3_11 = P02FN2_A1650LSD1CuitEmpl_3_11[0] ;
         A1EmpCod = P02FN2_A1EmpCod[0] ;
         A3CliCod = P02FN2_A3CliCod[0] ;
         A1649LSDSec = P02FN2_A1649LSDSec[0] ;
         AV14CellRow = (int)(AV14CellRow+1) ;
         /* Execute user subroutine: 'BEFOREWRITELINE' */
         S172 ();
         if ( returnInSub )
         {
            pr_default.close(0);
            returnInSub = true;
            if (true) return;
         }
         AV37VisibleColumnCount = 0 ;
         AV82GXV4 = 1 ;
         while ( AV82GXV4 <= AV29ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
         {
            AV31ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV29ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV82GXV4));
            if ( AV31ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
            {
               if ( GXutil.strcmp(AV31ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "&RegTipo") == 0 )
               {
                  AV28RegTipo = "01" ;
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV28RegTipo, GXv_char7) ;
                  lsd_reg1wwexport.this.GXt_char6 = GXv_char7[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV37VisibleColumnCount), 1, 1).setText( GXt_char6 );
               }
               else if ( GXutil.strcmp(AV31ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LSD1CuitEmpl_3_11") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV37VisibleColumnCount), 1, 1).setNumber( A1650LSD1CuitEmpl_3_11 );
               }
               else if ( GXutil.strcmp(AV31ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LSD1IdentificacionEnvio_14_2") == 0 )
               {
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A1651LSD1IdentificacionEnvio_14_2, GXv_char7) ;
                  lsd_reg1wwexport.this.GXt_char6 = GXv_char7[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV37VisibleColumnCount), 1, 1).setText( GXt_char6 );
               }
               else if ( GXutil.strcmp(AV31ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LSD1periodoLiquidacion_16_6") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV37VisibleColumnCount), 1, 1).setNumber( A1652LSD1periodoLiquidacion_16_6 );
               }
               else if ( GXutil.strcmp(AV31ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LSD1tipoLiquidacion_22_1") == 0 )
               {
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A1653LSD1tipoLiquidacion_22_1, GXv_char7) ;
                  lsd_reg1wwexport.this.GXt_char6 = GXv_char7[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV37VisibleColumnCount), 1, 1).setText( GXt_char6 );
               }
               else if ( GXutil.strcmp(AV31ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LSD1numeroLiquidacion_23_5") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV37VisibleColumnCount), 1, 1).setNumber( A1654LSD1numeroLiquidacion_23_5 );
               }
               else if ( GXutil.strcmp(AV31ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LSD1diasBase_28_2") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV37VisibleColumnCount), 1, 1).setNumber( A1655LSD1diasBase_28_2 );
               }
               else if ( GXutil.strcmp(AV31ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LSD1cantidadRegistrosTipo04_30_6") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV37VisibleColumnCount), 1, 1).setNumber( A1656LSD1cantidadRegistrosTipo04_30 );
               }
               AV37VisibleColumnCount = (long)(AV37VisibleColumnCount+1) ;
            }
            AV82GXV4 = (int)(AV82GXV4+1) ;
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
      AV29ColumnsSelector = (web.wwpbaseobjects.SdtWWPColumnsSelector)new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector8[0] = AV29ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "&RegTipo", "", "Identificador", true, "") ;
      AV29ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV29ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "LSD1CuitEmpl_3_11", "", "CUIT", true, "") ;
      AV29ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV29ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "LSD1IdentificacionEnvio_14_2", "", "Identif. envío", true, "") ;
      AV29ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV29ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "LSD1periodoLiquidacion_16_6", "", "Período", true, "") ;
      AV29ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV29ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "LSD1tipoLiquidacion_22_1", "", "Tipo de liquidación", true, "") ;
      AV29ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV29ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "LSD1numeroLiquidacion_23_5", "", "Nro. Liq.", true, "") ;
      AV29ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV29ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "LSD1diasBase_28_2", "", "Días base", true, "") ;
      AV29ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV29ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "LSD1cantidadRegistrosTipo04_30_6", "", "Cantidad de registros tipo 04", true, "") ;
      AV29ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV29ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "&VerSVG", "", "", true, "") ;
      AV29ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV29ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "&ModificarSVG", "", "", true, "") ;
      AV29ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXt_char6 = AV33UserCustomValue ;
      GXv_char7[0] = GXt_char6 ;
      new web.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "LSD_reg1WWColumnsSelector", GXv_char7) ;
      lsd_reg1wwexport.this.GXt_char6 = GXv_char7[0] ;
      AV33UserCustomValue = GXt_char6 ;
      if ( ! ( (GXutil.strcmp("", AV33UserCustomValue)==0) ) )
      {
         AV30ColumnsSelectorAux.fromxml(AV33UserCustomValue, null, null);
         GXv_SdtWWPColumnsSelector8[0] = AV30ColumnsSelectorAux;
         GXv_SdtWWPColumnsSelector9[0] = AV29ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnselector_updatecolumns(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, GXv_SdtWWPColumnsSelector9) ;
         AV30ColumnsSelectorAux = GXv_SdtWWPColumnsSelector8[0] ;
         AV29ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      }
   }

   public void S201( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV24Session.getValue("LSD_reg1WWGridState"), "") == 0 )
      {
         AV26GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "LSD_reg1WWGridState"), null, null);
      }
      else
      {
         AV26GridState.fromxml(AV24Session.getValue("LSD_reg1WWGridState"), null, null);
      }
      AV22OrderedBy = AV26GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV23OrderedDsc = AV26GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV83GXV5 = 1 ;
      while ( AV83GXV5 <= AV26GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV27GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV26GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV83GXV5));
         if ( GXutil.strcmp(AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLSD1CUITEMPL_3_11") == 0 )
         {
            AV40TFLSD1CuitEmpl_3_11 = GXutil.lval( AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value()) ;
            AV41TFLSD1CuitEmpl_3_11_To = GXutil.lval( AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto()) ;
         }
         else if ( GXutil.strcmp(AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLSD1IDENTIFICACIONENVIO_14_2") == 0 )
         {
            AV43TFLSD1IdentificacionEnvio_14_2 = AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLSD1IDENTIFICACIONENVIO_14_2_SEL") == 0 )
         {
            AV42TFLSD1IdentificacionEnvio_14_2_SelsJson = AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV44TFLSD1IdentificacionEnvio_14_2_Sels.fromJSonString(AV42TFLSD1IdentificacionEnvio_14_2_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLSD1PERIODOLIQUIDACION_16_6") == 0 )
         {
            AV46TFLSD1periodoLiquidacion_16_6 = (int)(GXutil.lval( AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV47TFLSD1periodoLiquidacion_16_6_To = (int)(GXutil.lval( AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLSD1TIPOLIQUIDACION_22_1") == 0 )
         {
            AV49TFLSD1tipoLiquidacion_22_1 = AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLSD1TIPOLIQUIDACION_22_1_SEL") == 0 )
         {
            AV48TFLSD1tipoLiquidacion_22_1_SelsJson = AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV50TFLSD1tipoLiquidacion_22_1_Sels.fromJSonString(AV48TFLSD1tipoLiquidacion_22_1_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLSD1NUMEROLIQUIDACION_23_5") == 0 )
         {
            AV52TFLSD1numeroLiquidacion_23_5 = (int)(GXutil.lval( AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV53TFLSD1numeroLiquidacion_23_5_To = (int)(GXutil.lval( AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLSD1DIASBASE_28_2") == 0 )
         {
            AV54TFLSD1diasBase_28_2 = (byte)(GXutil.lval( AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV55TFLSD1diasBase_28_2_To = (byte)(GXutil.lval( AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLSD1CANTIDADREGISTROSTIPO04_30_6") == 0 )
         {
            AV56TFLSD1cantidadRegistrosTipo04_30_6 = (int)(GXutil.lval( AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV57TFLSD1cantidadRegistrosTipo04_30_6_To = (int)(GXutil.lval( AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV17MenuOpcCod = AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&CLICOD") == 0 )
         {
            AV18CliCod = (int)(GXutil.lval( AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&EMPCOD") == 0 )
         {
            AV19EmpCod = (short)(GXutil.lval( AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&PARMPERIODO") == 0 )
         {
            AV20parmPeriodo = localUtil.ctod( AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
         }
         else if ( GXutil.strcmp(AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&PARMNROLIQ") == 0 )
         {
            AV21parmNroLiq = (int)(GXutil.lval( AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         AV83GXV5 = (int)(AV83GXV5+1) ;
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
      this.aP0[0] = lsd_reg1wwexport.this.AV12Filename;
      this.aP1[0] = lsd_reg1wwexport.this.AV13ErrorMessage;
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
      AV61Pgmname = "" ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV11ExcelDocument = new com.genexus.gxoffice.ExcelDoc();
      AV44TFLSD1IdentificacionEnvio_14_2_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV45TFLSD1IdentificacionEnvio_14_2_Sel = "" ;
      AV43TFLSD1IdentificacionEnvio_14_2 = "" ;
      AV50TFLSD1tipoLiquidacion_22_1_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV51TFLSD1tipoLiquidacion_22_1_Sel = "" ;
      AV49TFLSD1tipoLiquidacion_22_1 = "" ;
      GXv_exceldoc4 = new com.genexus.gxoffice.ExcelDoc[1] ;
      GXv_int5 = new short[1] ;
      AV24Session = httpContext.getWebSession();
      AV32ColumnsSelectorXML = "" ;
      AV29ColumnsSelector = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV31ColumnsSelector_Column = new web.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      A1651LSD1IdentificacionEnvio_14_2 = "" ;
      A1653LSD1tipoLiquidacion_22_1 = "" ;
      AV70Lsd_reg1wwds_5_tflsd1identificacionenvio_14_2 = "" ;
      AV71Lsd_reg1wwds_6_tflsd1identificacionenvio_14_2_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV74Lsd_reg1wwds_9_tflsd1tipoliquidacion_22_1 = "" ;
      AV75Lsd_reg1wwds_10_tflsd1tipoliquidacion_22_1_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV70Lsd_reg1wwds_5_tflsd1identificacionenvio_14_2 = "" ;
      lV74Lsd_reg1wwds_9_tflsd1tipoliquidacion_22_1 = "" ;
      AV20parmPeriodo = GXutil.nullDate() ;
      A1734LSD1LiqPeriodo = GXutil.nullDate() ;
      P02FN2_A1734LSD1LiqPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      P02FN2_A1733LSD1LiqNro = new int[1] ;
      P02FN2_A1656LSD1cantidadRegistrosTipo04_30 = new int[1] ;
      P02FN2_A1655LSD1diasBase_28_2 = new byte[1] ;
      P02FN2_A1654LSD1numeroLiquidacion_23_5 = new int[1] ;
      P02FN2_A1653LSD1tipoLiquidacion_22_1 = new String[] {""} ;
      P02FN2_A1652LSD1periodoLiquidacion_16_6 = new int[1] ;
      P02FN2_A1651LSD1IdentificacionEnvio_14_2 = new String[] {""} ;
      P02FN2_A1650LSD1CuitEmpl_3_11 = new long[1] ;
      P02FN2_A1EmpCod = new short[1] ;
      P02FN2_A3CliCod = new int[1] ;
      P02FN2_A1649LSDSec = new int[1] ;
      AV28RegTipo = "" ;
      AV33UserCustomValue = "" ;
      GXt_char6 = "" ;
      GXv_char7 = new String[1] ;
      AV30ColumnsSelectorAux = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector8 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector9 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      AV26GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV27GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV42TFLSD1IdentificacionEnvio_14_2_SelsJson = "" ;
      AV48TFLSD1tipoLiquidacion_22_1_SelsJson = "" ;
      AV17MenuOpcCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.lsd_reg1wwexport__default(),
         new Object[] {
             new Object[] {
            P02FN2_A1734LSD1LiqPeriodo, P02FN2_A1733LSD1LiqNro, P02FN2_A1656LSD1cantidadRegistrosTipo04_30, P02FN2_A1655LSD1diasBase_28_2, P02FN2_A1654LSD1numeroLiquidacion_23_5, P02FN2_A1653LSD1tipoLiquidacion_22_1, P02FN2_A1652LSD1periodoLiquidacion_16_6, P02FN2_A1651LSD1IdentificacionEnvio_14_2, P02FN2_A1650LSD1CuitEmpl_3_11, P02FN2_A1EmpCod,
            P02FN2_A3CliCod, P02FN2_A1649LSDSec
            }
         }
      );
      AV61Pgmname = "LSD_reg1WWExport" ;
      /* GeneXus formulas. */
      AV61Pgmname = "LSD_reg1WWExport" ;
      Gx_err = (short)(0) ;
   }

   private byte AV54TFLSD1diasBase_28_2 ;
   private byte AV55TFLSD1diasBase_28_2_To ;
   private byte A1655LSD1diasBase_28_2 ;
   private byte AV78Lsd_reg1wwds_13_tflsd1diasbase_28_2 ;
   private byte AV79Lsd_reg1wwds_14_tflsd1diasbase_28_2_to ;
   private short GXv_int5[] ;
   private short AV67Lsd_reg1wwds_2_empcod ;
   private short AV19EmpCod ;
   private short AV22OrderedBy ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV14CellRow ;
   private int AV15FirstColumn ;
   private int AV16Random ;
   private int AV62GXV1 ;
   private int AV46TFLSD1periodoLiquidacion_16_6 ;
   private int AV47TFLSD1periodoLiquidacion_16_6_To ;
   private int AV63GXV2 ;
   private int AV52TFLSD1numeroLiquidacion_23_5 ;
   private int AV53TFLSD1numeroLiquidacion_23_5_To ;
   private int AV56TFLSD1cantidadRegistrosTipo04_30_6 ;
   private int AV57TFLSD1cantidadRegistrosTipo04_30_6_To ;
   private int AV64GXV3 ;
   private int A1652LSD1periodoLiquidacion_16_6 ;
   private int A1654LSD1numeroLiquidacion_23_5 ;
   private int A1656LSD1cantidadRegistrosTipo04_30 ;
   private int AV66Lsd_reg1wwds_1_clicod ;
   private int AV18CliCod ;
   private int AV72Lsd_reg1wwds_7_tflsd1periodoliquidacion_16_6 ;
   private int AV73Lsd_reg1wwds_8_tflsd1periodoliquidacion_16_6_to ;
   private int AV76Lsd_reg1wwds_11_tflsd1numeroliquidacion_23_5 ;
   private int AV77Lsd_reg1wwds_12_tflsd1numeroliquidacion_23_5_to ;
   private int AV80Lsd_reg1wwds_15_tflsd1cantidadregistrostipo04_30_6 ;
   private int AV81Lsd_reg1wwds_16_tflsd1cantidadregistrostipo04_30_6_to ;
   private int AV71Lsd_reg1wwds_6_tflsd1identificacionenvio_14_2_sels_size ;
   private int AV75Lsd_reg1wwds_10_tflsd1tipoliquidacion_22_1_sels_size ;
   private int AV21parmNroLiq ;
   private int A1733LSD1LiqNro ;
   private int A3CliCod ;
   private int A1649LSDSec ;
   private int AV82GXV4 ;
   private int AV83GXV5 ;
   private long AV40TFLSD1CuitEmpl_3_11 ;
   private long AV41TFLSD1CuitEmpl_3_11_To ;
   private long AV58i ;
   private long AV37VisibleColumnCount ;
   private long A1650LSD1CuitEmpl_3_11 ;
   private long AV68Lsd_reg1wwds_3_tflsd1cuitempl_3_11 ;
   private long AV69Lsd_reg1wwds_4_tflsd1cuitempl_3_11_to ;
   private String AV61Pgmname ;
   private String AV45TFLSD1IdentificacionEnvio_14_2_Sel ;
   private String AV43TFLSD1IdentificacionEnvio_14_2 ;
   private String AV51TFLSD1tipoLiquidacion_22_1_Sel ;
   private String AV49TFLSD1tipoLiquidacion_22_1 ;
   private String A1651LSD1IdentificacionEnvio_14_2 ;
   private String A1653LSD1tipoLiquidacion_22_1 ;
   private String AV70Lsd_reg1wwds_5_tflsd1identificacionenvio_14_2 ;
   private String AV74Lsd_reg1wwds_9_tflsd1tipoliquidacion_22_1 ;
   private String scmdbuf ;
   private String lV70Lsd_reg1wwds_5_tflsd1identificacionenvio_14_2 ;
   private String lV74Lsd_reg1wwds_9_tflsd1tipoliquidacion_22_1 ;
   private String AV28RegTipo ;
   private String GXt_char6 ;
   private String GXv_char7[] ;
   private java.util.Date AV20parmPeriodo ;
   private java.util.Date A1734LSD1LiqPeriodo ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean AV23OrderedDsc ;
   private String AV32ColumnsSelectorXML ;
   private String AV33UserCustomValue ;
   private String AV42TFLSD1IdentificacionEnvio_14_2_SelsJson ;
   private String AV48TFLSD1tipoLiquidacion_22_1_SelsJson ;
   private String AV12Filename ;
   private String AV13ErrorMessage ;
   private String AV17MenuOpcCod ;
   private com.genexus.webpanels.WebSession AV24Session ;
   private GXSimpleCollection<String> AV44TFLSD1IdentificacionEnvio_14_2_Sels ;
   private GXSimpleCollection<String> AV50TFLSD1tipoLiquidacion_22_1_Sels ;
   private String[] aP1 ;
   private String[] aP0 ;
   private IDataStoreProvider pr_default ;
   private java.util.Date[] P02FN2_A1734LSD1LiqPeriodo ;
   private int[] P02FN2_A1733LSD1LiqNro ;
   private int[] P02FN2_A1656LSD1cantidadRegistrosTipo04_30 ;
   private byte[] P02FN2_A1655LSD1diasBase_28_2 ;
   private int[] P02FN2_A1654LSD1numeroLiquidacion_23_5 ;
   private String[] P02FN2_A1653LSD1tipoLiquidacion_22_1 ;
   private int[] P02FN2_A1652LSD1periodoLiquidacion_16_6 ;
   private String[] P02FN2_A1651LSD1IdentificacionEnvio_14_2 ;
   private long[] P02FN2_A1650LSD1CuitEmpl_3_11 ;
   private short[] P02FN2_A1EmpCod ;
   private int[] P02FN2_A3CliCod ;
   private int[] P02FN2_A1649LSDSec ;
   private com.genexus.gxoffice.ExcelDoc AV11ExcelDocument ;
   private com.genexus.gxoffice.ExcelDoc GXv_exceldoc4[] ;
   private GXSimpleCollection<String> AV71Lsd_reg1wwds_6_tflsd1identificacionenvio_14_2_sels ;
   private GXSimpleCollection<String> AV75Lsd_reg1wwds_10_tflsd1tipoliquidacion_22_1_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV26GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV27GridStateFilterValue ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV29ColumnsSelector ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV30ColumnsSelectorAux ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector8[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector9[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector_Column AV31ColumnsSelector_Column ;
}

final  class lsd_reg1wwexport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P02FN2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1651LSD1IdentificacionEnvio_14_2 ,
                                          GXSimpleCollection<String> AV71Lsd_reg1wwds_6_tflsd1identificacionenvio_14_2_sels ,
                                          String A1653LSD1tipoLiquidacion_22_1 ,
                                          GXSimpleCollection<String> AV75Lsd_reg1wwds_10_tflsd1tipoliquidacion_22_1_sels ,
                                          long AV68Lsd_reg1wwds_3_tflsd1cuitempl_3_11 ,
                                          long AV69Lsd_reg1wwds_4_tflsd1cuitempl_3_11_to ,
                                          int AV71Lsd_reg1wwds_6_tflsd1identificacionenvio_14_2_sels_size ,
                                          String AV70Lsd_reg1wwds_5_tflsd1identificacionenvio_14_2 ,
                                          int AV72Lsd_reg1wwds_7_tflsd1periodoliquidacion_16_6 ,
                                          int AV73Lsd_reg1wwds_8_tflsd1periodoliquidacion_16_6_to ,
                                          int AV75Lsd_reg1wwds_10_tflsd1tipoliquidacion_22_1_sels_size ,
                                          String AV74Lsd_reg1wwds_9_tflsd1tipoliquidacion_22_1 ,
                                          int AV76Lsd_reg1wwds_11_tflsd1numeroliquidacion_23_5 ,
                                          int AV77Lsd_reg1wwds_12_tflsd1numeroliquidacion_23_5_to ,
                                          byte AV78Lsd_reg1wwds_13_tflsd1diasbase_28_2 ,
                                          byte AV79Lsd_reg1wwds_14_tflsd1diasbase_28_2_to ,
                                          int AV80Lsd_reg1wwds_15_tflsd1cantidadregistrostipo04_30_6 ,
                                          int AV81Lsd_reg1wwds_16_tflsd1cantidadregistrostipo04_30_6_to ,
                                          int AV21parmNroLiq ,
                                          java.util.Date AV20parmPeriodo ,
                                          long A1650LSD1CuitEmpl_3_11 ,
                                          int A1652LSD1periodoLiquidacion_16_6 ,
                                          int A1654LSD1numeroLiquidacion_23_5 ,
                                          byte A1655LSD1diasBase_28_2 ,
                                          int A1656LSD1cantidadRegistrosTipo04_30 ,
                                          int A1733LSD1LiqNro ,
                                          java.util.Date A1734LSD1LiqPeriodo ,
                                          short AV22OrderedBy ,
                                          boolean AV23OrderedDsc ,
                                          int AV66Lsd_reg1wwds_1_clicod ,
                                          short AV67Lsd_reg1wwds_2_empcod ,
                                          int A3CliCod ,
                                          short A1EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int10 = new byte[16];
      Object[] GXv_Object11 = new Object[2];
      scmdbuf = "SELECT LSD1LiqPeriodo, LSD1LiqNro, LSD1cantidadRegistrosTipo04_30, LSD1diasBase_28_2, LSD1numeroLiquidacion_23_5, LSD1tipoLiquidacion_22_1, LSD1periodoLiquidacion_16_6," ;
      scmdbuf += " LSD1IdentificacionEnvio_14_2, LSD1CuitEmpl_3_11, EmpCod, CliCod, LSDSec FROM LSD_reg1" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ?)");
      if ( ! (0==AV68Lsd_reg1wwds_3_tflsd1cuitempl_3_11) )
      {
         addWhere(sWhereString, "(LSD1CuitEmpl_3_11 >= ?)");
      }
      else
      {
         GXv_int10[2] = (byte)(1) ;
      }
      if ( ! (0==AV69Lsd_reg1wwds_4_tflsd1cuitempl_3_11_to) )
      {
         addWhere(sWhereString, "(LSD1CuitEmpl_3_11 <= ?)");
      }
      else
      {
         GXv_int10[3] = (byte)(1) ;
      }
      if ( ( AV71Lsd_reg1wwds_6_tflsd1identificacionenvio_14_2_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV70Lsd_reg1wwds_5_tflsd1identificacionenvio_14_2)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(LSD1IdentificacionEnvio_14_2) like LOWER(?))");
      }
      else
      {
         GXv_int10[4] = (byte)(1) ;
      }
      if ( AV71Lsd_reg1wwds_6_tflsd1identificacionenvio_14_2_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV71Lsd_reg1wwds_6_tflsd1identificacionenvio_14_2_sels, "LSD1IdentificacionEnvio_14_2 IN (", ")")+")");
      }
      if ( ! (0==AV72Lsd_reg1wwds_7_tflsd1periodoliquidacion_16_6) )
      {
         addWhere(sWhereString, "(LSD1periodoLiquidacion_16_6 >= ?)");
      }
      else
      {
         GXv_int10[5] = (byte)(1) ;
      }
      if ( ! (0==AV73Lsd_reg1wwds_8_tflsd1periodoliquidacion_16_6_to) )
      {
         addWhere(sWhereString, "(LSD1periodoLiquidacion_16_6 <= ?)");
      }
      else
      {
         GXv_int10[6] = (byte)(1) ;
      }
      if ( ( AV75Lsd_reg1wwds_10_tflsd1tipoliquidacion_22_1_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV74Lsd_reg1wwds_9_tflsd1tipoliquidacion_22_1)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(LSD1tipoLiquidacion_22_1) like LOWER(?))");
      }
      else
      {
         GXv_int10[7] = (byte)(1) ;
      }
      if ( AV75Lsd_reg1wwds_10_tflsd1tipoliquidacion_22_1_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV75Lsd_reg1wwds_10_tflsd1tipoliquidacion_22_1_sels, "LSD1tipoLiquidacion_22_1 IN (", ")")+")");
      }
      if ( ! (0==AV76Lsd_reg1wwds_11_tflsd1numeroliquidacion_23_5) )
      {
         addWhere(sWhereString, "(LSD1numeroLiquidacion_23_5 >= ?)");
      }
      else
      {
         GXv_int10[8] = (byte)(1) ;
      }
      if ( ! (0==AV77Lsd_reg1wwds_12_tflsd1numeroliquidacion_23_5_to) )
      {
         addWhere(sWhereString, "(LSD1numeroLiquidacion_23_5 <= ?)");
      }
      else
      {
         GXv_int10[9] = (byte)(1) ;
      }
      if ( ! (0==AV78Lsd_reg1wwds_13_tflsd1diasbase_28_2) )
      {
         addWhere(sWhereString, "(LSD1diasBase_28_2 >= ?)");
      }
      else
      {
         GXv_int10[10] = (byte)(1) ;
      }
      if ( ! (0==AV79Lsd_reg1wwds_14_tflsd1diasbase_28_2_to) )
      {
         addWhere(sWhereString, "(LSD1diasBase_28_2 <= ?)");
      }
      else
      {
         GXv_int10[11] = (byte)(1) ;
      }
      if ( ! (0==AV80Lsd_reg1wwds_15_tflsd1cantidadregistrostipo04_30_6) )
      {
         addWhere(sWhereString, "(LSD1cantidadRegistrosTipo04_30 >= ?)");
      }
      else
      {
         GXv_int10[12] = (byte)(1) ;
      }
      if ( ! (0==AV81Lsd_reg1wwds_16_tflsd1cantidadregistrostipo04_30_6_to) )
      {
         addWhere(sWhereString, "(LSD1cantidadRegistrosTipo04_30 <= ?)");
      }
      else
      {
         GXv_int10[13] = (byte)(1) ;
      }
      if ( ! (0==AV21parmNroLiq) )
      {
         addWhere(sWhereString, "(LSD1LiqNro = ?)");
      }
      else
      {
         GXv_int10[14] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV20parmPeriodo)) )
      {
         addWhere(sWhereString, "(LSD1LiqPeriodo = ?)");
      }
      else
      {
         GXv_int10[15] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      if ( AV22OrderedBy == 1 )
      {
         scmdbuf += " ORDER BY CliCod, EmpCod, LSDSec DESC" ;
      }
      else if ( ( AV22OrderedBy == 2 ) && ! AV23OrderedDsc )
      {
         scmdbuf += " ORDER BY CliCod, EmpCod, LSD1CuitEmpl_3_11" ;
      }
      else if ( ( AV22OrderedBy == 2 ) && ( AV23OrderedDsc ) )
      {
         scmdbuf += " ORDER BY CliCod DESC, EmpCod DESC, LSD1CuitEmpl_3_11 DESC" ;
      }
      else if ( ( AV22OrderedBy == 3 ) && ! AV23OrderedDsc )
      {
         scmdbuf += " ORDER BY CliCod, EmpCod, LSD1IdentificacionEnvio_14_2" ;
      }
      else if ( ( AV22OrderedBy == 3 ) && ( AV23OrderedDsc ) )
      {
         scmdbuf += " ORDER BY CliCod DESC, EmpCod DESC, LSD1IdentificacionEnvio_14_2 DESC" ;
      }
      else if ( ( AV22OrderedBy == 4 ) && ! AV23OrderedDsc )
      {
         scmdbuf += " ORDER BY CliCod, EmpCod, LSD1periodoLiquidacion_16_6" ;
      }
      else if ( ( AV22OrderedBy == 4 ) && ( AV23OrderedDsc ) )
      {
         scmdbuf += " ORDER BY CliCod DESC, EmpCod DESC, LSD1periodoLiquidacion_16_6 DESC" ;
      }
      else if ( ( AV22OrderedBy == 5 ) && ! AV23OrderedDsc )
      {
         scmdbuf += " ORDER BY CliCod, EmpCod, LSD1tipoLiquidacion_22_1" ;
      }
      else if ( ( AV22OrderedBy == 5 ) && ( AV23OrderedDsc ) )
      {
         scmdbuf += " ORDER BY CliCod DESC, EmpCod DESC, LSD1tipoLiquidacion_22_1 DESC" ;
      }
      else if ( ( AV22OrderedBy == 6 ) && ! AV23OrderedDsc )
      {
         scmdbuf += " ORDER BY CliCod, EmpCod, LSD1numeroLiquidacion_23_5" ;
      }
      else if ( ( AV22OrderedBy == 6 ) && ( AV23OrderedDsc ) )
      {
         scmdbuf += " ORDER BY CliCod DESC, EmpCod DESC, LSD1numeroLiquidacion_23_5 DESC" ;
      }
      else if ( ( AV22OrderedBy == 7 ) && ! AV23OrderedDsc )
      {
         scmdbuf += " ORDER BY CliCod, EmpCod, LSD1diasBase_28_2" ;
      }
      else if ( ( AV22OrderedBy == 7 ) && ( AV23OrderedDsc ) )
      {
         scmdbuf += " ORDER BY CliCod DESC, EmpCod DESC, LSD1diasBase_28_2 DESC" ;
      }
      else if ( ( AV22OrderedBy == 8 ) && ! AV23OrderedDsc )
      {
         scmdbuf += " ORDER BY CliCod, EmpCod, LSD1cantidadRegistrosTipo04_30" ;
      }
      else if ( ( AV22OrderedBy == 8 ) && ( AV23OrderedDsc ) )
      {
         scmdbuf += " ORDER BY CliCod DESC, EmpCod DESC, LSD1cantidadRegistrosTipo04_30 DESC" ;
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
                  return conditional_P02FN2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , ((Number) dynConstraints[4]).longValue() , ((Number) dynConstraints[5]).longValue() , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , ((Number) dynConstraints[9]).intValue() , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , ((Number) dynConstraints[13]).intValue() , ((Number) dynConstraints[14]).byteValue() , ((Number) dynConstraints[15]).byteValue() , ((Number) dynConstraints[16]).intValue() , ((Number) dynConstraints[17]).intValue() , ((Number) dynConstraints[18]).intValue() , (java.util.Date)dynConstraints[19] , ((Number) dynConstraints[20]).longValue() , ((Number) dynConstraints[21]).intValue() , ((Number) dynConstraints[22]).intValue() , ((Number) dynConstraints[23]).byteValue() , ((Number) dynConstraints[24]).intValue() , ((Number) dynConstraints[25]).intValue() , (java.util.Date)dynConstraints[26] , ((Number) dynConstraints[27]).shortValue() , ((Boolean) dynConstraints[28]).booleanValue() , ((Number) dynConstraints[29]).intValue() , ((Number) dynConstraints[30]).shortValue() , ((Number) dynConstraints[31]).intValue() , ((Number) dynConstraints[32]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02FN2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDate(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 1);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               ((String[]) buf[7])[0] = rslt.getString(8, 2);
               ((long[]) buf[8])[0] = rslt.getLong(9);
               ((short[]) buf[9])[0] = rslt.getShort(10);
               ((int[]) buf[10])[0] = rslt.getInt(11);
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
                  stmt.setInt(sIdx, ((Number) parms[16]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[17]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLong(sIdx, ((Number) parms[18]).longValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLong(sIdx, ((Number) parms[19]).longValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[20], 2);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[21]).intValue());
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[22]).intValue());
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[23], 1);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[24]).intValue());
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[25]).intValue());
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[26]).byteValue());
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[27]).byteValue());
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[28]).intValue());
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[29]).intValue());
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[30]).intValue());
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[31]);
               }
               return;
      }
   }

}

