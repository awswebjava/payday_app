package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class eliminarultimapalabra extends GXProcedure
{
   public eliminarultimapalabra( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( eliminarultimapalabra.class ), "" );
   }

   public eliminarultimapalabra( int remoteHandle ,
                                 ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( )
   {
      eliminarultimapalabra.this.aP0 = new String[] {""};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( String[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( String[] aP0 )
   {
      eliminarultimapalabra.this.AV9texto = aP0[0];
      this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( GXutil.len( AV9texto) <= 4 )
      {
         AV9texto = "" ;
      }
      else
      {
         AV8palabras = new GXSimpleCollection<String>(String.class, "internal", "", GxRegex.Split(AV9texto," ")) ;
         AV11textoAux = AV9texto ;
         AV9texto = "" ;
         if ( AV8palabras.size() > 1 )
         {
            AV12i = (short)(1) ;
            while ( AV12i < AV8palabras.size() )
            {
               AV9texto += (String)AV8palabras.elementAt(-1+AV12i) ;
               if ( AV12i != AV8palabras.size() )
               {
                  AV9texto += " " ;
               }
               AV12i = (short)(AV12i+1) ;
            }
         }
         else
         {
            if ( AV8palabras.size() == 1 )
            {
               AV13cuantos = (short)(GXutil.len( (String)AV8palabras.elementAt(-1+1))-1) ;
               AV9texto = GXutil.substring( (String)AV8palabras.elementAt(-1+1), 1, AV13cuantos) ;
            }
         }
      }
      new web.msgdebug7(remoteHandle, context).execute( AV16Pgmname, httpContext.getMessage( "texto ", "")+AV9texto) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = eliminarultimapalabra.this.AV9texto;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8palabras = new GXSimpleCollection<String>(String.class, "internal", "");
      AV11textoAux = "" ;
      AV16Pgmname = "" ;
      AV16Pgmname = "EliminarUltimaPalabra" ;
      /* GeneXus formulas. */
      AV16Pgmname = "EliminarUltimaPalabra" ;
      Gx_err = (short)(0) ;
   }

   private short AV12i ;
   private short AV13cuantos ;
   private short Gx_err ;
   private String AV9texto ;
   private String AV11textoAux ;
   private String AV16Pgmname ;
   private String[] aP0 ;
   private GXSimpleCollection<String> AV8palabras ;
}

