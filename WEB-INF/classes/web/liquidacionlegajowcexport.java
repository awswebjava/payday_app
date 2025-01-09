package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class liquidacionlegajowcexport extends GXProcedure
{
   public liquidacionlegajowcexport( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( liquidacionlegajowcexport.class ), "" );
   }

   public liquidacionlegajowcexport( int remoteHandle ,
                                     ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String[] aP0 )
   {
      liquidacionlegajowcexport.this.aP1 = new String[] {""};
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
      liquidacionlegajowcexport.this.aP0 = aP0;
      liquidacionlegajowcexport.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWLiquidacion", GXv_boolean2) ;
      liquidacionlegajowcexport.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( ! AV8IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV156Pgmname))}, new String[] {"GxObject"}) );
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
         AV13CellRow = 1 ;
         AV14FirstColumn = 1 ;
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
      AV15Random = (int)(GXutil.random( )*10000) ;
      AV11Filename = "LiquidacionLegajoWCExport-" + GXutil.trim( GXutil.str( AV15Random, 8, 0)) + ".xlsx" ;
      AV10ExcelDocument.Open(AV11Filename);
      /* Execute user subroutine: 'CHECKSTATUS' */
      S121 ();
      if (returnInSub) return;
      AV10ExcelDocument.Clear();
   }

   public void S131( )
   {
      /* 'WRITEFILTERS' Routine */
      returnInSub = false ;
      if ( ! ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV119TFLiqLegImpBasico)==0) && (DecimalUtil.compareTo(DecimalUtil.ZERO, AV120TFLiqLegImpBasico_To)==0) ) )
      {
         GXv_exceldoc4[0] = AV10ExcelDocument ;
         GXv_int5[0] = (short)(AV13CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV14FirstColumn), httpContext.getMessage( "Básico", "")) ;
         AV10ExcelDocument = GXv_exceldoc4[0] ;
         liquidacionlegajowcexport.this.AV13CellRow = GXv_int5[0] ;
         AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV119TFLiqLegImpBasico)) );
         GXv_exceldoc4[0] = AV10ExcelDocument ;
         GXv_int5[0] = (short)(AV13CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV14FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV10ExcelDocument = GXv_exceldoc4[0] ;
         liquidacionlegajowcexport.this.AV13CellRow = GXv_int5[0] ;
         AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+3, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV120TFLiqLegImpBasico_To)) );
      }
      if ( ! ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV106TFLiqLegImpTotBruto)==0) && (DecimalUtil.compareTo(DecimalUtil.ZERO, AV107TFLiqLegImpTotBruto_To)==0) ) )
      {
         GXv_exceldoc4[0] = AV10ExcelDocument ;
         GXv_int5[0] = (short)(AV13CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV14FirstColumn), httpContext.getMessage( "Bruto", "")) ;
         AV10ExcelDocument = GXv_exceldoc4[0] ;
         liquidacionlegajowcexport.this.AV13CellRow = GXv_int5[0] ;
         AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV106TFLiqLegImpTotBruto)) );
         GXv_exceldoc4[0] = AV10ExcelDocument ;
         GXv_int5[0] = (short)(AV13CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV14FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV10ExcelDocument = GXv_exceldoc4[0] ;
         liquidacionlegajowcexport.this.AV13CellRow = GXv_int5[0] ;
         AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+3, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV107TFLiqLegImpTotBruto_To)) );
      }
      if ( ! ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV117TFLiqLegImpTotBruSinSAC)==0) && (DecimalUtil.compareTo(DecimalUtil.ZERO, AV118TFLiqLegImpTotBruSinSAC_To)==0) ) )
      {
         GXv_exceldoc4[0] = AV10ExcelDocument ;
         GXv_int5[0] = (short)(AV13CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV14FirstColumn), httpContext.getMessage( "Bruto sin SAC", "")) ;
         AV10ExcelDocument = GXv_exceldoc4[0] ;
         liquidacionlegajowcexport.this.AV13CellRow = GXv_int5[0] ;
         AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV117TFLiqLegImpTotBruSinSAC)) );
         GXv_exceldoc4[0] = AV10ExcelDocument ;
         GXv_int5[0] = (short)(AV13CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV14FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV10ExcelDocument = GXv_exceldoc4[0] ;
         liquidacionlegajowcexport.this.AV13CellRow = GXv_int5[0] ;
         AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+3, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV118TFLiqLegImpTotBruSinSAC_To)) );
      }
      if ( ! ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV111TFLiqLegImpTotRetGan)==0) && (DecimalUtil.compareTo(DecimalUtil.ZERO, AV112TFLiqLegImpTotRetGan_To)==0) ) )
      {
         GXv_exceldoc4[0] = AV10ExcelDocument ;
         GXv_int5[0] = (short)(AV13CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV14FirstColumn), httpContext.getMessage( "Ret. IIGG", "")) ;
         AV10ExcelDocument = GXv_exceldoc4[0] ;
         liquidacionlegajowcexport.this.AV13CellRow = GXv_int5[0] ;
         AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV111TFLiqLegImpTotRetGan)) );
         GXv_exceldoc4[0] = AV10ExcelDocument ;
         GXv_int5[0] = (short)(AV13CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV14FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV10ExcelDocument = GXv_exceldoc4[0] ;
         liquidacionlegajowcexport.this.AV13CellRow = GXv_int5[0] ;
         AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+3, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV112TFLiqLegImpTotRetGan_To)) );
      }
      if ( ! ( ( AV140TFLiqLegError_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV10ExcelDocument ;
         GXv_int5[0] = (short)(AV13CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV14FirstColumn), httpContext.getMessage( "Error", "")) ;
         AV10ExcelDocument = GXv_exceldoc4[0] ;
         liquidacionlegajowcexport.this.AV13CellRow = GXv_int5[0] ;
         AV90i = 1 ;
         AV157GXV1 = 1 ;
         while ( AV157GXV1 <= AV140TFLiqLegError_Sels.size() )
         {
            AV141TFLiqLegError_Sel = (String)AV140TFLiqLegError_Sels.elementAt(-1+AV157GXV1) ;
            if ( AV90i == 1 )
            {
               AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).setText( AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV141TFLiqLegError_Sel, GXv_char7) ;
            liquidacionlegajowcexport.this.GXt_char6 = GXv_char7[0] ;
            AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).setText( AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).getText()+GXt_char6 );
            AV90i = (long)(AV90i+1) ;
            AV157GXV1 = (int)(AV157GXV1+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV139TFLiqLegError)==0) ) )
         {
            GXv_exceldoc4[0] = AV10ExcelDocument ;
            GXv_int5[0] = (short)(AV13CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV14FirstColumn), httpContext.getMessage( "Error", "")) ;
            AV10ExcelDocument = GXv_exceldoc4[0] ;
            liquidacionlegajowcexport.this.AV13CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV139TFLiqLegError, GXv_char7) ;
            liquidacionlegajowcexport.this.GXt_char6 = GXv_char7[0] ;
            AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( ( AV145TFLiqLegErrorAux_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV10ExcelDocument ;
         GXv_int5[0] = (short)(AV13CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV14FirstColumn), httpContext.getMessage( "Error conceptos auxiliares", "")) ;
         AV10ExcelDocument = GXv_exceldoc4[0] ;
         liquidacionlegajowcexport.this.AV13CellRow = GXv_int5[0] ;
         AV90i = 1 ;
         AV158GXV2 = 1 ;
         while ( AV158GXV2 <= AV145TFLiqLegErrorAux_Sels.size() )
         {
            AV146TFLiqLegErrorAux_Sel = (String)AV145TFLiqLegErrorAux_Sels.elementAt(-1+AV158GXV2) ;
            if ( AV90i == 1 )
            {
               AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).setText( AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV146TFLiqLegErrorAux_Sel, GXv_char7) ;
            liquidacionlegajowcexport.this.GXt_char6 = GXv_char7[0] ;
            AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).setText( AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).getText()+GXt_char6 );
            AV90i = (long)(AV90i+1) ;
            AV158GXV2 = (int)(AV158GXV2+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV144TFLiqLegErrorAux)==0) ) )
         {
            GXv_exceldoc4[0] = AV10ExcelDocument ;
            GXv_int5[0] = (short)(AV13CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV14FirstColumn), httpContext.getMessage( "Error conceptos auxiliares", "")) ;
            AV10ExcelDocument = GXv_exceldoc4[0] ;
            liquidacionlegajowcexport.this.AV13CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV144TFLiqLegErrorAux, GXv_char7) ;
            liquidacionlegajowcexport.this.GXt_char6 = GXv_char7[0] ;
            AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV130TFLiqLegImpContr)==0) && (DecimalUtil.compareTo(DecimalUtil.ZERO, AV131TFLiqLegImpContr_To)==0) ) )
      {
         GXv_exceldoc4[0] = AV10ExcelDocument ;
         GXv_int5[0] = (short)(AV13CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV14FirstColumn), httpContext.getMessage( "Contr.", "")) ;
         AV10ExcelDocument = GXv_exceldoc4[0] ;
         liquidacionlegajowcexport.this.AV13CellRow = GXv_int5[0] ;
         AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV130TFLiqLegImpContr)) );
         GXv_exceldoc4[0] = AV10ExcelDocument ;
         GXv_int5[0] = (short)(AV13CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV14FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV10ExcelDocument = GXv_exceldoc4[0] ;
         liquidacionlegajowcexport.this.AV13CellRow = GXv_int5[0] ;
         AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+3, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV131TFLiqLegImpContr_To)) );
      }
      if ( ! ( (0==AV134TFLIqLegIteraciones) && (0==AV135TFLIqLegIteraciones_To) ) )
      {
         GXv_exceldoc4[0] = AV10ExcelDocument ;
         GXv_int5[0] = (short)(AV13CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV14FirstColumn), httpContext.getMessage( "Iteraciones Proceso", "")) ;
         AV10ExcelDocument = GXv_exceldoc4[0] ;
         liquidacionlegajowcexport.this.AV13CellRow = GXv_int5[0] ;
         AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).setNumber( AV134TFLIqLegIteraciones );
         GXv_exceldoc4[0] = AV10ExcelDocument ;
         GXv_int5[0] = (short)(AV13CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV14FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV10ExcelDocument = GXv_exceldoc4[0] ;
         liquidacionlegajowcexport.this.AV13CellRow = GXv_int5[0] ;
         AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+3, 1, 1).setNumber( AV135TFLIqLegIteraciones_To );
      }
      if ( ! ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV136TFLiqLegSegundos)==0) && (DecimalUtil.compareTo(DecimalUtil.ZERO, AV137TFLiqLegSegundos_To)==0) ) )
      {
         GXv_exceldoc4[0] = AV10ExcelDocument ;
         GXv_int5[0] = (short)(AV13CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV14FirstColumn), httpContext.getMessage( "Segundos", "")) ;
         AV10ExcelDocument = GXv_exceldoc4[0] ;
         liquidacionlegajowcexport.this.AV13CellRow = GXv_int5[0] ;
         AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV136TFLiqLegSegundos)) );
         GXv_exceldoc4[0] = AV10ExcelDocument ;
         GXv_int5[0] = (short)(AV13CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV14FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV10ExcelDocument = GXv_exceldoc4[0] ;
         liquidacionlegajowcexport.this.AV13CellRow = GXv_int5[0] ;
         AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+3, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV137TFLiqLegSegundos_To)) );
      }
      if ( ! ( ( AV148TFLiqLegAuxEstado_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV10ExcelDocument ;
         GXv_int5[0] = (short)(AV13CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV14FirstColumn), httpContext.getMessage( "Estado conceptos auxiliares", "")) ;
         AV10ExcelDocument = GXv_exceldoc4[0] ;
         liquidacionlegajowcexport.this.AV13CellRow = GXv_int5[0] ;
         AV90i = 1 ;
         AV159GXV3 = 1 ;
         while ( AV159GXV3 <= AV148TFLiqLegAuxEstado_Sels.size() )
         {
            AV149TFLiqLegAuxEstado_Sel = ((Number) AV148TFLiqLegAuxEstado_Sels.elementAt(-1+AV159GXV3)).byteValue() ;
            if ( AV90i == 1 )
            {
               AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).setText( AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).getText()+", " );
            }
            AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).setText( AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).getText()+httpContext.getMessage( web.gxdomainliquidacionestado.getDescription(httpContext,(byte)AV149TFLiqLegAuxEstado_Sel), "") );
            AV90i = (long)(AV90i+1) ;
            AV159GXV3 = (int)(AV159GXV3+1) ;
         }
      }
      AV13CellRow = (int)(AV13CellRow+2) ;
   }

   public void S141( )
   {
      /* 'WRITECOLUMNTITLES' Routine */
      returnInSub = false ;
      AV99VisibleColumnCount = 0 ;
      if ( GXutil.strcmp(AV19Session.getValue("LiquidacionLegajoWCColumnsSelector"), "") != 0 )
      {
         AV94ColumnsSelectorXML = AV19Session.getValue("LiquidacionLegajoWCColumnsSelector") ;
         AV91ColumnsSelector.fromxml(AV94ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S151 ();
         if (returnInSub) return;
      }
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV91ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+16)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      AV91ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().sort("Order");
      AV160GXV4 = 1 ;
      while ( AV160GXV4 <= AV91ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
      {
         AV93ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV91ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV160GXV4));
         if ( AV93ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV10ExcelDocument.Cells(AV13CellRow, (int)(AV14FirstColumn+AV99VisibleColumnCount), 1, 1).setText( httpContext.getMessage( ((GXutil.strcmp("", AV93ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname())==0) ? AV93ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname() : AV93ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname()), "") );
            AV10ExcelDocument.Cells(AV13CellRow, (int)(AV14FirstColumn+AV99VisibleColumnCount), 1, 1).setBold( (short)(1) );
            AV10ExcelDocument.Cells(AV13CellRow, (int)(AV14FirstColumn+AV99VisibleColumnCount), 1, 1).setColor( 11 );
            AV99VisibleColumnCount = (long)(AV99VisibleColumnCount+1) ;
         }
         AV160GXV4 = (int)(AV160GXV4+1) ;
      }
   }

   public void S161( )
   {
      /* 'WRITEDATA' Routine */
      returnInSub = false ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A891LiqLegError ,
                                           AV140TFLiqLegError_Sels ,
                                           A1781LiqLegErrorAux ,
                                           AV145TFLiqLegErrorAux_Sels ,
                                           Byte.valueOf(A1780LiqLegAuxEstado) ,
                                           AV148TFLiqLegAuxEstado_Sels ,
                                           AV119TFLiqLegImpBasico ,
                                           AV120TFLiqLegImpBasico_To ,
                                           AV106TFLiqLegImpTotBruto ,
                                           AV107TFLiqLegImpTotBruto_To ,
                                           AV117TFLiqLegImpTotBruSinSAC ,
                                           AV118TFLiqLegImpTotBruSinSAC_To ,
                                           AV111TFLiqLegImpTotRetGan ,
                                           AV112TFLiqLegImpTotRetGan_To ,
                                           Integer.valueOf(AV140TFLiqLegError_Sels.size()) ,
                                           AV139TFLiqLegError ,
                                           Integer.valueOf(AV145TFLiqLegErrorAux_Sels.size()) ,
                                           AV144TFLiqLegErrorAux ,
                                           AV130TFLiqLegImpContr ,
                                           AV131TFLiqLegImpContr_To ,
                                           Short.valueOf(AV134TFLIqLegIteraciones) ,
                                           Short.valueOf(AV135TFLIqLegIteraciones_To) ,
                                           AV136TFLiqLegSegundos ,
                                           AV137TFLiqLegSegundos_To ,
                                           Integer.valueOf(AV148TFLiqLegAuxEstado_Sels.size()) ,
                                           A760LiqLegImpBasico ,
                                           A498LiqLegImpTotBruto ,
                                           A759LiqLegImpTotBruSinSAC ,
                                           A757LiqLegImpTotRetGan ,
                                           A1157LiqLegImpContr ,
                                           Short.valueOf(A883LIqLegIteraciones) ,
                                           A884LiqLegSegundos ,
                                           Short.valueOf(AV105OrderedBy) ,
                                           Boolean.valueOf(AV18OrderedDsc) ,
                                           Integer.valueOf(AV102CliCod) ,
                                           Short.valueOf(AV16EmpCod) ,
                                           Integer.valueOf(AV17LiqNro) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Integer.valueOf(A31LiqNro) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL,
                                           TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.DECIMAL,
                                           TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.DECIMAL, TypeConstants.SHORT,
                                           TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT
                                           }
      });
      lV139TFLiqLegError = GXutil.concat( GXutil.rtrim( AV139TFLiqLegError), "%", "") ;
      lV144TFLiqLegErrorAux = GXutil.concat( GXutil.rtrim( AV144TFLiqLegErrorAux), "%", "") ;
      /* Using cursor P00AW2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV102CliCod), Short.valueOf(AV16EmpCod), Integer.valueOf(AV17LiqNro), AV119TFLiqLegImpBasico, AV120TFLiqLegImpBasico_To, AV106TFLiqLegImpTotBruto, AV107TFLiqLegImpTotBruto_To, AV117TFLiqLegImpTotBruSinSAC, AV118TFLiqLegImpTotBruSinSAC_To, AV111TFLiqLegImpTotRetGan, AV112TFLiqLegImpTotRetGan_To, lV139TFLiqLegError, lV144TFLiqLegErrorAux, AV130TFLiqLegImpContr, AV131TFLiqLegImpContr_To, Short.valueOf(AV134TFLIqLegIteraciones), Short.valueOf(AV135TFLIqLegIteraciones_To), AV136TFLiqLegSegundos, AV137TFLiqLegSegundos_To});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A31LiqNro = P00AW2_A31LiqNro[0] ;
         A1EmpCod = P00AW2_A1EmpCod[0] ;
         A3CliCod = P00AW2_A3CliCod[0] ;
         A1780LiqLegAuxEstado = P00AW2_A1780LiqLegAuxEstado[0] ;
         A884LiqLegSegundos = P00AW2_A884LiqLegSegundos[0] ;
         A883LIqLegIteraciones = P00AW2_A883LIqLegIteraciones[0] ;
         A1157LiqLegImpContr = P00AW2_A1157LiqLegImpContr[0] ;
         A1781LiqLegErrorAux = P00AW2_A1781LiqLegErrorAux[0] ;
         A891LiqLegError = P00AW2_A891LiqLegError[0] ;
         A757LiqLegImpTotRetGan = P00AW2_A757LiqLegImpTotRetGan[0] ;
         A759LiqLegImpTotBruSinSAC = P00AW2_A759LiqLegImpTotBruSinSAC[0] ;
         A498LiqLegImpTotBruto = P00AW2_A498LiqLegImpTotBruto[0] ;
         A760LiqLegImpBasico = P00AW2_A760LiqLegImpBasico[0] ;
         A1131LiqLegImpOtrDescu = P00AW2_A1131LiqLegImpOtrDescu[0] ;
         A579LiqLegImpTotDescu = P00AW2_A579LiqLegImpTotDescu[0] ;
         A239LegCUIL = P00AW2_A239LegCUIL[0] ;
         A281LiqLegImpTotal = P00AW2_A281LiqLegImpTotal[0] ;
         A6LegNumero = P00AW2_A6LegNumero[0] ;
         A239LegCUIL = P00AW2_A239LegCUIL[0] ;
         AV13CellRow = (int)(AV13CellRow+1) ;
         /* Execute user subroutine: 'BEFOREWRITELINE' */
         S172 ();
         if ( returnInSub )
         {
            pr_default.close(0);
            pr_default.close(0);
            returnInSub = true;
            if (true) return;
         }
         AV99VisibleColumnCount = 0 ;
         AV162GXV5 = 1 ;
         while ( AV162GXV5 <= AV91ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
         {
            AV93ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV91ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV162GXV5));
            if ( AV93ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
            {
               if ( GXutil.strcmp(AV93ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "&LegHtml") == 0 )
               {
                  GXt_char6 = AV153LegHtml ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.gethtmlleg(remoteHandle, context).execute( A3CliCod, A1EmpCod, A6LegNumero, GXv_char7) ;
                  liquidacionlegajowcexport.this.GXt_char6 = GXv_char7[0] ;
                  AV153LegHtml = GXt_char6 ;
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV153LegHtml, GXv_char7) ;
                  liquidacionlegajowcexport.this.GXt_char6 = GXv_char7[0] ;
                  AV10ExcelDocument.Cells(AV13CellRow, (int)(AV14FirstColumn+AV99VisibleColumnCount), 1, 1).setText( GXt_char6 );
               }
               else if ( GXutil.strcmp(AV93ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LiqLegImpBasico") == 0 )
               {
                  AV10ExcelDocument.Cells(AV13CellRow, (int)(AV14FirstColumn+AV99VisibleColumnCount), 1, 1).setNumber( (double)(DecimalUtil.decToDouble(A760LiqLegImpBasico)) );
               }
               else if ( GXutil.strcmp(AV93ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LiqLegImpTotBruto") == 0 )
               {
                  AV10ExcelDocument.Cells(AV13CellRow, (int)(AV14FirstColumn+AV99VisibleColumnCount), 1, 1).setNumber( (double)(DecimalUtil.decToDouble(A498LiqLegImpTotBruto)) );
               }
               else if ( GXutil.strcmp(AV93ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LiqLegImpTotal") == 0 )
               {
                  AV10ExcelDocument.Cells(AV13CellRow, (int)(AV14FirstColumn+AV99VisibleColumnCount), 1, 1).setNumber( (double)(DecimalUtil.decToDouble(A281LiqLegImpTotal)) );
               }
               else if ( GXutil.strcmp(AV93ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LiqLegImpTotBruSinSAC") == 0 )
               {
                  AV10ExcelDocument.Cells(AV13CellRow, (int)(AV14FirstColumn+AV99VisibleColumnCount), 1, 1).setNumber( (double)(DecimalUtil.decToDouble(A759LiqLegImpTotBruSinSAC)) );
               }
               else if ( GXutil.strcmp(AV93ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LiqLegImpTotRetGan") == 0 )
               {
                  AV10ExcelDocument.Cells(AV13CellRow, (int)(AV14FirstColumn+AV99VisibleColumnCount), 1, 1).setNumber( (double)(DecimalUtil.decToDouble(A757LiqLegImpTotRetGan)) );
               }
               else if ( GXutil.strcmp(AV93ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "&LiqLegImpOtrDescu") == 0 )
               {
                  AV129LiqLegImpOtrDescu = A1131LiqLegImpOtrDescu.multiply(DecimalUtil.doubleToDec(-1)) ;
                  AV10ExcelDocument.Cells(AV13CellRow, (int)(AV14FirstColumn+AV99VisibleColumnCount), 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV129LiqLegImpOtrDescu)) );
               }
               else if ( GXutil.strcmp(AV93ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "&LiqLegImpTotDescu") == 0 )
               {
                  AV115LiqLegImpTotDescu = A579LiqLegImpTotDescu.multiply(DecimalUtil.doubleToDec(-1)) ;
                  AV10ExcelDocument.Cells(AV13CellRow, (int)(AV14FirstColumn+AV99VisibleColumnCount), 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV115LiqLegImpTotDescu)) );
               }
               else if ( GXutil.strcmp(AV93ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LiqLegError") == 0 )
               {
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A891LiqLegError, GXv_char7) ;
                  liquidacionlegajowcexport.this.GXt_char6 = GXv_char7[0] ;
                  AV10ExcelDocument.Cells(AV13CellRow, (int)(AV14FirstColumn+AV99VisibleColumnCount), 1, 1).setText( GXt_char6 );
               }
               else if ( GXutil.strcmp(AV93ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LiqLegErrorAux") == 0 )
               {
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A1781LiqLegErrorAux, GXv_char7) ;
                  liquidacionlegajowcexport.this.GXt_char6 = GXv_char7[0] ;
                  AV10ExcelDocument.Cells(AV13CellRow, (int)(AV14FirstColumn+AV99VisibleColumnCount), 1, 1).setText( GXt_char6 );
               }
               else if ( GXutil.strcmp(AV93ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LegCUIL") == 0 )
               {
                  AV10ExcelDocument.Cells(AV13CellRow, (int)(AV14FirstColumn+AV99VisibleColumnCount), 1, 1).setNumber( A239LegCUIL );
               }
               else if ( GXutil.strcmp(AV93ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LiqLegImpContr") == 0 )
               {
                  AV10ExcelDocument.Cells(AV13CellRow, (int)(AV14FirstColumn+AV99VisibleColumnCount), 1, 1).setNumber( (double)(DecimalUtil.decToDouble(A1157LiqLegImpContr)) );
               }
               else if ( GXutil.strcmp(AV93ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LIqLegIteraciones") == 0 )
               {
                  AV10ExcelDocument.Cells(AV13CellRow, (int)(AV14FirstColumn+AV99VisibleColumnCount), 1, 1).setNumber( A883LIqLegIteraciones );
               }
               else if ( GXutil.strcmp(AV93ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LiqLegSegundos") == 0 )
               {
                  AV10ExcelDocument.Cells(AV13CellRow, (int)(AV14FirstColumn+AV99VisibleColumnCount), 1, 1).setNumber( (double)(DecimalUtil.decToDouble(A884LiqLegSegundos)) );
               }
               else if ( GXutil.strcmp(AV93ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LiqLegAuxEstado") == 0 )
               {
                  AV10ExcelDocument.Cells(AV13CellRow, (int)(AV14FirstColumn+AV99VisibleColumnCount), 1, 1).setText( httpContext.getMessage( web.gxdomainliquidacionestado.getDescription(httpContext,(byte)A1780LiqLegAuxEstado), "") );
               }
               AV99VisibleColumnCount = (long)(AV99VisibleColumnCount+1) ;
            }
            AV162GXV5 = (int)(AV162GXV5+1) ;
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
      AV10ExcelDocument.Save();
      /* Execute user subroutine: 'CHECKSTATUS' */
      S121 ();
      if (returnInSub) return;
      AV10ExcelDocument.Close();
   }

   public void S121( )
   {
      /* 'CHECKSTATUS' Routine */
      returnInSub = false ;
      if ( AV10ExcelDocument.getErrCode() != 0 )
      {
         AV11Filename = "" ;
         AV12ErrorMessage = AV10ExcelDocument.getErrDescription() ;
         AV10ExcelDocument.Close();
         returnInSub = true;
         if (true) return;
      }
   }

   public void S151( )
   {
      /* 'INITIALIZECOLUMNSSELECTOR' Routine */
      returnInSub = false ;
      AV91ColumnsSelector = (web.wwpbaseobjects.SdtWWPColumnsSelector)new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector8[0] = AV91ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "&LegHtml", "", "Legajo", true, "") ;
      AV91ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV91ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "LiqLegImpBasico", "", "Básico", false, "") ;
      AV91ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV91ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "LiqLegImpTotBruto", "", "Bruto", true, "") ;
      AV91ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV91ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "LiqLegImpTotal", "", "Neto", true, "") ;
      AV91ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV91ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "LiqLegImpTotBruSinSAC", "", "Bruto sin SAC", false, "") ;
      AV91ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV91ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "LiqLegImpTotRetGan", "", "Ret. IIGG", true, "") ;
      AV91ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV91ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "&LiqLegImpOtrDescu", "", "Aportes", true, "") ;
      AV91ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV91ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "&LiqLegImpTotDescu", "", "Ret. Total", false, "") ;
      AV91ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV91ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "LiqLegError", "", "Error", false, "") ;
      AV91ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV91ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "LiqLegErrorAux", "", "Error conceptos auxiliares", false, "") ;
      AV91ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV91ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "LegCUIL", "", "CUIL", false, "") ;
      AV91ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV91ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "LiqLegImpContr", "", "Contr.", true, "") ;
      AV91ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV91ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "LIqLegIteraciones", "", "Iteraciones Proceso", false, "") ;
      AV91ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV91ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "LiqLegSegundos", "", "Segundos", false, "") ;
      AV91ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV91ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "LiqLegAuxEstado", "", "Estado conceptos auxiliares", false, "") ;
      AV91ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV91ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "&VerSVG", "", "", true, "") ;
      AV91ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXt_char6 = AV95UserCustomValue ;
      GXv_char7[0] = GXt_char6 ;
      new web.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "LiquidacionLegajoWCColumnsSelector", GXv_char7) ;
      liquidacionlegajowcexport.this.GXt_char6 = GXv_char7[0] ;
      AV95UserCustomValue = GXt_char6 ;
      if ( ! ( (GXutil.strcmp("", AV95UserCustomValue)==0) ) )
      {
         AV92ColumnsSelectorAux.fromxml(AV95UserCustomValue, null, null);
         GXv_SdtWWPColumnsSelector8[0] = AV92ColumnsSelectorAux;
         GXv_SdtWWPColumnsSelector9[0] = AV91ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnselector_updatecolumns(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, GXv_SdtWWPColumnsSelector9) ;
         AV92ColumnsSelectorAux = GXv_SdtWWPColumnsSelector8[0] ;
         AV91ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      }
   }

   public void S201( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV19Session.getValue("LiquidacionLegajoWCGridState"), "") == 0 )
      {
         AV21GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "LiquidacionLegajoWCGridState"), null, null);
      }
      else
      {
         AV21GridState.fromxml(AV19Session.getValue("LiquidacionLegajoWCGridState"), null, null);
      }
      AV105OrderedBy = AV21GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV18OrderedDsc = AV21GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV163GXV6 = 1 ;
      while ( AV163GXV6 <= AV21GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV22GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV21GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV163GXV6));
         if ( GXutil.strcmp(AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQLEGIMPBASICO") == 0 )
         {
            AV119TFLiqLegImpBasico = CommonUtil.decimalVal( AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV120TFLiqLegImpBasico_To = CommonUtil.decimalVal( AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQLEGIMPTOTBRUTO") == 0 )
         {
            AV106TFLiqLegImpTotBruto = CommonUtil.decimalVal( AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV107TFLiqLegImpTotBruto_To = CommonUtil.decimalVal( AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQLEGIMPTOTBRUSINSAC") == 0 )
         {
            AV117TFLiqLegImpTotBruSinSAC = CommonUtil.decimalVal( AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV118TFLiqLegImpTotBruSinSAC_To = CommonUtil.decimalVal( AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQLEGIMPTOTRETGAN") == 0 )
         {
            AV111TFLiqLegImpTotRetGan = CommonUtil.decimalVal( AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV112TFLiqLegImpTotRetGan_To = CommonUtil.decimalVal( AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQLEGERROR") == 0 )
         {
            AV139TFLiqLegError = AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQLEGERROR_SEL") == 0 )
         {
            AV138TFLiqLegError_SelsJson = AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV140TFLiqLegError_Sels.fromJSonString(AV138TFLiqLegError_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQLEGERRORAUX") == 0 )
         {
            AV144TFLiqLegErrorAux = AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQLEGERRORAUX_SEL") == 0 )
         {
            AV143TFLiqLegErrorAux_SelsJson = AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV145TFLiqLegErrorAux_Sels.fromJSonString(AV143TFLiqLegErrorAux_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQLEGIMPCONTR") == 0 )
         {
            AV130TFLiqLegImpContr = CommonUtil.decimalVal( AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV131TFLiqLegImpContr_To = CommonUtil.decimalVal( AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQLEGITERACIONES") == 0 )
         {
            AV134TFLIqLegIteraciones = (short)(GXutil.lval( AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV135TFLIqLegIteraciones_To = (short)(GXutil.lval( AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQLEGSEGUNDOS") == 0 )
         {
            AV136TFLiqLegSegundos = CommonUtil.decimalVal( AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV137TFLiqLegSegundos_To = CommonUtil.decimalVal( AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQLEGAUXESTADO_SEL") == 0 )
         {
            AV147TFLiqLegAuxEstado_SelsJson = AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV148TFLiqLegAuxEstado_Sels.fromJSonString(AV147TFLiqLegAuxEstado_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV142MenuOpcCod = AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&CLICOD") == 0 )
         {
            AV102CliCod = (int)(GXutil.lval( AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&EMPCOD") == 0 )
         {
            AV16EmpCod = (short)(GXutil.lval( AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&LIQNRO") == 0 )
         {
            AV17LiqNro = (int)(GXutil.lval( AV22GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         AV163GXV6 = (int)(AV163GXV6+1) ;
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
      this.aP0[0] = liquidacionlegajowcexport.this.AV11Filename;
      this.aP1[0] = liquidacionlegajowcexport.this.AV12ErrorMessage;
      CloseOpenCursors();
      AV10ExcelDocument.cleanup();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV11Filename = "" ;
      AV12ErrorMessage = "" ;
      GXv_boolean2 = new boolean[1] ;
      AV156Pgmname = "" ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV10ExcelDocument = new com.genexus.gxoffice.ExcelDoc();
      AV119TFLiqLegImpBasico = DecimalUtil.ZERO ;
      AV120TFLiqLegImpBasico_To = DecimalUtil.ZERO ;
      AV106TFLiqLegImpTotBruto = DecimalUtil.ZERO ;
      AV107TFLiqLegImpTotBruto_To = DecimalUtil.ZERO ;
      AV117TFLiqLegImpTotBruSinSAC = DecimalUtil.ZERO ;
      AV118TFLiqLegImpTotBruSinSAC_To = DecimalUtil.ZERO ;
      AV111TFLiqLegImpTotRetGan = DecimalUtil.ZERO ;
      AV112TFLiqLegImpTotRetGan_To = DecimalUtil.ZERO ;
      AV140TFLiqLegError_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV141TFLiqLegError_Sel = "" ;
      AV139TFLiqLegError = "" ;
      AV145TFLiqLegErrorAux_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV146TFLiqLegErrorAux_Sel = "" ;
      AV144TFLiqLegErrorAux = "" ;
      AV130TFLiqLegImpContr = DecimalUtil.ZERO ;
      AV131TFLiqLegImpContr_To = DecimalUtil.ZERO ;
      AV136TFLiqLegSegundos = DecimalUtil.ZERO ;
      AV137TFLiqLegSegundos_To = DecimalUtil.ZERO ;
      AV148TFLiqLegAuxEstado_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      GXv_exceldoc4 = new com.genexus.gxoffice.ExcelDoc[1] ;
      GXv_int5 = new short[1] ;
      AV19Session = httpContext.getWebSession();
      AV94ColumnsSelectorXML = "" ;
      AV91ColumnsSelector = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV93ColumnsSelector_Column = new web.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      scmdbuf = "" ;
      lV139TFLiqLegError = "" ;
      lV144TFLiqLegErrorAux = "" ;
      A891LiqLegError = "" ;
      A1781LiqLegErrorAux = "" ;
      A760LiqLegImpBasico = DecimalUtil.ZERO ;
      A498LiqLegImpTotBruto = DecimalUtil.ZERO ;
      A759LiqLegImpTotBruSinSAC = DecimalUtil.ZERO ;
      A757LiqLegImpTotRetGan = DecimalUtil.ZERO ;
      A1157LiqLegImpContr = DecimalUtil.ZERO ;
      A884LiqLegSegundos = DecimalUtil.ZERO ;
      P00AW2_A31LiqNro = new int[1] ;
      P00AW2_A1EmpCod = new short[1] ;
      P00AW2_A3CliCod = new int[1] ;
      P00AW2_A1780LiqLegAuxEstado = new byte[1] ;
      P00AW2_A884LiqLegSegundos = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P00AW2_A883LIqLegIteraciones = new short[1] ;
      P00AW2_A1157LiqLegImpContr = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P00AW2_A1781LiqLegErrorAux = new String[] {""} ;
      P00AW2_A891LiqLegError = new String[] {""} ;
      P00AW2_A757LiqLegImpTotRetGan = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P00AW2_A759LiqLegImpTotBruSinSAC = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P00AW2_A498LiqLegImpTotBruto = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P00AW2_A760LiqLegImpBasico = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P00AW2_A1131LiqLegImpOtrDescu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P00AW2_A579LiqLegImpTotDescu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P00AW2_A239LegCUIL = new long[1] ;
      P00AW2_A281LiqLegImpTotal = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P00AW2_A6LegNumero = new int[1] ;
      A1131LiqLegImpOtrDescu = DecimalUtil.ZERO ;
      A579LiqLegImpTotDescu = DecimalUtil.ZERO ;
      A281LiqLegImpTotal = DecimalUtil.ZERO ;
      AV153LegHtml = "" ;
      AV129LiqLegImpOtrDescu = DecimalUtil.ZERO ;
      AV115LiqLegImpTotDescu = DecimalUtil.ZERO ;
      AV95UserCustomValue = "" ;
      GXt_char6 = "" ;
      GXv_char7 = new String[1] ;
      AV92ColumnsSelectorAux = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector8 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector9 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      AV21GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV22GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV138TFLiqLegError_SelsJson = "" ;
      AV143TFLiqLegErrorAux_SelsJson = "" ;
      AV147TFLiqLegAuxEstado_SelsJson = "" ;
      AV142MenuOpcCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.liquidacionlegajowcexport__default(),
         new Object[] {
             new Object[] {
            P00AW2_A31LiqNro, P00AW2_A1EmpCod, P00AW2_A3CliCod, P00AW2_A1780LiqLegAuxEstado, P00AW2_A884LiqLegSegundos, P00AW2_A883LIqLegIteraciones, P00AW2_A1157LiqLegImpContr, P00AW2_A1781LiqLegErrorAux, P00AW2_A891LiqLegError, P00AW2_A757LiqLegImpTotRetGan,
            P00AW2_A759LiqLegImpTotBruSinSAC, P00AW2_A498LiqLegImpTotBruto, P00AW2_A760LiqLegImpBasico, P00AW2_A1131LiqLegImpOtrDescu, P00AW2_A579LiqLegImpTotDescu, P00AW2_A239LegCUIL, P00AW2_A281LiqLegImpTotal, P00AW2_A6LegNumero
            }
         }
      );
      AV156Pgmname = "LiquidacionLegajoWCExport" ;
      /* GeneXus formulas. */
      AV156Pgmname = "LiquidacionLegajoWCExport" ;
      Gx_err = (short)(0) ;
   }

   private byte AV149TFLiqLegAuxEstado_Sel ;
   private byte A1780LiqLegAuxEstado ;
   private short AV134TFLIqLegIteraciones ;
   private short AV135TFLIqLegIteraciones_To ;
   private short GXv_int5[] ;
   private short A883LIqLegIteraciones ;
   private short AV105OrderedBy ;
   private short AV16EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV13CellRow ;
   private int AV14FirstColumn ;
   private int AV15Random ;
   private int AV157GXV1 ;
   private int AV158GXV2 ;
   private int AV159GXV3 ;
   private int AV160GXV4 ;
   private int AV140TFLiqLegError_Sels_size ;
   private int AV145TFLiqLegErrorAux_Sels_size ;
   private int AV148TFLiqLegAuxEstado_Sels_size ;
   private int AV102CliCod ;
   private int AV17LiqNro ;
   private int A3CliCod ;
   private int A31LiqNro ;
   private int A6LegNumero ;
   private int AV162GXV5 ;
   private int AV163GXV6 ;
   private long AV90i ;
   private long AV99VisibleColumnCount ;
   private long A239LegCUIL ;
   private java.math.BigDecimal AV119TFLiqLegImpBasico ;
   private java.math.BigDecimal AV120TFLiqLegImpBasico_To ;
   private java.math.BigDecimal AV106TFLiqLegImpTotBruto ;
   private java.math.BigDecimal AV107TFLiqLegImpTotBruto_To ;
   private java.math.BigDecimal AV117TFLiqLegImpTotBruSinSAC ;
   private java.math.BigDecimal AV118TFLiqLegImpTotBruSinSAC_To ;
   private java.math.BigDecimal AV111TFLiqLegImpTotRetGan ;
   private java.math.BigDecimal AV112TFLiqLegImpTotRetGan_To ;
   private java.math.BigDecimal AV130TFLiqLegImpContr ;
   private java.math.BigDecimal AV131TFLiqLegImpContr_To ;
   private java.math.BigDecimal AV136TFLiqLegSegundos ;
   private java.math.BigDecimal AV137TFLiqLegSegundos_To ;
   private java.math.BigDecimal A760LiqLegImpBasico ;
   private java.math.BigDecimal A498LiqLegImpTotBruto ;
   private java.math.BigDecimal A759LiqLegImpTotBruSinSAC ;
   private java.math.BigDecimal A757LiqLegImpTotRetGan ;
   private java.math.BigDecimal A1157LiqLegImpContr ;
   private java.math.BigDecimal A884LiqLegSegundos ;
   private java.math.BigDecimal A1131LiqLegImpOtrDescu ;
   private java.math.BigDecimal A579LiqLegImpTotDescu ;
   private java.math.BigDecimal A281LiqLegImpTotal ;
   private java.math.BigDecimal AV129LiqLegImpOtrDescu ;
   private java.math.BigDecimal AV115LiqLegImpTotDescu ;
   private String AV156Pgmname ;
   private String scmdbuf ;
   private String GXt_char6 ;
   private String GXv_char7[] ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean AV18OrderedDsc ;
   private String AV94ColumnsSelectorXML ;
   private String AV95UserCustomValue ;
   private String AV138TFLiqLegError_SelsJson ;
   private String AV143TFLiqLegErrorAux_SelsJson ;
   private String AV147TFLiqLegAuxEstado_SelsJson ;
   private String AV11Filename ;
   private String AV12ErrorMessage ;
   private String AV141TFLiqLegError_Sel ;
   private String AV139TFLiqLegError ;
   private String AV146TFLiqLegErrorAux_Sel ;
   private String AV144TFLiqLegErrorAux ;
   private String lV139TFLiqLegError ;
   private String lV144TFLiqLegErrorAux ;
   private String A891LiqLegError ;
   private String A1781LiqLegErrorAux ;
   private String AV153LegHtml ;
   private String AV142MenuOpcCod ;
   private GXSimpleCollection<Byte> AV148TFLiqLegAuxEstado_Sels ;
   private com.genexus.webpanels.WebSession AV19Session ;
   private GXSimpleCollection<String> AV140TFLiqLegError_Sels ;
   private GXSimpleCollection<String> AV145TFLiqLegErrorAux_Sels ;
   private String[] aP1 ;
   private String[] aP0 ;
   private IDataStoreProvider pr_default ;
   private int[] P00AW2_A31LiqNro ;
   private short[] P00AW2_A1EmpCod ;
   private int[] P00AW2_A3CliCod ;
   private byte[] P00AW2_A1780LiqLegAuxEstado ;
   private java.math.BigDecimal[] P00AW2_A884LiqLegSegundos ;
   private short[] P00AW2_A883LIqLegIteraciones ;
   private java.math.BigDecimal[] P00AW2_A1157LiqLegImpContr ;
   private String[] P00AW2_A1781LiqLegErrorAux ;
   private String[] P00AW2_A891LiqLegError ;
   private java.math.BigDecimal[] P00AW2_A757LiqLegImpTotRetGan ;
   private java.math.BigDecimal[] P00AW2_A759LiqLegImpTotBruSinSAC ;
   private java.math.BigDecimal[] P00AW2_A498LiqLegImpTotBruto ;
   private java.math.BigDecimal[] P00AW2_A760LiqLegImpBasico ;
   private java.math.BigDecimal[] P00AW2_A1131LiqLegImpOtrDescu ;
   private java.math.BigDecimal[] P00AW2_A579LiqLegImpTotDescu ;
   private long[] P00AW2_A239LegCUIL ;
   private java.math.BigDecimal[] P00AW2_A281LiqLegImpTotal ;
   private int[] P00AW2_A6LegNumero ;
   private com.genexus.gxoffice.ExcelDoc AV10ExcelDocument ;
   private com.genexus.gxoffice.ExcelDoc GXv_exceldoc4[] ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV21GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV22GridStateFilterValue ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV91ColumnsSelector ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV92ColumnsSelectorAux ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector8[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector9[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector_Column AV93ColumnsSelector_Column ;
}

final  class liquidacionlegajowcexport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P00AW2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A891LiqLegError ,
                                          GXSimpleCollection<String> AV140TFLiqLegError_Sels ,
                                          String A1781LiqLegErrorAux ,
                                          GXSimpleCollection<String> AV145TFLiqLegErrorAux_Sels ,
                                          byte A1780LiqLegAuxEstado ,
                                          GXSimpleCollection<Byte> AV148TFLiqLegAuxEstado_Sels ,
                                          java.math.BigDecimal AV119TFLiqLegImpBasico ,
                                          java.math.BigDecimal AV120TFLiqLegImpBasico_To ,
                                          java.math.BigDecimal AV106TFLiqLegImpTotBruto ,
                                          java.math.BigDecimal AV107TFLiqLegImpTotBruto_To ,
                                          java.math.BigDecimal AV117TFLiqLegImpTotBruSinSAC ,
                                          java.math.BigDecimal AV118TFLiqLegImpTotBruSinSAC_To ,
                                          java.math.BigDecimal AV111TFLiqLegImpTotRetGan ,
                                          java.math.BigDecimal AV112TFLiqLegImpTotRetGan_To ,
                                          int AV140TFLiqLegError_Sels_size ,
                                          String AV139TFLiqLegError ,
                                          int AV145TFLiqLegErrorAux_Sels_size ,
                                          String AV144TFLiqLegErrorAux ,
                                          java.math.BigDecimal AV130TFLiqLegImpContr ,
                                          java.math.BigDecimal AV131TFLiqLegImpContr_To ,
                                          short AV134TFLIqLegIteraciones ,
                                          short AV135TFLIqLegIteraciones_To ,
                                          java.math.BigDecimal AV136TFLiqLegSegundos ,
                                          java.math.BigDecimal AV137TFLiqLegSegundos_To ,
                                          int AV148TFLiqLegAuxEstado_Sels_size ,
                                          java.math.BigDecimal A760LiqLegImpBasico ,
                                          java.math.BigDecimal A498LiqLegImpTotBruto ,
                                          java.math.BigDecimal A759LiqLegImpTotBruSinSAC ,
                                          java.math.BigDecimal A757LiqLegImpTotRetGan ,
                                          java.math.BigDecimal A1157LiqLegImpContr ,
                                          short A883LIqLegIteraciones ,
                                          java.math.BigDecimal A884LiqLegSegundos ,
                                          short AV105OrderedBy ,
                                          boolean AV18OrderedDsc ,
                                          int AV102CliCod ,
                                          short AV16EmpCod ,
                                          int AV17LiqNro ,
                                          int A3CliCod ,
                                          short A1EmpCod ,
                                          int A31LiqNro )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int10 = new byte[19];
      Object[] GXv_Object11 = new Object[2];
      scmdbuf = "SELECT T1.LiqNro, T1.EmpCod, T1.CliCod, T1.LiqLegAuxEstado, T1.LiqLegSegundos, T1.LIqLegIteraciones, T1.LiqLegImpContr, T1.LiqLegErrorAux, T1.LiqLegError, T1.LiqLegImpTotRetGan," ;
      scmdbuf += " T1.LiqLegImpTotBruSinSAC, T1.LiqLegImpTotBruto, T1.LiqLegImpBasico, T1.LiqLegImpOtrDescu, T1.LiqLegImpTotDescu, T2.LegCUIL, T1.LiqLegImpTotal, T1.LegNumero FROM" ;
      scmdbuf += " (LiquidacionLegajo T1 INNER JOIN Legajo T2 ON T2.CliCod = T1.CliCod AND T2.EmpCod = T1.EmpCod AND T2.LegNumero = T1.LegNumero)" ;
      addWhere(sWhereString, "(T1.CliCod = ? and T1.EmpCod = ? and T1.LiqNro = ?)");
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV119TFLiqLegImpBasico)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpBasico >= ?)");
      }
      else
      {
         GXv_int10[3] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV120TFLiqLegImpBasico_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpBasico <= ?)");
      }
      else
      {
         GXv_int10[4] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV106TFLiqLegImpTotBruto)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpTotBruto >= ?)");
      }
      else
      {
         GXv_int10[5] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV107TFLiqLegImpTotBruto_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpTotBruto <= ?)");
      }
      else
      {
         GXv_int10[6] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV117TFLiqLegImpTotBruSinSAC)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpTotBruSinSAC >= ?)");
      }
      else
      {
         GXv_int10[7] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV118TFLiqLegImpTotBruSinSAC_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpTotBruSinSAC <= ?)");
      }
      else
      {
         GXv_int10[8] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV111TFLiqLegImpTotRetGan)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpTotRetGan >= ?)");
      }
      else
      {
         GXv_int10[9] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV112TFLiqLegImpTotRetGan_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpTotRetGan <= ?)");
      }
      else
      {
         GXv_int10[10] = (byte)(1) ;
      }
      if ( ( AV140TFLiqLegError_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV139TFLiqLegError)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.LiqLegError) like LOWER(?))");
      }
      else
      {
         GXv_int10[11] = (byte)(1) ;
      }
      if ( AV140TFLiqLegError_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV140TFLiqLegError_Sels, "T1.LiqLegError IN (", ")")+")");
      }
      if ( ( AV145TFLiqLegErrorAux_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV144TFLiqLegErrorAux)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.LiqLegErrorAux) like LOWER(?))");
      }
      else
      {
         GXv_int10[12] = (byte)(1) ;
      }
      if ( AV145TFLiqLegErrorAux_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV145TFLiqLegErrorAux_Sels, "T1.LiqLegErrorAux IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV130TFLiqLegImpContr)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpContr >= ?)");
      }
      else
      {
         GXv_int10[13] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV131TFLiqLegImpContr_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpContr <= ?)");
      }
      else
      {
         GXv_int10[14] = (byte)(1) ;
      }
      if ( ! (0==AV134TFLIqLegIteraciones) )
      {
         addWhere(sWhereString, "(T1.LIqLegIteraciones >= ?)");
      }
      else
      {
         GXv_int10[15] = (byte)(1) ;
      }
      if ( ! (0==AV135TFLIqLegIteraciones_To) )
      {
         addWhere(sWhereString, "(T1.LIqLegIteraciones <= ?)");
      }
      else
      {
         GXv_int10[16] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV136TFLiqLegSegundos)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegSegundos >= ?)");
      }
      else
      {
         GXv_int10[17] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV137TFLiqLegSegundos_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegSegundos <= ?)");
      }
      else
      {
         GXv_int10[18] = (byte)(1) ;
      }
      if ( AV148TFLiqLegAuxEstado_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV148TFLiqLegAuxEstado_Sels, "T1.LiqLegAuxEstado IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      if ( AV105OrderedBy == 1 )
      {
         scmdbuf += " ORDER BY T1.CliCod, T1.EmpCod, T1.LiqNro, T1.LegNumero" ;
      }
      else if ( ( AV105OrderedBy == 2 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.LiqLegImpBasico" ;
      }
      else if ( ( AV105OrderedBy == 2 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.LiqLegImpBasico DESC" ;
      }
      else if ( ( AV105OrderedBy == 3 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.LiqLegImpTotBruto" ;
      }
      else if ( ( AV105OrderedBy == 3 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.LiqLegImpTotBruto DESC" ;
      }
      else if ( ( AV105OrderedBy == 4 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.LiqLegImpTotal" ;
      }
      else if ( ( AV105OrderedBy == 4 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.LiqLegImpTotal DESC" ;
      }
      else if ( ( AV105OrderedBy == 5 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.LiqLegImpTotBruSinSAC" ;
      }
      else if ( ( AV105OrderedBy == 5 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.LiqLegImpTotBruSinSAC DESC" ;
      }
      else if ( ( AV105OrderedBy == 6 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.LiqLegImpTotRetGan" ;
      }
      else if ( ( AV105OrderedBy == 6 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.LiqLegImpTotRetGan DESC" ;
      }
      else if ( ( AV105OrderedBy == 7 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.LiqLegError" ;
      }
      else if ( ( AV105OrderedBy == 7 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.LiqLegError DESC" ;
      }
      else if ( ( AV105OrderedBy == 8 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.LiqLegErrorAux" ;
      }
      else if ( ( AV105OrderedBy == 8 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.LiqLegErrorAux DESC" ;
      }
      else if ( ( AV105OrderedBy == 9 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.LiqLegImpContr" ;
      }
      else if ( ( AV105OrderedBy == 9 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.LiqLegImpContr DESC" ;
      }
      else if ( ( AV105OrderedBy == 10 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.LIqLegIteraciones" ;
      }
      else if ( ( AV105OrderedBy == 10 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.LIqLegIteraciones DESC" ;
      }
      else if ( ( AV105OrderedBy == 11 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.LiqLegSegundos" ;
      }
      else if ( ( AV105OrderedBy == 11 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.LiqLegSegundos DESC" ;
      }
      else if ( ( AV105OrderedBy == 12 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.LiqLegAuxEstado" ;
      }
      else if ( ( AV105OrderedBy == 12 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.LiqLegAuxEstado DESC" ;
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
                  return conditional_P00AW2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , ((Number) dynConstraints[4]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[5] , (java.math.BigDecimal)dynConstraints[6] , (java.math.BigDecimal)dynConstraints[7] , (java.math.BigDecimal)dynConstraints[8] , (java.math.BigDecimal)dynConstraints[9] , (java.math.BigDecimal)dynConstraints[10] , (java.math.BigDecimal)dynConstraints[11] , (java.math.BigDecimal)dynConstraints[12] , (java.math.BigDecimal)dynConstraints[13] , ((Number) dynConstraints[14]).intValue() , (String)dynConstraints[15] , ((Number) dynConstraints[16]).intValue() , (String)dynConstraints[17] , (java.math.BigDecimal)dynConstraints[18] , (java.math.BigDecimal)dynConstraints[19] , ((Number) dynConstraints[20]).shortValue() , ((Number) dynConstraints[21]).shortValue() , (java.math.BigDecimal)dynConstraints[22] , (java.math.BigDecimal)dynConstraints[23] , ((Number) dynConstraints[24]).intValue() , (java.math.BigDecimal)dynConstraints[25] , (java.math.BigDecimal)dynConstraints[26] , (java.math.BigDecimal)dynConstraints[27] , (java.math.BigDecimal)dynConstraints[28] , (java.math.BigDecimal)dynConstraints[29] , ((Number) dynConstraints[30]).shortValue() , (java.math.BigDecimal)dynConstraints[31] , ((Number) dynConstraints[32]).shortValue() , ((Boolean) dynConstraints[33]).booleanValue() , ((Number) dynConstraints[34]).intValue() , ((Number) dynConstraints[35]).shortValue() , ((Number) dynConstraints[36]).intValue() , ((Number) dynConstraints[37]).intValue() , ((Number) dynConstraints[38]).shortValue() , ((Number) dynConstraints[39]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00AW2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,6);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(7,2);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((java.math.BigDecimal[]) buf[9])[0] = rslt.getBigDecimal(10,2);
               ((java.math.BigDecimal[]) buf[10])[0] = rslt.getBigDecimal(11,2);
               ((java.math.BigDecimal[]) buf[11])[0] = rslt.getBigDecimal(12,2);
               ((java.math.BigDecimal[]) buf[12])[0] = rslt.getBigDecimal(13,2);
               ((java.math.BigDecimal[]) buf[13])[0] = rslt.getBigDecimal(14,2);
               ((java.math.BigDecimal[]) buf[14])[0] = rslt.getBigDecimal(15,2);
               ((long[]) buf[15])[0] = rslt.getLong(16);
               ((java.math.BigDecimal[]) buf[16])[0] = rslt.getBigDecimal(17,2);
               ((int[]) buf[17])[0] = rslt.getInt(18);
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
                  stmt.setInt(sIdx, ((Number) parms[19]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[20]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[21]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[22], 2);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[23], 2);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[24], 2);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[25], 2);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[26], 2);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[27], 2);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[28], 2);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[29], 2);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[30], 400);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[31], 400);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[32], 2);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[33], 2);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[34]).shortValue());
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[35]).shortValue());
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[36], 6);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[37], 6);
               }
               return;
      }
   }

}

