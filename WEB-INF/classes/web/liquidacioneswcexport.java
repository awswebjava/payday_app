package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class liquidacioneswcexport extends GXProcedure
{
   public liquidacioneswcexport( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( liquidacioneswcexport.class ), "" );
   }

   public liquidacioneswcexport( int remoteHandle ,
                                 ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String[] aP0 )
   {
      liquidacioneswcexport.this.aP1 = new String[] {""};
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
      liquidacioneswcexport.this.aP0 = aP0;
      liquidacioneswcexport.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWLegajos", GXv_boolean2) ;
      liquidacioneswcexport.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( ! AV8IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV82Pgmname))}, new String[] {"GxObject"}) );
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
      AV12Filename = "liquidacionesWCExport-" + GXutil.trim( GXutil.str( AV16Random, 8, 0)) + ".xlsx" ;
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
      if ( ! ( (0==AV41TFLiqNro) && (0==AV42TFLiqNro_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Número", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         liquidacioneswcexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV41TFLiqNro );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         liquidacioneswcexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV42TFLiqNro_To );
      }
      if ( ! ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV43TFLiqFecha)) && GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV44TFLiqFecha_To)) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Fecha de Liq.", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         liquidacioneswcexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_dtime6 = GXutil.resetTime( AV43TFLiqFecha );
         AV11ExcelDocument.setDateFormat(localUtil, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " ");
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setDate( GXt_dtime6 );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         liquidacioneswcexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_dtime6 = GXutil.resetTime( AV44TFLiqFecha_To );
         AV11ExcelDocument.setDateFormat(localUtil, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " ");
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setDate( GXt_dtime6 );
      }
      if ( ! ( ( AV47TFLiqPerPalabra_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Periodo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         liquidacioneswcexport.this.AV14CellRow = GXv_int5[0] ;
         AV73i = 1 ;
         AV83GXV1 = 1 ;
         while ( AV83GXV1 <= AV47TFLiqPerPalabra_Sels.size() )
         {
            AV48TFLiqPerPalabra_Sel = (String)AV47TFLiqPerPalabra_Sels.elementAt(-1+AV83GXV1) ;
            if ( AV73i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char7 = "" ;
            GXv_char8[0] = GXt_char7 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV48TFLiqPerPalabra_Sel, GXv_char8) ;
            liquidacioneswcexport.this.GXt_char7 = GXv_char8[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char7 );
            AV73i = (long)(AV73i+1) ;
            AV83GXV1 = (int)(AV83GXV1+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV46TFLiqPerPalabra)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Periodo", "")) ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            liquidacioneswcexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char7 = "" ;
            GXv_char8[0] = GXt_char7 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV46TFLiqPerPalabra, GXv_char8) ;
            liquidacioneswcexport.this.GXt_char7 = GXv_char8[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char7 );
         }
      }
      if ( ! ( ( AV51TFLiqNombre_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Liquidación", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         liquidacioneswcexport.this.AV14CellRow = GXv_int5[0] ;
         AV73i = 1 ;
         AV84GXV2 = 1 ;
         while ( AV84GXV2 <= AV51TFLiqNombre_Sels.size() )
         {
            AV52TFLiqNombre_Sel = (String)AV51TFLiqNombre_Sels.elementAt(-1+AV84GXV2) ;
            if ( AV73i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char7 = "" ;
            GXv_char8[0] = GXt_char7 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV52TFLiqNombre_Sel, GXv_char8) ;
            liquidacioneswcexport.this.GXt_char7 = GXv_char8[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char7 );
            AV73i = (long)(AV73i+1) ;
            AV84GXV2 = (int)(AV84GXV2+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV50TFLiqNombre)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Liquidación", "")) ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            liquidacioneswcexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char7 = "" ;
            GXv_char8[0] = GXt_char7 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV50TFLiqNombre, GXv_char8) ;
            liquidacioneswcexport.this.GXt_char7 = GXv_char8[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char7 );
         }
      }
      if ( ! ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV53TFLiqFecPago)) && GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV54TFLiqFecPago_To)) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Fecha de Pago", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         liquidacioneswcexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_dtime6 = GXutil.resetTime( AV53TFLiqFecPago );
         AV11ExcelDocument.setDateFormat(localUtil, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " ");
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setDate( GXt_dtime6 );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         liquidacioneswcexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_dtime6 = GXutil.resetTime( AV54TFLiqFecPago_To );
         AV11ExcelDocument.setDateFormat(localUtil, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " ");
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setDate( GXt_dtime6 );
      }
      if ( ! ( ( AV57TFTLiqCod_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Tipo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         liquidacioneswcexport.this.AV14CellRow = GXv_int5[0] ;
         AV73i = 1 ;
         AV85GXV3 = 1 ;
         while ( AV85GXV3 <= AV57TFTLiqCod_Sels.size() )
         {
            AV58TFTLiqCod_Sel = (String)AV57TFTLiqCod_Sels.elementAt(-1+AV85GXV3) ;
            if ( AV73i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV72TFTLiqCod_SelDsc = AV58TFTLiqCod_Sel ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+AV72TFTLiqCod_SelDsc );
            AV73i = (long)(AV73i+1) ;
            AV85GXV3 = (int)(AV85GXV3+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV56TFTLiqCod)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Tipo", "")) ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            liquidacioneswcexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char7 = "" ;
            GXv_char8[0] = GXt_char7 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV56TFTLiqCod, GXv_char8) ;
            liquidacioneswcexport.this.GXt_char7 = GXv_char8[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char7 );
         }
      }
      if ( ! ( ( AV75TFLiqModTra_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Modo de trabajo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         liquidacioneswcexport.this.AV14CellRow = GXv_int5[0] ;
         AV73i = 1 ;
         AV86GXV4 = 1 ;
         while ( AV86GXV4 <= AV75TFLiqModTra_Sels.size() )
         {
            AV76TFLiqModTra_Sel = (String)AV75TFLiqModTra_Sels.elementAt(-1+AV86GXV4) ;
            if ( AV73i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+httpContext.getMessage( web.gxdomainmodo_trabajo.getDescription(httpContext,(String)AV76TFLiqModTra_Sel), "") );
            AV73i = (long)(AV73i+1) ;
            AV86GXV4 = (int)(AV86GXV4+1) ;
         }
      }
      if ( ! ( ( AV78TFLiqFrecPag_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Frecuencia de pago", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         liquidacioneswcexport.this.AV14CellRow = GXv_int5[0] ;
         AV73i = 1 ;
         AV87GXV5 = 1 ;
         while ( AV87GXV5 <= AV78TFLiqFrecPag_Sels.size() )
         {
            AV79TFLiqFrecPag_Sel = ((Number) AV78TFLiqFrecPag_Sels.elementAt(-1+AV87GXV5)).byteValue() ;
            if ( AV73i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+httpContext.getMessage( web.gxdomainclaseleg.getDescription(httpContext,(byte)AV79TFLiqFrecPag_Sel), "") );
            AV73i = (long)(AV73i+1) ;
            AV87GXV5 = (int)(AV87GXV5+1) ;
         }
      }
      if ( ! ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV62TFLiqLegImpBasico)==0) && (DecimalUtil.compareTo(DecimalUtil.ZERO, AV63TFLiqLegImpBasico_To)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Básico", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         liquidacioneswcexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV62TFLiqLegImpBasico)) );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         liquidacioneswcexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV63TFLiqLegImpBasico_To)) );
      }
      if ( ! ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV64TFLiqLegImpTotBruto)==0) && (DecimalUtil.compareTo(DecimalUtil.ZERO, AV65TFLiqLegImpTotBruto_To)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Bruto", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         liquidacioneswcexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV64TFLiqLegImpTotBruto)) );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         liquidacioneswcexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV65TFLiqLegImpTotBruto_To)) );
      }
      if ( ! ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV66TFLiqLegImpTotBruProm)==0) && (DecimalUtil.compareTo(DecimalUtil.ZERO, AV67TFLiqLegImpTotBruProm_To)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Bruto Prom. sin SAC", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         liquidacioneswcexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV66TFLiqLegImpTotBruProm)) );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         liquidacioneswcexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV67TFLiqLegImpTotBruProm_To)) );
      }
      if ( ! ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV68TFLiqLegImpTotBruSinSAC)==0) && (DecimalUtil.compareTo(DecimalUtil.ZERO, AV69TFLiqLegImpTotBruSinSAC_To)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Bruto sin SAC", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         liquidacioneswcexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV68TFLiqLegImpTotBruSinSAC)) );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         liquidacioneswcexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV69TFLiqLegImpTotBruSinSAC_To)) );
      }
      if ( ! ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV70TFLiqLegImpTotRetGan)==0) && (DecimalUtil.compareTo(DecimalUtil.ZERO, AV71TFLiqLegImpTotRetGan_To)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Imp. Ganancias (Ret/Dev)", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         liquidacioneswcexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV70TFLiqLegImpTotRetGan)) );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         liquidacioneswcexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV71TFLiqLegImpTotRetGan_To)) );
      }
      AV14CellRow = (int)(AV14CellRow+2) ;
   }

   public void S141( )
   {
      /* 'WRITECOLUMNTITLES' Routine */
      returnInSub = false ;
      AV38VisibleColumnCount = 0 ;
      if ( GXutil.strcmp(AV24Session.getValue("liquidacionesWCColumnsSelector"), "") != 0 )
      {
         AV33ColumnsSelectorXML = AV24Session.getValue("liquidacionesWCColumnsSelector") ;
         AV30ColumnsSelector.fromxml(AV33ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S151 ();
         if (returnInSub) return;
      }
      AV30ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().sort("Order");
      AV88GXV6 = 1 ;
      while ( AV88GXV6 <= AV30ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
      {
         AV32ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV30ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV88GXV6));
         if ( AV32ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV38VisibleColumnCount), 1, 1).setText( httpContext.getMessage( ((GXutil.strcmp("", AV32ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname())==0) ? AV32ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname() : AV32ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname()), "") );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV38VisibleColumnCount), 1, 1).setBold( (short)(1) );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV38VisibleColumnCount), 1, 1).setColor( 11 );
            AV38VisibleColumnCount = (long)(AV38VisibleColumnCount+1) ;
         }
         AV88GXV6 = (int)(AV88GXV6+1) ;
      }
   }

   public void S161( )
   {
      /* 'WRITEDATA' Routine */
      returnInSub = false ;
      AV21FirstDataCellRow = (int)(AV14CellRow+1) ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A748LiqPerPalabra ,
                                           AV47TFLiqPerPalabra_Sels ,
                                           A874LiqNombre ,
                                           AV51TFLiqNombre_Sels ,
                                           A32TLiqCod ,
                                           AV57TFTLiqCod_Sels ,
                                           A2409LiqModTra ,
                                           AV75TFLiqModTra_Sels ,
                                           Byte.valueOf(A2414LiqFrecPag) ,
                                           AV78TFLiqFrecPag_Sels ,
                                           Integer.valueOf(AV41TFLiqNro) ,
                                           Integer.valueOf(AV42TFLiqNro_To) ,
                                           AV43TFLiqFecha ,
                                           AV44TFLiqFecha_To ,
                                           Integer.valueOf(AV47TFLiqPerPalabra_Sels.size()) ,
                                           AV46TFLiqPerPalabra ,
                                           Integer.valueOf(AV51TFLiqNombre_Sels.size()) ,
                                           AV50TFLiqNombre ,
                                           AV53TFLiqFecPago ,
                                           AV54TFLiqFecPago_To ,
                                           Integer.valueOf(AV57TFTLiqCod_Sels.size()) ,
                                           AV56TFTLiqCod ,
                                           Integer.valueOf(AV75TFLiqModTra_Sels.size()) ,
                                           Integer.valueOf(AV78TFLiqFrecPag_Sels.size()) ,
                                           AV62TFLiqLegImpBasico ,
                                           AV63TFLiqLegImpBasico_To ,
                                           AV64TFLiqLegImpTotBruto ,
                                           AV65TFLiqLegImpTotBruto_To ,
                                           AV66TFLiqLegImpTotBruProm ,
                                           AV67TFLiqLegImpTotBruProm_To ,
                                           AV68TFLiqLegImpTotBruSinSAC ,
                                           AV69TFLiqLegImpTotBruSinSAC_To ,
                                           AV70TFLiqLegImpTotRetGan ,
                                           AV71TFLiqLegImpTotRetGan_To ,
                                           Integer.valueOf(A31LiqNro) ,
                                           A98LiqFecha ,
                                           A280LiqFecPago ,
                                           A340TliqDesc ,
                                           A760LiqLegImpBasico ,
                                           A498LiqLegImpTotBruto ,
                                           A758LiqLegImpTotBruProm ,
                                           A759LiqLegImpTotBruSinSAC ,
                                           A757LiqLegImpTotRetGan ,
                                           Short.valueOf(AV22OrderedBy) ,
                                           Boolean.valueOf(AV23OrderedDsc) ,
                                           Integer.valueOf(AV17CliCod) ,
                                           Short.valueOf(AV18EmpCod) ,
                                           Integer.valueOf(AV20LegNumero) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Integer.valueOf(A6LegNumero) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.INT, TypeConstants.DATE, TypeConstants.DATE,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL,
                                           TypeConstants.INT, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.SHORT,
                                           TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT
                                           }
      });
      lV46TFLiqPerPalabra = GXutil.padr( GXutil.rtrim( AV46TFLiqPerPalabra), 20, "%") ;
      lV50TFLiqNombre = GXutil.concat( GXutil.rtrim( AV50TFLiqNombre), "%", "") ;
      lV56TFTLiqCod = GXutil.concat( GXutil.rtrim( AV56TFTLiqCod), "%", "") ;
      /* Using cursor P01QP2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV17CliCod), Short.valueOf(AV18EmpCod), Integer.valueOf(AV20LegNumero), Integer.valueOf(AV41TFLiqNro), Integer.valueOf(AV42TFLiqNro_To), AV43TFLiqFecha, AV44TFLiqFecha_To, lV46TFLiqPerPalabra, lV50TFLiqNombre, AV53TFLiqFecPago, AV54TFLiqFecPago_To, lV56TFTLiqCod, AV62TFLiqLegImpBasico, AV63TFLiqLegImpBasico_To, AV64TFLiqLegImpTotBruto, AV65TFLiqLegImpTotBruto_To, AV66TFLiqLegImpTotBruProm, AV67TFLiqLegImpTotBruProm_To, AV68TFLiqLegImpTotBruSinSAC, AV69TFLiqLegImpTotBruSinSAC_To, AV70TFLiqLegImpTotRetGan, AV71TFLiqLegImpTotRetGan_To});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A757LiqLegImpTotRetGan = P01QP2_A757LiqLegImpTotRetGan[0] ;
         A759LiqLegImpTotBruSinSAC = P01QP2_A759LiqLegImpTotBruSinSAC[0] ;
         A758LiqLegImpTotBruProm = P01QP2_A758LiqLegImpTotBruProm[0] ;
         A498LiqLegImpTotBruto = P01QP2_A498LiqLegImpTotBruto[0] ;
         A760LiqLegImpBasico = P01QP2_A760LiqLegImpBasico[0] ;
         A2414LiqFrecPag = P01QP2_A2414LiqFrecPag[0] ;
         A2409LiqModTra = P01QP2_A2409LiqModTra[0] ;
         A32TLiqCod = P01QP2_A32TLiqCod[0] ;
         n32TLiqCod = P01QP2_n32TLiqCod[0] ;
         A340TliqDesc = P01QP2_A340TliqDesc[0] ;
         A280LiqFecPago = P01QP2_A280LiqFecPago[0] ;
         A874LiqNombre = P01QP2_A874LiqNombre[0] ;
         A748LiqPerPalabra = P01QP2_A748LiqPerPalabra[0] ;
         A98LiqFecha = P01QP2_A98LiqFecha[0] ;
         A31LiqNro = P01QP2_A31LiqNro[0] ;
         A6LegNumero = P01QP2_A6LegNumero[0] ;
         A1EmpCod = P01QP2_A1EmpCod[0] ;
         A3CliCod = P01QP2_A3CliCod[0] ;
         A579LiqLegImpTotDescu = P01QP2_A579LiqLegImpTotDescu[0] ;
         A281LiqLegImpTotal = P01QP2_A281LiqLegImpTotal[0] ;
         A2414LiqFrecPag = P01QP2_A2414LiqFrecPag[0] ;
         A2409LiqModTra = P01QP2_A2409LiqModTra[0] ;
         A280LiqFecPago = P01QP2_A280LiqFecPago[0] ;
         A874LiqNombre = P01QP2_A874LiqNombre[0] ;
         A748LiqPerPalabra = P01QP2_A748LiqPerPalabra[0] ;
         A98LiqFecha = P01QP2_A98LiqFecha[0] ;
         A340TliqDesc = P01QP2_A340TliqDesc[0] ;
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
         AV38VisibleColumnCount = 0 ;
         AV90GXV7 = 1 ;
         while ( AV90GXV7 <= AV30ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
         {
            AV32ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV30ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV90GXV7));
            if ( AV32ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
            {
               if ( GXutil.strcmp(AV32ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LiqNro") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV38VisibleColumnCount), 1, 1).setNumber( A31LiqNro );
               }
               else if ( GXutil.strcmp(AV32ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LiqFecha") == 0 )
               {
                  GXt_dtime6 = GXutil.resetTime( A98LiqFecha );
                  AV11ExcelDocument.setDateFormat(localUtil, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " ");
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV38VisibleColumnCount), 1, 1).setDate( GXt_dtime6 );
               }
               else if ( GXutil.strcmp(AV32ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LiqPerPalabra") == 0 )
               {
                  GXt_char7 = "" ;
                  GXv_char8[0] = GXt_char7 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A748LiqPerPalabra, GXv_char8) ;
                  liquidacioneswcexport.this.GXt_char7 = GXv_char8[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV38VisibleColumnCount), 1, 1).setText( GXt_char7 );
               }
               else if ( GXutil.strcmp(AV32ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LiqNombre") == 0 )
               {
                  GXt_char7 = "" ;
                  GXv_char8[0] = GXt_char7 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A874LiqNombre, GXv_char8) ;
                  liquidacioneswcexport.this.GXt_char7 = GXv_char8[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV38VisibleColumnCount), 1, 1).setText( GXt_char7 );
               }
               else if ( GXutil.strcmp(AV32ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LiqFecPago") == 0 )
               {
                  GXt_dtime6 = GXutil.resetTime( A280LiqFecPago );
                  AV11ExcelDocument.setDateFormat(localUtil, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " ");
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV38VisibleColumnCount), 1, 1).setDate( GXt_dtime6 );
               }
               else if ( GXutil.strcmp(AV32ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "TLiqCod") == 0 )
               {
                  GXt_char7 = "" ;
                  GXv_char8[0] = GXt_char7 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A340TliqDesc, GXv_char8) ;
                  liquidacioneswcexport.this.GXt_char7 = GXv_char8[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV38VisibleColumnCount), 1, 1).setText( GXt_char7 );
               }
               else if ( GXutil.strcmp(AV32ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LiqModTra") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV38VisibleColumnCount), 1, 1).setText( httpContext.getMessage( web.gxdomainmodo_trabajo.getDescription(httpContext,(String)A2409LiqModTra), "") );
               }
               else if ( GXutil.strcmp(AV32ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LiqFrecPag") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV38VisibleColumnCount), 1, 1).setText( httpContext.getMessage( web.gxdomainclaseleg.getDescription(httpContext,(byte)A2414LiqFrecPag), "") );
               }
               else if ( GXutil.strcmp(AV32ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LiqLegImpBasico") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV38VisibleColumnCount), 1, 1).setNumber( (double)(DecimalUtil.decToDouble(A760LiqLegImpBasico)) );
               }
               else if ( GXutil.strcmp(AV32ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LiqLegImpTotBruto") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV38VisibleColumnCount), 1, 1).setNumber( (double)(DecimalUtil.decToDouble(A498LiqLegImpTotBruto)) );
               }
               else if ( GXutil.strcmp(AV32ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LiqLegImpTotBruProm") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV38VisibleColumnCount), 1, 1).setNumber( (double)(DecimalUtil.decToDouble(A758LiqLegImpTotBruProm)) );
               }
               else if ( GXutil.strcmp(AV32ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LiqLegImpTotBruSinSAC") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV38VisibleColumnCount), 1, 1).setNumber( (double)(DecimalUtil.decToDouble(A759LiqLegImpTotBruSinSAC)) );
               }
               else if ( GXutil.strcmp(AV32ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "&LiqLegImpTotDescu") == 0 )
               {
                  AV28LiqLegImpTotDescu = A579LiqLegImpTotDescu.multiply(DecimalUtil.doubleToDec(-1)) ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV38VisibleColumnCount), 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV28LiqLegImpTotDescu)) );
               }
               else if ( GXutil.strcmp(AV32ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LiqLegImpTotRetGan") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV38VisibleColumnCount), 1, 1).setNumber( (double)(DecimalUtil.decToDouble(A757LiqLegImpTotRetGan)) );
               }
               else if ( GXutil.strcmp(AV32ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LiqLegImpTotal") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV38VisibleColumnCount), 1, 1).setNumber( (double)(DecimalUtil.decToDouble(A281LiqLegImpTotal)) );
               }
               else if ( GXutil.strcmp(AV32ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "&ErrorLiqLeg") == 0 )
               {
                  GXt_char7 = AV29ErrorLiqLeg ;
                  GXv_char8[0] = GXt_char7 ;
                  new web.liqleggeterror(remoteHandle, context).execute( A3CliCod, A1EmpCod, A31LiqNro, A6LegNumero, GXv_char8) ;
                  liquidacioneswcexport.this.GXt_char7 = GXv_char8[0] ;
                  AV29ErrorLiqLeg = GXt_char7 ;
                  GXt_char7 = "" ;
                  GXv_char8[0] = GXt_char7 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV29ErrorLiqLeg, GXv_char8) ;
                  liquidacioneswcexport.this.GXt_char7 = GXv_char8[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV38VisibleColumnCount), 1, 1).setText( GXt_char7 );
               }
               AV38VisibleColumnCount = (long)(AV38VisibleColumnCount+1) ;
            }
            AV90GXV7 = (int)(AV90GXV7+1) ;
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
      AV38VisibleColumnCount = 0 ;
      AV91GXV8 = 1 ;
      while ( AV91GXV8 <= AV30ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
      {
         AV32ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV30ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV91GXV8));
         if ( AV32ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            if ( GXutil.strcmp(AV32ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LiqLegImpTotBruto") == 0 )
            {
               AV11ExcelDocument.Cells(AV14CellRow+1, (int)(AV15FirstColumn+AV38VisibleColumnCount), 1, 1).setText( GXutil.format( "=SUM(%1%2:%1%3)", GXutil.chr( (short)(GXutil.asc( "A")+AV38VisibleColumnCount)), GXutil.trim( GXutil.str( AV21FirstDataCellRow, 8, 0)), GXutil.trim( GXutil.str( AV14CellRow, 8, 0)), "", "", "", "", "", "") );
            }
            else if ( GXutil.strcmp(AV32ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "&LiqLegImpTotDescu") == 0 )
            {
               AV11ExcelDocument.Cells(AV14CellRow+1, (int)(AV15FirstColumn+AV38VisibleColumnCount), 1, 1).setText( GXutil.format( "=SUM(%1%2:%1%3)", GXutil.chr( (short)(GXutil.asc( "A")+AV38VisibleColumnCount)), GXutil.trim( GXutil.str( AV21FirstDataCellRow, 8, 0)), GXutil.trim( GXutil.str( AV14CellRow, 8, 0)), "", "", "", "", "", "") );
            }
            else if ( GXutil.strcmp(AV32ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LiqLegImpTotRetGan") == 0 )
            {
               AV11ExcelDocument.Cells(AV14CellRow+1, (int)(AV15FirstColumn+AV38VisibleColumnCount), 1, 1).setText( GXutil.format( "=SUM(%1%2:%1%3)", GXutil.chr( (short)(GXutil.asc( "A")+AV38VisibleColumnCount)), GXutil.trim( GXutil.str( AV21FirstDataCellRow, 8, 0)), GXutil.trim( GXutil.str( AV14CellRow, 8, 0)), "", "", "", "", "", "") );
            }
            else if ( GXutil.strcmp(AV32ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LiqLegImpTotal") == 0 )
            {
               AV11ExcelDocument.Cells(AV14CellRow+1, (int)(AV15FirstColumn+AV38VisibleColumnCount), 1, 1).setText( GXutil.format( "=SUM(%1%2:%1%3)", GXutil.chr( (short)(GXutil.asc( "A")+AV38VisibleColumnCount)), GXutil.trim( GXutil.str( AV21FirstDataCellRow, 8, 0)), GXutil.trim( GXutil.str( AV14CellRow, 8, 0)), "", "", "", "", "", "") );
            }
            AV38VisibleColumnCount = (long)(AV38VisibleColumnCount+1) ;
         }
         AV91GXV8 = (int)(AV91GXV8+1) ;
      }
      AV11ExcelDocument.Cells(AV14CellRow+1, AV15FirstColumn, 1, (int)(AV38VisibleColumnCount)).setItalic( (short)(1) );
      AV11ExcelDocument.Cells(AV14CellRow+1, AV15FirstColumn, 1, (int)(AV38VisibleColumnCount)).setBold( (short)(1) );
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
      AV30ColumnsSelector = (web.wwpbaseobjects.SdtWWPColumnsSelector)new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector9[0] = AV30ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "LiqNro", "", "Número", false, "") ;
      AV30ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV30ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "LiqFecha", "", "Fecha de Liq.", false, "") ;
      AV30ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV30ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "LiqPerPalabra", "", "Periodo", false, "") ;
      AV30ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV30ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "LiqNombre", "", "Liquidación", true, "") ;
      AV30ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV30ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "LiqFecPago", "", "Fecha de Pago", false, "") ;
      AV30ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV30ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "TLiqCod", "", "Tipo", false, "") ;
      AV30ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV30ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "LiqModTra", "", "Modo de trabajo", true, "") ;
      AV30ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV30ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "LiqFrecPag", "", "Frecuencia de pago", true, "") ;
      AV30ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV30ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "LiqLegImpBasico", "", "Básico", true, "") ;
      AV30ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV30ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "LiqLegImpTotBruto", "", "Bruto", true, "") ;
      AV30ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV30ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "LiqLegImpTotBruProm", "", "Bruto Prom. sin SAC", true, "") ;
      AV30ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV30ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "LiqLegImpTotBruSinSAC", "", "Bruto sin SAC", true, "") ;
      AV30ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV30ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "&LiqLegImpTotDescu", "", "Descuentos", true, "") ;
      AV30ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV30ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "LiqLegImpTotRetGan", "", "Imp. Ganancias (Ret/Dev)", true, "") ;
      AV30ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV30ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "LiqLegImpTotal", "", "Neto", true, "") ;
      AV30ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV30ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "&ErrorLiqLeg", "", "Error", false, "") ;
      AV30ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXt_char7 = AV34UserCustomValue ;
      GXv_char8[0] = GXt_char7 ;
      new web.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "liquidacionesWCColumnsSelector", GXv_char8) ;
      liquidacioneswcexport.this.GXt_char7 = GXv_char8[0] ;
      AV34UserCustomValue = GXt_char7 ;
      if ( ! ( (GXutil.strcmp("", AV34UserCustomValue)==0) ) )
      {
         AV31ColumnsSelectorAux.fromxml(AV34UserCustomValue, null, null);
         GXv_SdtWWPColumnsSelector9[0] = AV31ColumnsSelectorAux;
         GXv_SdtWWPColumnsSelector10[0] = AV30ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnselector_updatecolumns(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, GXv_SdtWWPColumnsSelector10) ;
         AV31ColumnsSelectorAux = GXv_SdtWWPColumnsSelector9[0] ;
         AV30ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      }
   }

   public void S211( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV24Session.getValue("liquidacionesWCGridState"), "") == 0 )
      {
         AV26GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "liquidacionesWCGridState"), null, null);
      }
      else
      {
         AV26GridState.fromxml(AV24Session.getValue("liquidacionesWCGridState"), null, null);
      }
      AV22OrderedBy = AV26GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV23OrderedDsc = AV26GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV92GXV9 = 1 ;
      while ( AV92GXV9 <= AV26GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV27GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV26GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV92GXV9));
         if ( GXutil.strcmp(AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQNRO") == 0 )
         {
            AV41TFLiqNro = (int)(GXutil.lval( AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV42TFLiqNro_To = (int)(GXutil.lval( AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQFECHA") == 0 )
         {
            AV43TFLiqFecha = localUtil.ctod( AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            AV44TFLiqFecha_To = localUtil.ctod( AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
         }
         else if ( GXutil.strcmp(AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQPERPALABRA") == 0 )
         {
            AV46TFLiqPerPalabra = AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQPERPALABRA_SEL") == 0 )
         {
            AV45TFLiqPerPalabra_SelsJson = AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV47TFLiqPerPalabra_Sels.fromJSonString(AV45TFLiqPerPalabra_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQNOMBRE") == 0 )
         {
            AV50TFLiqNombre = AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQNOMBRE_SEL") == 0 )
         {
            AV49TFLiqNombre_SelsJson = AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV51TFLiqNombre_Sels.fromJSonString(AV49TFLiqNombre_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQFECPAGO") == 0 )
         {
            AV53TFLiqFecPago = localUtil.ctod( AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            AV54TFLiqFecPago_To = localUtil.ctod( AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
         }
         else if ( GXutil.strcmp(AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFTLIQCOD") == 0 )
         {
            AV56TFTLiqCod = AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFTLIQCOD_SEL") == 0 )
         {
            AV55TFTLiqCod_SelsJson = AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV57TFTLiqCod_Sels.fromJSonString(AV55TFTLiqCod_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQMODTRA_SEL") == 0 )
         {
            AV74TFLiqModTra_SelsJson = AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV75TFLiqModTra_Sels.fromJSonString(AV74TFLiqModTra_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQFRECPAG_SEL") == 0 )
         {
            AV77TFLiqFrecPag_SelsJson = AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV78TFLiqFrecPag_Sels.fromJSonString(AV77TFLiqFrecPag_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQLEGIMPBASICO") == 0 )
         {
            AV62TFLiqLegImpBasico = CommonUtil.decimalVal( AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV63TFLiqLegImpBasico_To = CommonUtil.decimalVal( AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQLEGIMPTOTBRUTO") == 0 )
         {
            AV64TFLiqLegImpTotBruto = CommonUtil.decimalVal( AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV65TFLiqLegImpTotBruto_To = CommonUtil.decimalVal( AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQLEGIMPTOTBRUPROM") == 0 )
         {
            AV66TFLiqLegImpTotBruProm = CommonUtil.decimalVal( AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV67TFLiqLegImpTotBruProm_To = CommonUtil.decimalVal( AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQLEGIMPTOTBRUSINSAC") == 0 )
         {
            AV68TFLiqLegImpTotBruSinSAC = CommonUtil.decimalVal( AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV69TFLiqLegImpTotBruSinSAC_To = CommonUtil.decimalVal( AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQLEGIMPTOTRETGAN") == 0 )
         {
            AV70TFLiqLegImpTotRetGan = CommonUtil.decimalVal( AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV71TFLiqLegImpTotRetGan_To = CommonUtil.decimalVal( AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&CLICOD") == 0 )
         {
            AV17CliCod = (int)(GXutil.lval( AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&EMPCOD") == 0 )
         {
            AV18EmpCod = (short)(GXutil.lval( AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&LEGNUMERO") == 0 )
         {
            AV20LegNumero = (int)(GXutil.lval( AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         AV92GXV9 = (int)(AV92GXV9+1) ;
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
      this.aP0[0] = liquidacioneswcexport.this.AV12Filename;
      this.aP1[0] = liquidacioneswcexport.this.AV13ErrorMessage;
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
      AV82Pgmname = "" ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV11ExcelDocument = new com.genexus.gxoffice.ExcelDoc();
      AV43TFLiqFecha = GXutil.nullDate() ;
      AV44TFLiqFecha_To = GXutil.nullDate() ;
      AV47TFLiqPerPalabra_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV48TFLiqPerPalabra_Sel = "" ;
      AV46TFLiqPerPalabra = "" ;
      AV51TFLiqNombre_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV52TFLiqNombre_Sel = "" ;
      AV50TFLiqNombre = "" ;
      AV53TFLiqFecPago = GXutil.nullDate() ;
      AV54TFLiqFecPago_To = GXutil.nullDate() ;
      AV57TFTLiqCod_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV58TFTLiqCod_Sel = "" ;
      AV72TFTLiqCod_SelDsc = "" ;
      AV56TFTLiqCod = "" ;
      AV75TFLiqModTra_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV76TFLiqModTra_Sel = "" ;
      AV78TFLiqFrecPag_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV62TFLiqLegImpBasico = DecimalUtil.ZERO ;
      AV63TFLiqLegImpBasico_To = DecimalUtil.ZERO ;
      AV64TFLiqLegImpTotBruto = DecimalUtil.ZERO ;
      AV65TFLiqLegImpTotBruto_To = DecimalUtil.ZERO ;
      AV66TFLiqLegImpTotBruProm = DecimalUtil.ZERO ;
      AV67TFLiqLegImpTotBruProm_To = DecimalUtil.ZERO ;
      AV68TFLiqLegImpTotBruSinSAC = DecimalUtil.ZERO ;
      AV69TFLiqLegImpTotBruSinSAC_To = DecimalUtil.ZERO ;
      AV70TFLiqLegImpTotRetGan = DecimalUtil.ZERO ;
      AV71TFLiqLegImpTotRetGan_To = DecimalUtil.ZERO ;
      GXv_exceldoc4 = new com.genexus.gxoffice.ExcelDoc[1] ;
      GXv_int5 = new short[1] ;
      AV24Session = httpContext.getWebSession();
      AV33ColumnsSelectorXML = "" ;
      AV30ColumnsSelector = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV32ColumnsSelector_Column = new web.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      scmdbuf = "" ;
      lV46TFLiqPerPalabra = "" ;
      lV50TFLiqNombre = "" ;
      lV56TFTLiqCod = "" ;
      A748LiqPerPalabra = "" ;
      A874LiqNombre = "" ;
      A32TLiqCod = "" ;
      A2409LiqModTra = "" ;
      A98LiqFecha = GXutil.nullDate() ;
      A280LiqFecPago = GXutil.nullDate() ;
      A340TliqDesc = "" ;
      A760LiqLegImpBasico = DecimalUtil.ZERO ;
      A498LiqLegImpTotBruto = DecimalUtil.ZERO ;
      A758LiqLegImpTotBruProm = DecimalUtil.ZERO ;
      A759LiqLegImpTotBruSinSAC = DecimalUtil.ZERO ;
      A757LiqLegImpTotRetGan = DecimalUtil.ZERO ;
      P01QP2_A757LiqLegImpTotRetGan = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01QP2_A759LiqLegImpTotBruSinSAC = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01QP2_A758LiqLegImpTotBruProm = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01QP2_A498LiqLegImpTotBruto = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01QP2_A760LiqLegImpBasico = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01QP2_A2414LiqFrecPag = new byte[1] ;
      P01QP2_A2409LiqModTra = new String[] {""} ;
      P01QP2_A32TLiqCod = new String[] {""} ;
      P01QP2_n32TLiqCod = new boolean[] {false} ;
      P01QP2_A340TliqDesc = new String[] {""} ;
      P01QP2_A280LiqFecPago = new java.util.Date[] {GXutil.nullDate()} ;
      P01QP2_A874LiqNombre = new String[] {""} ;
      P01QP2_A748LiqPerPalabra = new String[] {""} ;
      P01QP2_A98LiqFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P01QP2_A31LiqNro = new int[1] ;
      P01QP2_A6LegNumero = new int[1] ;
      P01QP2_A1EmpCod = new short[1] ;
      P01QP2_A3CliCod = new int[1] ;
      P01QP2_A579LiqLegImpTotDescu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01QP2_A281LiqLegImpTotal = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      A579LiqLegImpTotDescu = DecimalUtil.ZERO ;
      A281LiqLegImpTotal = DecimalUtil.ZERO ;
      GXt_dtime6 = GXutil.resetTime( GXutil.nullDate() );
      AV28LiqLegImpTotDescu = DecimalUtil.ZERO ;
      AV29ErrorLiqLeg = "" ;
      AV34UserCustomValue = "" ;
      GXt_char7 = "" ;
      GXv_char8 = new String[1] ;
      AV31ColumnsSelectorAux = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector9 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector10 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      AV26GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV27GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV45TFLiqPerPalabra_SelsJson = "" ;
      AV49TFLiqNombre_SelsJson = "" ;
      AV55TFTLiqCod_SelsJson = "" ;
      AV74TFLiqModTra_SelsJson = "" ;
      AV77TFLiqFrecPag_SelsJson = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.liquidacioneswcexport__default(),
         new Object[] {
             new Object[] {
            P01QP2_A757LiqLegImpTotRetGan, P01QP2_A759LiqLegImpTotBruSinSAC, P01QP2_A758LiqLegImpTotBruProm, P01QP2_A498LiqLegImpTotBruto, P01QP2_A760LiqLegImpBasico, P01QP2_A2414LiqFrecPag, P01QP2_A2409LiqModTra, P01QP2_A32TLiqCod, P01QP2_n32TLiqCod, P01QP2_A340TliqDesc,
            P01QP2_A280LiqFecPago, P01QP2_A874LiqNombre, P01QP2_A748LiqPerPalabra, P01QP2_A98LiqFecha, P01QP2_A31LiqNro, P01QP2_A6LegNumero, P01QP2_A1EmpCod, P01QP2_A3CliCod, P01QP2_A579LiqLegImpTotDescu, P01QP2_A281LiqLegImpTotal
            }
         }
      );
      AV82Pgmname = "liquidacionesWCExport" ;
      /* GeneXus formulas. */
      AV82Pgmname = "liquidacionesWCExport" ;
      Gx_err = (short)(0) ;
   }

   private byte AV79TFLiqFrecPag_Sel ;
   private byte A2414LiqFrecPag ;
   private short GXv_int5[] ;
   private short AV22OrderedBy ;
   private short AV18EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV14CellRow ;
   private int AV15FirstColumn ;
   private int AV16Random ;
   private int AV41TFLiqNro ;
   private int AV42TFLiqNro_To ;
   private int AV83GXV1 ;
   private int AV84GXV2 ;
   private int AV85GXV3 ;
   private int AV86GXV4 ;
   private int AV87GXV5 ;
   private int AV88GXV6 ;
   private int AV21FirstDataCellRow ;
   private int AV47TFLiqPerPalabra_Sels_size ;
   private int AV51TFLiqNombre_Sels_size ;
   private int AV57TFTLiqCod_Sels_size ;
   private int AV75TFLiqModTra_Sels_size ;
   private int AV78TFLiqFrecPag_Sels_size ;
   private int A31LiqNro ;
   private int AV17CliCod ;
   private int AV20LegNumero ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private int AV90GXV7 ;
   private int AV91GXV8 ;
   private int AV92GXV9 ;
   private long AV73i ;
   private long AV38VisibleColumnCount ;
   private java.math.BigDecimal AV62TFLiqLegImpBasico ;
   private java.math.BigDecimal AV63TFLiqLegImpBasico_To ;
   private java.math.BigDecimal AV64TFLiqLegImpTotBruto ;
   private java.math.BigDecimal AV65TFLiqLegImpTotBruto_To ;
   private java.math.BigDecimal AV66TFLiqLegImpTotBruProm ;
   private java.math.BigDecimal AV67TFLiqLegImpTotBruProm_To ;
   private java.math.BigDecimal AV68TFLiqLegImpTotBruSinSAC ;
   private java.math.BigDecimal AV69TFLiqLegImpTotBruSinSAC_To ;
   private java.math.BigDecimal AV70TFLiqLegImpTotRetGan ;
   private java.math.BigDecimal AV71TFLiqLegImpTotRetGan_To ;
   private java.math.BigDecimal A760LiqLegImpBasico ;
   private java.math.BigDecimal A498LiqLegImpTotBruto ;
   private java.math.BigDecimal A758LiqLegImpTotBruProm ;
   private java.math.BigDecimal A759LiqLegImpTotBruSinSAC ;
   private java.math.BigDecimal A757LiqLegImpTotRetGan ;
   private java.math.BigDecimal A579LiqLegImpTotDescu ;
   private java.math.BigDecimal A281LiqLegImpTotal ;
   private java.math.BigDecimal AV28LiqLegImpTotDescu ;
   private String AV82Pgmname ;
   private String AV48TFLiqPerPalabra_Sel ;
   private String AV46TFLiqPerPalabra ;
   private String AV58TFTLiqCod_Sel ;
   private String AV76TFLiqModTra_Sel ;
   private String scmdbuf ;
   private String lV46TFLiqPerPalabra ;
   private String A748LiqPerPalabra ;
   private String A32TLiqCod ;
   private String A2409LiqModTra ;
   private String GXt_char7 ;
   private String GXv_char8[] ;
   private java.util.Date GXt_dtime6 ;
   private java.util.Date AV43TFLiqFecha ;
   private java.util.Date AV44TFLiqFecha_To ;
   private java.util.Date AV53TFLiqFecPago ;
   private java.util.Date AV54TFLiqFecPago_To ;
   private java.util.Date A98LiqFecha ;
   private java.util.Date A280LiqFecPago ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean AV23OrderedDsc ;
   private boolean n32TLiqCod ;
   private String AV33ColumnsSelectorXML ;
   private String AV34UserCustomValue ;
   private String AV45TFLiqPerPalabra_SelsJson ;
   private String AV49TFLiqNombre_SelsJson ;
   private String AV55TFTLiqCod_SelsJson ;
   private String AV74TFLiqModTra_SelsJson ;
   private String AV77TFLiqFrecPag_SelsJson ;
   private String AV12Filename ;
   private String AV13ErrorMessage ;
   private String AV52TFLiqNombre_Sel ;
   private String AV50TFLiqNombre ;
   private String AV72TFTLiqCod_SelDsc ;
   private String AV56TFTLiqCod ;
   private String lV50TFLiqNombre ;
   private String lV56TFTLiqCod ;
   private String A874LiqNombre ;
   private String A340TliqDesc ;
   private String AV29ErrorLiqLeg ;
   private GXSimpleCollection<Byte> AV78TFLiqFrecPag_Sels ;
   private com.genexus.webpanels.WebSession AV24Session ;
   private GXSimpleCollection<String> AV47TFLiqPerPalabra_Sels ;
   private GXSimpleCollection<String> AV57TFTLiqCod_Sels ;
   private GXSimpleCollection<String> AV75TFLiqModTra_Sels ;
   private GXSimpleCollection<String> AV51TFLiqNombre_Sels ;
   private String[] aP1 ;
   private String[] aP0 ;
   private IDataStoreProvider pr_default ;
   private java.math.BigDecimal[] P01QP2_A757LiqLegImpTotRetGan ;
   private java.math.BigDecimal[] P01QP2_A759LiqLegImpTotBruSinSAC ;
   private java.math.BigDecimal[] P01QP2_A758LiqLegImpTotBruProm ;
   private java.math.BigDecimal[] P01QP2_A498LiqLegImpTotBruto ;
   private java.math.BigDecimal[] P01QP2_A760LiqLegImpBasico ;
   private byte[] P01QP2_A2414LiqFrecPag ;
   private String[] P01QP2_A2409LiqModTra ;
   private String[] P01QP2_A32TLiqCod ;
   private boolean[] P01QP2_n32TLiqCod ;
   private String[] P01QP2_A340TliqDesc ;
   private java.util.Date[] P01QP2_A280LiqFecPago ;
   private String[] P01QP2_A874LiqNombre ;
   private String[] P01QP2_A748LiqPerPalabra ;
   private java.util.Date[] P01QP2_A98LiqFecha ;
   private int[] P01QP2_A31LiqNro ;
   private int[] P01QP2_A6LegNumero ;
   private short[] P01QP2_A1EmpCod ;
   private int[] P01QP2_A3CliCod ;
   private java.math.BigDecimal[] P01QP2_A579LiqLegImpTotDescu ;
   private java.math.BigDecimal[] P01QP2_A281LiqLegImpTotal ;
   private com.genexus.gxoffice.ExcelDoc AV11ExcelDocument ;
   private com.genexus.gxoffice.ExcelDoc GXv_exceldoc4[] ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV26GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV27GridStateFilterValue ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV30ColumnsSelector ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV31ColumnsSelectorAux ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector9[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector10[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector_Column AV32ColumnsSelector_Column ;
}

final  class liquidacioneswcexport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01QP2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A748LiqPerPalabra ,
                                          GXSimpleCollection<String> AV47TFLiqPerPalabra_Sels ,
                                          String A874LiqNombre ,
                                          GXSimpleCollection<String> AV51TFLiqNombre_Sels ,
                                          String A32TLiqCod ,
                                          GXSimpleCollection<String> AV57TFTLiqCod_Sels ,
                                          String A2409LiqModTra ,
                                          GXSimpleCollection<String> AV75TFLiqModTra_Sels ,
                                          byte A2414LiqFrecPag ,
                                          GXSimpleCollection<Byte> AV78TFLiqFrecPag_Sels ,
                                          int AV41TFLiqNro ,
                                          int AV42TFLiqNro_To ,
                                          java.util.Date AV43TFLiqFecha ,
                                          java.util.Date AV44TFLiqFecha_To ,
                                          int AV47TFLiqPerPalabra_Sels_size ,
                                          String AV46TFLiqPerPalabra ,
                                          int AV51TFLiqNombre_Sels_size ,
                                          String AV50TFLiqNombre ,
                                          java.util.Date AV53TFLiqFecPago ,
                                          java.util.Date AV54TFLiqFecPago_To ,
                                          int AV57TFTLiqCod_Sels_size ,
                                          String AV56TFTLiqCod ,
                                          int AV75TFLiqModTra_Sels_size ,
                                          int AV78TFLiqFrecPag_Sels_size ,
                                          java.math.BigDecimal AV62TFLiqLegImpBasico ,
                                          java.math.BigDecimal AV63TFLiqLegImpBasico_To ,
                                          java.math.BigDecimal AV64TFLiqLegImpTotBruto ,
                                          java.math.BigDecimal AV65TFLiqLegImpTotBruto_To ,
                                          java.math.BigDecimal AV66TFLiqLegImpTotBruProm ,
                                          java.math.BigDecimal AV67TFLiqLegImpTotBruProm_To ,
                                          java.math.BigDecimal AV68TFLiqLegImpTotBruSinSAC ,
                                          java.math.BigDecimal AV69TFLiqLegImpTotBruSinSAC_To ,
                                          java.math.BigDecimal AV70TFLiqLegImpTotRetGan ,
                                          java.math.BigDecimal AV71TFLiqLegImpTotRetGan_To ,
                                          int A31LiqNro ,
                                          java.util.Date A98LiqFecha ,
                                          java.util.Date A280LiqFecPago ,
                                          String A340TliqDesc ,
                                          java.math.BigDecimal A760LiqLegImpBasico ,
                                          java.math.BigDecimal A498LiqLegImpTotBruto ,
                                          java.math.BigDecimal A758LiqLegImpTotBruProm ,
                                          java.math.BigDecimal A759LiqLegImpTotBruSinSAC ,
                                          java.math.BigDecimal A757LiqLegImpTotRetGan ,
                                          short AV22OrderedBy ,
                                          boolean AV23OrderedDsc ,
                                          int AV17CliCod ,
                                          short AV18EmpCod ,
                                          int AV20LegNumero ,
                                          int A3CliCod ,
                                          short A1EmpCod ,
                                          int A6LegNumero )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int11 = new byte[22];
      Object[] GXv_Object12 = new Object[2];
      scmdbuf = "SELECT T1.LiqLegImpTotRetGan, T1.LiqLegImpTotBruSinSAC, T1.LiqLegImpTotBruProm, T1.LiqLegImpTotBruto, T1.LiqLegImpBasico, T2.LiqFrecPag, T2.LiqModTra, T1.TLiqCod," ;
      scmdbuf += " T3.TliqDesc, T2.LiqFecPago, T2.LiqNombre, T2.LiqPerPalabra, T2.LiqFecha, T1.LiqNro, T1.LegNumero, T1.EmpCod, T1.CliCod, T1.LiqLegImpTotDescu, T1.LiqLegImpTotal" ;
      scmdbuf += " FROM ((LiquidacionLegajo T1 INNER JOIN Liquidacion T2 ON T2.CliCod = T1.CliCod AND T2.EmpCod = T1.EmpCod AND T2.LiqNro = T1.LiqNro) LEFT JOIN TipoLiquidacion T3" ;
      scmdbuf += " ON T3.CliCod = T1.CliCod AND T3.TLiqCod = T1.TLiqCod)" ;
      addWhere(sWhereString, "(T1.CliCod = ? and T1.EmpCod = ? and T1.LegNumero = ?)");
      if ( ! (0==AV41TFLiqNro) )
      {
         addWhere(sWhereString, "(T1.LiqNro >= ?)");
      }
      else
      {
         GXv_int11[3] = (byte)(1) ;
      }
      if ( ! (0==AV42TFLiqNro_To) )
      {
         addWhere(sWhereString, "(T1.LiqNro <= ?)");
      }
      else
      {
         GXv_int11[4] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV43TFLiqFecha)) )
      {
         addWhere(sWhereString, "(T2.LiqFecha >= ?)");
      }
      else
      {
         GXv_int11[5] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV44TFLiqFecha_To)) )
      {
         addWhere(sWhereString, "(T2.LiqFecha <= ?)");
      }
      else
      {
         GXv_int11[6] = (byte)(1) ;
      }
      if ( ( AV47TFLiqPerPalabra_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV46TFLiqPerPalabra)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.LiqPerPalabra) like LOWER(?))");
      }
      else
      {
         GXv_int11[7] = (byte)(1) ;
      }
      if ( AV47TFLiqPerPalabra_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV47TFLiqPerPalabra_Sels, "T2.LiqPerPalabra IN (", ")")+")");
      }
      if ( ( AV51TFLiqNombre_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV50TFLiqNombre)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.LiqNombre) like LOWER(?))");
      }
      else
      {
         GXv_int11[8] = (byte)(1) ;
      }
      if ( AV51TFLiqNombre_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV51TFLiqNombre_Sels, "T2.LiqNombre IN (", ")")+")");
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV53TFLiqFecPago)) )
      {
         addWhere(sWhereString, "(T2.LiqFecPago >= ?)");
      }
      else
      {
         GXv_int11[9] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV54TFLiqFecPago_To)) )
      {
         addWhere(sWhereString, "(T2.LiqFecPago <= ?)");
      }
      else
      {
         GXv_int11[10] = (byte)(1) ;
      }
      if ( ( AV57TFTLiqCod_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV56TFTLiqCod)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T3.TliqDesc) like LOWER(?))");
      }
      else
      {
         GXv_int11[11] = (byte)(1) ;
      }
      if ( AV57TFTLiqCod_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV57TFTLiqCod_Sels, "T1.TLiqCod IN (", ")")+")");
      }
      if ( AV75TFLiqModTra_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV75TFLiqModTra_Sels, "T2.LiqModTra IN (", ")")+")");
      }
      if ( AV78TFLiqFrecPag_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV78TFLiqFrecPag_Sels, "T2.LiqFrecPag IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV62TFLiqLegImpBasico)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpBasico >= ?)");
      }
      else
      {
         GXv_int11[12] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV63TFLiqLegImpBasico_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpBasico <= ?)");
      }
      else
      {
         GXv_int11[13] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV64TFLiqLegImpTotBruto)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpTotBruto >= ?)");
      }
      else
      {
         GXv_int11[14] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV65TFLiqLegImpTotBruto_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpTotBruto <= ?)");
      }
      else
      {
         GXv_int11[15] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV66TFLiqLegImpTotBruProm)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpTotBruProm >= ?)");
      }
      else
      {
         GXv_int11[16] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV67TFLiqLegImpTotBruProm_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpTotBruProm <= ?)");
      }
      else
      {
         GXv_int11[17] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV68TFLiqLegImpTotBruSinSAC)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpTotBruSinSAC >= ?)");
      }
      else
      {
         GXv_int11[18] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV69TFLiqLegImpTotBruSinSAC_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpTotBruSinSAC <= ?)");
      }
      else
      {
         GXv_int11[19] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV70TFLiqLegImpTotRetGan)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpTotRetGan >= ?)");
      }
      else
      {
         GXv_int11[20] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV71TFLiqLegImpTotRetGan_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpTotRetGan <= ?)");
      }
      else
      {
         GXv_int11[21] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      if ( AV22OrderedBy == 1 )
      {
         scmdbuf += " ORDER BY T1.CliCod, T1.EmpCod, T1.LegNumero, T1.LiqNro DESC" ;
      }
      else if ( ( AV22OrderedBy == 2 ) && ! AV23OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.CliCod, T1.EmpCod, T1.LegNumero, T1.LiqNro" ;
      }
      else if ( ( AV22OrderedBy == 2 ) && ( AV23OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.CliCod DESC, T1.EmpCod DESC, T1.LegNumero DESC, T1.LiqNro DESC" ;
      }
      else if ( ( AV22OrderedBy == 3 ) && ! AV23OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.CliCod, T1.EmpCod, T1.LegNumero, T2.LiqFecha" ;
      }
      else if ( ( AV22OrderedBy == 3 ) && ( AV23OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.CliCod DESC, T1.EmpCod DESC, T1.LegNumero DESC, T2.LiqFecha DESC" ;
      }
      else if ( ( AV22OrderedBy == 4 ) && ! AV23OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.CliCod, T1.EmpCod, T1.LegNumero, T2.LiqPerPalabra" ;
      }
      else if ( ( AV22OrderedBy == 4 ) && ( AV23OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.CliCod DESC, T1.EmpCod DESC, T1.LegNumero DESC, T2.LiqPerPalabra DESC" ;
      }
      else if ( ( AV22OrderedBy == 5 ) && ! AV23OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.CliCod, T1.EmpCod, T1.LegNumero, T2.LiqNombre" ;
      }
      else if ( ( AV22OrderedBy == 5 ) && ( AV23OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.CliCod DESC, T1.EmpCod DESC, T1.LegNumero DESC, T2.LiqNombre DESC" ;
      }
      else if ( ( AV22OrderedBy == 6 ) && ! AV23OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.CliCod, T1.EmpCod, T1.LegNumero, T2.LiqFecPago" ;
      }
      else if ( ( AV22OrderedBy == 6 ) && ( AV23OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.CliCod DESC, T1.EmpCod DESC, T1.LegNumero DESC, T2.LiqFecPago DESC" ;
      }
      else if ( ( AV22OrderedBy == 7 ) && ! AV23OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.CliCod, T1.EmpCod, T1.LegNumero, T1.TLiqCod" ;
      }
      else if ( ( AV22OrderedBy == 7 ) && ( AV23OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.CliCod DESC, T1.EmpCod DESC, T1.LegNumero DESC, T1.TLiqCod DESC" ;
      }
      else if ( ( AV22OrderedBy == 8 ) && ! AV23OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.CliCod, T1.EmpCod, T1.LegNumero, T2.LiqModTra" ;
      }
      else if ( ( AV22OrderedBy == 8 ) && ( AV23OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.CliCod DESC, T1.EmpCod DESC, T1.LegNumero DESC, T2.LiqModTra DESC" ;
      }
      else if ( ( AV22OrderedBy == 9 ) && ! AV23OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.CliCod, T1.EmpCod, T1.LegNumero, T2.LiqFrecPag" ;
      }
      else if ( ( AV22OrderedBy == 9 ) && ( AV23OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.CliCod DESC, T1.EmpCod DESC, T1.LegNumero DESC, T2.LiqFrecPag DESC" ;
      }
      else if ( ( AV22OrderedBy == 10 ) && ! AV23OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.CliCod, T1.EmpCod, T1.LegNumero, T1.LiqLegImpBasico" ;
      }
      else if ( ( AV22OrderedBy == 10 ) && ( AV23OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.CliCod DESC, T1.EmpCod DESC, T1.LegNumero DESC, T1.LiqLegImpBasico DESC" ;
      }
      else if ( ( AV22OrderedBy == 11 ) && ! AV23OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.CliCod, T1.EmpCod, T1.LegNumero, T1.LiqLegImpTotBruto" ;
      }
      else if ( ( AV22OrderedBy == 11 ) && ( AV23OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.CliCod DESC, T1.EmpCod DESC, T1.LegNumero DESC, T1.LiqLegImpTotBruto DESC" ;
      }
      else if ( ( AV22OrderedBy == 12 ) && ! AV23OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.CliCod, T1.EmpCod, T1.LegNumero, T1.LiqLegImpTotBruProm" ;
      }
      else if ( ( AV22OrderedBy == 12 ) && ( AV23OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.CliCod DESC, T1.EmpCod DESC, T1.LegNumero DESC, T1.LiqLegImpTotBruProm DESC" ;
      }
      else if ( ( AV22OrderedBy == 13 ) && ! AV23OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.CliCod, T1.EmpCod, T1.LegNumero, T1.LiqLegImpTotBruSinSAC" ;
      }
      else if ( ( AV22OrderedBy == 13 ) && ( AV23OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.CliCod DESC, T1.EmpCod DESC, T1.LegNumero DESC, T1.LiqLegImpTotBruSinSAC DESC" ;
      }
      else if ( ( AV22OrderedBy == 14 ) && ! AV23OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.CliCod, T1.EmpCod, T1.LegNumero, T1.LiqLegImpTotRetGan" ;
      }
      else if ( ( AV22OrderedBy == 14 ) && ( AV23OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.CliCod DESC, T1.EmpCod DESC, T1.LegNumero DESC, T1.LiqLegImpTotRetGan DESC" ;
      }
      else if ( ( AV22OrderedBy == 15 ) && ! AV23OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.CliCod, T1.EmpCod, T1.LegNumero, T1.LiqLegImpTotal" ;
      }
      else if ( ( AV22OrderedBy == 15 ) && ( AV23OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.CliCod DESC, T1.EmpCod DESC, T1.LegNumero DESC, T1.LiqLegImpTotal DESC" ;
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
                  return conditional_P01QP2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , ((Number) dynConstraints[8]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[9] , ((Number) dynConstraints[10]).intValue() , ((Number) dynConstraints[11]).intValue() , (java.util.Date)dynConstraints[12] , (java.util.Date)dynConstraints[13] , ((Number) dynConstraints[14]).intValue() , (String)dynConstraints[15] , ((Number) dynConstraints[16]).intValue() , (String)dynConstraints[17] , (java.util.Date)dynConstraints[18] , (java.util.Date)dynConstraints[19] , ((Number) dynConstraints[20]).intValue() , (String)dynConstraints[21] , ((Number) dynConstraints[22]).intValue() , ((Number) dynConstraints[23]).intValue() , (java.math.BigDecimal)dynConstraints[24] , (java.math.BigDecimal)dynConstraints[25] , (java.math.BigDecimal)dynConstraints[26] , (java.math.BigDecimal)dynConstraints[27] , (java.math.BigDecimal)dynConstraints[28] , (java.math.BigDecimal)dynConstraints[29] , (java.math.BigDecimal)dynConstraints[30] , (java.math.BigDecimal)dynConstraints[31] , (java.math.BigDecimal)dynConstraints[32] , (java.math.BigDecimal)dynConstraints[33] , ((Number) dynConstraints[34]).intValue() , (java.util.Date)dynConstraints[35] , (java.util.Date)dynConstraints[36] , (String)dynConstraints[37] , (java.math.BigDecimal)dynConstraints[38] , (java.math.BigDecimal)dynConstraints[39] , (java.math.BigDecimal)dynConstraints[40] , (java.math.BigDecimal)dynConstraints[41] , (java.math.BigDecimal)dynConstraints[42] , ((Number) dynConstraints[43]).shortValue() , ((Boolean) dynConstraints[44]).booleanValue() , ((Number) dynConstraints[45]).intValue() , ((Number) dynConstraints[46]).shortValue() , ((Number) dynConstraints[47]).intValue() , ((Number) dynConstraints[48]).intValue() , ((Number) dynConstraints[49]).shortValue() , ((Number) dynConstraints[50]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01QP2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((java.math.BigDecimal[]) buf[0])[0] = rslt.getBigDecimal(1,2);
               ((java.math.BigDecimal[]) buf[1])[0] = rslt.getBigDecimal(2,2);
               ((java.math.BigDecimal[]) buf[2])[0] = rslt.getBigDecimal(3,2);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,2);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,2);
               ((byte[]) buf[5])[0] = rslt.getByte(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 1);
               ((String[]) buf[7])[0] = rslt.getString(8, 20);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((String[]) buf[9])[0] = rslt.getVarchar(9);
               ((java.util.Date[]) buf[10])[0] = rslt.getGXDate(10);
               ((String[]) buf[11])[0] = rslt.getVarchar(11);
               ((String[]) buf[12])[0] = rslt.getString(12, 20);
               ((java.util.Date[]) buf[13])[0] = rslt.getGXDate(13);
               ((int[]) buf[14])[0] = rslt.getInt(14);
               ((int[]) buf[15])[0] = rslt.getInt(15);
               ((short[]) buf[16])[0] = rslt.getShort(16);
               ((int[]) buf[17])[0] = rslt.getInt(17);
               ((java.math.BigDecimal[]) buf[18])[0] = rslt.getBigDecimal(18,2);
               ((java.math.BigDecimal[]) buf[19])[0] = rslt.getBigDecimal(19,2);
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
                  stmt.setInt(sIdx, ((Number) parms[22]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[23]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[24]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[25]).intValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[26]).intValue());
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[27]);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[28]);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[29], 20);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[30], 400);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[31]);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[32]);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[33], 30);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[34], 2);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[35], 2);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[36], 2);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[37], 2);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[38], 2);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[39], 2);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[40], 2);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[41], 2);
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[42], 2);
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[43], 2);
               }
               return;
      }
   }

}

