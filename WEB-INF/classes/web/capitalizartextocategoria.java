package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class capitalizartextocategoria extends GXProcedure
{
   public capitalizartextocategoria( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( capitalizartextocategoria.class ), "" );
   }

   public capitalizartextocategoria( int remoteHandle ,
                                     ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 )
   {
      capitalizartextocategoria.this.aP1 = new String[] {""};
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
      capitalizartextocategoria.this.AV10sinCapTexto = aP0;
      capitalizartextocategoria.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod(remoteHandle, context).execute( AV16Pgmname, httpContext.getMessage( "antes ", "")+AV10sinCapTexto) ;
      AV11Textos = new GXSimpleCollection<String>(String.class, "internal", "", GxRegex.Split(AV10sinCapTexto,"-")) ;
      if ( AV11Textos.size() != 2 )
      {
         AV8Texto = GXutil.lower( GXutil.trim( AV10sinCapTexto)) ;
         AV9resto = (short)(GXutil.len( GXutil.trim( AV8Texto))-1) ;
         AV8Texto = GXutil.upper( GXutil.substring( AV8Texto, 1, 1)) + GXutil.substring( AV8Texto, 2, AV9resto) ;
      }
      else
      {
         AV12primeraParte = GXutil.trim( (String)AV11Textos.elementAt(-1+1)) ;
         AV12primeraParte = GXutil.lower( GXutil.trim( AV12primeraParte)) ;
         AV9resto = (short)(GXutil.len( GXutil.trim( AV12primeraParte))-1) ;
         AV12primeraParte = GXutil.upper( GXutil.substring( AV12primeraParte, 1, 1)) + GXutil.substring( AV12primeraParte, 2, AV9resto) ;
         AV13segundaParte = GXutil.trim( (String)AV11Textos.elementAt(-1+2)) ;
         AV13segundaParte = GXutil.lower( GXutil.trim( AV13segundaParte)) ;
         AV9resto = (short)(GXutil.len( GXutil.trim( AV13segundaParte))-1) ;
         AV13segundaParte = GXutil.upper( GXutil.substring( AV13segundaParte, 1, 1)) + GXutil.substring( AV13segundaParte, 2, AV9resto) ;
         AV8Texto = GXutil.trim( AV12primeraParte) + " - " + GXutil.trim( AV13segundaParte) ;
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV16Pgmname, httpContext.getMessage( "despues ", "")+AV8Texto) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = capitalizartextocategoria.this.AV8Texto;
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
      AV16Pgmname = "" ;
      AV11Textos = new GXSimpleCollection<String>(String.class, "internal", "");
      AV12primeraParte = "" ;
      AV13segundaParte = "" ;
      AV16Pgmname = "CapitalizarTextoCategoria" ;
      /* GeneXus formulas. */
      AV16Pgmname = "CapitalizarTextoCategoria" ;
      Gx_err = (short)(0) ;
   }

   private short AV9resto ;
   private short Gx_err ;
   private String AV16Pgmname ;
   private String AV10sinCapTexto ;
   private String AV8Texto ;
   private String AV12primeraParte ;
   private String AV13segundaParte ;
   private String[] aP1 ;
   private GXSimpleCollection<String> AV11Textos ;
}

