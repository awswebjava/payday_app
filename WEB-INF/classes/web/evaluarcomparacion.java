package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class evaluarcomparacion extends GXProcedure
{
   public evaluarcomparacion( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( evaluarcomparacion.class ), "" );
   }

   public evaluarcomparacion( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( String aP0 ,
                              java.math.BigDecimal aP1 ,
                              java.math.BigDecimal aP2 )
   {
      evaluarcomparacion.this.aP3 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( String aP0 ,
                        java.math.BigDecimal aP1 ,
                        java.math.BigDecimal aP2 ,
                        boolean[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( String aP0 ,
                             java.math.BigDecimal aP1 ,
                             java.math.BigDecimal aP2 ,
                             boolean[] aP3 )
   {
      evaluarcomparacion.this.AV10operador_comparacion = aP0;
      evaluarcomparacion.this.AV8a_Importes = aP1;
      evaluarcomparacion.this.AV11b_Importes = aP2;
      evaluarcomparacion.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV9verdadero = false ;
      if ( GXutil.strcmp(AV10operador_comparacion, "mayor") == 0 )
      {
         if ( DecimalUtil.compareTo(AV8a_Importes, AV11b_Importes) > 0 )
         {
            AV9verdadero = true ;
         }
      }
      else if ( GXutil.strcmp(AV10operador_comparacion, "menor") == 0 )
      {
         if ( DecimalUtil.compareTo(AV8a_Importes, AV11b_Importes) < 0 )
         {
            AV9verdadero = true ;
         }
      }
      else if ( GXutil.strcmp(AV10operador_comparacion, "mayorOIgual") == 0 )
      {
         if ( DecimalUtil.compareTo(AV8a_Importes, AV11b_Importes) >= 0 )
         {
            AV9verdadero = true ;
         }
      }
      else if ( GXutil.strcmp(AV10operador_comparacion, "menorOIgual") == 0 )
      {
         if ( DecimalUtil.compareTo(AV8a_Importes, AV11b_Importes) <= 0 )
         {
            AV9verdadero = true ;
         }
      }
      else if ( GXutil.strcmp(AV10operador_comparacion, "igual") == 0 )
      {
         if ( DecimalUtil.compareTo(AV8a_Importes, AV11b_Importes) == 0 )
         {
            AV9verdadero = true ;
         }
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = evaluarcomparacion.this.AV9verdadero;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private java.math.BigDecimal AV8a_Importes ;
   private java.math.BigDecimal AV11b_Importes ;
   private String AV10operador_comparacion ;
   private boolean AV9verdadero ;
   private boolean[] aP3 ;
}

