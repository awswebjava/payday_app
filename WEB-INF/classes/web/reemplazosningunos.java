package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class reemplazosningunos extends GXProcedure
{
   public reemplazosningunos( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( reemplazosningunos.class ), "" );
   }

   public reemplazosningunos( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             String aP1 )
   {
      reemplazosningunos.this.aP2 = new String[] {""};
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
      reemplazosningunos.this.AV9CliCod = aP0;
      reemplazosningunos.this.AV11parmDescrip = aP1;
      reemplazosningunos.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV10auxDescrip = GXutil.trim( AV11parmDescrip) ;
      GXt_char1 = AV8fueraDeConvenioDescrip ;
      GXv_char2[0] = GXt_char1 ;
      new web.textofueradeconvenio(remoteHandle, context).execute( AV9CliCod, GXv_char2) ;
      reemplazosningunos.this.GXt_char1 = GXv_char2[0] ;
      AV8fueraDeConvenioDescrip = GXt_char1 ;
      if ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV10auxDescrip)), GXutil.upper( GXutil.trim( AV8fueraDeConvenioDescrip))) == 0 )
      {
         AV10auxDescrip = "" ;
      }
      else
      {
         if ( ( GXutil.strcmp(GXutil.upper( AV10auxDescrip), httpContext.getMessage( "NO", "")) == 0 ) || ( GXutil.strcmp(GXutil.upper( AV10auxDescrip), httpContext.getMessage( "NINGUNO", "")) == 0 ) || ( GXutil.strcmp(GXutil.upper( AV10auxDescrip), httpContext.getMessage( "NINGUNA", "")) == 0 ) || ( GXutil.strcmp(GXutil.upper( AV10auxDescrip), httpContext.getMessage( "NADA", "")) == 0 ) || ( GXutil.strcmp(AV10auxDescrip, "-") == 0 ) || ( GXutil.strcmp(AV10auxDescrip, httpContext.getMessage( "NO APLICA", "")) == 0 ) || ( GXutil.strSearch( GXutil.upper( AV10auxDescrip), httpContext.getMessage( "EXCLUIDO DE", ""), 1) != 0 ) || ( GXutil.strcmp(GXutil.upper( AV10auxDescrip), httpContext.getMessage( "SIN CATEGORIAS", "")) == 0 ) )
         {
            AV10auxDescrip = "" ;
         }
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = reemplazosningunos.this.AV10auxDescrip;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10auxDescrip = "" ;
      AV8fueraDeConvenioDescrip = "" ;
      GXt_char1 = "" ;
      GXv_char2 = new String[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV9CliCod ;
   private String GXt_char1 ;
   private String GXv_char2[] ;
   private String AV11parmDescrip ;
   private String AV10auxDescrip ;
   private String AV8fueraDeConvenioDescrip ;
   private String[] aP2 ;
}

