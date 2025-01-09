package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class conceptosobregiro extends GXProcedure
{
   public conceptosobregiro( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( conceptosobregiro.class ), "" );
   }

   public conceptosobregiro( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             String[] aP1 )
   {
      conceptosobregiro.this.aP2 = new String[] {""};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( int aP0 ,
                        String[] aP1 ,
                        String[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( int aP0 ,
                             String[] aP1 ,
                             String[] aP2 )
   {
      conceptosobregiro.this.AV9CliCod = aP0;
      conceptosobregiro.this.aP1 = aP1;
      conceptosobregiro.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_char1 = AV8concodigo ;
      GXt_char2 = AV8concodigo ;
      GXv_char3[0] = GXt_char2 ;
      new web.concepto_sobregiro_codigoparam(remoteHandle, context).execute( GXv_char3) ;
      conceptosobregiro.this.GXt_char2 = GXv_char3[0] ;
      GXv_char4[0] = GXt_char1 ;
      new web.getparametro(remoteHandle, context).execute( AV9CliCod, GXt_char2, GXv_char4) ;
      conceptosobregiro.this.GXt_char1 = GXv_char4[0] ;
      AV8concodigo = GXt_char1 ;
      if ( (GXutil.strcmp("", AV8concodigo)==0) )
      {
         AV10error = httpContext.getMessage( "No está creado el parámetro de concepto de sobregiro", "") ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = conceptosobregiro.this.AV8concodigo;
      this.aP2[0] = conceptosobregiro.this.AV10error;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8concodigo = "" ;
      AV10error = "" ;
      GXt_char1 = "" ;
      GXt_char2 = "" ;
      GXv_char3 = new String[1] ;
      GXv_char4 = new String[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV9CliCod ;
   private String AV8concodigo ;
   private String GXt_char1 ;
   private String GXt_char2 ;
   private String GXv_char3[] ;
   private String GXv_char4[] ;
   private String AV10error ;
   private String[] aP2 ;
   private String[] aP1 ;
}

