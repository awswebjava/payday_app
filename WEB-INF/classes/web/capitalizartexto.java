package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class capitalizartexto extends GXProcedure
{
   public capitalizartexto( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( capitalizartexto.class ), "" );
   }

   public capitalizartexto( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 )
   {
      capitalizartexto.this.aP1 = new String[] {""};
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
      capitalizartexto.this.AV10sinCapTexto = aP0;
      capitalizartexto.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod(remoteHandle, context).execute( AV13Pgmname, httpContext.getMessage( "antes ", "")+AV10sinCapTexto) ;
      if ( GXutil.strcmp(GXutil.substring( AV10sinCapTexto, 1, 1), "¡") != 0 )
      {
         AV8Texto = GXutil.lower( GXutil.trim( AV10sinCapTexto)) ;
         AV9resto = (short)(GXutil.len( GXutil.trim( AV8Texto))-1) ;
         AV8Texto = GXutil.upper( GXutil.substring( AV8Texto, 1, 1)) + GXutil.substring( AV8Texto, 2, AV9resto) ;
      }
      else
      {
         AV8Texto = GXutil.lower( GXutil.trim( AV10sinCapTexto)) ;
         AV9resto = (short)(GXutil.len( GXutil.trim( AV8Texto))-2) ;
         AV8Texto = GXutil.upper( GXutil.substring( AV8Texto, 1, 2)) + GXutil.substring( AV8Texto, 3, AV9resto) ;
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV13Pgmname, httpContext.getMessage( "despues ", "")+AV8Texto) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = capitalizartexto.this.AV8Texto;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8Texto = "" ;
      AV13Pgmname = "" ;
      AV13Pgmname = "CapitalizarTexto" ;
      /* GeneXus formulas. */
      AV13Pgmname = "CapitalizarTexto" ;
      Gx_err = (short)(0) ;
   }

   private short AV9resto ;
   private short Gx_err ;
   private String AV13Pgmname ;
   private String AV10sinCapTexto ;
   private String AV8Texto ;
   private String[] aP1 ;
}

