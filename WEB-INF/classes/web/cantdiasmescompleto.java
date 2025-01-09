package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class cantdiasmescompleto extends GXProcedure
{
   public cantdiasmescompleto( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( cantdiasmescompleto.class ), "" );
   }

   public cantdiasmescompleto( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( boolean aP0 ,
                             java.util.Date aP1 ,
                             short[] aP2 ,
                             short[] aP3 )
   {
      cantdiasmescompleto.this.aP4 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4);
      return aP4[0];
   }

   public void execute( boolean aP0 ,
                        java.util.Date aP1 ,
                        short[] aP2 ,
                        short[] aP3 ,
                        String[] aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( boolean aP0 ,
                             java.util.Date aP1 ,
                             short[] aP2 ,
                             short[] aP3 ,
                             String[] aP4 )
   {
      cantdiasmescompleto.this.AV8todosLosMeses30 = aP0;
      cantdiasmescompleto.this.AV12LiqPeriodo = aP1;
      cantdiasmescompleto.this.aP2 = aP2;
      cantdiasmescompleto.this.aP3 = aP3;
      cantdiasmescompleto.this.aP4 = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( AV8todosLosMeses30 )
      {
         AV9Cantidad = (short)(30) ;
         AV10cantidadBasica = AV9Cantidad ;
         AV11LiqDLog = httpContext.getMessage( "Inicializa ", "") + GXutil.trim( AV13OpeCodFormula) + httpContext.getMessage( " en  ", "") + GXutil.trim( GXutil.str( AV9Cantidad, 4, 0)) ;
         if ( GXutil.day( GXutil.eomdate( AV12LiqPeriodo)) != 30 )
         {
            AV11LiqDLog += httpContext.getMessage( " por estar el parámetro <b>Todos los meses tienen 30 días</b> en Si", "") ;
         }
      }
      else
      {
         AV9Cantidad = (short)(GXutil.day( GXutil.eomdate( AV12LiqPeriodo))) ;
         AV10cantidadBasica = AV9Cantidad ;
         AV11LiqDLog = httpContext.getMessage( "Inicializa ", "") + GXutil.trim( AV13OpeCodFormula) + httpContext.getMessage( " en ", "") + GXutil.trim( GXutil.str( AV9Cantidad, 4, 0)) ;
         if ( GXutil.day( GXutil.eomdate( AV12LiqPeriodo)) != 30 )
         {
            AV11LiqDLog += httpContext.getMessage( " por estar el parámetro \"Calcular siempre 30 días del mes\" en \"No\"", "") ;
         }
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = cantdiasmescompleto.this.AV9Cantidad;
      this.aP3[0] = cantdiasmescompleto.this.AV10cantidadBasica;
      this.aP4[0] = cantdiasmescompleto.this.AV11LiqDLog;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV11LiqDLog = "" ;
      AV13OpeCodFormula = "" ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV9Cantidad ;
   private short AV10cantidadBasica ;
   private short Gx_err ;
   private String AV13OpeCodFormula ;
   private java.util.Date AV12LiqPeriodo ;
   private boolean AV8todosLosMeses30 ;
   private String AV11LiqDLog ;
   private String[] aP4 ;
   private short[] aP2 ;
   private short[] aP3 ;
}

