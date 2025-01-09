package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class duplicaliquidacion extends GXProcedure
{
   public duplicaliquidacion( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( duplicaliquidacion.class ), "" );
   }

   public duplicaliquidacion( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXSimpleCollection<Integer> executeUdp( int aP0 ,
                                                  short aP1 ,
                                                  byte aP2 ,
                                                  java.util.Date aP3 ,
                                                  GXSimpleCollection<Integer> aP4 ,
                                                  String aP5 ,
                                                  boolean[] aP6 ,
                                                  int[] aP7 )
   {
      duplicaliquidacion.this.aP8 = new GXSimpleCollection[] {new GXSimpleCollection<Integer>(Integer.class, "internal", "")};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8);
      return aP8[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        byte aP2 ,
                        java.util.Date aP3 ,
                        GXSimpleCollection<Integer> aP4 ,
                        String aP5 ,
                        boolean[] aP6 ,
                        int[] aP7 ,
                        GXSimpleCollection<Integer>[] aP8 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             byte aP2 ,
                             java.util.Date aP3 ,
                             GXSimpleCollection<Integer> aP4 ,
                             String aP5 ,
                             boolean[] aP6 ,
                             int[] aP7 ,
                             GXSimpleCollection<Integer>[] aP8 )
   {
      duplicaliquidacion.this.AV9CliCod = aP0;
      duplicaliquidacion.this.AV8EmpCod = aP1;
      duplicaliquidacion.this.AV14LiqClase = aP2;
      duplicaliquidacion.this.AV10LiqPeriodo = aP3;
      duplicaliquidacion.this.AV15legnumero = aP4;
      duplicaliquidacion.this.AV11TLiqCod = aP5;
      duplicaliquidacion.this.aP6 = aP6;
      duplicaliquidacion.this.aP7 = aP7;
      duplicaliquidacion.this.aP8 = aP8;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV17i = (short)(1) ;
      while ( AV17i <= AV15legnumero.size() )
      {
         AV16legnumeroALiquidar.add((int)(((Number) AV15legnumero.elementAt(-1+AV17i)).intValue()), 0);
         GXv_boolean1[0] = false ;
         GXv_boolean2[0] = AV18duplica ;
         new web.legajotieneliquidacionoposterior(remoteHandle, context).execute( AV9CliCod, AV8EmpCod, ((Number) AV15legnumero.elementAt(-1+AV17i)).intValue(), AV10LiqPeriodo, AV11TLiqCod, GXv_boolean1, GXv_boolean2) ;
         duplicaliquidacion.this.AV18duplica = GXv_boolean2[0] ;
         if ( AV18duplica )
         {
            if (true) break;
         }
         AV17i = (short)(AV17i+1) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP6[0] = duplicaliquidacion.this.AV18duplica;
      this.aP7[0] = duplicaliquidacion.this.AV19LiqNro;
      this.aP8[0] = duplicaliquidacion.this.AV16legnumeroALiquidar;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV16legnumeroALiquidar = new GXSimpleCollection<Integer>(Integer.class, "internal", "");
      GXv_boolean1 = new boolean[1] ;
      GXv_boolean2 = new boolean[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV14LiqClase ;
   private short AV8EmpCod ;
   private short AV17i ;
   private short Gx_err ;
   private int AV9CliCod ;
   private int AV19LiqNro ;
   private String AV11TLiqCod ;
   private java.util.Date AV10LiqPeriodo ;
   private boolean AV18duplica ;
   private boolean GXv_boolean1[] ;
   private boolean GXv_boolean2[] ;
   private GXSimpleCollection<Integer> AV15legnumero ;
   private GXSimpleCollection<Integer> AV16legnumeroALiquidar ;
   private GXSimpleCollection<Integer>[] aP8 ;
   private boolean[] aP6 ;
   private int[] aP7 ;
}

