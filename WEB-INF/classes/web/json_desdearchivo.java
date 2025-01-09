package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class json_desdearchivo extends GXProcedure
{
   public json_desdearchivo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( json_desdearchivo.class ), "" );
   }

   public json_desdearchivo( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( java.util.Date aP0 ,
                             String aP1 ,
                             String[] aP2 )
   {
      json_desdearchivo.this.aP3 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( java.util.Date aP0 ,
                        String aP1 ,
                        String[] aP2 ,
                        String[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( java.util.Date aP0 ,
                             String aP1 ,
                             String[] aP2 ,
                             String[] aP3 )
   {
      json_desdearchivo.this.AV14fecha = aP0;
      json_desdearchivo.this.AV15entidad = aP1;
      json_desdearchivo.this.aP2 = aP2;
      json_desdearchivo.this.aP3 = aP3;
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
      json_desdearchivo.this.GXt_char1 = GXv_char2[0] ;
      AV12rutaAplicacion = GXt_char1 ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV19Pgmname, httpContext.getMessage( "hola", "")) ;
      if ( GXutil.strcmp(AV15entidad, httpContext.getMessage( "DEI", "")) == 0 )
      {
         if ( GXutil.dateCompare(GXutil.resetTime(AV14fecha), GXutil.resetTime(localUtil.ymdtod( 2022, 11, 1))) )
         {
            AV12rutaAplicacion += httpContext.getMessage( "/static/jsons_ini/ded_esp_inc.json", "") ;
         }
         else
         {
            if ( GXutil.dateCompare(GXutil.resetTime(AV14fecha), GXutil.resetTime(localUtil.ymdtod( 2022, 1, 1))) )
            {
               AV12rutaAplicacion += httpContext.getMessage( "/static/jsons_ini/ded_esp_inc_enero.json", "") ;
            }
            else
            {
               if ( GXutil.dateCompare(GXutil.resetTime(AV14fecha), GXutil.resetTime(localUtil.ymdtod( 2022, 6, 1))) )
               {
                  AV12rutaAplicacion += httpContext.getMessage( "/static/jsons_ini/ded_esp_inc_junio.json", "") ;
               }
               else
               {
                  if ( GXutil.dateCompare(GXutil.resetTime(AV14fecha), GXutil.resetTime(localUtil.ymdtod( 2023, 1, 1))) )
                  {
                     AV12rutaAplicacion += httpContext.getMessage( "/static/jsons_ini/ded_esp_inc_enero_2023.json", "") ;
                  }
                  else
                  {
                     if ( GXutil.dateCompare(GXutil.resetTime(AV14fecha), GXutil.resetTime(localUtil.ymdtod( 2023, 5, 1))) )
                     {
                        AV12rutaAplicacion += httpContext.getMessage( "/static/jsons_ini/ded_esp_inc_mayo_2023.json", "") ;
                     }
                  }
               }
            }
         }
      }
      else if ( GXutil.strcmp(AV15entidad, httpContext.getMessage( "FERIADOS", "")) == 0 )
      {
         AV12rutaAplicacion += httpContext.getMessage( "/static/jsons_ini/feriados_", "") + GXutil.trim( GXutil.str( GXutil.year( AV14fecha), 10, 0)) + httpContext.getMessage( ".json", "") ;
      }
      else
      {
         AV12rutaAplicacion += httpContext.getMessage( "/static/jsons_ini/", "") + GXutil.trim( AV15entidad) + httpContext.getMessage( ".json", "") ;
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV19Pgmname, httpContext.getMessage( "&rutaAplicacion ", "")+AV12rutaAplicacion) ;
      AV8File.setSource( GXutil.trim( AV12rutaAplicacion) );
      if ( AV8File.exists() )
      {
         AV8File.openRead("");
         while ( ! AV8File.getEof() )
         {
            AV9json += AV8File.readLine() ;
         }
         new web.msgdebug_prod(remoteHandle, context).execute( AV19Pgmname, httpContext.getMessage( "jsn ", "")+AV9json) ;
         AV8File.close();
      }
      else
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV19Pgmname, httpContext.getMessage( "No existe archivo ", "")+GXutil.trim( AV12rutaAplicacion)) ;
         AV16error = httpContext.getMessage( "No existe archivo ", "") + GXutil.trim( AV12rutaAplicacion) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = json_desdearchivo.this.AV9json;
      this.aP3[0] = json_desdearchivo.this.AV16error;
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
      AV16error = "" ;
      AV12rutaAplicacion = "" ;
      GXt_char1 = "" ;
      GXv_char2 = new String[1] ;
      AV19Pgmname = "" ;
      AV8File = new com.genexus.util.GXFile();
      AV19Pgmname = "json_desdearchivo" ;
      /* GeneXus formulas. */
      AV19Pgmname = "json_desdearchivo" ;
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV15entidad ;
   private String GXt_char1 ;
   private String GXv_char2[] ;
   private String AV19Pgmname ;
   private java.util.Date AV14fecha ;
   private String AV9json ;
   private String AV16error ;
   private String AV12rutaAplicacion ;
   private com.genexus.util.GXFile AV8File ;
   private String[] aP3 ;
   private String[] aP2 ;
}

