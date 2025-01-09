package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class validarequivalencia extends GXProcedure
{
   public validarequivalencia( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( validarequivalencia.class ), "" );
   }

   public validarequivalencia( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( String aP0 ,
                              String aP1 )
   {
      validarequivalencia.this.aP2 = new boolean[] {false};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( String aP0 ,
                        String aP1 ,
                        boolean[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( String aP0 ,
                             String aP1 ,
                             boolean[] aP2 )
   {
      validarequivalencia.this.AV8importado_Descrip = aP0;
      validarequivalencia.this.AV9sistema_Descrip = aP1;
      validarequivalencia.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV10sistemaDesripPalabra = new GXSimpleCollection<String>(String.class, "internal", "", GxRegex.Split(AV9sistema_Descrip," ")) ;
      AV11sistemaDescrip2Palabra = new GXSimpleCollection<String>(String.class, "internal", "", GxRegex.Split(AV9sistema_Descrip,"/")) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV17Pgmname, httpContext.getMessage( "&sistemaDesripPalabra count ", "")+GXutil.trim( GXutil.str( AV10sistemaDesripPalabra.size(), 9, 0))) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV17Pgmname, httpContext.getMessage( "&&sistemaDescrip2Palabra count ", "")+GXutil.trim( GXutil.str( AV11sistemaDescrip2Palabra.size(), 9, 0))) ;
      AV13i = (short)(1) ;
      while ( AV13i <= AV10sistemaDesripPalabra.size() )
      {
         AV12palabras.add((String)AV10sistemaDesripPalabra.elementAt(-1+AV13i), 0);
         AV13i = (short)(AV13i+1) ;
      }
      AV13i = (short)(1) ;
      while ( AV13i <= AV11sistemaDescrip2Palabra.size() )
      {
         AV12palabras.add((String)AV11sistemaDescrip2Palabra.elementAt(-1+AV13i), 0);
         AV13i = (short)(AV13i+1) ;
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV17Pgmname, httpContext.getMessage( "&importado_Descrip ", "")+AV8importado_Descrip) ;
      AV13i = (short)(1) ;
      while ( AV13i <= AV12palabras.size() )
      {
         if ( GXutil.strcmp(GXutil.trim( (String)AV12palabras.elementAt(-1+AV13i)), GXutil.trim( AV8importado_Descrip)) == 0 )
         {
            Cond_result = true ;
         }
         else
         {
            Cond_result = false ;
         }
         if ( Cond_result )
         {
            AV14equivalente = true ;
            if (true) break;
         }
         AV13i = (short)(AV13i+1) ;
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV17Pgmname, httpContext.getMessage( "&equivalente ", "")+GXutil.trim( GXutil.booltostr( AV14equivalente))) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = validarequivalencia.this.AV14equivalente;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10sistemaDesripPalabra = new GXSimpleCollection<String>(String.class, "internal", "");
      AV11sistemaDescrip2Palabra = new GXSimpleCollection<String>(String.class, "internal", "");
      AV17Pgmname = "" ;
      AV12palabras = new GXSimpleCollection<String>(String.class, "internal", "");
      AV17Pgmname = "validarEquivalencia" ;
      /* GeneXus formulas. */
      AV17Pgmname = "validarEquivalencia" ;
      Gx_err = (short)(0) ;
   }

   private short AV13i ;
   private short Gx_err ;
   private String AV17Pgmname ;
   private boolean AV14equivalente ;
   private boolean Cond_result ;
   private String AV8importado_Descrip ;
   private String AV9sistema_Descrip ;
   private boolean[] aP2 ;
   private GXSimpleCollection<String> AV10sistemaDesripPalabra ;
   private GXSimpleCollection<String> AV11sistemaDescrip2Palabra ;
   private GXSimpleCollection<String> AV12palabras ;
}

