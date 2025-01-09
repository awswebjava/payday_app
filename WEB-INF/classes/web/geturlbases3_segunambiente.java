package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class geturlbases3_segunambiente extends GXProcedure
{
   public geturlbases3_segunambiente( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( geturlbases3_segunambiente.class ), "" );
   }

   public geturlbases3_segunambiente( int remoteHandle ,
                                      ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              String aP1 ,
                              String[] aP2 )
   {
      geturlbases3_segunambiente.this.aP3 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        String[] aP2 ,
                        boolean[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             String[] aP2 ,
                             boolean[] aP3 )
   {
      geturlbases3_segunambiente.this.AV9CliCod = aP0;
      geturlbases3_segunambiente.this.AV11que = aP1;
      geturlbases3_segunambiente.this.aP2 = aP2;
      geturlbases3_segunambiente.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_char1 = AV8a3lutilitiesHost ;
      GXt_char2 = AV8a3lutilitiesHost ;
      GXv_char3[0] = GXt_char2 ;
      new web.a3lutilitieshost_codigoparam(remoteHandle, context).execute( GXv_char3) ;
      geturlbases3_segunambiente.this.GXt_char2 = GXv_char3[0] ;
      GXv_char4[0] = GXt_char1 ;
      new web.getparametro(remoteHandle, context).execute( AV9CliCod, GXt_char2, GXv_char4) ;
      geturlbases3_segunambiente.this.GXt_char1 = GXv_char4[0] ;
      AV8a3lutilitiesHost = GXt_char1 ;
      if ( GXutil.strcmp(GXutil.lower( GXutil.trim( AV8a3lutilitiesHost)), httpContext.getMessage( "localhost", "")) == 0 )
      {
         GXv_char4[0] = AV10LiqLinkS3Html ;
         new web.geturlbases3(remoteHandle, context).execute( AV9CliCod, AV11que, GXv_char4) ;
         geturlbases3_segunambiente.this.AV10LiqLinkS3Html = GXv_char4[0] ;
         AV12localEs = true ;
      }
      else
      {
         AV13urlSinVpcEs = GXutil.boolval( new web.getparametro(remoteHandle, context).executeUdp( AV9CliCod, new web.usarurls3sinvpc_codigoparam(remoteHandle, context).executeUdp( ))) ;
         if ( AV13urlSinVpcEs )
         {
            GXv_char4[0] = AV10LiqLinkS3Html ;
            new web.geturlbases3(remoteHandle, context).execute( AV9CliCod, AV11que, GXv_char4) ;
            geturlbases3_segunambiente.this.AV10LiqLinkS3Html = GXv_char4[0] ;
         }
         else
         {
            GXv_char4[0] = AV10LiqLinkS3Html ;
            new web.geturl_vpc_bases3(remoteHandle, context).execute( AV9CliCod, AV11que, GXv_char4) ;
            geturlbases3_segunambiente.this.AV10LiqLinkS3Html = GXv_char4[0] ;
         }
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = geturlbases3_segunambiente.this.AV10LiqLinkS3Html;
      this.aP3[0] = geturlbases3_segunambiente.this.AV12localEs;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10LiqLinkS3Html = "" ;
      AV8a3lutilitiesHost = "" ;
      GXt_char1 = "" ;
      GXt_char2 = "" ;
      GXv_char3 = new String[1] ;
      GXv_char4 = new String[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV9CliCod ;
   private String AV11que ;
   private String GXt_char1 ;
   private String GXt_char2 ;
   private String GXv_char3[] ;
   private String GXv_char4[] ;
   private boolean AV12localEs ;
   private boolean AV13urlSinVpcEs ;
   private String AV10LiqLinkS3Html ;
   private String AV8a3lutilitiesHost ;
   private boolean[] aP3 ;
   private String[] aP2 ;
}

