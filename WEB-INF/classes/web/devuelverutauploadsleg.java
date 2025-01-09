package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class devuelverutauploadsleg extends GXProcedure
{
   public devuelverutauploadsleg( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( devuelverutauploadsleg.class ), "" );
   }

   public devuelverutauploadsleg( int remoteHandle ,
                                  ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             String[] aP3 )
   {
      devuelverutauploadsleg.this.aP4 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4);
      return aP4[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        String[] aP3 ,
                        String[] aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             String[] aP3 ,
                             String[] aP4 )
   {
      devuelverutauploadsleg.this.AV10CliCod = aP0;
      devuelverutauploadsleg.this.AV11EmpCod = aP1;
      devuelverutauploadsleg.this.AV18LegNumero = aP2;
      devuelverutauploadsleg.this.aP3 = aP3;
      devuelverutauploadsleg.this.aP4 = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_char1[0] = AV14carpetaEnNode ;
      new web.getnombrecarpetaennode(remoteHandle, context).execute( AV10CliCod, AV11EmpCod, AV18LegNumero, GXv_char1) ;
      devuelverutauploadsleg.this.AV14carpetaEnNode = GXv_char1[0] ;
      AV12destinationDir = AV14carpetaEnNode ;
      GXv_char1[0] = AV9rutaRelativaUploads ;
      new web.geturlbases3(remoteHandle, context).execute( AV10CliCod, httpContext.getMessage( "IMG", ""), GXv_char1) ;
      devuelverutauploadsleg.this.AV9rutaRelativaUploads = GXv_char1[0] ;
      AV19url += "/" + GXutil.trim( AV9rutaRelativaUploads) + "/" ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = devuelverutauploadsleg.this.AV12destinationDir;
      this.aP4[0] = devuelverutauploadsleg.this.AV9rutaRelativaUploads;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV12destinationDir = "" ;
      AV9rutaRelativaUploads = "" ;
      AV14carpetaEnNode = "" ;
      GXv_char1 = new String[1] ;
      AV19url = "" ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV11EmpCod ;
   private short Gx_err ;
   private int AV10CliCod ;
   private int AV18LegNumero ;
   private String GXv_char1[] ;
   private String AV12destinationDir ;
   private String AV9rutaRelativaUploads ;
   private String AV14carpetaEnNode ;
   private String AV19url ;
   private String[] aP4 ;
   private String[] aP3 ;
}

