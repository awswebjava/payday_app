package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getnodehostyport extends GXProcedure
{
   public getnodehostyport( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getnodehostyport.class ), "" );
   }

   public getnodehostyport( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public short executeUdp( int aP0 ,
                            String aP1 ,
                            String[] aP2 )
   {
      getnodehostyport.this.aP3 = new short[] {0};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        String[] aP2 ,
                        short[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             String[] aP2 ,
                             short[] aP3 )
   {
      getnodehostyport.this.AV10CliCod = aP0;
      getnodehostyport.this.AV12RestLocId = aP1;
      getnodehostyport.this.aP2 = aP2;
      getnodehostyport.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( ! (GXutil.strcmp("", AV12RestLocId)==0) )
      {
         GXv_boolean1[0] = AV11RestLocHab ;
         GXv_char2[0] = AV8a3lutilitiesHost ;
         GXv_int3[0] = AV9nodePort ;
         new web.getrest_lochostport(remoteHandle, context).execute( AV10CliCod, AV12RestLocId, (short)(0), GXv_boolean1, GXv_char2, GXv_int3) ;
         getnodehostyport.this.AV11RestLocHab = GXv_boolean1[0] ;
         getnodehostyport.this.AV8a3lutilitiesHost = GXv_char2[0] ;
         getnodehostyport.this.AV9nodePort = (short)((short)(GXv_int3[0])) ;
      }
      if ( (GXutil.strcmp("", AV12RestLocId)==0) || ! AV11RestLocHab )
      {
         GXt_char4 = AV8a3lutilitiesHost ;
         GXt_char5 = AV8a3lutilitiesHost ;
         GXv_char2[0] = GXt_char5 ;
         new web.a3lutilitieshost_codigoparam(remoteHandle, context).execute( GXv_char2) ;
         getnodehostyport.this.GXt_char5 = GXv_char2[0] ;
         GXv_char6[0] = GXt_char4 ;
         new web.getparametro(remoteHandle, context).execute( AV10CliCod, GXt_char5, GXv_char6) ;
         getnodehostyport.this.GXt_char4 = GXv_char6[0] ;
         AV8a3lutilitiesHost = GXt_char4 ;
         GXt_char5 = "" ;
         GXt_char4 = "" ;
         GXv_char6[0] = GXt_char4 ;
         new web.htmlapdf_puerto_codigoparam(remoteHandle, context).execute( GXv_char6) ;
         getnodehostyport.this.GXt_char4 = GXv_char6[0] ;
         GXv_char2[0] = GXt_char5 ;
         new web.getparametro(remoteHandle, context).execute( AV10CliCod, GXt_char4, GXv_char2) ;
         getnodehostyport.this.GXt_char5 = GXv_char2[0] ;
         AV9nodePort = (short)(GXutil.lval( GXt_char5)) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = getnodehostyport.this.AV8a3lutilitiesHost;
      this.aP3[0] = getnodehostyport.this.AV9nodePort;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8a3lutilitiesHost = "" ;
      GXv_boolean1 = new boolean[1] ;
      GXv_int3 = new int[1] ;
      GXt_char5 = "" ;
      GXt_char4 = "" ;
      GXv_char6 = new String[1] ;
      GXv_char2 = new String[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV9nodePort ;
   private short Gx_err ;
   private int AV10CliCod ;
   private int GXv_int3[] ;
   private String AV12RestLocId ;
   private String GXt_char5 ;
   private String GXt_char4 ;
   private String GXv_char6[] ;
   private String GXv_char2[] ;
   private boolean AV11RestLocHab ;
   private boolean GXv_boolean1[] ;
   private String AV8a3lutilitiesHost ;
   private short[] aP3 ;
   private String[] aP2 ;
}

