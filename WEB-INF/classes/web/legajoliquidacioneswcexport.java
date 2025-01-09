package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class legajoliquidacioneswcexport extends GXProcedure
{
   public legajoliquidacioneswcexport( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( legajoliquidacioneswcexport.class ), "" );
   }

   public legajoliquidacioneswcexport( int remoteHandle ,
                                       ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String[] aP0 )
   {
      legajoliquidacioneswcexport.this.aP1 = new String[] {""};
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
      legajoliquidacioneswcexport.this.aP0 = aP0;
      legajoliquidacioneswcexport.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWLegajo", GXv_boolean2) ;
      legajoliquidacioneswcexport.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( ! AV8IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV76Pgmname))}, new String[] {"GxObject"}) );
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
      AV12Filename = "LegajoLiquidacionesWCExport-" + GXutil.trim( GXutil.str( AV16Random, 8, 0)) + ".xlsx" ;
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
      if ( ! ( (0==AV40TFLiqNro) && (0==AV41TFLiqNro_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Número", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         legajoliquidacioneswcexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV40TFLiqNro );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         legajoliquidacioneswcexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV41TFLiqNro_To );
      }
      if ( ! ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV42TFLiqFecha)) && GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV43TFLiqFecha_To)) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Fecha de Liq.", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         legajoliquidacioneswcexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_dtime6 = GXutil.resetTime( AV42TFLiqFecha );
         AV11ExcelDocument.setDateFormat(localUtil, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " ");
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setDate( GXt_dtime6 );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         legajoliquidacioneswcexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_dtime6 = GXutil.resetTime( AV43TFLiqFecha_To );
         AV11ExcelDocument.setDateFormat(localUtil, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " ");
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setDate( GXt_dtime6 );
      }
      if ( ! ( ( AV46TFLiqPerPalabra_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Periodo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         legajoliquidacioneswcexport.this.AV14CellRow = GXv_int5[0] ;
         AV62i = 1 ;
         AV77GXV1 = 1 ;
         while ( AV77GXV1 <= AV46TFLiqPerPalabra_Sels.size() )
         {
            AV47TFLiqPerPalabra_Sel = (String)AV46TFLiqPerPalabra_Sels.elementAt(-1+AV77GXV1) ;
            if ( AV62i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char7 = "" ;
            GXv_char8[0] = GXt_char7 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV47TFLiqPerPalabra_Sel, GXv_char8) ;
            legajoliquidacioneswcexport.this.GXt_char7 = GXv_char8[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char7 );
            AV62i = (long)(AV62i+1) ;
            AV77GXV1 = (int)(AV77GXV1+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV45TFLiqPerPalabra)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Periodo", "")) ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            legajoliquidacioneswcexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char7 = "" ;
            GXv_char8[0] = GXt_char7 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV45TFLiqPerPalabra, GXv_char8) ;
            legajoliquidacioneswcexport.this.GXt_char7 = GXv_char8[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char7 );
         }
      }
      if ( ! ( ( AV71TFLiqNombre_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Liquidación", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         legajoliquidacioneswcexport.this.AV14CellRow = GXv_int5[0] ;
         AV62i = 1 ;
         AV78GXV2 = 1 ;
         while ( AV78GXV2 <= AV71TFLiqNombre_Sels.size() )
         {
            AV72TFLiqNombre_Sel = (String)AV71TFLiqNombre_Sels.elementAt(-1+AV78GXV2) ;
            if ( AV62i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char7 = "" ;
            GXv_char8[0] = GXt_char7 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV72TFLiqNombre_Sel, GXv_char8) ;
            legajoliquidacioneswcexport.this.GXt_char7 = GXv_char8[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char7 );
            AV62i = (long)(AV62i+1) ;
            AV78GXV2 = (int)(AV78GXV2+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV70TFLiqNombre)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Liquidación", "")) ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            legajoliquidacioneswcexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char7 = "" ;
            GXv_char8[0] = GXt_char7 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV70TFLiqNombre, GXv_char8) ;
            legajoliquidacioneswcexport.this.GXt_char7 = GXv_char8[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char7 );
         }
      }
      if ( ! ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV48TFLiqFecPago)) && GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV49TFLiqFecPago_To)) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Fecha de Pago", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         legajoliquidacioneswcexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_dtime6 = GXutil.resetTime( AV48TFLiqFecPago );
         AV11ExcelDocument.setDateFormat(localUtil, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " ");
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setDate( GXt_dtime6 );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         legajoliquidacioneswcexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_dtime6 = GXutil.resetTime( AV49TFLiqFecPago_To );
         AV11ExcelDocument.setDateFormat(localUtil, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " ");
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setDate( GXt_dtime6 );
      }
      if ( ! ( ( AV52TFTLiqCod_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Tipo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         legajoliquidacioneswcexport.this.AV14CellRow = GXv_int5[0] ;
         AV62i = 1 ;
         AV79GXV3 = 1 ;
         while ( AV79GXV3 <= AV52TFTLiqCod_Sels.size() )
         {
            AV53TFTLiqCod_Sel = (String)AV52TFTLiqCod_Sels.elementAt(-1+AV79GXV3) ;
            if ( AV62i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV61TFTLiqCod_SelDsc = AV53TFTLiqCod_Sel ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+AV61TFTLiqCod_SelDsc );
            AV62i = (long)(AV62i+1) ;
            AV79GXV3 = (int)(AV79GXV3+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV51TFTLiqCod)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Tipo", "")) ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            legajoliquidacioneswcexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char7 = "" ;
            GXv_char8[0] = GXt_char7 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV51TFTLiqCod, GXv_char8) ;
            legajoliquidacioneswcexport.this.GXt_char7 = GXv_char8[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char7 );
         }
      }
      if ( ! ( ( AV55TFLiqClase_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Clase de Legajos", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         legajoliquidacioneswcexport.this.AV14CellRow = GXv_int5[0] ;
         AV62i = 1 ;
         AV80GXV4 = 1 ;
         while ( AV80GXV4 <= AV55TFLiqClase_Sels.size() )
         {
            AV56TFLiqClase_Sel = ((Number) AV55TFLiqClase_Sels.elementAt(-1+AV80GXV4)).byteValue() ;
            if ( AV62i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+httpContext.getMessage( web.gxdomainliquidacionclase.getDescription(httpContext,(byte)AV56TFLiqClase_Sel), "") );
            AV62i = (long)(AV62i+1) ;
            AV80GXV4 = (int)(AV80GXV4+1) ;
         }
      }
      if ( ! ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV67TFLiqLegImpBasico)==0) && (DecimalUtil.compareTo(DecimalUtil.ZERO, AV68TFLiqLegImpBasico_To)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Básico", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         legajoliquidacioneswcexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV67TFLiqLegImpBasico)) );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         legajoliquidacioneswcexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV68TFLiqLegImpBasico_To)) );
      }
      if ( ! ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV59TFLiqLegImpTotBruto)==0) && (DecimalUtil.compareTo(DecimalUtil.ZERO, AV60TFLiqLegImpTotBruto_To)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Bruto", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         legajoliquidacioneswcexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV59TFLiqLegImpTotBruto)) );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         legajoliquidacioneswcexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV60TFLiqLegImpTotBruto_To)) );
      }
      if ( ! ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV57TFLiqLegImpTotBruProm)==0) && (DecimalUtil.compareTo(DecimalUtil.ZERO, AV58TFLiqLegImpTotBruProm_To)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Bruto Prom. sin SAC", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         legajoliquidacioneswcexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV57TFLiqLegImpTotBruProm)) );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         legajoliquidacioneswcexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV58TFLiqLegImpTotBruProm_To)) );
      }
      if ( ! ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV65TFLiqLegImpTotBruSinSAC)==0) && (DecimalUtil.compareTo(DecimalUtil.ZERO, AV66TFLiqLegImpTotBruSinSAC_To)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Bruto sin SAC", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         legajoliquidacioneswcexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV65TFLiqLegImpTotBruSinSAC)) );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         legajoliquidacioneswcexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV66TFLiqLegImpTotBruSinSAC_To)) );
      }
      if ( ! ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV63TFLiqLegImpTotRetGan)==0) && (DecimalUtil.compareTo(DecimalUtil.ZERO, AV64TFLiqLegImpTotRetGan_To)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Imp. Ganancias (Ret/Dev)", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         legajoliquidacioneswcexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV63TFLiqLegImpTotRetGan)) );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         legajoliquidacioneswcexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV64TFLiqLegImpTotRetGan_To)) );
      }
      AV14CellRow = (int)(AV14CellRow+2) ;
   }

   public void S141( )
   {
      /* 'WRITECOLUMNTITLES' Routine */
      returnInSub = false ;
      AV37VisibleColumnCount = 0 ;
      if ( GXutil.strcmp(AV22Session.getValue("LegajoLiquidacionesWCColumnsSelector"), "") != 0 )
      {
         AV32ColumnsSelectorXML = AV22Session.getValue("LegajoLiquidacionesWCColumnsSelector") ;
         AV29ColumnsSelector.fromxml(AV32ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S151 ();
         if (returnInSub) return;
      }
      AV29ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().sort("Order");
      AV81GXV5 = 1 ;
      while ( AV81GXV5 <= AV29ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
      {
         AV31ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV29ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV81GXV5));
         if ( AV31ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV37VisibleColumnCount), 1, 1).setText( httpContext.getMessage( ((GXutil.strcmp("", AV31ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname())==0) ? AV31ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname() : AV31ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname()), "") );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV37VisibleColumnCount), 1, 1).setBold( (short)(1) );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV37VisibleColumnCount), 1, 1).setColor( 11 );
            AV37VisibleColumnCount = (long)(AV37VisibleColumnCount+1) ;
         }
         AV81GXV5 = (int)(AV81GXV5+1) ;
      }
   }

   public void S161( )
   {
      /* 'WRITEDATA' Routine */
      returnInSub = false ;
      AV73FirstDataCellRow = (int)(AV14CellRow+1) ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A748LiqPerPalabra ,
                                           AV46TFLiqPerPalabra_Sels ,
                                           A874LiqNombre ,
                                           AV71TFLiqNombre_Sels ,
                                           A32TLiqCod ,
                                           AV52TFTLiqCod_Sels ,
                                           Byte.valueOf(A268LiqClase) ,
                                           AV55TFLiqClase_Sels ,
                                           Integer.valueOf(AV40TFLiqNro) ,
                                           Integer.valueOf(AV41TFLiqNro_To) ,
                                           AV42TFLiqFecha ,
                                           AV43TFLiqFecha_To ,
                                           Integer.valueOf(AV46TFLiqPerPalabra_Sels.size()) ,
                                           AV45TFLiqPerPalabra ,
                                           Integer.valueOf(AV71TFLiqNombre_Sels.size()) ,
                                           AV70TFLiqNombre ,
                                           AV48TFLiqFecPago ,
                                           AV49TFLiqFecPago_To ,
                                           Integer.valueOf(AV52TFTLiqCod_Sels.size()) ,
                                           AV51TFTLiqCod ,
                                           Integer.valueOf(AV55TFLiqClase_Sels.size()) ,
                                           AV67TFLiqLegImpBasico ,
                                           AV68TFLiqLegImpBasico_To ,
                                           AV59TFLiqLegImpTotBruto ,
                                           AV60TFLiqLegImpTotBruto_To ,
                                           AV57TFLiqLegImpTotBruProm ,
                                           AV58TFLiqLegImpTotBruProm_To ,
                                           AV65TFLiqLegImpTotBruSinSAC ,
                                           AV66TFLiqLegImpTotBruSinSAC_To ,
                                           AV63TFLiqLegImpTotRetGan ,
                                           AV64TFLiqLegImpTotRetGan_To ,
                                           Integer.valueOf(A31LiqNro) ,
                                           A98LiqFecha ,
                                           A280LiqFecPago ,
                                           A340TliqDesc ,
                                           A760LiqLegImpBasico ,
                                           A498LiqLegImpTotBruto ,
                                           A758LiqLegImpTotBruProm ,
                                           A759LiqLegImpTotBruSinSAC ,
                                           A757LiqLegImpTotRetGan ,
                                           Short.valueOf(AV20OrderedBy) ,
                                           Boolean.valueOf(AV21OrderedDsc) ,
                                           Integer.valueOf(AV17CliCod) ,
                                           Short.valueOf(AV18EmpCod) ,
                                           Integer.valueOf(AV19LegNumero) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Integer.valueOf(A6LegNumero) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.BYTE, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.INT, TypeConstants.DATE, TypeConstants.DATE,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.DECIMAL,
                                           TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT,
                                           TypeConstants.DATE, TypeConstants.DATE, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.BOOLEAN,
                                           TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT
                                           }
      });
      lV45TFLiqPerPalabra = GXutil.padr( GXutil.rtrim( AV45TFLiqPerPalabra), 20, "%") ;
      lV70TFLiqNombre = GXutil.concat( GXutil.rtrim( AV70TFLiqNombre), "%", "") ;
      lV51TFTLiqCod = GXutil.concat( GXutil.rtrim( AV51TFTLiqCod), "%", "") ;
      /* Using cursor P00S32 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV17CliCod), Short.valueOf(AV18EmpCod), Integer.valueOf(AV19LegNumero), Integer.valueOf(AV40TFLiqNro), Integer.valueOf(AV41TFLiqNro_To), AV42TFLiqFecha, AV43TFLiqFecha_To, lV45TFLiqPerPalabra, lV70TFLiqNombre, AV48TFLiqFecPago, AV49TFLiqFecPago_To, lV51TFTLiqCod, AV67TFLiqLegImpBasico, AV68TFLiqLegImpBasico_To, AV59TFLiqLegImpTotBruto, AV60TFLiqLegImpTotBruto_To, AV57TFLiqLegImpTotBruProm, AV58TFLiqLegImpTotBruProm_To, AV65TFLiqLegImpTotBruSinSAC, AV66TFLiqLegImpTotBruSinSAC_To, AV63TFLiqLegImpTotRetGan, AV64TFLiqLegImpTotRetGan_To});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A757LiqLegImpTotRetGan = P00S32_A757LiqLegImpTotRetGan[0] ;
         A759LiqLegImpTotBruSinSAC = P00S32_A759LiqLegImpTotBruSinSAC[0] ;
         A758LiqLegImpTotBruProm = P00S32_A758LiqLegImpTotBruProm[0] ;
         A498LiqLegImpTotBruto = P00S32_A498LiqLegImpTotBruto[0] ;
         A760LiqLegImpBasico = P00S32_A760LiqLegImpBasico[0] ;
         A268LiqClase = P00S32_A268LiqClase[0] ;
         n268LiqClase = P00S32_n268LiqClase[0] ;
         A32TLiqCod = P00S32_A32TLiqCod[0] ;
         n32TLiqCod = P00S32_n32TLiqCod[0] ;
         A340TliqDesc = P00S32_A340TliqDesc[0] ;
         A280LiqFecPago = P00S32_A280LiqFecPago[0] ;
         A874LiqNombre = P00S32_A874LiqNombre[0] ;
         A748LiqPerPalabra = P00S32_A748LiqPerPalabra[0] ;
         A98LiqFecha = P00S32_A98LiqFecha[0] ;
         A31LiqNro = P00S32_A31LiqNro[0] ;
         A6LegNumero = P00S32_A6LegNumero[0] ;
         A1EmpCod = P00S32_A1EmpCod[0] ;
         A3CliCod = P00S32_A3CliCod[0] ;
         A579LiqLegImpTotDescu = P00S32_A579LiqLegImpTotDescu[0] ;
         A281LiqLegImpTotal = P00S32_A281LiqLegImpTotal[0] ;
         A268LiqClase = P00S32_A268LiqClase[0] ;
         n268LiqClase = P00S32_n268LiqClase[0] ;
         A280LiqFecPago = P00S32_A280LiqFecPago[0] ;
         A874LiqNombre = P00S32_A874LiqNombre[0] ;
         A748LiqPerPalabra = P00S32_A748LiqPerPalabra[0] ;
         A98LiqFecha = P00S32_A98LiqFecha[0] ;
         A340TliqDesc = P00S32_A340TliqDesc[0] ;
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
         AV37VisibleColumnCount = 0 ;
         AV83GXV6 = 1 ;
         while ( AV83GXV6 <= AV29ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
         {
            AV31ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV29ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV83GXV6));
            if ( AV31ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
            {
               if ( GXutil.strcmp(AV31ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LiqNro") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV37VisibleColumnCount), 1, 1).setNumber( A31LiqNro );
               }
               else if ( GXutil.strcmp(AV31ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LiqFecha") == 0 )
               {
                  GXt_dtime6 = GXutil.resetTime( A98LiqFecha );
                  AV11ExcelDocument.setDateFormat(localUtil, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " ");
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV37VisibleColumnCount), 1, 1).setDate( GXt_dtime6 );
               }
               else if ( GXutil.strcmp(AV31ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LiqPerPalabra") == 0 )
               {
                  GXt_char7 = "" ;
                  GXv_char8[0] = GXt_char7 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A748LiqPerPalabra, GXv_char8) ;
                  legajoliquidacioneswcexport.this.GXt_char7 = GXv_char8[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV37VisibleColumnCount), 1, 1).setText( GXt_char7 );
               }
               else if ( GXutil.strcmp(AV31ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LiqNombre") == 0 )
               {
                  GXt_char7 = "" ;
                  GXv_char8[0] = GXt_char7 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A874LiqNombre, GXv_char8) ;
                  legajoliquidacioneswcexport.this.GXt_char7 = GXv_char8[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV37VisibleColumnCount), 1, 1).setText( GXt_char7 );
               }
               else if ( GXutil.strcmp(AV31ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LiqFecPago") == 0 )
               {
                  GXt_dtime6 = GXutil.resetTime( A280LiqFecPago );
                  AV11ExcelDocument.setDateFormat(localUtil, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " ");
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV37VisibleColumnCount), 1, 1).setDate( GXt_dtime6 );
               }
               else if ( GXutil.strcmp(AV31ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "TLiqCod") == 0 )
               {
                  GXt_char7 = "" ;
                  GXv_char8[0] = GXt_char7 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A340TliqDesc, GXv_char8) ;
                  legajoliquidacioneswcexport.this.GXt_char7 = GXv_char8[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV37VisibleColumnCount), 1, 1).setText( GXt_char7 );
               }
               else if ( GXutil.strcmp(AV31ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LiqClase") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV37VisibleColumnCount), 1, 1).setText( httpContext.getMessage( web.gxdomainliquidacionclase.getDescription(httpContext,(byte)A268LiqClase), "") );
               }
               else if ( GXutil.strcmp(AV31ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LiqLegImpBasico") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV37VisibleColumnCount), 1, 1).setNumber( (double)(DecimalUtil.decToDouble(A760LiqLegImpBasico)) );
               }
               else if ( GXutil.strcmp(AV31ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LiqLegImpTotBruto") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV37VisibleColumnCount), 1, 1).setNumber( (double)(DecimalUtil.decToDouble(A498LiqLegImpTotBruto)) );
               }
               else if ( GXutil.strcmp(AV31ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LiqLegImpTotBruProm") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV37VisibleColumnCount), 1, 1).setNumber( (double)(DecimalUtil.decToDouble(A758LiqLegImpTotBruProm)) );
               }
               else if ( GXutil.strcmp(AV31ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LiqLegImpTotBruSinSAC") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV37VisibleColumnCount), 1, 1).setNumber( (double)(DecimalUtil.decToDouble(A759LiqLegImpTotBruSinSAC)) );
               }
               else if ( GXutil.strcmp(AV31ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "&LiqLegImpTotDescu") == 0 )
               {
                  AV26LiqLegImpTotDescu = A579LiqLegImpTotDescu.multiply(DecimalUtil.doubleToDec(-1)) ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV37VisibleColumnCount), 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV26LiqLegImpTotDescu)) );
               }
               else if ( GXutil.strcmp(AV31ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LiqLegImpTotRetGan") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV37VisibleColumnCount), 1, 1).setNumber( (double)(DecimalUtil.decToDouble(A757LiqLegImpTotRetGan)) );
               }
               else if ( GXutil.strcmp(AV31ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LiqLegImpTotal") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV37VisibleColumnCount), 1, 1).setNumber( (double)(DecimalUtil.decToDouble(A281LiqLegImpTotal)) );
               }
               else if ( GXutil.strcmp(AV31ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "&ErrorLiqLeg") == 0 )
               {
                  GXt_char7 = AV28ErrorLiqLeg ;
                  GXv_char8[0] = GXt_char7 ;
                  new web.liqleggeterror(remoteHandle, context).execute( A3CliCod, A1EmpCod, A31LiqNro, A6LegNumero, GXv_char8) ;
                  legajoliquidacioneswcexport.this.GXt_char7 = GXv_char8[0] ;
                  AV28ErrorLiqLeg = GXt_char7 ;
                  GXt_char7 = "" ;
                  GXv_char8[0] = GXt_char7 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV28ErrorLiqLeg, GXv_char8) ;
                  legajoliquidacioneswcexport.this.GXt_char7 = GXv_char8[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV37VisibleColumnCount), 1, 1).setText( GXt_char7 );
               }
               AV37VisibleColumnCount = (long)(AV37VisibleColumnCount+1) ;
            }
            AV83GXV6 = (int)(AV83GXV6+1) ;
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
      AV37VisibleColumnCount = 0 ;
      AV84GXV7 = 1 ;
      while ( AV84GXV7 <= AV29ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
      {
         AV31ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV29ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV84GXV7));
         if ( AV31ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            if ( GXutil.strcmp(AV31ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LiqLegImpTotBruto") == 0 )
            {
               AV11ExcelDocument.Cells(AV14CellRow+1, (int)(AV15FirstColumn+AV37VisibleColumnCount), 1, 1).setText( GXutil.format( "=SUM(%1%2:%1%3)", GXutil.chr( (short)(GXutil.asc( "A")+AV37VisibleColumnCount)), GXutil.trim( GXutil.str( AV73FirstDataCellRow, 8, 0)), GXutil.trim( GXutil.str( AV14CellRow, 8, 0)), "", "", "", "", "", "") );
            }
            else if ( GXutil.strcmp(AV31ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "&LiqLegImpTotDescu") == 0 )
            {
               AV11ExcelDocument.Cells(AV14CellRow+1, (int)(AV15FirstColumn+AV37VisibleColumnCount), 1, 1).setText( GXutil.format( "=SUM(%1%2:%1%3)", GXutil.chr( (short)(GXutil.asc( "A")+AV37VisibleColumnCount)), GXutil.trim( GXutil.str( AV73FirstDataCellRow, 8, 0)), GXutil.trim( GXutil.str( AV14CellRow, 8, 0)), "", "", "", "", "", "") );
            }
            else if ( GXutil.strcmp(AV31ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LiqLegImpTotRetGan") == 0 )
            {
               AV11ExcelDocument.Cells(AV14CellRow+1, (int)(AV15FirstColumn+AV37VisibleColumnCount), 1, 1).setText( GXutil.format( "=SUM(%1%2:%1%3)", GXutil.chr( (short)(GXutil.asc( "A")+AV37VisibleColumnCount)), GXutil.trim( GXutil.str( AV73FirstDataCellRow, 8, 0)), GXutil.trim( GXutil.str( AV14CellRow, 8, 0)), "", "", "", "", "", "") );
            }
            else if ( GXutil.strcmp(AV31ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LiqLegImpTotal") == 0 )
            {
               AV11ExcelDocument.Cells(AV14CellRow+1, (int)(AV15FirstColumn+AV37VisibleColumnCount), 1, 1).setText( GXutil.format( "=SUM(%1%2:%1%3)", GXutil.chr( (short)(GXutil.asc( "A")+AV37VisibleColumnCount)), GXutil.trim( GXutil.str( AV73FirstDataCellRow, 8, 0)), GXutil.trim( GXutil.str( AV14CellRow, 8, 0)), "", "", "", "", "", "") );
            }
            AV37VisibleColumnCount = (long)(AV37VisibleColumnCount+1) ;
         }
         AV84GXV7 = (int)(AV84GXV7+1) ;
      }
      AV11ExcelDocument.Cells(AV14CellRow+1, AV15FirstColumn, 1, (int)(AV37VisibleColumnCount)).setItalic( (short)(1) );
      AV11ExcelDocument.Cells(AV14CellRow+1, AV15FirstColumn, 1, (int)(AV37VisibleColumnCount)).setBold( (short)(1) );
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
      AV29ColumnsSelector = (web.wwpbaseobjects.SdtWWPColumnsSelector)new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector9[0] = AV29ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "LiqNro", "", "Número", false, "") ;
      AV29ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV29ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "LiqFecha", "", "Fecha de Liq.", false, "") ;
      AV29ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV29ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "LiqPerPalabra", "", "Periodo", false, "") ;
      AV29ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV29ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "LiqNombre", "", "Liquidación", true, "") ;
      AV29ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV29ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "LiqFecPago", "", "Fecha de Pago", false, "") ;
      AV29ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV29ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "TLiqCod", "", "Tipo", false, "") ;
      AV29ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV29ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "LiqClase", "", "Clase de Legajos", false, "") ;
      AV29ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV29ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "LiqLegImpBasico", "", "Básico", true, "") ;
      AV29ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV29ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "LiqLegImpTotBruto", "", "Bruto", true, "") ;
      AV29ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV29ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "LiqLegImpTotBruProm", "", "Bruto Prom. sin SAC", true, "") ;
      AV29ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV29ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "LiqLegImpTotBruSinSAC", "", "Bruto sin SAC", true, "") ;
      AV29ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV29ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "&LiqLegImpTotDescu", "", "Descuentos", true, "") ;
      AV29ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV29ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "LiqLegImpTotRetGan", "", "Imp. Ganancias (Ret/Dev)", true, "") ;
      AV29ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV29ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "LiqLegImpTotal", "", "Neto", true, "") ;
      AV29ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV29ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "&ErrorLiqLeg", "", "Error", false, "") ;
      AV29ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXt_char7 = AV33UserCustomValue ;
      GXv_char8[0] = GXt_char7 ;
      new web.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "LegajoLiquidacionesWCColumnsSelector", GXv_char8) ;
      legajoliquidacioneswcexport.this.GXt_char7 = GXv_char8[0] ;
      AV33UserCustomValue = GXt_char7 ;
      if ( ! ( (GXutil.strcmp("", AV33UserCustomValue)==0) ) )
      {
         AV30ColumnsSelectorAux.fromxml(AV33UserCustomValue, null, null);
         GXv_SdtWWPColumnsSelector9[0] = AV30ColumnsSelectorAux;
         GXv_SdtWWPColumnsSelector10[0] = AV29ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnselector_updatecolumns(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, GXv_SdtWWPColumnsSelector10) ;
         AV30ColumnsSelectorAux = GXv_SdtWWPColumnsSelector9[0] ;
         AV29ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      }
   }

   public void S211( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV22Session.getValue("LegajoLiquidacionesWCGridState"), "") == 0 )
      {
         AV24GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "LegajoLiquidacionesWCGridState"), null, null);
      }
      else
      {
         AV24GridState.fromxml(AV22Session.getValue("LegajoLiquidacionesWCGridState"), null, null);
      }
      AV20OrderedBy = AV24GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV21OrderedDsc = AV24GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV85GXV8 = 1 ;
      while ( AV85GXV8 <= AV24GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV25GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV24GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV85GXV8));
         if ( GXutil.strcmp(AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQNRO") == 0 )
         {
            AV40TFLiqNro = (int)(GXutil.lval( AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV41TFLiqNro_To = (int)(GXutil.lval( AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQFECHA") == 0 )
         {
            AV42TFLiqFecha = localUtil.ctod( AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            AV43TFLiqFecha_To = localUtil.ctod( AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
         }
         else if ( GXutil.strcmp(AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQPERPALABRA") == 0 )
         {
            AV45TFLiqPerPalabra = AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQPERPALABRA_SEL") == 0 )
         {
            AV44TFLiqPerPalabra_SelsJson = AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV46TFLiqPerPalabra_Sels.fromJSonString(AV44TFLiqPerPalabra_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQNOMBRE") == 0 )
         {
            AV70TFLiqNombre = AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQNOMBRE_SEL") == 0 )
         {
            AV69TFLiqNombre_SelsJson = AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV71TFLiqNombre_Sels.fromJSonString(AV69TFLiqNombre_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQFECPAGO") == 0 )
         {
            AV48TFLiqFecPago = localUtil.ctod( AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            AV49TFLiqFecPago_To = localUtil.ctod( AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
         }
         else if ( GXutil.strcmp(AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFTLIQCOD") == 0 )
         {
            AV51TFTLiqCod = AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFTLIQCOD_SEL") == 0 )
         {
            AV50TFTLiqCod_SelsJson = AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV52TFTLiqCod_Sels.fromJSonString(AV50TFTLiqCod_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQCLASE_SEL") == 0 )
         {
            AV54TFLiqClase_SelsJson = AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV55TFLiqClase_Sels.fromJSonString(AV54TFLiqClase_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQLEGIMPBASICO") == 0 )
         {
            AV67TFLiqLegImpBasico = CommonUtil.decimalVal( AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV68TFLiqLegImpBasico_To = CommonUtil.decimalVal( AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQLEGIMPTOTBRUTO") == 0 )
         {
            AV59TFLiqLegImpTotBruto = CommonUtil.decimalVal( AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV60TFLiqLegImpTotBruto_To = CommonUtil.decimalVal( AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQLEGIMPTOTBRUPROM") == 0 )
         {
            AV57TFLiqLegImpTotBruProm = CommonUtil.decimalVal( AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV58TFLiqLegImpTotBruProm_To = CommonUtil.decimalVal( AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQLEGIMPTOTBRUSINSAC") == 0 )
         {
            AV65TFLiqLegImpTotBruSinSAC = CommonUtil.decimalVal( AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV66TFLiqLegImpTotBruSinSAC_To = CommonUtil.decimalVal( AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQLEGIMPTOTRETGAN") == 0 )
         {
            AV63TFLiqLegImpTotRetGan = CommonUtil.decimalVal( AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV64TFLiqLegImpTotRetGan_To = CommonUtil.decimalVal( AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&CLICOD") == 0 )
         {
            AV17CliCod = (int)(GXutil.lval( AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&EMPCOD") == 0 )
         {
            AV18EmpCod = (short)(GXutil.lval( AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&LEGNUMERO") == 0 )
         {
            AV19LegNumero = (int)(GXutil.lval( AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         AV85GXV8 = (int)(AV85GXV8+1) ;
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
      this.aP0[0] = legajoliquidacioneswcexport.this.AV12Filename;
      this.aP1[0] = legajoliquidacioneswcexport.this.AV13ErrorMessage;
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
      AV76Pgmname = "" ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV11ExcelDocument = new com.genexus.gxoffice.ExcelDoc();
      AV42TFLiqFecha = GXutil.nullDate() ;
      AV43TFLiqFecha_To = GXutil.nullDate() ;
      AV46TFLiqPerPalabra_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV47TFLiqPerPalabra_Sel = "" ;
      AV45TFLiqPerPalabra = "" ;
      AV71TFLiqNombre_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV72TFLiqNombre_Sel = "" ;
      AV70TFLiqNombre = "" ;
      AV48TFLiqFecPago = GXutil.nullDate() ;
      AV49TFLiqFecPago_To = GXutil.nullDate() ;
      AV52TFTLiqCod_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV53TFTLiqCod_Sel = "" ;
      AV61TFTLiqCod_SelDsc = "" ;
      AV51TFTLiqCod = "" ;
      AV55TFLiqClase_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV67TFLiqLegImpBasico = DecimalUtil.ZERO ;
      AV68TFLiqLegImpBasico_To = DecimalUtil.ZERO ;
      AV59TFLiqLegImpTotBruto = DecimalUtil.ZERO ;
      AV60TFLiqLegImpTotBruto_To = DecimalUtil.ZERO ;
      AV57TFLiqLegImpTotBruProm = DecimalUtil.ZERO ;
      AV58TFLiqLegImpTotBruProm_To = DecimalUtil.ZERO ;
      AV65TFLiqLegImpTotBruSinSAC = DecimalUtil.ZERO ;
      AV66TFLiqLegImpTotBruSinSAC_To = DecimalUtil.ZERO ;
      AV63TFLiqLegImpTotRetGan = DecimalUtil.ZERO ;
      AV64TFLiqLegImpTotRetGan_To = DecimalUtil.ZERO ;
      GXv_exceldoc4 = new com.genexus.gxoffice.ExcelDoc[1] ;
      GXv_int5 = new short[1] ;
      AV22Session = httpContext.getWebSession();
      AV32ColumnsSelectorXML = "" ;
      AV29ColumnsSelector = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV31ColumnsSelector_Column = new web.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      scmdbuf = "" ;
      lV45TFLiqPerPalabra = "" ;
      lV70TFLiqNombre = "" ;
      lV51TFTLiqCod = "" ;
      A748LiqPerPalabra = "" ;
      A874LiqNombre = "" ;
      A32TLiqCod = "" ;
      A98LiqFecha = GXutil.nullDate() ;
      A280LiqFecPago = GXutil.nullDate() ;
      A340TliqDesc = "" ;
      A760LiqLegImpBasico = DecimalUtil.ZERO ;
      A498LiqLegImpTotBruto = DecimalUtil.ZERO ;
      A758LiqLegImpTotBruProm = DecimalUtil.ZERO ;
      A759LiqLegImpTotBruSinSAC = DecimalUtil.ZERO ;
      A757LiqLegImpTotRetGan = DecimalUtil.ZERO ;
      P00S32_A757LiqLegImpTotRetGan = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P00S32_A759LiqLegImpTotBruSinSAC = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P00S32_A758LiqLegImpTotBruProm = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P00S32_A498LiqLegImpTotBruto = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P00S32_A760LiqLegImpBasico = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P00S32_A268LiqClase = new byte[1] ;
      P00S32_n268LiqClase = new boolean[] {false} ;
      P00S32_A32TLiqCod = new String[] {""} ;
      P00S32_n32TLiqCod = new boolean[] {false} ;
      P00S32_A340TliqDesc = new String[] {""} ;
      P00S32_A280LiqFecPago = new java.util.Date[] {GXutil.nullDate()} ;
      P00S32_A874LiqNombre = new String[] {""} ;
      P00S32_A748LiqPerPalabra = new String[] {""} ;
      P00S32_A98LiqFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P00S32_A31LiqNro = new int[1] ;
      P00S32_A6LegNumero = new int[1] ;
      P00S32_A1EmpCod = new short[1] ;
      P00S32_A3CliCod = new int[1] ;
      P00S32_A579LiqLegImpTotDescu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P00S32_A281LiqLegImpTotal = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      A579LiqLegImpTotDescu = DecimalUtil.ZERO ;
      A281LiqLegImpTotal = DecimalUtil.ZERO ;
      GXt_dtime6 = GXutil.resetTime( GXutil.nullDate() );
      AV26LiqLegImpTotDescu = DecimalUtil.ZERO ;
      AV28ErrorLiqLeg = "" ;
      AV33UserCustomValue = "" ;
      GXt_char7 = "" ;
      GXv_char8 = new String[1] ;
      AV30ColumnsSelectorAux = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector9 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector10 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      AV24GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV25GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV44TFLiqPerPalabra_SelsJson = "" ;
      AV69TFLiqNombre_SelsJson = "" ;
      AV50TFTLiqCod_SelsJson = "" ;
      AV54TFLiqClase_SelsJson = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.legajoliquidacioneswcexport__default(),
         new Object[] {
             new Object[] {
            P00S32_A757LiqLegImpTotRetGan, P00S32_A759LiqLegImpTotBruSinSAC, P00S32_A758LiqLegImpTotBruProm, P00S32_A498LiqLegImpTotBruto, P00S32_A760LiqLegImpBasico, P00S32_A268LiqClase, P00S32_n268LiqClase, P00S32_A32TLiqCod, P00S32_n32TLiqCod, P00S32_A340TliqDesc,
            P00S32_A280LiqFecPago, P00S32_A874LiqNombre, P00S32_A748LiqPerPalabra, P00S32_A98LiqFecha, P00S32_A31LiqNro, P00S32_A6LegNumero, P00S32_A1EmpCod, P00S32_A3CliCod, P00S32_A579LiqLegImpTotDescu, P00S32_A281LiqLegImpTotal
            }
         }
      );
      AV76Pgmname = "LegajoLiquidacionesWCExport" ;
      /* GeneXus formulas. */
      AV76Pgmname = "LegajoLiquidacionesWCExport" ;
      Gx_err = (short)(0) ;
   }

   private byte AV56TFLiqClase_Sel ;
   private byte A268LiqClase ;
   private short GXv_int5[] ;
   private short AV20OrderedBy ;
   private short AV18EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV14CellRow ;
   private int AV15FirstColumn ;
   private int AV16Random ;
   private int AV40TFLiqNro ;
   private int AV41TFLiqNro_To ;
   private int AV77GXV1 ;
   private int AV78GXV2 ;
   private int AV79GXV3 ;
   private int AV80GXV4 ;
   private int AV81GXV5 ;
   private int AV73FirstDataCellRow ;
   private int AV46TFLiqPerPalabra_Sels_size ;
   private int AV71TFLiqNombre_Sels_size ;
   private int AV52TFTLiqCod_Sels_size ;
   private int AV55TFLiqClase_Sels_size ;
   private int A31LiqNro ;
   private int AV17CliCod ;
   private int AV19LegNumero ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private int AV83GXV6 ;
   private int AV84GXV7 ;
   private int AV85GXV8 ;
   private long AV62i ;
   private long AV37VisibleColumnCount ;
   private java.math.BigDecimal AV67TFLiqLegImpBasico ;
   private java.math.BigDecimal AV68TFLiqLegImpBasico_To ;
   private java.math.BigDecimal AV59TFLiqLegImpTotBruto ;
   private java.math.BigDecimal AV60TFLiqLegImpTotBruto_To ;
   private java.math.BigDecimal AV57TFLiqLegImpTotBruProm ;
   private java.math.BigDecimal AV58TFLiqLegImpTotBruProm_To ;
   private java.math.BigDecimal AV65TFLiqLegImpTotBruSinSAC ;
   private java.math.BigDecimal AV66TFLiqLegImpTotBruSinSAC_To ;
   private java.math.BigDecimal AV63TFLiqLegImpTotRetGan ;
   private java.math.BigDecimal AV64TFLiqLegImpTotRetGan_To ;
   private java.math.BigDecimal A760LiqLegImpBasico ;
   private java.math.BigDecimal A498LiqLegImpTotBruto ;
   private java.math.BigDecimal A758LiqLegImpTotBruProm ;
   private java.math.BigDecimal A759LiqLegImpTotBruSinSAC ;
   private java.math.BigDecimal A757LiqLegImpTotRetGan ;
   private java.math.BigDecimal A579LiqLegImpTotDescu ;
   private java.math.BigDecimal A281LiqLegImpTotal ;
   private java.math.BigDecimal AV26LiqLegImpTotDescu ;
   private String AV76Pgmname ;
   private String AV47TFLiqPerPalabra_Sel ;
   private String AV45TFLiqPerPalabra ;
   private String AV53TFTLiqCod_Sel ;
   private String scmdbuf ;
   private String lV45TFLiqPerPalabra ;
   private String A748LiqPerPalabra ;
   private String A32TLiqCod ;
   private String GXt_char7 ;
   private String GXv_char8[] ;
   private java.util.Date GXt_dtime6 ;
   private java.util.Date AV42TFLiqFecha ;
   private java.util.Date AV43TFLiqFecha_To ;
   private java.util.Date AV48TFLiqFecPago ;
   private java.util.Date AV49TFLiqFecPago_To ;
   private java.util.Date A98LiqFecha ;
   private java.util.Date A280LiqFecPago ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean AV21OrderedDsc ;
   private boolean n268LiqClase ;
   private boolean n32TLiqCod ;
   private String AV32ColumnsSelectorXML ;
   private String AV33UserCustomValue ;
   private String AV44TFLiqPerPalabra_SelsJson ;
   private String AV69TFLiqNombre_SelsJson ;
   private String AV50TFTLiqCod_SelsJson ;
   private String AV54TFLiqClase_SelsJson ;
   private String AV12Filename ;
   private String AV13ErrorMessage ;
   private String AV72TFLiqNombre_Sel ;
   private String AV70TFLiqNombre ;
   private String AV61TFTLiqCod_SelDsc ;
   private String AV51TFTLiqCod ;
   private String lV70TFLiqNombre ;
   private String lV51TFTLiqCod ;
   private String A874LiqNombre ;
   private String A340TliqDesc ;
   private String AV28ErrorLiqLeg ;
   private GXSimpleCollection<Byte> AV55TFLiqClase_Sels ;
   private com.genexus.webpanels.WebSession AV22Session ;
   private GXSimpleCollection<String> AV46TFLiqPerPalabra_Sels ;
   private GXSimpleCollection<String> AV52TFTLiqCod_Sels ;
   private GXSimpleCollection<String> AV71TFLiqNombre_Sels ;
   private String[] aP1 ;
   private String[] aP0 ;
   private IDataStoreProvider pr_default ;
   private java.math.BigDecimal[] P00S32_A757LiqLegImpTotRetGan ;
   private java.math.BigDecimal[] P00S32_A759LiqLegImpTotBruSinSAC ;
   private java.math.BigDecimal[] P00S32_A758LiqLegImpTotBruProm ;
   private java.math.BigDecimal[] P00S32_A498LiqLegImpTotBruto ;
   private java.math.BigDecimal[] P00S32_A760LiqLegImpBasico ;
   private byte[] P00S32_A268LiqClase ;
   private boolean[] P00S32_n268LiqClase ;
   private String[] P00S32_A32TLiqCod ;
   private boolean[] P00S32_n32TLiqCod ;
   private String[] P00S32_A340TliqDesc ;
   private java.util.Date[] P00S32_A280LiqFecPago ;
   private String[] P00S32_A874LiqNombre ;
   private String[] P00S32_A748LiqPerPalabra ;
   private java.util.Date[] P00S32_A98LiqFecha ;
   private int[] P00S32_A31LiqNro ;
   private int[] P00S32_A6LegNumero ;
   private short[] P00S32_A1EmpCod ;
   private int[] P00S32_A3CliCod ;
   private java.math.BigDecimal[] P00S32_A579LiqLegImpTotDescu ;
   private java.math.BigDecimal[] P00S32_A281LiqLegImpTotal ;
   private com.genexus.gxoffice.ExcelDoc AV11ExcelDocument ;
   private com.genexus.gxoffice.ExcelDoc GXv_exceldoc4[] ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV24GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV25GridStateFilterValue ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV29ColumnsSelector ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV30ColumnsSelectorAux ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector9[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector10[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector_Column AV31ColumnsSelector_Column ;
}

final  class legajoliquidacioneswcexport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P00S32( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A748LiqPerPalabra ,
                                          GXSimpleCollection<String> AV46TFLiqPerPalabra_Sels ,
                                          String A874LiqNombre ,
                                          GXSimpleCollection<String> AV71TFLiqNombre_Sels ,
                                          String A32TLiqCod ,
                                          GXSimpleCollection<String> AV52TFTLiqCod_Sels ,
                                          byte A268LiqClase ,
                                          GXSimpleCollection<Byte> AV55TFLiqClase_Sels ,
                                          int AV40TFLiqNro ,
                                          int AV41TFLiqNro_To ,
                                          java.util.Date AV42TFLiqFecha ,
                                          java.util.Date AV43TFLiqFecha_To ,
                                          int AV46TFLiqPerPalabra_Sels_size ,
                                          String AV45TFLiqPerPalabra ,
                                          int AV71TFLiqNombre_Sels_size ,
                                          String AV70TFLiqNombre ,
                                          java.util.Date AV48TFLiqFecPago ,
                                          java.util.Date AV49TFLiqFecPago_To ,
                                          int AV52TFTLiqCod_Sels_size ,
                                          String AV51TFTLiqCod ,
                                          int AV55TFLiqClase_Sels_size ,
                                          java.math.BigDecimal AV67TFLiqLegImpBasico ,
                                          java.math.BigDecimal AV68TFLiqLegImpBasico_To ,
                                          java.math.BigDecimal AV59TFLiqLegImpTotBruto ,
                                          java.math.BigDecimal AV60TFLiqLegImpTotBruto_To ,
                                          java.math.BigDecimal AV57TFLiqLegImpTotBruProm ,
                                          java.math.BigDecimal AV58TFLiqLegImpTotBruProm_To ,
                                          java.math.BigDecimal AV65TFLiqLegImpTotBruSinSAC ,
                                          java.math.BigDecimal AV66TFLiqLegImpTotBruSinSAC_To ,
                                          java.math.BigDecimal AV63TFLiqLegImpTotRetGan ,
                                          java.math.BigDecimal AV64TFLiqLegImpTotRetGan_To ,
                                          int A31LiqNro ,
                                          java.util.Date A98LiqFecha ,
                                          java.util.Date A280LiqFecPago ,
                                          String A340TliqDesc ,
                                          java.math.BigDecimal A760LiqLegImpBasico ,
                                          java.math.BigDecimal A498LiqLegImpTotBruto ,
                                          java.math.BigDecimal A758LiqLegImpTotBruProm ,
                                          java.math.BigDecimal A759LiqLegImpTotBruSinSAC ,
                                          java.math.BigDecimal A757LiqLegImpTotRetGan ,
                                          short AV20OrderedBy ,
                                          boolean AV21OrderedDsc ,
                                          int AV17CliCod ,
                                          short AV18EmpCod ,
                                          int AV19LegNumero ,
                                          int A3CliCod ,
                                          short A1EmpCod ,
                                          int A6LegNumero )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int11 = new byte[22];
      Object[] GXv_Object12 = new Object[2];
      scmdbuf = "SELECT T1.LiqLegImpTotRetGan, T1.LiqLegImpTotBruSinSAC, T1.LiqLegImpTotBruProm, T1.LiqLegImpTotBruto, T1.LiqLegImpBasico, T2.LiqClase, T1.TLiqCod, T3.TliqDesc, T2.LiqFecPago," ;
      scmdbuf += " T2.LiqNombre, T2.LiqPerPalabra, T2.LiqFecha, T1.LiqNro, T1.LegNumero, T1.EmpCod, T1.CliCod, T1.LiqLegImpTotDescu, T1.LiqLegImpTotal FROM ((LiquidacionLegajo T1" ;
      scmdbuf += " INNER JOIN Liquidacion T2 ON T2.CliCod = T1.CliCod AND T2.EmpCod = T1.EmpCod AND T2.LiqNro = T1.LiqNro) LEFT JOIN TipoLiquidacion T3 ON T3.CliCod = T1.CliCod AND" ;
      scmdbuf += " T3.TLiqCod = T1.TLiqCod)" ;
      addWhere(sWhereString, "(T1.CliCod = ? and T1.EmpCod = ? and T1.LegNumero = ?)");
      if ( ! (0==AV40TFLiqNro) )
      {
         addWhere(sWhereString, "(T1.LiqNro >= ?)");
      }
      else
      {
         GXv_int11[3] = (byte)(1) ;
      }
      if ( ! (0==AV41TFLiqNro_To) )
      {
         addWhere(sWhereString, "(T1.LiqNro <= ?)");
      }
      else
      {
         GXv_int11[4] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV42TFLiqFecha)) )
      {
         addWhere(sWhereString, "(T2.LiqFecha >= ?)");
      }
      else
      {
         GXv_int11[5] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV43TFLiqFecha_To)) )
      {
         addWhere(sWhereString, "(T2.LiqFecha <= ?)");
      }
      else
      {
         GXv_int11[6] = (byte)(1) ;
      }
      if ( ( AV46TFLiqPerPalabra_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV45TFLiqPerPalabra)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.LiqPerPalabra) like LOWER(?))");
      }
      else
      {
         GXv_int11[7] = (byte)(1) ;
      }
      if ( AV46TFLiqPerPalabra_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV46TFLiqPerPalabra_Sels, "T2.LiqPerPalabra IN (", ")")+")");
      }
      if ( ( AV71TFLiqNombre_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV70TFLiqNombre)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.LiqNombre) like LOWER(?))");
      }
      else
      {
         GXv_int11[8] = (byte)(1) ;
      }
      if ( AV71TFLiqNombre_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV71TFLiqNombre_Sels, "T2.LiqNombre IN (", ")")+")");
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV48TFLiqFecPago)) )
      {
         addWhere(sWhereString, "(T2.LiqFecPago >= ?)");
      }
      else
      {
         GXv_int11[9] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV49TFLiqFecPago_To)) )
      {
         addWhere(sWhereString, "(T2.LiqFecPago <= ?)");
      }
      else
      {
         GXv_int11[10] = (byte)(1) ;
      }
      if ( ( AV52TFTLiqCod_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV51TFTLiqCod)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T3.TliqDesc) like LOWER(?))");
      }
      else
      {
         GXv_int11[11] = (byte)(1) ;
      }
      if ( AV52TFTLiqCod_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV52TFTLiqCod_Sels, "T1.TLiqCod IN (", ")")+")");
      }
      if ( AV55TFLiqClase_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV55TFLiqClase_Sels, "T2.LiqClase IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV67TFLiqLegImpBasico)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpBasico >= ?)");
      }
      else
      {
         GXv_int11[12] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV68TFLiqLegImpBasico_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpBasico <= ?)");
      }
      else
      {
         GXv_int11[13] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV59TFLiqLegImpTotBruto)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpTotBruto >= ?)");
      }
      else
      {
         GXv_int11[14] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV60TFLiqLegImpTotBruto_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpTotBruto <= ?)");
      }
      else
      {
         GXv_int11[15] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV57TFLiqLegImpTotBruProm)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpTotBruProm >= ?)");
      }
      else
      {
         GXv_int11[16] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV58TFLiqLegImpTotBruProm_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpTotBruProm <= ?)");
      }
      else
      {
         GXv_int11[17] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV65TFLiqLegImpTotBruSinSAC)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpTotBruSinSAC >= ?)");
      }
      else
      {
         GXv_int11[18] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV66TFLiqLegImpTotBruSinSAC_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpTotBruSinSAC <= ?)");
      }
      else
      {
         GXv_int11[19] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV63TFLiqLegImpTotRetGan)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpTotRetGan >= ?)");
      }
      else
      {
         GXv_int11[20] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV64TFLiqLegImpTotRetGan_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpTotRetGan <= ?)");
      }
      else
      {
         GXv_int11[21] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      if ( AV20OrderedBy == 1 )
      {
         scmdbuf += " ORDER BY T1.CliCod, T1.EmpCod, T1.LegNumero, T1.LiqNro DESC" ;
      }
      else if ( ( AV20OrderedBy == 2 ) && ! AV21OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.CliCod, T1.EmpCod, T1.LegNumero, T1.LiqNro" ;
      }
      else if ( ( AV20OrderedBy == 2 ) && ( AV21OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.CliCod DESC, T1.EmpCod DESC, T1.LegNumero DESC, T1.LiqNro DESC" ;
      }
      else if ( ( AV20OrderedBy == 3 ) && ! AV21OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.CliCod, T1.EmpCod, T1.LegNumero, T2.LiqFecha" ;
      }
      else if ( ( AV20OrderedBy == 3 ) && ( AV21OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.CliCod DESC, T1.EmpCod DESC, T1.LegNumero DESC, T2.LiqFecha DESC" ;
      }
      else if ( ( AV20OrderedBy == 4 ) && ! AV21OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.CliCod, T1.EmpCod, T1.LegNumero, T2.LiqPerPalabra" ;
      }
      else if ( ( AV20OrderedBy == 4 ) && ( AV21OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.CliCod DESC, T1.EmpCod DESC, T1.LegNumero DESC, T2.LiqPerPalabra DESC" ;
      }
      else if ( ( AV20OrderedBy == 5 ) && ! AV21OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.CliCod, T1.EmpCod, T1.LegNumero, T2.LiqNombre" ;
      }
      else if ( ( AV20OrderedBy == 5 ) && ( AV21OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.CliCod DESC, T1.EmpCod DESC, T1.LegNumero DESC, T2.LiqNombre DESC" ;
      }
      else if ( ( AV20OrderedBy == 6 ) && ! AV21OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.CliCod, T1.EmpCod, T1.LegNumero, T2.LiqFecPago" ;
      }
      else if ( ( AV20OrderedBy == 6 ) && ( AV21OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.CliCod DESC, T1.EmpCod DESC, T1.LegNumero DESC, T2.LiqFecPago DESC" ;
      }
      else if ( ( AV20OrderedBy == 7 ) && ! AV21OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.CliCod, T1.EmpCod, T1.LegNumero, T1.TLiqCod" ;
      }
      else if ( ( AV20OrderedBy == 7 ) && ( AV21OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.CliCod DESC, T1.EmpCod DESC, T1.LegNumero DESC, T1.TLiqCod DESC" ;
      }
      else if ( ( AV20OrderedBy == 8 ) && ! AV21OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.CliCod, T1.EmpCod, T1.LegNumero, T2.LiqClase" ;
      }
      else if ( ( AV20OrderedBy == 8 ) && ( AV21OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.CliCod DESC, T1.EmpCod DESC, T1.LegNumero DESC, T2.LiqClase DESC" ;
      }
      else if ( ( AV20OrderedBy == 9 ) && ! AV21OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.CliCod, T1.EmpCod, T1.LegNumero, T1.LiqLegImpBasico" ;
      }
      else if ( ( AV20OrderedBy == 9 ) && ( AV21OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.CliCod DESC, T1.EmpCod DESC, T1.LegNumero DESC, T1.LiqLegImpBasico DESC" ;
      }
      else if ( ( AV20OrderedBy == 10 ) && ! AV21OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.CliCod, T1.EmpCod, T1.LegNumero, T1.LiqLegImpTotBruto" ;
      }
      else if ( ( AV20OrderedBy == 10 ) && ( AV21OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.CliCod DESC, T1.EmpCod DESC, T1.LegNumero DESC, T1.LiqLegImpTotBruto DESC" ;
      }
      else if ( ( AV20OrderedBy == 11 ) && ! AV21OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.CliCod, T1.EmpCod, T1.LegNumero, T1.LiqLegImpTotBruProm" ;
      }
      else if ( ( AV20OrderedBy == 11 ) && ( AV21OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.CliCod DESC, T1.EmpCod DESC, T1.LegNumero DESC, T1.LiqLegImpTotBruProm DESC" ;
      }
      else if ( ( AV20OrderedBy == 12 ) && ! AV21OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.CliCod, T1.EmpCod, T1.LegNumero, T1.LiqLegImpTotBruSinSAC" ;
      }
      else if ( ( AV20OrderedBy == 12 ) && ( AV21OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.CliCod DESC, T1.EmpCod DESC, T1.LegNumero DESC, T1.LiqLegImpTotBruSinSAC DESC" ;
      }
      else if ( ( AV20OrderedBy == 13 ) && ! AV21OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.CliCod, T1.EmpCod, T1.LegNumero, T1.LiqLegImpTotRetGan" ;
      }
      else if ( ( AV20OrderedBy == 13 ) && ( AV21OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.CliCod DESC, T1.EmpCod DESC, T1.LegNumero DESC, T1.LiqLegImpTotRetGan DESC" ;
      }
      else if ( ( AV20OrderedBy == 14 ) && ! AV21OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.CliCod, T1.EmpCod, T1.LegNumero, T1.LiqLegImpTotal" ;
      }
      else if ( ( AV20OrderedBy == 14 ) && ( AV21OrderedDsc ) )
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
                  return conditional_P00S32(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , ((Number) dynConstraints[9]).intValue() , (java.util.Date)dynConstraints[10] , (java.util.Date)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , (String)dynConstraints[13] , ((Number) dynConstraints[14]).intValue() , (String)dynConstraints[15] , (java.util.Date)dynConstraints[16] , (java.util.Date)dynConstraints[17] , ((Number) dynConstraints[18]).intValue() , (String)dynConstraints[19] , ((Number) dynConstraints[20]).intValue() , (java.math.BigDecimal)dynConstraints[21] , (java.math.BigDecimal)dynConstraints[22] , (java.math.BigDecimal)dynConstraints[23] , (java.math.BigDecimal)dynConstraints[24] , (java.math.BigDecimal)dynConstraints[25] , (java.math.BigDecimal)dynConstraints[26] , (java.math.BigDecimal)dynConstraints[27] , (java.math.BigDecimal)dynConstraints[28] , (java.math.BigDecimal)dynConstraints[29] , (java.math.BigDecimal)dynConstraints[30] , ((Number) dynConstraints[31]).intValue() , (java.util.Date)dynConstraints[32] , (java.util.Date)dynConstraints[33] , (String)dynConstraints[34] , (java.math.BigDecimal)dynConstraints[35] , (java.math.BigDecimal)dynConstraints[36] , (java.math.BigDecimal)dynConstraints[37] , (java.math.BigDecimal)dynConstraints[38] , (java.math.BigDecimal)dynConstraints[39] , ((Number) dynConstraints[40]).shortValue() , ((Boolean) dynConstraints[41]).booleanValue() , ((Number) dynConstraints[42]).intValue() , ((Number) dynConstraints[43]).shortValue() , ((Number) dynConstraints[44]).intValue() , ((Number) dynConstraints[45]).intValue() , ((Number) dynConstraints[46]).shortValue() , ((Number) dynConstraints[47]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00S32", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((String[]) buf[7])[0] = rslt.getString(7, 20);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((String[]) buf[9])[0] = rslt.getVarchar(8);
               ((java.util.Date[]) buf[10])[0] = rslt.getGXDate(9);
               ((String[]) buf[11])[0] = rslt.getVarchar(10);
               ((String[]) buf[12])[0] = rslt.getString(11, 20);
               ((java.util.Date[]) buf[13])[0] = rslt.getGXDate(12);
               ((int[]) buf[14])[0] = rslt.getInt(13);
               ((int[]) buf[15])[0] = rslt.getInt(14);
               ((short[]) buf[16])[0] = rslt.getShort(15);
               ((int[]) buf[17])[0] = rslt.getInt(16);
               ((java.math.BigDecimal[]) buf[18])[0] = rslt.getBigDecimal(17,2);
               ((java.math.BigDecimal[]) buf[19])[0] = rslt.getBigDecimal(18,2);
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

