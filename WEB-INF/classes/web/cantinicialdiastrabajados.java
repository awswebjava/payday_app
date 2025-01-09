package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class cantinicialdiastrabajados extends GXProcedure
{
   public cantinicialdiastrabajados( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( cantinicialdiastrabajados.class ), "" );
   }

   public cantinicialdiastrabajados( int remoteHandle ,
                                     ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             String aP1 ,
                             String aP2 ,
                             byte aP3 ,
                             java.util.Date aP4 ,
                             java.util.Date aP5 ,
                             java.util.Date aP6 ,
                             boolean aP7 ,
                             byte aP8 ,
                             short[] aP9 ,
                             short[] aP10 )
   {
      cantinicialdiastrabajados.this.aP11 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11);
      return aP11[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        String aP2 ,
                        byte aP3 ,
                        java.util.Date aP4 ,
                        java.util.Date aP5 ,
                        java.util.Date aP6 ,
                        boolean aP7 ,
                        byte aP8 ,
                        short[] aP9 ,
                        short[] aP10 ,
                        String[] aP11 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             String aP2 ,
                             byte aP3 ,
                             java.util.Date aP4 ,
                             java.util.Date aP5 ,
                             java.util.Date aP6 ,
                             boolean aP7 ,
                             byte aP8 ,
                             short[] aP9 ,
                             short[] aP10 ,
                             String[] aP11 )
   {
      cantinicialdiastrabajados.this.AV21CliCod = aP0;
      cantinicialdiastrabajados.this.AV17TLiqCod = aP1;
      cantinicialdiastrabajados.this.AV14egresoTLiqCOd = aP2;
      cantinicialdiastrabajados.this.AV12LegClase = aP3;
      cantinicialdiastrabajados.this.AV15LegFecIngreso = aP4;
      cantinicialdiastrabajados.this.AV8LegFecEgreso = aP5;
      cantinicialdiastrabajados.this.AV9LiqPeriodo = aP6;
      cantinicialdiastrabajados.this.AV18todosLosMeses30 = aP7;
      cantinicialdiastrabajados.this.AV22EmpTipoExp = aP8;
      cantinicialdiastrabajados.this.aP9 = aP9;
      cantinicialdiastrabajados.this.aP10 = aP10;
      cantinicialdiastrabajados.this.aP11 = aP11;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( ( AV22EmpTipoExp == 1 ) && ( ( GXutil.month( AV8LegFecEgreso) == GXutil.month( AV9LiqPeriodo) ) && ( GXutil.year( AV8LegFecEgreso) == GXutil.year( AV9LiqPeriodo) ) && !( GXutil.dateCompare(GXutil.resetTime(AV8LegFecEgreso), GXutil.resetTime(GXutil.eomdate( AV9LiqPeriodo))) ) ) )
      {
         AV10Cantidad = (short)(GXutil.day( AV8LegFecEgreso)) ;
         AV11LiqDLog = httpContext.getMessage( "Inicializa ", "") + GXutil.trim( AV19OpeCodFormula) + httpContext.getMessage( " en ", "") + GXutil.trim( GXutil.str( AV10Cantidad, 4, 0)) + httpContext.getMessage( " por ser ", "") + GXutil.trim( localUtil.dtoc( AV8LegFecEgreso, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/")) + httpContext.getMessage( " la fecha de egreso", "") ;
      }
      else
      {
         if ( AV12LegClase == 2 )
         {
            AV10Cantidad = (short)(15) ;
            AV13cantidadBasica = AV10Cantidad ;
            AV11LiqDLog = httpContext.getMessage( "Inicializa ", "") + GXutil.trim( AV19OpeCodFormula) + httpContext.getMessage( " en ", "") + GXutil.trim( GXutil.str( AV10Cantidad, 4, 0)) + httpContext.getMessage( " por ser liquidación de quincena", "") ;
         }
         else
         {
            if ( AV12LegClase == 3 )
            {
               AV10Cantidad = (short)(7) ;
               AV13cantidadBasica = AV10Cantidad ;
               AV11LiqDLog = httpContext.getMessage( "Inicializa ", "") + GXutil.trim( AV19OpeCodFormula) + httpContext.getMessage( " en ", "") + GXutil.trim( GXutil.str( AV10Cantidad, 4, 0)) + httpContext.getMessage( " por ser liquidación de semana", "") ;
            }
            else
            {
               if ( AV12LegClase == 4 )
               {
                  AV10Cantidad = (short)(1) ;
                  AV13cantidadBasica = AV10Cantidad ;
                  AV11LiqDLog = httpContext.getMessage( "Inicializa ", "") + GXutil.trim( AV19OpeCodFormula) + httpContext.getMessage( " en ", "") + GXutil.trim( GXutil.str( AV10Cantidad, 4, 0)) + httpContext.getMessage( " por ser liquidación de día", "") ;
               }
               else
               {
                  if ( ( GXutil.strcmp(AV17TLiqCod, AV14egresoTLiqCOd) == 0 ) && GXutil.resetTime(AV8LegFecEgreso).before( GXutil.resetTime( AV9LiqPeriodo )) && ( AV22EmpTipoExp == 1 ) )
                  {
                     AV10Cantidad = (short)(0) ;
                     AV11LiqDLog = httpContext.getMessage( "Inicializa en cero por tener fecha de egreso ", "") + GXutil.trim( localUtil.dtoc( AV8LegFecEgreso, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/")) + httpContext.getMessage( " anterior a periodo liquidado", "") ;
                     returnInSub = true;
                     cleanup();
                     if (true) return;
                  }
                  else
                  {
                     GXv_int1[0] = AV10Cantidad ;
                     GXv_int2[0] = AV13cantidadBasica ;
                     GXv_char3[0] = AV11LiqDLog ;
                     new web.cantdiasmescompleto(remoteHandle, context).execute( AV18todosLosMeses30, AV9LiqPeriodo, GXv_int1, GXv_int2, GXv_char3) ;
                     cantinicialdiastrabajados.this.AV10Cantidad = GXv_int1[0] ;
                     cantinicialdiastrabajados.this.AV13cantidadBasica = GXv_int2[0] ;
                     cantinicialdiastrabajados.this.AV11LiqDLog = GXv_char3[0] ;
                  }
               }
            }
         }
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP9[0] = cantinicialdiastrabajados.this.AV10Cantidad;
      this.aP10[0] = cantinicialdiastrabajados.this.AV13cantidadBasica;
      this.aP11[0] = cantinicialdiastrabajados.this.AV11LiqDLog;
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
      AV19OpeCodFormula = "" ;
      GXv_int1 = new short[1] ;
      GXv_int2 = new short[1] ;
      GXv_char3 = new String[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV12LegClase ;
   private byte AV22EmpTipoExp ;
   private short AV10Cantidad ;
   private short AV13cantidadBasica ;
   private short GXv_int1[] ;
   private short GXv_int2[] ;
   private short Gx_err ;
   private int AV21CliCod ;
   private String AV17TLiqCod ;
   private String AV14egresoTLiqCOd ;
   private String AV19OpeCodFormula ;
   private String GXv_char3[] ;
   private java.util.Date AV15LegFecIngreso ;
   private java.util.Date AV8LegFecEgreso ;
   private java.util.Date AV9LiqPeriodo ;
   private boolean AV18todosLosMeses30 ;
   private boolean returnInSub ;
   private String AV11LiqDLog ;
   private String[] aP11 ;
   private short[] aP9 ;
   private short[] aP10 ;
}

