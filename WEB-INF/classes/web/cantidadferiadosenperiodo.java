package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class cantidadferiadosenperiodo extends GXProcedure
{
   public cantidadferiadosenperiodo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( cantidadferiadosenperiodo.class ), "" );
   }

   public cantidadferiadosenperiodo( int remoteHandle ,
                                     ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public short executeUdp( int aP0 ,
                            short aP1 ,
                            int aP2 ,
                            int aP3 ,
                            java.util.Date aP4 )
   {
      cantidadferiadosenperiodo.this.aP5 = new short[] {0};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
      return aP5[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        java.util.Date aP4 ,
                        short[] aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             java.util.Date aP4 ,
                             short[] aP5 )
   {
      cantidadferiadosenperiodo.this.AV14CliCod = aP0;
      cantidadferiadosenperiodo.this.AV15EmpCod = aP1;
      cantidadferiadosenperiodo.this.AV16LiqNro = aP2;
      cantidadferiadosenperiodo.this.AV17LegNumero = aP3;
      cantidadferiadosenperiodo.this.AV20LiqPeriodo = aP4;
      cantidadferiadosenperiodo.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV8PaiCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getpaicod(remoteHandle, context).execute( AV14CliCod, GXv_int2) ;
      cantidadferiadosenperiodo.this.GXt_int1 = GXv_int2[0] ;
      AV8PaiCod = GXt_int1 ;
      GXv_char3[0] = AV18TLiqCod ;
      new web.gettipoliq(remoteHandle, context).execute( AV14CliCod, AV15EmpCod, AV16LiqNro, GXv_char3) ;
      cantidadferiadosenperiodo.this.AV18TLiqCod = GXv_char3[0] ;
      GXv_int4[0] = AV19LegClase ;
      new web.getlegajoclase(remoteHandle, context).execute( AV14CliCod, AV15EmpCod, AV17LegNumero, GXv_int4) ;
      cantidadferiadosenperiodo.this.AV19LegClase = GXv_int4[0] ;
      GXv_date5[0] = AV9desdeFerFecha ;
      GXv_date6[0] = AV10hastaFerFecha ;
      new web.getrangoperiodos(remoteHandle, context).execute( AV14CliCod, AV15EmpCod, AV16LiqNro, AV17LegNumero, AV18TLiqCod, AV19LegClase, AV20LiqPeriodo, false, GXv_date5, GXv_date6) ;
      cantidadferiadosenperiodo.this.AV9desdeFerFecha = GXv_date5[0] ;
      cantidadferiadosenperiodo.this.AV10hastaFerFecha = GXv_date6[0] ;
      GXv_char3[0] = AV30LegConveCodigo ;
      GXv_char7[0] = AV23LegReligion ;
      GXv_char8[0] = AV26LegOrigen ;
      GXv_boolean9[0] = AV24empresaliquidaReligion ;
      GXv_boolean10[0] = AV27empresaliquidaOrigen ;
      GXv_boolean11[0] = AV28empresaliquidaConvenio ;
      new web.getreligorigconvenio(remoteHandle, context).execute( AV14CliCod, AV15EmpCod, AV17LegNumero, AV8PaiCod, GXv_char3, GXv_char7, GXv_char8, GXv_boolean9, GXv_boolean10, GXv_boolean11) ;
      cantidadferiadosenperiodo.this.AV30LegConveCodigo = GXv_char3[0] ;
      cantidadferiadosenperiodo.this.AV23LegReligion = GXv_char7[0] ;
      cantidadferiadosenperiodo.this.AV26LegOrigen = GXv_char8[0] ;
      cantidadferiadosenperiodo.this.AV24empresaliquidaReligion = GXv_boolean9[0] ;
      cantidadferiadosenperiodo.this.AV27empresaliquidaOrigen = GXv_boolean10[0] ;
      cantidadferiadosenperiodo.this.AV28empresaliquidaConvenio = GXv_boolean11[0] ;
      /* Using cursor P01BC2 */
      pr_default.execute(0, new Object[] {Short.valueOf(AV8PaiCod), AV9desdeFerFecha, AV10hastaFerFecha});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1227FerFecha = P01BC2_A1227FerFecha[0] ;
         A46PaiCod = P01BC2_A46PaiCod[0] ;
         A1230FerReligId = P01BC2_A1230FerReligId[0] ;
         n1230FerReligId = P01BC2_n1230FerReligId[0] ;
         A1232FerOrigId = P01BC2_A1232FerOrigId[0] ;
         n1232FerOrigId = P01BC2_n1232FerOrigId[0] ;
         A1234FeriadoConvenio = P01BC2_A1234FeriadoConvenio[0] ;
         n1234FeriadoConvenio = P01BC2_n1234FeriadoConvenio[0] ;
         A1223FerId = P01BC2_A1223FerId[0] ;
         A1226FerAnio = P01BC2_A1226FerAnio[0] ;
         A1230FerReligId = P01BC2_A1230FerReligId[0] ;
         n1230FerReligId = P01BC2_n1230FerReligId[0] ;
         A1232FerOrigId = P01BC2_A1232FerOrigId[0] ;
         n1232FerOrigId = P01BC2_n1232FerOrigId[0] ;
         A1234FeriadoConvenio = P01BC2_A1234FeriadoConvenio[0] ;
         n1234FeriadoConvenio = P01BC2_n1234FeriadoConvenio[0] ;
         GXv_boolean11[0] = AV25liquida ;
         new web.evaluanolaborable(remoteHandle, context).execute( AV14CliCod, AV15EmpCod, AV17LegNumero, A1227FerFecha, AV19LegClase, A1230FerReligId, AV23LegReligion, AV24empresaliquidaReligion, A1232FerOrigId, AV26LegOrigen, AV27empresaliquidaOrigen, A1234FeriadoConvenio, AV30LegConveCodigo, AV28empresaliquidaConvenio, GXv_boolean11) ;
         cantidadferiadosenperiodo.this.AV25liquida = GXv_boolean11[0] ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV37Pgmname, httpContext.getMessage( "ferid ", "")+GXutil.trim( A1223FerId)+httpContext.getMessage( " FerReligId ", "")+GXutil.trim( A1230FerReligId)+httpContext.getMessage( " &liquida  ", "")+GXutil.trim( GXutil.booltostr( AV25liquida))+httpContext.getMessage( " &empresaliquidaReligion ", "")+GXutil.trim( GXutil.booltostr( AV24empresaliquidaReligion))+httpContext.getMessage( " legregi ", "")+GXutil.trim( AV23LegReligion)) ;
         if ( AV25liquida )
         {
            AV33hayFeriadoTrabajado = false ;
            GXv_boolean11[0] = AV12hayLicenciaQueAbsorbe ;
            GXv_char8[0] = "" ;
            new web.haylicenciaqueabsorbefer(remoteHandle, context).execute( AV14CliCod, AV15EmpCod, AV17LegNumero, A1227FerFecha, A1227FerFecha, GXv_boolean11, GXv_char8) ;
            cantidadferiadosenperiodo.this.AV12hayLicenciaQueAbsorbe = GXv_boolean11[0] ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV37Pgmname, httpContext.getMessage( "&hayLicenciaQueAbsorbe ", "")+GXutil.trim( GXutil.booltostr( AV12hayLicenciaQueAbsorbe))) ;
            if ( ! AV12hayLicenciaQueAbsorbe && ! AV33hayFeriadoTrabajado )
            {
               AV21cantidad = (short)(AV21cantidad+1) ;
               new web.msgdebug_prod(remoteHandle, context).execute( AV37Pgmname, httpContext.getMessage( "suma", "")) ;
            }
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP5[0] = cantidadferiadosenperiodo.this.AV21cantidad;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      GXv_int2 = new short[1] ;
      AV18TLiqCod = "" ;
      GXv_int4 = new byte[1] ;
      AV9desdeFerFecha = GXutil.nullDate() ;
      GXv_date5 = new java.util.Date[1] ;
      AV10hastaFerFecha = GXutil.nullDate() ;
      GXv_date6 = new java.util.Date[1] ;
      AV30LegConveCodigo = "" ;
      GXv_char3 = new String[1] ;
      AV23LegReligion = "" ;
      GXv_char7 = new String[1] ;
      AV26LegOrigen = "" ;
      GXv_boolean9 = new boolean[1] ;
      GXv_boolean10 = new boolean[1] ;
      scmdbuf = "" ;
      P01BC2_A1227FerFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P01BC2_A46PaiCod = new short[1] ;
      P01BC2_A1230FerReligId = new String[] {""} ;
      P01BC2_n1230FerReligId = new boolean[] {false} ;
      P01BC2_A1232FerOrigId = new String[] {""} ;
      P01BC2_n1232FerOrigId = new boolean[] {false} ;
      P01BC2_A1234FeriadoConvenio = new String[] {""} ;
      P01BC2_n1234FeriadoConvenio = new boolean[] {false} ;
      P01BC2_A1223FerId = new String[] {""} ;
      P01BC2_A1226FerAnio = new short[1] ;
      A1227FerFecha = GXutil.nullDate() ;
      A1230FerReligId = "" ;
      A1232FerOrigId = "" ;
      A1234FeriadoConvenio = "" ;
      A1223FerId = "" ;
      AV37Pgmname = "" ;
      GXv_boolean11 = new boolean[1] ;
      GXv_char8 = new String[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.cantidadferiadosenperiodo__default(),
         new Object[] {
             new Object[] {
            P01BC2_A1227FerFecha, P01BC2_A46PaiCod, P01BC2_A1230FerReligId, P01BC2_n1230FerReligId, P01BC2_A1232FerOrigId, P01BC2_n1232FerOrigId, P01BC2_A1234FeriadoConvenio, P01BC2_n1234FeriadoConvenio, P01BC2_A1223FerId, P01BC2_A1226FerAnio
            }
         }
      );
      AV37Pgmname = "cantidadFeriadosEnPeriodo" ;
      /* GeneXus formulas. */
      AV37Pgmname = "cantidadFeriadosEnPeriodo" ;
      Gx_err = (short)(0) ;
   }

   private byte AV19LegClase ;
   private byte GXv_int4[] ;
   private short AV15EmpCod ;
   private short AV21cantidad ;
   private short AV8PaiCod ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short A46PaiCod ;
   private short A1226FerAnio ;
   private short Gx_err ;
   private int AV14CliCod ;
   private int AV16LiqNro ;
   private int AV17LegNumero ;
   private String AV18TLiqCod ;
   private String AV30LegConveCodigo ;
   private String GXv_char3[] ;
   private String AV23LegReligion ;
   private String GXv_char7[] ;
   private String AV26LegOrigen ;
   private String scmdbuf ;
   private String A1230FerReligId ;
   private String A1232FerOrigId ;
   private String A1234FeriadoConvenio ;
   private String A1223FerId ;
   private String AV37Pgmname ;
   private String GXv_char8[] ;
   private java.util.Date AV20LiqPeriodo ;
   private java.util.Date AV9desdeFerFecha ;
   private java.util.Date GXv_date5[] ;
   private java.util.Date AV10hastaFerFecha ;
   private java.util.Date GXv_date6[] ;
   private java.util.Date A1227FerFecha ;
   private boolean AV24empresaliquidaReligion ;
   private boolean GXv_boolean9[] ;
   private boolean AV27empresaliquidaOrigen ;
   private boolean GXv_boolean10[] ;
   private boolean AV28empresaliquidaConvenio ;
   private boolean n1230FerReligId ;
   private boolean n1232FerOrigId ;
   private boolean n1234FeriadoConvenio ;
   private boolean AV25liquida ;
   private boolean AV33hayFeriadoTrabajado ;
   private boolean AV12hayLicenciaQueAbsorbe ;
   private boolean GXv_boolean11[] ;
   private short[] aP5 ;
   private IDataStoreProvider pr_default ;
   private java.util.Date[] P01BC2_A1227FerFecha ;
   private short[] P01BC2_A46PaiCod ;
   private String[] P01BC2_A1230FerReligId ;
   private boolean[] P01BC2_n1230FerReligId ;
   private String[] P01BC2_A1232FerOrigId ;
   private boolean[] P01BC2_n1232FerOrigId ;
   private String[] P01BC2_A1234FeriadoConvenio ;
   private boolean[] P01BC2_n1234FeriadoConvenio ;
   private String[] P01BC2_A1223FerId ;
   private short[] P01BC2_A1226FerAnio ;
}

final  class cantidadferiadosenperiodo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01BC2", "SELECT T1.FerFecha, T1.PaiCod, T2.FerReligId, T2.FerOrigId, T2.FeriadoConvenio, T1.FerId, T1.FerAnio FROM (feriado_agenda T1 INNER JOIN feriado T2 ON T2.PaiCod = T1.PaiCod AND T2.FerId = T1.FerId) WHERE (T1.PaiCod = ?) AND (T1.FerFecha >= ?) AND (T1.FerFecha <= ?) ORDER BY T1.PaiCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDate(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((String[]) buf[4])[0] = rslt.getString(4, 20);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((String[]) buf[6])[0] = rslt.getString(5, 20);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((String[]) buf[8])[0] = rslt.getString(6, 40);
               ((short[]) buf[9])[0] = rslt.getShort(7);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setDate(2, (java.util.Date)parms[1]);
               stmt.setDate(3, (java.util.Date)parms[2]);
               return;
      }
   }

}

