package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class otros_desdearchivo extends GXProcedure
{
   public otros_desdearchivo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( otros_desdearchivo.class ), "" );
   }

   public otros_desdearchivo( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 )
   {
      otros_desdearchivo.this.aP1 = new String[] {""};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( String aP0 ,
                        String[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( String aP0 ,
                             String[] aP1 )
   {
      otros_desdearchivo.this.AV15que = aP0;
      otros_desdearchivo.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_char1 = AV12rutaAplicacion ;
      GXv_char2[0] = GXt_char1 ;
      new web.getdefaultpath(remoteHandle, context).execute( GXv_char2) ;
      otros_desdearchivo.this.GXt_char1 = GXv_char2[0] ;
      AV12rutaAplicacion = GXt_char1 ;
      AV12rutaAplicacion += httpContext.getMessage( "/static/jsons_ini/", "") + GXutil.trim( AV15que) + httpContext.getMessage( ".json", "") ;
      AV8File.setSource( GXutil.trim( AV12rutaAplicacion) );
      if ( AV8File.exists() )
      {
         AV8File.openRead("");
         while ( ! AV8File.getEof() )
         {
            AV9json += AV8File.readLine() ;
         }
         AV8File.close();
      }
      else
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV18Pgmname, httpContext.getMessage( "No existe archivo ", "")+GXutil.trim( AV12rutaAplicacion)) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = otros_desdearchivo.this.AV9json;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9json = "" ;
      AV12rutaAplicacion = "" ;
      GXt_char1 = "" ;
      GXv_char2 = new String[1] ;
      AV8File = new com.genexus.util.GXFile();
      AV18Pgmname = "" ;
      AV18Pgmname = "otros_desdearchivo" ;
      /* GeneXus formulas. */
      AV18Pgmname = "otros_desdearchivo" ;
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV15que ;
   private String GXt_char1 ;
   private String GXv_char2[] ;
   private String AV18Pgmname ;
   private String AV9json ;
   private String AV12rutaAplicacion ;
   private com.genexus.util.GXFile AV8File ;
   private String[] aP1 ;
}

