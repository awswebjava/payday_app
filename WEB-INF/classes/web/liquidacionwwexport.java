package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class liquidacionwwexport extends GXProcedure
{
   public liquidacionwwexport( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( liquidacionwwexport.class ), "" );
   }

   public liquidacionwwexport( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String[] aP0 )
   {
      liquidacionwwexport.this.aP1 = new String[] {""};
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
      liquidacionwwexport.this.aP0 = aP0;
      liquidacionwwexport.this.aP1 = aP1;
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
      liquidacionwwexport.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( ! AV8IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV92Pgmname))}, new String[] {"GxObject"}) );
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
      AV12Filename = "LiquidacionWWExport-" + GXutil.trim( GXutil.str( AV16Random, 8, 0)) + ".xlsx" ;
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
      if ( ! ( (0==AV21LiqRelNro) ) )
      {
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+0, 1, 1).setNumber( AV21LiqRelNro );
      }
      if ( ! ( (0==AV39TFLiqNro) && (0==AV40TFLiqNro_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Número", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         liquidacionwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV39TFLiqNro );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         liquidacionwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV40TFLiqNro_To );
      }
      if ( ! ( (GXutil.strcmp("", AV42TFLiqNombre_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Descripción", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         liquidacionwwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV42TFLiqNombre_Sel, GXv_char7) ;
         liquidacionwwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV41TFLiqNombre)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Descripción", "")) ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            liquidacionwwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV41TFLiqNombre, GXv_char7) ;
            liquidacionwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV43TFLiqFecha)) && GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV44TFLiqFecha_To)) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Fecha de liq.", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         liquidacionwwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_dtime8 = GXutil.resetTime( AV43TFLiqFecha );
         AV11ExcelDocument.setDateFormat(localUtil, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " ");
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setDate( GXt_dtime8 );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         liquidacionwwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_dtime8 = GXutil.resetTime( AV44TFLiqFecha_To );
         AV11ExcelDocument.setDateFormat(localUtil, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " ");
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setDate( GXt_dtime8 );
      }
      if ( ! ( ( AV47TFLiqPerPalabra_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Periodo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         liquidacionwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV77i = 1 ;
         AV93GXV1 = 1 ;
         while ( AV93GXV1 <= AV47TFLiqPerPalabra_Sels.size() )
         {
            AV48TFLiqPerPalabra_Sel = (String)AV47TFLiqPerPalabra_Sels.elementAt(-1+AV93GXV1) ;
            if ( AV77i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV48TFLiqPerPalabra_Sel, GXv_char7) ;
            liquidacionwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char6 );
            AV77i = (long)(AV77i+1) ;
            AV93GXV1 = (int)(AV93GXV1+1) ;
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
            liquidacionwwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV46TFLiqPerPalabra, GXv_char7) ;
            liquidacionwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV49TFLiqFecPago)) && GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV50TFLiqFecPago_To)) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Fecha de pago", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         liquidacionwwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_dtime8 = GXutil.resetTime( AV49TFLiqFecPago );
         AV11ExcelDocument.setDateFormat(localUtil, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " ");
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setDate( GXt_dtime8 );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         liquidacionwwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_dtime8 = GXutil.resetTime( AV50TFLiqFecPago_To );
         AV11ExcelDocument.setDateFormat(localUtil, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " ");
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setDate( GXt_dtime8 );
      }
      if ( ! ( ( AV82TFTLiqDescAux_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Tipo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         liquidacionwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV77i = 1 ;
         AV94GXV2 = 1 ;
         while ( AV94GXV2 <= AV82TFTLiqDescAux_Sels.size() )
         {
            AV83TFTLiqDescAux_Sel = (String)AV82TFTLiqDescAux_Sels.elementAt(-1+AV94GXV2) ;
            if ( AV77i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV83TFTLiqDescAux_Sel, GXv_char7) ;
            liquidacionwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char6 );
            AV77i = (long)(AV77i+1) ;
            AV94GXV2 = (int)(AV94GXV2+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV81TFTLiqDescAux)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Tipo", "")) ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            liquidacionwwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV81TFTLiqDescAux, GXv_char7) ;
            liquidacionwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( ( AV85TFLiqModTra_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Relación laboral", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         liquidacionwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV77i = 1 ;
         AV95GXV3 = 1 ;
         while ( AV95GXV3 <= AV85TFLiqModTra_Sels.size() )
         {
            AV86TFLiqModTra_Sel = (String)AV85TFLiqModTra_Sels.elementAt(-1+AV95GXV3) ;
            if ( AV77i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+httpContext.getMessage( web.gxdomainmodo_trabajo.getDescription(httpContext,(String)AV86TFLiqModTra_Sel), "") );
            AV77i = (long)(AV77i+1) ;
            AV95GXV3 = (int)(AV95GXV3+1) ;
         }
      }
      if ( ! ( ( AV88TFLiqFrecPag_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Frecuencia de pago", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         liquidacionwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV77i = 1 ;
         AV96GXV4 = 1 ;
         while ( AV96GXV4 <= AV88TFLiqFrecPag_Sels.size() )
         {
            AV89TFLiqFrecPag_Sel = ((Number) AV88TFLiqFrecPag_Sels.elementAt(-1+AV96GXV4)).byteValue() ;
            if ( AV77i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+httpContext.getMessage( web.gxdomainclaseleg.getDescription(httpContext,(byte)AV89TFLiqFrecPag_Sel), "") );
            AV77i = (long)(AV77i+1) ;
            AV96GXV4 = (int)(AV96GXV4+1) ;
         }
      }
      if ( ! ( (0==AV58TFLiqCntLeg) && (0==AV59TFLiqCntLeg_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Cantidad de recibos", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         liquidacionwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV58TFLiqCntLeg );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         liquidacionwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV59TFLiqCntLeg_To );
      }
      if ( ! ( ( AV62TFLiqError_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Error", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         liquidacionwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV77i = 1 ;
         AV97GXV5 = 1 ;
         while ( AV97GXV5 <= AV62TFLiqError_Sels.size() )
         {
            AV63TFLiqError_Sel = (String)AV62TFLiqError_Sels.elementAt(-1+AV97GXV5) ;
            if ( AV77i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV63TFLiqError_Sel, GXv_char7) ;
            liquidacionwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char6 );
            AV77i = (long)(AV77i+1) ;
            AV97GXV5 = (int)(AV97GXV5+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV61TFLiqError)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Error", "")) ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            liquidacionwwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV61TFLiqError, GXv_char7) ;
            liquidacionwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( ( AV66TFLiqDescrip_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Observación", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         liquidacionwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV77i = 1 ;
         AV98GXV6 = 1 ;
         while ( AV98GXV6 <= AV66TFLiqDescrip_Sels.size() )
         {
            AV67TFLiqDescrip_Sel = (String)AV66TFLiqDescrip_Sels.elementAt(-1+AV98GXV6) ;
            if ( AV77i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV67TFLiqDescrip_Sel, GXv_char7) ;
            liquidacionwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+GXt_char6 );
            AV77i = (long)(AV77i+1) ;
            AV98GXV6 = (int)(AV98GXV6+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV65TFLiqDescrip)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Observación", "")) ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            liquidacionwwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV65TFLiqDescrip, GXv_char7) ;
            liquidacionwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV72TFLiqImpBruto)==0) && (DecimalUtil.compareTo(DecimalUtil.ZERO, AV73TFLiqImpBruto_To)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Bruto", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         liquidacionwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV72TFLiqImpBruto)) );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         liquidacionwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV73TFLiqImpBruto_To)) );
      }
      if ( ! ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV74TFLiqImpNeto)==0) && (DecimalUtil.compareTo(DecimalUtil.ZERO, AV75TFLiqImpNeto_To)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), httpContext.getMessage( "Neto", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         liquidacionwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV74TFLiqImpNeto)) );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), httpContext.getMessage( "WWP_TSTo", "")) ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         liquidacionwwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(AV75TFLiqImpNeto_To)) );
      }
      AV14CellRow = (int)(AV14CellRow+2) ;
   }

   public void S141( )
   {
      /* 'WRITECOLUMNTITLES' Routine */
      returnInSub = false ;
      AV36VisibleColumnCount = 0 ;
      if ( GXutil.strcmp(AV22Session.getValue("LiquidacionWWColumnsSelector"), "") != 0 )
      {
         AV31ColumnsSelectorXML = AV22Session.getValue("LiquidacionWWColumnsSelector") ;
         AV28ColumnsSelector.fromxml(AV31ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S151 ();
         if (returnInSub) return;
      }
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV28ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+10)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV28ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+11)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV28ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+12)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV28ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+13)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV28ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+14)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV28ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+19)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      ((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV28ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+20)).setgxTv_SdtWWPColumnsSelector_Column_Isvisible( false );
      AV28ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().sort("Order");
      AV99GXV7 = 1 ;
      while ( AV99GXV7 <= AV28ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
      {
         AV30ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV28ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV99GXV7));
         if ( AV30ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV36VisibleColumnCount), 1, 1).setText( httpContext.getMessage( ((GXutil.strcmp("", AV30ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname())==0) ? AV30ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname() : AV30ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname()), "") );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV36VisibleColumnCount), 1, 1).setBold( (short)(1) );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV36VisibleColumnCount), 1, 1).setColor( 11 );
            AV36VisibleColumnCount = (long)(AV36VisibleColumnCount+1) ;
         }
         AV99GXV7 = (int)(AV99GXV7+1) ;
      }
   }

   public void S161( )
   {
      /* 'WRITEDATA' Routine */
      returnInSub = false ;
      AV101Liquidacionwwds_1_periodoliq = AV18PeriodoLiq ;
      AV102Liquidacionwwds_2_liqrelnro = AV21LiqRelNro ;
      AV103Liquidacionwwds_3_tfliqnro = AV39TFLiqNro ;
      AV104Liquidacionwwds_4_tfliqnro_to = AV40TFLiqNro_To ;
      AV105Liquidacionwwds_5_tfliqnombre = AV41TFLiqNombre ;
      AV106Liquidacionwwds_6_tfliqnombre_sel = AV42TFLiqNombre_Sel ;
      AV107Liquidacionwwds_7_tfliqfecha = AV43TFLiqFecha ;
      AV108Liquidacionwwds_8_tfliqfecha_to = AV44TFLiqFecha_To ;
      AV109Liquidacionwwds_9_tfliqperpalabra = AV46TFLiqPerPalabra ;
      AV110Liquidacionwwds_10_tfliqperpalabra_sels = AV47TFLiqPerPalabra_Sels ;
      AV111Liquidacionwwds_11_tfliqfecpago = AV49TFLiqFecPago ;
      AV112Liquidacionwwds_12_tfliqfecpago_to = AV50TFLiqFecPago_To ;
      AV113Liquidacionwwds_13_tftliqdescaux = AV81TFTLiqDescAux ;
      AV114Liquidacionwwds_14_tftliqdescaux_sels = AV82TFTLiqDescAux_Sels ;
      AV115Liquidacionwwds_15_tfliqmodtra_sels = AV85TFLiqModTra_Sels ;
      AV116Liquidacionwwds_16_tfliqfrecpag_sels = AV88TFLiqFrecPag_Sels ;
      AV117Liquidacionwwds_17_tfliqcntleg = AV58TFLiqCntLeg ;
      AV118Liquidacionwwds_18_tfliqcntleg_to = AV59TFLiqCntLeg_To ;
      AV119Liquidacionwwds_19_tfliqerror = AV61TFLiqError ;
      AV120Liquidacionwwds_20_tfliqerror_sels = AV62TFLiqError_Sels ;
      AV121Liquidacionwwds_21_tfliqdescrip = AV65TFLiqDescrip ;
      AV122Liquidacionwwds_22_tfliqdescrip_sels = AV66TFLiqDescrip_Sels ;
      AV123Liquidacionwwds_23_tfliqimpbruto = AV72TFLiqImpBruto ;
      AV124Liquidacionwwds_24_tfliqimpbruto_to = AV73TFLiqImpBruto_To ;
      AV125Liquidacionwwds_25_tfliqimpneto = AV74TFLiqImpNeto ;
      AV126Liquidacionwwds_26_tfliqimpneto_to = AV75TFLiqImpNeto_To ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A748LiqPerPalabra ,
                                           AV110Liquidacionwwds_10_tfliqperpalabra_sels ,
                                           A2368TLiqDescAux ,
                                           AV114Liquidacionwwds_14_tftliqdescaux_sels ,
                                           A2409LiqModTra ,
                                           AV115Liquidacionwwds_15_tfliqmodtra_sels ,
                                           Byte.valueOf(A2414LiqFrecPag) ,
                                           AV116Liquidacionwwds_16_tfliqfrecpag_sels ,
                                           A766LiqError ,
                                           AV120Liquidacionwwds_20_tfliqerror_sels ,
                                           A271LiqDescrip ,
                                           AV122Liquidacionwwds_22_tfliqdescrip_sels ,
                                           Integer.valueOf(AV103Liquidacionwwds_3_tfliqnro) ,
                                           Integer.valueOf(AV104Liquidacionwwds_4_tfliqnro_to) ,
                                           AV106Liquidacionwwds_6_tfliqnombre_sel ,
                                           AV107Liquidacionwwds_7_tfliqfecha ,
                                           AV108Liquidacionwwds_8_tfliqfecha_to ,
                                           Integer.valueOf(AV110Liquidacionwwds_10_tfliqperpalabra_sels.size()) ,
                                           AV109Liquidacionwwds_9_tfliqperpalabra ,
                                           AV111Liquidacionwwds_11_tfliqfecpago ,
                                           AV112Liquidacionwwds_12_tfliqfecpago_to ,
                                           Integer.valueOf(AV114Liquidacionwwds_14_tftliqdescaux_sels.size()) ,
                                           AV113Liquidacionwwds_13_tftliqdescaux ,
                                           Integer.valueOf(AV115Liquidacionwwds_15_tfliqmodtra_sels.size()) ,
                                           Integer.valueOf(AV116Liquidacionwwds_16_tfliqfrecpag_sels.size()) ,
                                           Short.valueOf(AV117Liquidacionwwds_17_tfliqcntleg) ,
                                           Short.valueOf(AV118Liquidacionwwds_18_tfliqcntleg_to) ,
                                           Integer.valueOf(AV120Liquidacionwwds_20_tfliqerror_sels.size()) ,
                                           AV119Liquidacionwwds_19_tfliqerror ,
                                           Integer.valueOf(AV122Liquidacionwwds_22_tfliqdescrip_sels.size()) ,
                                           AV121Liquidacionwwds_21_tfliqdescrip ,
                                           AV123Liquidacionwwds_23_tfliqimpbruto ,
                                           AV124Liquidacionwwds_24_tfliqimpbruto_to ,
                                           AV125Liquidacionwwds_25_tfliqimpneto ,
                                           AV126Liquidacionwwds_26_tfliqimpneto_to ,
                                           Integer.valueOf(A31LiqNro) ,
                                           A874LiqNombre ,
                                           A98LiqFecha ,
                                           A280LiqFecPago ,
                                           Short.valueOf(A495LiqCntLeg) ,
                                           A497LiqImpBruto ,
                                           A496LiqImpNeto ,
                                           Short.valueOf(AV19OrderedBy) ,
                                           Boolean.valueOf(AV20OrderedDsc) ,
                                           Integer.valueOf(A2112LiqRelNro) ,
                                           Integer.valueOf(AV78CliCod) ,
                                           Short.valueOf(AV79EmpCod) ,
                                           AV101Liquidacionwwds_1_periodoliq ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) ,
                                           A1729PeriodoLiq } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DATE,
                                           TypeConstants.DATE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT,
                                           TypeConstants.SHORT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.SHORT, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.BOOLEAN,
                                           TypeConstants.INT, TypeConstants.SHORT, TypeConstants.DATE, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.DATE
                                           }
      });
      lV109Liquidacionwwds_9_tfliqperpalabra = GXutil.padr( GXutil.rtrim( AV109Liquidacionwwds_9_tfliqperpalabra), 20, "%") ;
      lV113Liquidacionwwds_13_tftliqdescaux = GXutil.concat( GXutil.rtrim( AV113Liquidacionwwds_13_tftliqdescaux), "%", "") ;
      lV119Liquidacionwwds_19_tfliqerror = GXutil.concat( GXutil.rtrim( AV119Liquidacionwwds_19_tfliqerror), "%", "") ;
      lV121Liquidacionwwds_21_tfliqdescrip = GXutil.concat( GXutil.rtrim( AV121Liquidacionwwds_21_tfliqdescrip), "%", "") ;
      /* Using cursor P02F72 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV78CliCod), Short.valueOf(AV79EmpCod), AV101Liquidacionwwds_1_periodoliq, Integer.valueOf(AV103Liquidacionwwds_3_tfliqnro), Integer.valueOf(AV104Liquidacionwwds_4_tfliqnro_to), AV106Liquidacionwwds_6_tfliqnombre_sel, AV107Liquidacionwwds_7_tfliqfecha, AV108Liquidacionwwds_8_tfliqfecha_to, lV109Liquidacionwwds_9_tfliqperpalabra, AV111Liquidacionwwds_11_tfliqfecpago, AV112Liquidacionwwds_12_tfliqfecpago_to, lV113Liquidacionwwds_13_tftliqdescaux, Short.valueOf(AV117Liquidacionwwds_17_tfliqcntleg), Short.valueOf(AV118Liquidacionwwds_18_tfliqcntleg_to), lV119Liquidacionwwds_19_tfliqerror, lV121Liquidacionwwds_21_tfliqdescrip, AV123Liquidacionwwds_23_tfliqimpbruto, AV124Liquidacionwwds_24_tfliqimpbruto_to, AV125Liquidacionwwds_25_tfliqimpneto, AV126Liquidacionwwds_26_tfliqimpneto_to});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1EmpCod = P02F72_A1EmpCod[0] ;
         A3CliCod = P02F72_A3CliCod[0] ;
         A2112LiqRelNro = P02F72_A2112LiqRelNro[0] ;
         n2112LiqRelNro = P02F72_n2112LiqRelNro[0] ;
         A496LiqImpNeto = P02F72_A496LiqImpNeto[0] ;
         A497LiqImpBruto = P02F72_A497LiqImpBruto[0] ;
         A271LiqDescrip = P02F72_A271LiqDescrip[0] ;
         A766LiqError = P02F72_A766LiqError[0] ;
         A495LiqCntLeg = P02F72_A495LiqCntLeg[0] ;
         A2414LiqFrecPag = P02F72_A2414LiqFrecPag[0] ;
         A2409LiqModTra = P02F72_A2409LiqModTra[0] ;
         A2368TLiqDescAux = P02F72_A2368TLiqDescAux[0] ;
         A280LiqFecPago = P02F72_A280LiqFecPago[0] ;
         A748LiqPerPalabra = P02F72_A748LiqPerPalabra[0] ;
         A98LiqFecha = P02F72_A98LiqFecha[0] ;
         A874LiqNombre = P02F72_A874LiqNombre[0] ;
         A31LiqNro = P02F72_A31LiqNro[0] ;
         A1729PeriodoLiq = P02F72_A1729PeriodoLiq[0] ;
         AV14CellRow = (int)(AV14CellRow+1) ;
         /* Execute user subroutine: 'BEFOREWRITELINE' */
         S172 ();
         if ( returnInSub )
         {
            pr_default.close(0);
            returnInSub = true;
            if (true) return;
         }
         AV36VisibleColumnCount = 0 ;
         AV127GXV8 = 1 ;
         while ( AV127GXV8 <= AV28ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
         {
            AV30ColumnsSelector_Column = (web.wwpbaseobjects.SdtWWPColumnsSelector_Column)((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV28ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV127GXV8));
            if ( AV30ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
            {
               if ( GXutil.strcmp(AV30ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LiqNro") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV36VisibleColumnCount), 1, 1).setNumber( A31LiqNro );
               }
               else if ( GXutil.strcmp(AV30ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LiqNombre") == 0 )
               {
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A874LiqNombre, GXv_char7) ;
                  liquidacionwwexport.this.GXt_char6 = GXv_char7[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV36VisibleColumnCount), 1, 1).setText( GXt_char6 );
               }
               else if ( GXutil.strcmp(AV30ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LiqFecha") == 0 )
               {
                  GXt_dtime8 = GXutil.resetTime( A98LiqFecha );
                  AV11ExcelDocument.setDateFormat(localUtil, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " ");
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV36VisibleColumnCount), 1, 1).setDate( GXt_dtime8 );
               }
               else if ( GXutil.strcmp(AV30ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LiqPerPalabra") == 0 )
               {
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A748LiqPerPalabra, GXv_char7) ;
                  liquidacionwwexport.this.GXt_char6 = GXv_char7[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV36VisibleColumnCount), 1, 1).setText( GXt_char6 );
               }
               else if ( GXutil.strcmp(AV30ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LiqFecPago") == 0 )
               {
                  GXt_dtime8 = GXutil.resetTime( A280LiqFecPago );
                  AV11ExcelDocument.setDateFormat(localUtil, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " ");
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV36VisibleColumnCount), 1, 1).setDate( GXt_dtime8 );
               }
               else if ( GXutil.strcmp(AV30ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "TLiqDescAux") == 0 )
               {
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A2368TLiqDescAux, GXv_char7) ;
                  liquidacionwwexport.this.GXt_char6 = GXv_char7[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV36VisibleColumnCount), 1, 1).setText( GXt_char6 );
               }
               else if ( GXutil.strcmp(AV30ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LiqModTra") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV36VisibleColumnCount), 1, 1).setText( httpContext.getMessage( web.gxdomainmodo_trabajo.getDescription(httpContext,(String)A2409LiqModTra), "") );
               }
               else if ( GXutil.strcmp(AV30ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LiqFrecPag") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV36VisibleColumnCount), 1, 1).setText( httpContext.getMessage( web.gxdomainclaseleg.getDescription(httpContext,(byte)A2414LiqFrecPag), "") );
               }
               else if ( GXutil.strcmp(AV30ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LiqCntLeg") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV36VisibleColumnCount), 1, 1).setNumber( A495LiqCntLeg );
               }
               else if ( GXutil.strcmp(AV30ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LiqError") == 0 )
               {
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A766LiqError, GXv_char7) ;
                  liquidacionwwexport.this.GXt_char6 = GXv_char7[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV36VisibleColumnCount), 1, 1).setText( GXt_char6 );
               }
               else if ( GXutil.strcmp(AV30ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LiqDescrip") == 0 )
               {
                  GXt_char6 = "" ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A271LiqDescrip, GXv_char7) ;
                  liquidacionwwexport.this.GXt_char6 = GXv_char7[0] ;
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV36VisibleColumnCount), 1, 1).setText( GXt_char6 );
               }
               else if ( GXutil.strcmp(AV30ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LiqImpBruto") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV36VisibleColumnCount), 1, 1).setNumber( (double)(DecimalUtil.decToDouble(A497LiqImpBruto)) );
               }
               else if ( GXutil.strcmp(AV30ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname(), "LiqImpNeto") == 0 )
               {
                  AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV36VisibleColumnCount), 1, 1).setNumber( (double)(DecimalUtil.decToDouble(A496LiqImpNeto)) );
               }
               AV36VisibleColumnCount = (long)(AV36VisibleColumnCount+1) ;
            }
            AV127GXV8 = (int)(AV127GXV8+1) ;
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
      AV28ColumnsSelector = (web.wwpbaseobjects.SdtWWPColumnsSelector)new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector9[0] = AV28ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "LiqNro", "", "Número", false, "") ;
      AV28ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV28ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "LiqNombre", "", "Descripción", true, "") ;
      AV28ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV28ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "LiqFecha", "", "Fecha de liq.", false, "") ;
      AV28ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV28ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "LiqPerPalabra", "", "Periodo", true, "") ;
      AV28ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV28ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "LiqFecPago", "", "Fecha de pago", false, "") ;
      AV28ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV28ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "TLiqDescAux", "", "Tipo", true, "") ;
      AV28ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV28ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "LiqModTra", "", "Relación laboral", false, "") ;
      AV28ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV28ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "LiqFrecPag", "", "Frecuencia de pago", false, "") ;
      AV28ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV28ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "LiqCntLeg", "", "Cantidad de recibos", false, "") ;
      AV28ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV28ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "&EstadoPrin", "Estado", "Recibos", true, "") ;
      AV28ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV28ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "&EstadoPDF", "Estado", "PDFs", true, "") ;
      AV28ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV28ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "&EstadoLSDDep", "Estado", "Dep. LSD", false, "") ;
      AV28ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV28ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "&EstadoContr", "Estado", "Contr.", false, "") ;
      AV28ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV28ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "&EstadoAuxFut", "Estado", "Otros conceptos aux.", false, "") ;
      AV28ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV28ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "LiqError", "", "Error", false, "") ;
      AV28ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV28ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "LiqDescrip", "", "Observación", false, "") ;
      AV28ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV28ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "LiqImpBruto", "", "Bruto", false, "") ;
      AV28ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV28ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "LiqImpNeto", "", "Neto", false, "") ;
      AV28ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV28ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "&VerSVG", "", "", true, "") ;
      AV28ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      if ( ( A278LiqEstado != 4 ) && GXutil.dateCompare(GXutil.resetTime(A283LiqPeriodo), GXutil.resetTime(new web.ultimoperiodo(remoteHandle, context).executeUdp( A3CliCod, A1EmpCod))) && GXutil.dateCompare(GXutil.nullDate(), A719LiqFecImp) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         GXv_SdtWWPColumnsSelector9[0] = AV28ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "&ModificarSVG", "", "", true, "") ;
         AV28ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      }
      else
      {
         GXv_SdtWWPColumnsSelector9[0] = AV28ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "", "", "", false, "") ;
         AV28ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      }
      GXt_char6 = AV32UserCustomValue ;
      GXv_char7[0] = GXt_char6 ;
      new web.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "LiquidacionWWColumnsSelector", GXv_char7) ;
      liquidacionwwexport.this.GXt_char6 = GXv_char7[0] ;
      AV32UserCustomValue = GXt_char6 ;
      if ( ! ( (GXutil.strcmp("", AV32UserCustomValue)==0) ) )
      {
         AV29ColumnsSelectorAux.fromxml(AV32UserCustomValue, null, null);
         GXv_SdtWWPColumnsSelector9[0] = AV29ColumnsSelectorAux;
         GXv_SdtWWPColumnsSelector10[0] = AV28ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnselector_updatecolumns(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, GXv_SdtWWPColumnsSelector10) ;
         AV29ColumnsSelectorAux = GXv_SdtWWPColumnsSelector9[0] ;
         AV28ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      }
   }

   public void S201( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV22Session.getValue("LiquidacionWWGridState"), "") == 0 )
      {
         AV24GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "LiquidacionWWGridState"), null, null);
      }
      else
      {
         AV24GridState.fromxml(AV22Session.getValue("LiquidacionWWGridState"), null, null);
      }
      AV19OrderedBy = AV24GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV20OrderedDsc = AV24GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV128GXV9 = 1 ;
      while ( AV128GXV9 <= AV24GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV25GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV24GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV128GXV9));
         if ( GXutil.strcmp(AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "LIQRELNRO") == 0 )
         {
            AV21LiqRelNro = (int)(GXutil.lval( AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQNRO") == 0 )
         {
            AV39TFLiqNro = (int)(GXutil.lval( AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV40TFLiqNro_To = (int)(GXutil.lval( AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQNOMBRE") == 0 )
         {
            AV41TFLiqNombre = AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQNOMBRE_SEL") == 0 )
         {
            AV42TFLiqNombre_Sel = AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQFECHA") == 0 )
         {
            AV43TFLiqFecha = localUtil.ctod( AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            AV44TFLiqFecha_To = localUtil.ctod( AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
         }
         else if ( GXutil.strcmp(AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQPERPALABRA") == 0 )
         {
            AV46TFLiqPerPalabra = AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQPERPALABRA_SEL") == 0 )
         {
            AV45TFLiqPerPalabra_SelsJson = AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV47TFLiqPerPalabra_Sels.fromJSonString(AV45TFLiqPerPalabra_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQFECPAGO") == 0 )
         {
            AV49TFLiqFecPago = localUtil.ctod( AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            AV50TFLiqFecPago_To = localUtil.ctod( AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
         }
         else if ( GXutil.strcmp(AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFTLIQDESCAUX") == 0 )
         {
            AV81TFTLiqDescAux = AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFTLIQDESCAUX_SEL") == 0 )
         {
            AV80TFTLiqDescAux_SelsJson = AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV82TFTLiqDescAux_Sels.fromJSonString(AV80TFTLiqDescAux_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQMODTRA_SEL") == 0 )
         {
            AV84TFLiqModTra_SelsJson = AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV85TFLiqModTra_Sels.fromJSonString(AV84TFLiqModTra_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQFRECPAG_SEL") == 0 )
         {
            AV87TFLiqFrecPag_SelsJson = AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV88TFLiqFrecPag_Sels.fromJSonString(AV87TFLiqFrecPag_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQCNTLEG") == 0 )
         {
            AV58TFLiqCntLeg = (short)(GXutil.lval( AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV59TFLiqCntLeg_To = (short)(GXutil.lval( AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQERROR") == 0 )
         {
            AV61TFLiqError = AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQERROR_SEL") == 0 )
         {
            AV60TFLiqError_SelsJson = AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV62TFLiqError_Sels.fromJSonString(AV60TFLiqError_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQDESCRIP") == 0 )
         {
            AV65TFLiqDescrip = AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQDESCRIP_SEL") == 0 )
         {
            AV64TFLiqDescrip_SelsJson = AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV66TFLiqDescrip_Sels.fromJSonString(AV64TFLiqDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQIMPBRUTO") == 0 )
         {
            AV72TFLiqImpBruto = CommonUtil.decimalVal( AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV73TFLiqImpBruto_To = CommonUtil.decimalVal( AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQIMPNETO") == 0 )
         {
            AV74TFLiqImpNeto = CommonUtil.decimalVal( AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV75TFLiqImpNeto_To = CommonUtil.decimalVal( AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV17MenuOpcCod = AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&PERIODOLIQ") == 0 )
         {
            AV18PeriodoLiq = localUtil.ctod( AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
         }
         AV128GXV9 = (int)(AV128GXV9+1) ;
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
      this.aP0[0] = liquidacionwwexport.this.AV12Filename;
      this.aP1[0] = liquidacionwwexport.this.AV13ErrorMessage;
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
      AV92Pgmname = "" ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV11ExcelDocument = new com.genexus.gxoffice.ExcelDoc();
      AV42TFLiqNombre_Sel = "" ;
      AV41TFLiqNombre = "" ;
      AV43TFLiqFecha = GXutil.nullDate() ;
      AV44TFLiqFecha_To = GXutil.nullDate() ;
      AV47TFLiqPerPalabra_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV48TFLiqPerPalabra_Sel = "" ;
      AV46TFLiqPerPalabra = "" ;
      AV49TFLiqFecPago = GXutil.nullDate() ;
      AV50TFLiqFecPago_To = GXutil.nullDate() ;
      AV82TFTLiqDescAux_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV83TFTLiqDescAux_Sel = "" ;
      AV81TFTLiqDescAux = "" ;
      AV85TFLiqModTra_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV86TFLiqModTra_Sel = "" ;
      AV88TFLiqFrecPag_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV62TFLiqError_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV63TFLiqError_Sel = "" ;
      AV61TFLiqError = "" ;
      AV66TFLiqDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV67TFLiqDescrip_Sel = "" ;
      AV65TFLiqDescrip = "" ;
      AV72TFLiqImpBruto = DecimalUtil.ZERO ;
      AV73TFLiqImpBruto_To = DecimalUtil.ZERO ;
      AV74TFLiqImpNeto = DecimalUtil.ZERO ;
      AV75TFLiqImpNeto_To = DecimalUtil.ZERO ;
      GXv_exceldoc4 = new com.genexus.gxoffice.ExcelDoc[1] ;
      GXv_int5 = new short[1] ;
      A283LiqPeriodo = GXutil.nullDate() ;
      A719LiqFecImp = GXutil.resetTime( GXutil.nullDate() );
      AV22Session = httpContext.getWebSession();
      AV31ColumnsSelectorXML = "" ;
      AV28ColumnsSelector = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV30ColumnsSelector_Column = new web.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      A874LiqNombre = "" ;
      A98LiqFecha = GXutil.nullDate() ;
      A748LiqPerPalabra = "" ;
      A280LiqFecPago = GXutil.nullDate() ;
      A2368TLiqDescAux = "" ;
      A2409LiqModTra = "" ;
      A766LiqError = "" ;
      A271LiqDescrip = "" ;
      A497LiqImpBruto = DecimalUtil.ZERO ;
      A496LiqImpNeto = DecimalUtil.ZERO ;
      AV101Liquidacionwwds_1_periodoliq = GXutil.nullDate() ;
      AV18PeriodoLiq = GXutil.nullDate() ;
      AV105Liquidacionwwds_5_tfliqnombre = "" ;
      AV106Liquidacionwwds_6_tfliqnombre_sel = "" ;
      AV107Liquidacionwwds_7_tfliqfecha = GXutil.nullDate() ;
      AV108Liquidacionwwds_8_tfliqfecha_to = GXutil.nullDate() ;
      AV109Liquidacionwwds_9_tfliqperpalabra = "" ;
      AV110Liquidacionwwds_10_tfliqperpalabra_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV111Liquidacionwwds_11_tfliqfecpago = GXutil.nullDate() ;
      AV112Liquidacionwwds_12_tfliqfecpago_to = GXutil.nullDate() ;
      AV113Liquidacionwwds_13_tftliqdescaux = "" ;
      AV114Liquidacionwwds_14_tftliqdescaux_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV115Liquidacionwwds_15_tfliqmodtra_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV116Liquidacionwwds_16_tfliqfrecpag_sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV119Liquidacionwwds_19_tfliqerror = "" ;
      AV120Liquidacionwwds_20_tfliqerror_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV121Liquidacionwwds_21_tfliqdescrip = "" ;
      AV122Liquidacionwwds_22_tfliqdescrip_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV123Liquidacionwwds_23_tfliqimpbruto = DecimalUtil.ZERO ;
      AV124Liquidacionwwds_24_tfliqimpbruto_to = DecimalUtil.ZERO ;
      AV125Liquidacionwwds_25_tfliqimpneto = DecimalUtil.ZERO ;
      AV126Liquidacionwwds_26_tfliqimpneto_to = DecimalUtil.ZERO ;
      scmdbuf = "" ;
      lV109Liquidacionwwds_9_tfliqperpalabra = "" ;
      lV113Liquidacionwwds_13_tftliqdescaux = "" ;
      lV119Liquidacionwwds_19_tfliqerror = "" ;
      lV121Liquidacionwwds_21_tfliqdescrip = "" ;
      A1729PeriodoLiq = GXutil.nullDate() ;
      P02F72_A1EmpCod = new short[1] ;
      P02F72_A3CliCod = new int[1] ;
      P02F72_A2112LiqRelNro = new int[1] ;
      P02F72_n2112LiqRelNro = new boolean[] {false} ;
      P02F72_A496LiqImpNeto = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P02F72_A497LiqImpBruto = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P02F72_A271LiqDescrip = new String[] {""} ;
      P02F72_A766LiqError = new String[] {""} ;
      P02F72_A495LiqCntLeg = new short[1] ;
      P02F72_A2414LiqFrecPag = new byte[1] ;
      P02F72_A2409LiqModTra = new String[] {""} ;
      P02F72_A2368TLiqDescAux = new String[] {""} ;
      P02F72_A280LiqFecPago = new java.util.Date[] {GXutil.nullDate()} ;
      P02F72_A748LiqPerPalabra = new String[] {""} ;
      P02F72_A98LiqFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P02F72_A874LiqNombre = new String[] {""} ;
      P02F72_A31LiqNro = new int[1] ;
      P02F72_A1729PeriodoLiq = new java.util.Date[] {GXutil.nullDate()} ;
      GXt_dtime8 = GXutil.resetTime( GXutil.nullDate() );
      AV32UserCustomValue = "" ;
      GXt_char6 = "" ;
      GXv_char7 = new String[1] ;
      AV29ColumnsSelectorAux = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector9 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector10 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      AV24GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV25GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV45TFLiqPerPalabra_SelsJson = "" ;
      AV80TFTLiqDescAux_SelsJson = "" ;
      AV84TFLiqModTra_SelsJson = "" ;
      AV87TFLiqFrecPag_SelsJson = "" ;
      AV60TFLiqError_SelsJson = "" ;
      AV64TFLiqDescrip_SelsJson = "" ;
      AV17MenuOpcCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.liquidacionwwexport__default(),
         new Object[] {
             new Object[] {
            P02F72_A1EmpCod, P02F72_A3CliCod, P02F72_A2112LiqRelNro, P02F72_n2112LiqRelNro, P02F72_A496LiqImpNeto, P02F72_A497LiqImpBruto, P02F72_A271LiqDescrip, P02F72_A766LiqError, P02F72_A495LiqCntLeg, P02F72_A2414LiqFrecPag,
            P02F72_A2409LiqModTra, P02F72_A2368TLiqDescAux, P02F72_A280LiqFecPago, P02F72_A748LiqPerPalabra, P02F72_A98LiqFecha, P02F72_A874LiqNombre, P02F72_A31LiqNro, P02F72_A1729PeriodoLiq
            }
         }
      );
      AV92Pgmname = "LiquidacionWWExport" ;
      /* GeneXus formulas. */
      AV92Pgmname = "LiquidacionWWExport" ;
      Gx_err = (short)(0) ;
   }

   private byte AV89TFLiqFrecPag_Sel ;
   private byte A278LiqEstado ;
   private byte A2414LiqFrecPag ;
   private short AV58TFLiqCntLeg ;
   private short AV59TFLiqCntLeg_To ;
   private short GXv_int5[] ;
   private short A1EmpCod ;
   private short A495LiqCntLeg ;
   private short AV117Liquidacionwwds_17_tfliqcntleg ;
   private short AV118Liquidacionwwds_18_tfliqcntleg_to ;
   private short AV19OrderedBy ;
   private short AV79EmpCod ;
   private short Gx_err ;
   private int AV14CellRow ;
   private int AV15FirstColumn ;
   private int AV16Random ;
   private int AV21LiqRelNro ;
   private int AV39TFLiqNro ;
   private int AV40TFLiqNro_To ;
   private int AV93GXV1 ;
   private int AV94GXV2 ;
   private int AV95GXV3 ;
   private int AV96GXV4 ;
   private int AV97GXV5 ;
   private int AV98GXV6 ;
   private int A3CliCod ;
   private int AV99GXV7 ;
   private int A31LiqNro ;
   private int AV102Liquidacionwwds_2_liqrelnro ;
   private int AV103Liquidacionwwds_3_tfliqnro ;
   private int AV104Liquidacionwwds_4_tfliqnro_to ;
   private int AV110Liquidacionwwds_10_tfliqperpalabra_sels_size ;
   private int AV114Liquidacionwwds_14_tftliqdescaux_sels_size ;
   private int AV115Liquidacionwwds_15_tfliqmodtra_sels_size ;
   private int AV116Liquidacionwwds_16_tfliqfrecpag_sels_size ;
   private int AV120Liquidacionwwds_20_tfliqerror_sels_size ;
   private int AV122Liquidacionwwds_22_tfliqdescrip_sels_size ;
   private int A2112LiqRelNro ;
   private int AV78CliCod ;
   private int AV127GXV8 ;
   private int AV128GXV9 ;
   private long AV77i ;
   private long AV36VisibleColumnCount ;
   private java.math.BigDecimal AV72TFLiqImpBruto ;
   private java.math.BigDecimal AV73TFLiqImpBruto_To ;
   private java.math.BigDecimal AV74TFLiqImpNeto ;
   private java.math.BigDecimal AV75TFLiqImpNeto_To ;
   private java.math.BigDecimal A497LiqImpBruto ;
   private java.math.BigDecimal A496LiqImpNeto ;
   private java.math.BigDecimal AV123Liquidacionwwds_23_tfliqimpbruto ;
   private java.math.BigDecimal AV124Liquidacionwwds_24_tfliqimpbruto_to ;
   private java.math.BigDecimal AV125Liquidacionwwds_25_tfliqimpneto ;
   private java.math.BigDecimal AV126Liquidacionwwds_26_tfliqimpneto_to ;
   private String AV92Pgmname ;
   private String AV48TFLiqPerPalabra_Sel ;
   private String AV46TFLiqPerPalabra ;
   private String AV86TFLiqModTra_Sel ;
   private String A748LiqPerPalabra ;
   private String A2409LiqModTra ;
   private String AV109Liquidacionwwds_9_tfliqperpalabra ;
   private String scmdbuf ;
   private String lV109Liquidacionwwds_9_tfliqperpalabra ;
   private String GXt_char6 ;
   private String GXv_char7[] ;
   private java.util.Date A719LiqFecImp ;
   private java.util.Date GXt_dtime8 ;
   private java.util.Date AV43TFLiqFecha ;
   private java.util.Date AV44TFLiqFecha_To ;
   private java.util.Date AV49TFLiqFecPago ;
   private java.util.Date AV50TFLiqFecPago_To ;
   private java.util.Date A283LiqPeriodo ;
   private java.util.Date A98LiqFecha ;
   private java.util.Date A280LiqFecPago ;
   private java.util.Date AV101Liquidacionwwds_1_periodoliq ;
   private java.util.Date AV18PeriodoLiq ;
   private java.util.Date AV107Liquidacionwwds_7_tfliqfecha ;
   private java.util.Date AV108Liquidacionwwds_8_tfliqfecha_to ;
   private java.util.Date AV111Liquidacionwwds_11_tfliqfecpago ;
   private java.util.Date AV112Liquidacionwwds_12_tfliqfecpago_to ;
   private java.util.Date A1729PeriodoLiq ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean AV20OrderedDsc ;
   private boolean n2112LiqRelNro ;
   private boolean Cond_result ;
   private String AV31ColumnsSelectorXML ;
   private String AV32UserCustomValue ;
   private String AV45TFLiqPerPalabra_SelsJson ;
   private String AV80TFTLiqDescAux_SelsJson ;
   private String AV84TFLiqModTra_SelsJson ;
   private String AV87TFLiqFrecPag_SelsJson ;
   private String AV60TFLiqError_SelsJson ;
   private String AV64TFLiqDescrip_SelsJson ;
   private String AV12Filename ;
   private String AV13ErrorMessage ;
   private String AV42TFLiqNombre_Sel ;
   private String AV41TFLiqNombre ;
   private String AV83TFTLiqDescAux_Sel ;
   private String AV81TFTLiqDescAux ;
   private String AV63TFLiqError_Sel ;
   private String AV61TFLiqError ;
   private String AV67TFLiqDescrip_Sel ;
   private String AV65TFLiqDescrip ;
   private String A874LiqNombre ;
   private String A2368TLiqDescAux ;
   private String A766LiqError ;
   private String A271LiqDescrip ;
   private String AV105Liquidacionwwds_5_tfliqnombre ;
   private String AV106Liquidacionwwds_6_tfliqnombre_sel ;
   private String AV113Liquidacionwwds_13_tftliqdescaux ;
   private String AV119Liquidacionwwds_19_tfliqerror ;
   private String AV121Liquidacionwwds_21_tfliqdescrip ;
   private String lV113Liquidacionwwds_13_tftliqdescaux ;
   private String lV119Liquidacionwwds_19_tfliqerror ;
   private String lV121Liquidacionwwds_21_tfliqdescrip ;
   private String AV17MenuOpcCod ;
   private GXSimpleCollection<Byte> AV88TFLiqFrecPag_Sels ;
   private GXSimpleCollection<Byte> AV116Liquidacionwwds_16_tfliqfrecpag_sels ;
   private com.genexus.webpanels.WebSession AV22Session ;
   private GXSimpleCollection<String> AV47TFLiqPerPalabra_Sels ;
   private GXSimpleCollection<String> AV85TFLiqModTra_Sels ;
   private GXSimpleCollection<String> AV82TFTLiqDescAux_Sels ;
   private GXSimpleCollection<String> AV62TFLiqError_Sels ;
   private GXSimpleCollection<String> AV66TFLiqDescrip_Sels ;
   private String[] aP1 ;
   private String[] aP0 ;
   private IDataStoreProvider pr_default ;
   private short[] P02F72_A1EmpCod ;
   private int[] P02F72_A3CliCod ;
   private int[] P02F72_A2112LiqRelNro ;
   private boolean[] P02F72_n2112LiqRelNro ;
   private java.math.BigDecimal[] P02F72_A496LiqImpNeto ;
   private java.math.BigDecimal[] P02F72_A497LiqImpBruto ;
   private String[] P02F72_A271LiqDescrip ;
   private String[] P02F72_A766LiqError ;
   private short[] P02F72_A495LiqCntLeg ;
   private byte[] P02F72_A2414LiqFrecPag ;
   private String[] P02F72_A2409LiqModTra ;
   private String[] P02F72_A2368TLiqDescAux ;
   private java.util.Date[] P02F72_A280LiqFecPago ;
   private String[] P02F72_A748LiqPerPalabra ;
   private java.util.Date[] P02F72_A98LiqFecha ;
   private String[] P02F72_A874LiqNombre ;
   private int[] P02F72_A31LiqNro ;
   private java.util.Date[] P02F72_A1729PeriodoLiq ;
   private com.genexus.gxoffice.ExcelDoc AV11ExcelDocument ;
   private com.genexus.gxoffice.ExcelDoc GXv_exceldoc4[] ;
   private GXSimpleCollection<String> AV110Liquidacionwwds_10_tfliqperpalabra_sels ;
   private GXSimpleCollection<String> AV115Liquidacionwwds_15_tfliqmodtra_sels ;
   private GXSimpleCollection<String> AV114Liquidacionwwds_14_tftliqdescaux_sels ;
   private GXSimpleCollection<String> AV120Liquidacionwwds_20_tfliqerror_sels ;
   private GXSimpleCollection<String> AV122Liquidacionwwds_22_tfliqdescrip_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV24GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV25GridStateFilterValue ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV28ColumnsSelector ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV29ColumnsSelectorAux ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector9[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector10[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector_Column AV30ColumnsSelector_Column ;
}

final  class liquidacionwwexport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P02F72( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A748LiqPerPalabra ,
                                          GXSimpleCollection<String> AV110Liquidacionwwds_10_tfliqperpalabra_sels ,
                                          String A2368TLiqDescAux ,
                                          GXSimpleCollection<String> AV114Liquidacionwwds_14_tftliqdescaux_sels ,
                                          String A2409LiqModTra ,
                                          GXSimpleCollection<String> AV115Liquidacionwwds_15_tfliqmodtra_sels ,
                                          byte A2414LiqFrecPag ,
                                          GXSimpleCollection<Byte> AV116Liquidacionwwds_16_tfliqfrecpag_sels ,
                                          String A766LiqError ,
                                          GXSimpleCollection<String> AV120Liquidacionwwds_20_tfliqerror_sels ,
                                          String A271LiqDescrip ,
                                          GXSimpleCollection<String> AV122Liquidacionwwds_22_tfliqdescrip_sels ,
                                          int AV103Liquidacionwwds_3_tfliqnro ,
                                          int AV104Liquidacionwwds_4_tfliqnro_to ,
                                          String AV106Liquidacionwwds_6_tfliqnombre_sel ,
                                          java.util.Date AV107Liquidacionwwds_7_tfliqfecha ,
                                          java.util.Date AV108Liquidacionwwds_8_tfliqfecha_to ,
                                          int AV110Liquidacionwwds_10_tfliqperpalabra_sels_size ,
                                          String AV109Liquidacionwwds_9_tfliqperpalabra ,
                                          java.util.Date AV111Liquidacionwwds_11_tfliqfecpago ,
                                          java.util.Date AV112Liquidacionwwds_12_tfliqfecpago_to ,
                                          int AV114Liquidacionwwds_14_tftliqdescaux_sels_size ,
                                          String AV113Liquidacionwwds_13_tftliqdescaux ,
                                          int AV115Liquidacionwwds_15_tfliqmodtra_sels_size ,
                                          int AV116Liquidacionwwds_16_tfliqfrecpag_sels_size ,
                                          short AV117Liquidacionwwds_17_tfliqcntleg ,
                                          short AV118Liquidacionwwds_18_tfliqcntleg_to ,
                                          int AV120Liquidacionwwds_20_tfliqerror_sels_size ,
                                          String AV119Liquidacionwwds_19_tfliqerror ,
                                          int AV122Liquidacionwwds_22_tfliqdescrip_sels_size ,
                                          String AV121Liquidacionwwds_21_tfliqdescrip ,
                                          java.math.BigDecimal AV123Liquidacionwwds_23_tfliqimpbruto ,
                                          java.math.BigDecimal AV124Liquidacionwwds_24_tfliqimpbruto_to ,
                                          java.math.BigDecimal AV125Liquidacionwwds_25_tfliqimpneto ,
                                          java.math.BigDecimal AV126Liquidacionwwds_26_tfliqimpneto_to ,
                                          int A31LiqNro ,
                                          String A874LiqNombre ,
                                          java.util.Date A98LiqFecha ,
                                          java.util.Date A280LiqFecPago ,
                                          short A495LiqCntLeg ,
                                          java.math.BigDecimal A497LiqImpBruto ,
                                          java.math.BigDecimal A496LiqImpNeto ,
                                          short AV19OrderedBy ,
                                          boolean AV20OrderedDsc ,
                                          int A2112LiqRelNro ,
                                          int AV78CliCod ,
                                          short AV79EmpCod ,
                                          java.util.Date AV101Liquidacionwwds_1_periodoliq ,
                                          int A3CliCod ,
                                          short A1EmpCod ,
                                          java.util.Date A1729PeriodoLiq )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int11 = new byte[20];
      Object[] GXv_Object12 = new Object[2];
      scmdbuf = "SELECT EmpCod, CliCod, LiqRelNro, LiqImpNeto, LiqImpBruto, LiqDescrip, LiqError, LiqCntLeg, LiqFrecPag, LiqModTra, TLiqDescAux, LiqFecPago, LiqPerPalabra, LiqFecha," ;
      scmdbuf += " LiqNombre, LiqNro, PeriodoLiq FROM Liquidacion" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ? and PeriodoLiq = ?)");
      addWhere(sWhereString, "(LiqRelNro IS NULL)");
      if ( ! (0==AV103Liquidacionwwds_3_tfliqnro) )
      {
         addWhere(sWhereString, "(LiqNro >= ?)");
      }
      else
      {
         GXv_int11[3] = (byte)(1) ;
      }
      if ( ! (0==AV104Liquidacionwwds_4_tfliqnro_to) )
      {
         addWhere(sWhereString, "(LiqNro <= ?)");
      }
      else
      {
         GXv_int11[4] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV106Liquidacionwwds_6_tfliqnombre_sel)==0) )
      {
         addWhere(sWhereString, "(LiqNombre = ( ?))");
      }
      else
      {
         GXv_int11[5] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV107Liquidacionwwds_7_tfliqfecha)) )
      {
         addWhere(sWhereString, "(LiqFecha >= ?)");
      }
      else
      {
         GXv_int11[6] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV108Liquidacionwwds_8_tfliqfecha_to)) )
      {
         addWhere(sWhereString, "(LiqFecha <= ?)");
      }
      else
      {
         GXv_int11[7] = (byte)(1) ;
      }
      if ( ( AV110Liquidacionwwds_10_tfliqperpalabra_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV109Liquidacionwwds_9_tfliqperpalabra)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(LiqPerPalabra) like LOWER(?))");
      }
      else
      {
         GXv_int11[8] = (byte)(1) ;
      }
      if ( AV110Liquidacionwwds_10_tfliqperpalabra_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV110Liquidacionwwds_10_tfliqperpalabra_sels, "LiqPerPalabra IN (", ")")+")");
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV111Liquidacionwwds_11_tfliqfecpago)) )
      {
         addWhere(sWhereString, "(LiqFecPago >= ?)");
      }
      else
      {
         GXv_int11[9] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV112Liquidacionwwds_12_tfliqfecpago_to)) )
      {
         addWhere(sWhereString, "(LiqFecPago <= ?)");
      }
      else
      {
         GXv_int11[10] = (byte)(1) ;
      }
      if ( ( AV114Liquidacionwwds_14_tftliqdescaux_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV113Liquidacionwwds_13_tftliqdescaux)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(TLiqDescAux) like LOWER(?))");
      }
      else
      {
         GXv_int11[11] = (byte)(1) ;
      }
      if ( AV114Liquidacionwwds_14_tftliqdescaux_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV114Liquidacionwwds_14_tftliqdescaux_sels, "TLiqDescAux IN (", ")")+")");
      }
      if ( AV115Liquidacionwwds_15_tfliqmodtra_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV115Liquidacionwwds_15_tfliqmodtra_sels, "LiqModTra IN (", ")")+")");
      }
      if ( AV116Liquidacionwwds_16_tfliqfrecpag_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV116Liquidacionwwds_16_tfliqfrecpag_sels, "LiqFrecPag IN (", ")")+")");
      }
      if ( ! (0==AV117Liquidacionwwds_17_tfliqcntleg) )
      {
         addWhere(sWhereString, "(LiqCntLeg >= ?)");
      }
      else
      {
         GXv_int11[12] = (byte)(1) ;
      }
      if ( ! (0==AV118Liquidacionwwds_18_tfliqcntleg_to) )
      {
         addWhere(sWhereString, "(LiqCntLeg <= ?)");
      }
      else
      {
         GXv_int11[13] = (byte)(1) ;
      }
      if ( ( AV120Liquidacionwwds_20_tfliqerror_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV119Liquidacionwwds_19_tfliqerror)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(LiqError) like LOWER(?))");
      }
      else
      {
         GXv_int11[14] = (byte)(1) ;
      }
      if ( AV120Liquidacionwwds_20_tfliqerror_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV120Liquidacionwwds_20_tfliqerror_sels, "LiqError IN (", ")")+")");
      }
      if ( ( AV122Liquidacionwwds_22_tfliqdescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV121Liquidacionwwds_21_tfliqdescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(LiqDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int11[15] = (byte)(1) ;
      }
      if ( AV122Liquidacionwwds_22_tfliqdescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV122Liquidacionwwds_22_tfliqdescrip_sels, "LiqDescrip IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV123Liquidacionwwds_23_tfliqimpbruto)==0) )
      {
         addWhere(sWhereString, "(LiqImpBruto >= ?)");
      }
      else
      {
         GXv_int11[16] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV124Liquidacionwwds_24_tfliqimpbruto_to)==0) )
      {
         addWhere(sWhereString, "(LiqImpBruto <= ?)");
      }
      else
      {
         GXv_int11[17] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV125Liquidacionwwds_25_tfliqimpneto)==0) )
      {
         addWhere(sWhereString, "(LiqImpNeto >= ?)");
      }
      else
      {
         GXv_int11[18] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV126Liquidacionwwds_26_tfliqimpneto_to)==0) )
      {
         addWhere(sWhereString, "(LiqImpNeto <= ?)");
      }
      else
      {
         GXv_int11[19] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      if ( AV19OrderedBy == 1 )
      {
         scmdbuf += " ORDER BY CliCod, EmpCod, LiqNro DESC" ;
      }
      else if ( ( AV19OrderedBy == 2 ) && ! AV20OrderedDsc )
      {
         scmdbuf += " ORDER BY PeriodoLiq, LiqNro" ;
      }
      else if ( ( AV19OrderedBy == 2 ) && ( AV20OrderedDsc ) )
      {
         scmdbuf += " ORDER BY PeriodoLiq DESC, LiqNro DESC" ;
      }
      else if ( ( AV19OrderedBy == 3 ) && ! AV20OrderedDsc )
      {
         scmdbuf += " ORDER BY PeriodoLiq, LiqNombre" ;
      }
      else if ( ( AV19OrderedBy == 3 ) && ( AV20OrderedDsc ) )
      {
         scmdbuf += " ORDER BY PeriodoLiq DESC, LiqNombre DESC" ;
      }
      else if ( ( AV19OrderedBy == 4 ) && ! AV20OrderedDsc )
      {
         scmdbuf += " ORDER BY PeriodoLiq, LiqFecha" ;
      }
      else if ( ( AV19OrderedBy == 4 ) && ( AV20OrderedDsc ) )
      {
         scmdbuf += " ORDER BY PeriodoLiq DESC, LiqFecha DESC" ;
      }
      else if ( ( AV19OrderedBy == 5 ) && ! AV20OrderedDsc )
      {
         scmdbuf += " ORDER BY PeriodoLiq, LiqPerPalabra" ;
      }
      else if ( ( AV19OrderedBy == 5 ) && ( AV20OrderedDsc ) )
      {
         scmdbuf += " ORDER BY PeriodoLiq DESC, LiqPerPalabra DESC" ;
      }
      else if ( ( AV19OrderedBy == 6 ) && ! AV20OrderedDsc )
      {
         scmdbuf += " ORDER BY PeriodoLiq, LiqFecPago" ;
      }
      else if ( ( AV19OrderedBy == 6 ) && ( AV20OrderedDsc ) )
      {
         scmdbuf += " ORDER BY PeriodoLiq DESC, LiqFecPago DESC" ;
      }
      else if ( ( AV19OrderedBy == 7 ) && ! AV20OrderedDsc )
      {
         scmdbuf += " ORDER BY PeriodoLiq, TLiqDescAux" ;
      }
      else if ( ( AV19OrderedBy == 7 ) && ( AV20OrderedDsc ) )
      {
         scmdbuf += " ORDER BY PeriodoLiq DESC, TLiqDescAux DESC" ;
      }
      else if ( ( AV19OrderedBy == 8 ) && ! AV20OrderedDsc )
      {
         scmdbuf += " ORDER BY PeriodoLiq, LiqModTra" ;
      }
      else if ( ( AV19OrderedBy == 8 ) && ( AV20OrderedDsc ) )
      {
         scmdbuf += " ORDER BY PeriodoLiq DESC, LiqModTra DESC" ;
      }
      else if ( ( AV19OrderedBy == 9 ) && ! AV20OrderedDsc )
      {
         scmdbuf += " ORDER BY PeriodoLiq, LiqFrecPag" ;
      }
      else if ( ( AV19OrderedBy == 9 ) && ( AV20OrderedDsc ) )
      {
         scmdbuf += " ORDER BY PeriodoLiq DESC, LiqFrecPag DESC" ;
      }
      else if ( ( AV19OrderedBy == 10 ) && ! AV20OrderedDsc )
      {
         scmdbuf += " ORDER BY PeriodoLiq, LiqCntLeg" ;
      }
      else if ( ( AV19OrderedBy == 10 ) && ( AV20OrderedDsc ) )
      {
         scmdbuf += " ORDER BY PeriodoLiq DESC, LiqCntLeg DESC" ;
      }
      else if ( ( AV19OrderedBy == 11 ) && ! AV20OrderedDsc )
      {
         scmdbuf += " ORDER BY PeriodoLiq, LiqError" ;
      }
      else if ( ( AV19OrderedBy == 11 ) && ( AV20OrderedDsc ) )
      {
         scmdbuf += " ORDER BY PeriodoLiq DESC, LiqError DESC" ;
      }
      else if ( ( AV19OrderedBy == 12 ) && ! AV20OrderedDsc )
      {
         scmdbuf += " ORDER BY PeriodoLiq, LiqDescrip" ;
      }
      else if ( ( AV19OrderedBy == 12 ) && ( AV20OrderedDsc ) )
      {
         scmdbuf += " ORDER BY PeriodoLiq DESC, LiqDescrip DESC" ;
      }
      else if ( ( AV19OrderedBy == 13 ) && ! AV20OrderedDsc )
      {
         scmdbuf += " ORDER BY PeriodoLiq, LiqImpBruto" ;
      }
      else if ( ( AV19OrderedBy == 13 ) && ( AV20OrderedDsc ) )
      {
         scmdbuf += " ORDER BY PeriodoLiq DESC, LiqImpBruto DESC" ;
      }
      else if ( ( AV19OrderedBy == 14 ) && ! AV20OrderedDsc )
      {
         scmdbuf += " ORDER BY PeriodoLiq, LiqImpNeto" ;
      }
      else if ( ( AV19OrderedBy == 14 ) && ( AV20OrderedDsc ) )
      {
         scmdbuf += " ORDER BY PeriodoLiq DESC, LiqImpNeto DESC" ;
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
                  return conditional_P02F72(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , (String)dynConstraints[10] , (GXSimpleCollection<String>)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , ((Number) dynConstraints[13]).intValue() , (String)dynConstraints[14] , (java.util.Date)dynConstraints[15] , (java.util.Date)dynConstraints[16] , ((Number) dynConstraints[17]).intValue() , (String)dynConstraints[18] , (java.util.Date)dynConstraints[19] , (java.util.Date)dynConstraints[20] , ((Number) dynConstraints[21]).intValue() , (String)dynConstraints[22] , ((Number) dynConstraints[23]).intValue() , ((Number) dynConstraints[24]).intValue() , ((Number) dynConstraints[25]).shortValue() , ((Number) dynConstraints[26]).shortValue() , ((Number) dynConstraints[27]).intValue() , (String)dynConstraints[28] , ((Number) dynConstraints[29]).intValue() , (String)dynConstraints[30] , (java.math.BigDecimal)dynConstraints[31] , (java.math.BigDecimal)dynConstraints[32] , (java.math.BigDecimal)dynConstraints[33] , (java.math.BigDecimal)dynConstraints[34] , ((Number) dynConstraints[35]).intValue() , (String)dynConstraints[36] , (java.util.Date)dynConstraints[37] , (java.util.Date)dynConstraints[38] , ((Number) dynConstraints[39]).shortValue() , (java.math.BigDecimal)dynConstraints[40] , (java.math.BigDecimal)dynConstraints[41] , ((Number) dynConstraints[42]).shortValue() , ((Boolean) dynConstraints[43]).booleanValue() , ((Number) dynConstraints[44]).intValue() , ((Number) dynConstraints[45]).intValue() , ((Number) dynConstraints[46]).shortValue() , (java.util.Date)dynConstraints[47] , ((Number) dynConstraints[48]).intValue() , ((Number) dynConstraints[49]).shortValue() , (java.util.Date)dynConstraints[50] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02F72", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(4,2);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(5,2);
               ((String[]) buf[6])[0] = rslt.getVarchar(6);
               ((String[]) buf[7])[0] = rslt.getVarchar(7);
               ((short[]) buf[8])[0] = rslt.getShort(8);
               ((byte[]) buf[9])[0] = rslt.getByte(9);
               ((String[]) buf[10])[0] = rslt.getString(10, 1);
               ((String[]) buf[11])[0] = rslt.getVarchar(11);
               ((java.util.Date[]) buf[12])[0] = rslt.getGXDate(12);
               ((String[]) buf[13])[0] = rslt.getString(13, 20);
               ((java.util.Date[]) buf[14])[0] = rslt.getGXDate(14);
               ((String[]) buf[15])[0] = rslt.getVarchar(15);
               ((int[]) buf[16])[0] = rslt.getInt(16);
               ((java.util.Date[]) buf[17])[0] = rslt.getGXDate(17);
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
                  stmt.setInt(sIdx, ((Number) parms[20]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[21]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[22]);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[23]).intValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[24]).intValue());
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[25], 400);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[26]);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[27]);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[28], 20);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[29]);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[30]);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[31], 30);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[32]).shortValue());
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[33]).shortValue());
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[34], 400);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[35], 400);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[36], 2);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[37], 2);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[38], 2);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[39], 2);
               }
               return;
      }
   }

}

