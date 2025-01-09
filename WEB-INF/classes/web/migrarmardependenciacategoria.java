package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class migrarmardependenciacategoria extends GXProcedure
{
   public migrarmardependenciacategoria( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( migrarmardependenciacategoria.class ), "" );
   }

   public migrarmardependenciacategoria( int remoteHandle ,
                                         ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 ,
                             String aP1 )
   {
      migrarmardependenciacategoria.this.aP2 = new String[] {""};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( String aP0 ,
                        String aP1 ,
                        String[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( String aP0 ,
                             String aP1 ,
                             String[] aP2 )
   {
      migrarmardependenciacategoria.this.AV10ConveCodigo = aP0;
      migrarmardependenciacategoria.this.AV9auxZonCod = aP1;
      migrarmardependenciacategoria.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8auxDependencia = "" ;
      if ( ! (GXutil.strcmp("", AV9auxZonCod)==0) )
      {
         if ( ! (GXutil.strcmp("", AV10ConveCodigo)==0) )
         {
            AV8auxDependencia = "[\"" + GXutil.trim( AV10ConveCodigo) + "\",\"" + GXutil.trim( AV9auxZonCod) + "\"]" ;
         }
      }
      else
      {
         AV8auxDependencia = GXutil.trim( AV10ConveCodigo) ;
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV13Pgmname, httpContext.getMessage( "&ConveCodigo: ", "")+AV10ConveCodigo) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV13Pgmname, httpContext.getMessage( "&auxZonCod: ", "")+AV9auxZonCod) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV13Pgmname, httpContext.getMessage( "auxDependencia: ", "")+AV8auxDependencia) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = migrarmardependenciacategoria.this.AV8auxDependencia;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8auxDependencia = "" ;
      AV13Pgmname = "" ;
      AV13Pgmname = "migrArmarDependenciaCategoria" ;
      /* GeneXus formulas. */
      AV13Pgmname = "migrArmarDependenciaCategoria" ;
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV10ConveCodigo ;
   private String AV9auxZonCod ;
   private String AV13Pgmname ;
   private String AV8auxDependencia ;
   private String[] aP2 ;
}

