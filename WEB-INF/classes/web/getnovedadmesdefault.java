package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getnovedadmesdefault extends GXProcedure
{
   public getnovedadmesdefault( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getnovedadmesdefault.class ), "" );
   }

   public getnovedadmesdefault( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              short[] aP1 ,
                              int[] aP2 ,
                              short[] aP3 ,
                              short[] aP4 )
   {
      getnovedadmesdefault.this.aP5 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
      return aP5[0];
   }

   public void execute( int aP0 ,
                        short[] aP1 ,
                        int[] aP2 ,
                        short[] aP3 ,
                        short[] aP4 ,
                        boolean[] aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( int aP0 ,
                             short[] aP1 ,
                             int[] aP2 ,
                             short[] aP3 ,
                             short[] aP4 ,
                             boolean[] aP5 )
   {
      getnovedadmesdefault.this.AV11CliCod = aP0;
      getnovedadmesdefault.this.AV8EmpCod = aP1[0];
      this.aP1 = aP1;
      getnovedadmesdefault.this.AV9LegNumero = aP2[0];
      this.aP2 = aP2;
      getnovedadmesdefault.this.aP3 = aP3;
      getnovedadmesdefault.this.aP4 = aP4;
      getnovedadmesdefault.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_int1[0] = AV10LegClase ;
      new web.getlegajoclase(remoteHandle, context).execute( AV11CliCod, AV8EmpCod, AV9LegNumero, GXv_int1) ;
      getnovedadmesdefault.this.AV10LegClase = GXv_int1[0] ;
      if ( AV10LegClase == 1 )
      {
         GXv_int2[0] = AV15anio ;
         GXv_int3[0] = AV17mesNro ;
         GXv_boolean4[0] = AV16hay ;
         new web.getperiodoultliqmensual(remoteHandle, context).execute( AV11CliCod, AV8EmpCod, AV9LegNumero, GXv_int2, GXv_int3, GXv_boolean4) ;
         getnovedadmesdefault.this.AV15anio = GXv_int2[0] ;
         getnovedadmesdefault.this.AV17mesNro = GXv_int3[0] ;
         getnovedadmesdefault.this.AV16hay = GXv_boolean4[0] ;
         GXv_int3[0] = AV17mesNro ;
         GXv_int2[0] = AV15anio ;
         new web.getperiodosiguiente(remoteHandle, context).execute( AV11CliCod, AV8EmpCod, GXv_int3, GXv_int2) ;
         getnovedadmesdefault.this.AV17mesNro = GXv_int3[0] ;
         getnovedadmesdefault.this.AV15anio = GXv_int2[0] ;
      }
      else
      {
         GXv_int3[0] = AV15anio ;
         GXv_int1[0] = (byte)(AV17mesNro) ;
         GXv_date5[0] = AV14novLiqPeriodo ;
         GXv_boolean4[0] = AV16hay ;
         GXv_char6[0] = AV18TLiqCod ;
         new web.getultimanovedad(remoteHandle, context).execute( AV11CliCod, AV8EmpCod, AV9LegNumero, true, GXv_int3, GXv_int1, GXv_date5, GXv_boolean4, GXv_char6) ;
         getnovedadmesdefault.this.AV15anio = GXv_int3[0] ;
         getnovedadmesdefault.this.AV17mesNro = GXv_int1[0] ;
         getnovedadmesdefault.this.AV14novLiqPeriodo = GXv_date5[0] ;
         getnovedadmesdefault.this.AV16hay = GXv_boolean4[0] ;
         getnovedadmesdefault.this.AV18TLiqCod = GXv_char6[0] ;
         if ( AV16hay )
         {
            GXv_char6[0] = AV19primeraQuincenaTLiqCod ;
            new web.getparametro(remoteHandle, context).execute( AV11CliCod, new web.tipoliqquincena_codigoparam(remoteHandle, context).executeUdp( ), GXv_char6) ;
            getnovedadmesdefault.this.AV19primeraQuincenaTLiqCod = GXv_char6[0] ;
            if ( GXutil.strcmp(AV18TLiqCod, AV19primeraQuincenaTLiqCod) != 0 )
            {
               GXv_int3[0] = AV17mesNro ;
               GXv_int2[0] = AV15anio ;
               new web.getperiodosiguiente(remoteHandle, context).execute( AV11CliCod, AV8EmpCod, GXv_int3, GXv_int2) ;
               getnovedadmesdefault.this.AV17mesNro = GXv_int3[0] ;
               getnovedadmesdefault.this.AV15anio = GXv_int2[0] ;
            }
         }
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = getnovedadmesdefault.this.AV8EmpCod;
      this.aP2[0] = getnovedadmesdefault.this.AV9LegNumero;
      this.aP3[0] = getnovedadmesdefault.this.AV15anio;
      this.aP4[0] = getnovedadmesdefault.this.AV17mesNro;
      this.aP5[0] = getnovedadmesdefault.this.AV16hay;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      GXv_int1 = new byte[1] ;
      AV14novLiqPeriodo = GXutil.nullDate() ;
      GXv_date5 = new java.util.Date[1] ;
      GXv_boolean4 = new boolean[1] ;
      AV18TLiqCod = "" ;
      AV19primeraQuincenaTLiqCod = "" ;
      GXv_char6 = new String[1] ;
      GXv_int3 = new short[1] ;
      GXv_int2 = new short[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV10LegClase ;
   private byte GXv_int1[] ;
   private short AV8EmpCod ;
   private short AV15anio ;
   private short AV17mesNro ;
   private short GXv_int3[] ;
   private short GXv_int2[] ;
   private short Gx_err ;
   private int AV11CliCod ;
   private int AV9LegNumero ;
   private String AV18TLiqCod ;
   private String AV19primeraQuincenaTLiqCod ;
   private String GXv_char6[] ;
   private java.util.Date AV14novLiqPeriodo ;
   private java.util.Date GXv_date5[] ;
   private boolean AV16hay ;
   private boolean GXv_boolean4[] ;
   private boolean[] aP5 ;
   private short[] aP1 ;
   private int[] aP2 ;
   private short[] aP3 ;
   private short[] aP4 ;
}

