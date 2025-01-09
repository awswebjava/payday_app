package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class conceptodevoluciongananciasanioanterior extends GXProcedure
{
   public conceptodevoluciongananciasanioanterior( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( conceptodevoluciongananciasanioanterior.class ), "" );
   }

   public conceptodevoluciongananciasanioanterior( int remoteHandle ,
                                                   ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 )
   {
      conceptodevoluciongananciasanioanterior.this.aP1 = new String[] {""};
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
      conceptodevoluciongananciasanioanterior.this.AV8CliCod = aP0;
      conceptodevoluciongananciasanioanterior.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_char1 = AV9ConCodigo ;
      GXt_char2 = AV9ConCodigo ;
      GXv_char3[0] = GXt_char2 ;
      new web.concepto_devoluciongananciasanioanterior_codigoparam(remoteHandle, context).execute( GXv_char3) ;
      conceptodevoluciongananciasanioanterior.this.GXt_char2 = GXv_char3[0] ;
      GXv_char4[0] = GXt_char1 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char2, GXv_char4) ;
      conceptodevoluciongananciasanioanterior.this.GXt_char1 = GXv_char4[0] ;
      AV9ConCodigo = GXt_char1 ;
      if ( (GXutil.strcmp("", AV9ConCodigo)==0) )
      {
         AV9ConCodigo = httpContext.getMessage( "DES017", "") ;
      }
      new web.codigosfijosrevisar(remoteHandle, context).execute( ) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = conceptodevoluciongananciasanioanterior.this.AV9ConCodigo;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9ConCodigo = "" ;
      GXt_char1 = "" ;
      GXt_char2 = "" ;
      GXv_char3 = new String[1] ;
      GXv_char4 = new String[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV8CliCod ;
   private String AV9ConCodigo ;
   private String GXt_char1 ;
   private String GXt_char2 ;
   private String GXv_char3[] ;
   private String GXv_char4[] ;
   private String[] aP1 ;
}

