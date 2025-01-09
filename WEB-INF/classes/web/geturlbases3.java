package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class geturlbases3 extends GXProcedure
{
   public geturlbases3( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( geturlbases3.class ), "" );
   }

   public geturlbases3( int remoteHandle ,
                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             String aP1 )
   {
      geturlbases3.this.aP2 = new String[] {""};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        String[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             String[] aP2 )
   {
      geturlbases3.this.AV11CliCod = aP0;
      geturlbases3.this.AV12que = aP1;
      geturlbases3.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_char1 = AV8url ;
      GXv_char2[0] = GXt_char1 ;
      new web.obtenerdesesion(remoteHandle, context).execute( httpContext.getMessage( "url_base_s3_", "")+GXutil.trim( AV12que), GXv_char2) ;
      geturlbases3.this.GXt_char1 = GXv_char2[0] ;
      AV8url = GXt_char1 ;
      if ( (GXutil.strcmp("", AV8url)==0) )
      {
         AV8url = httpContext.getMessage( "https://s3.", "") ;
         GXt_char1 = AV9regionPalabra ;
         GXt_char3 = AV9regionPalabra ;
         GXv_char2[0] = GXt_char3 ;
         new web.s3awsregion_codigoparam(remoteHandle, context).execute( GXv_char2) ;
         geturlbases3.this.GXt_char3 = GXv_char2[0] ;
         GXv_char4[0] = GXt_char1 ;
         new web.getparametro(remoteHandle, context).execute( AV11CliCod, GXt_char3, GXv_char4) ;
         geturlbases3.this.GXt_char1 = GXv_char4[0] ;
         AV9regionPalabra = GXt_char1 ;
         AV8url += GXutil.trim( AV9regionPalabra) ;
         AV8url += httpContext.getMessage( ".amazonaws.com/", "") ;
         if ( GXutil.strcmp(AV12que, httpContext.getMessage( "IMG", "")) == 0 )
         {
            GXt_char3 = AV10bucketPalabra ;
            GXt_char1 = AV10bucketPalabra ;
            GXv_char4[0] = GXt_char1 ;
            new web.bucketname_codigoparam(remoteHandle, context).execute( GXv_char4) ;
            geturlbases3.this.GXt_char1 = GXv_char4[0] ;
            GXv_char2[0] = GXt_char3 ;
            new web.getparametro(remoteHandle, context).execute( AV11CliCod, GXt_char1, GXv_char2) ;
            geturlbases3.this.GXt_char3 = GXv_char2[0] ;
            AV10bucketPalabra = GXt_char3 ;
         }
         else
         {
            GXt_char3 = AV10bucketPalabra ;
            GXt_char1 = AV10bucketPalabra ;
            GXv_char4[0] = GXt_char1 ;
            new web.bucketnamepdf_codigo(remoteHandle, context).execute( GXv_char4) ;
            geturlbases3.this.GXt_char1 = GXv_char4[0] ;
            GXv_char2[0] = GXt_char3 ;
            new web.getparametro(remoteHandle, context).execute( AV11CliCod, GXt_char1, GXv_char2) ;
            geturlbases3.this.GXt_char3 = GXv_char2[0] ;
            AV10bucketPalabra = GXt_char3 ;
         }
         AV8url += GXutil.trim( AV10bucketPalabra) ;
         new web.setearensesion(remoteHandle, context).execute( httpContext.getMessage( "url_base_s3_", "")+GXutil.trim( AV12que), AV8url) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = geturlbases3.this.AV8url;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8url = "" ;
      AV9regionPalabra = "" ;
      AV10bucketPalabra = "" ;
      GXt_char3 = "" ;
      GXt_char1 = "" ;
      GXv_char4 = new String[1] ;
      GXv_char2 = new String[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV11CliCod ;
   private String AV12que ;
   private String AV9regionPalabra ;
   private String AV10bucketPalabra ;
   private String GXt_char3 ;
   private String GXt_char1 ;
   private String GXv_char4[] ;
   private String GXv_char2[] ;
   private String AV8url ;
   private String[] aP2 ;
}

