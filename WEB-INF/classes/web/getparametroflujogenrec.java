package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getparametroflujogenrec extends GXProcedure
{
   public getparametroflujogenrec( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getparametroflujogenrec.class ), "" );
   }

   public getparametroflujogenrec( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 )
   {
      getparametroflujogenrec.this.aP1 = new String[] {""};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( int aP0 ,
                        String[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( int aP0 ,
                             String[] aP1 )
   {
      getparametroflujogenrec.this.AV9CliCod = aP0;
      getparametroflujogenrec.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_char1 = AV8metodoInvocaPDF ;
      GXt_char2 = AV8metodoInvocaPDF ;
      GXv_char3[0] = GXt_char2 ;
      new web.metodoinvocapdf_codigoparam(remoteHandle, context).execute( GXv_char3) ;
      getparametroflujogenrec.this.GXt_char2 = GXv_char3[0] ;
      GXv_char4[0] = GXt_char1 ;
      new web.getparametro(remoteHandle, context).execute( AV9CliCod, GXt_char2, GXv_char4) ;
      getparametroflujogenrec.this.GXt_char1 = GXv_char4[0] ;
      AV8metodoInvocaPDF = GXt_char1 ;
      GXt_char2 = AV11auto_imprimir_PDFLiq ;
      GXt_char1 = AV11auto_imprimir_PDFLiq ;
      GXv_char4[0] = GXt_char1 ;
      new web.auto_imprimir_pdfliqleg_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      getparametroflujogenrec.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV9CliCod, GXt_char1, GXv_char3) ;
      getparametroflujogenrec.this.GXt_char2 = GXv_char3[0] ;
      AV11auto_imprimir_PDFLiq = GXt_char2 ;
      if ( ( GXutil.strcmp(AV11auto_imprimir_PDFLiq, httpContext.getMessage( "NO", "")) != 0 ) && ( ( GXutil.strcmp(AV8metodoInvocaPDF, httpContext.getMessage( "TRIGGER", "")) == 0 ) || ( GXutil.strcmp(AV8metodoInvocaPDF, httpContext.getMessage( "ASINCRONA", "")) == 0 ) ) )
      {
         GXv_char4[0] = AV10flujoGenRecPalabra ;
         new web.getparametro(remoteHandle, context).execute( AV9CliCod, new web.flujo_gen_rec_codigoparam(remoteHandle, context).executeUdp( ), GXv_char4) ;
         getparametroflujogenrec.this.AV10flujoGenRecPalabra = GXv_char4[0] ;
      }
      else
      {
         AV10flujoGenRecPalabra = "1" ;
      }
      if ( (GXutil.strcmp("", AV10flujoGenRecPalabra)==0) )
      {
         AV10flujoGenRecPalabra = "1" ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = getparametroflujogenrec.this.AV10flujoGenRecPalabra;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10flujoGenRecPalabra = "" ;
      AV8metodoInvocaPDF = "" ;
      AV11auto_imprimir_PDFLiq = "" ;
      GXt_char2 = "" ;
      GXt_char1 = "" ;
      GXv_char3 = new String[1] ;
      GXv_char4 = new String[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV9CliCod ;
   private String AV10flujoGenRecPalabra ;
   private String AV8metodoInvocaPDF ;
   private String AV11auto_imprimir_PDFLiq ;
   private String GXt_char2 ;
   private String GXt_char1 ;
   private String GXv_char3[] ;
   private String GXv_char4[] ;
   private String[] aP1 ;
}

