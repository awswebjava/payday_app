package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getempliqfer extends GXProcedure
{
   public getempliqfer( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getempliqfer.class ), "" );
   }

   public getempliqfer( int remoteHandle ,
                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              short aP1 ,
                              int aP2 ,
                              int aP3 ,
                              byte aP4 ,
                              String aP5 )
   {
      getempliqfer.this.aP6 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
      return aP6[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        byte aP4 ,
                        String aP5 ,
                        boolean[] aP6 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             byte aP4 ,
                             String aP5 ,
                             boolean[] aP6 )
   {
      getempliqfer.this.AV10CliCod = aP0;
      getempliqfer.this.AV8EmpCod = aP1;
      getempliqfer.this.AV17LiqNro = aP2;
      getempliqfer.this.AV18LegNumero = aP3;
      getempliqfer.this.AV11LegClase = aP4;
      getempliqfer.this.AV12LegModTra = aP5;
      getempliqfer.this.aP6 = aP6;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( ( AV11LegClase == 1 ) && ( GXutil.strcmp(AV12LegModTra, "E") == 0 ) )
      {
         GXv_char1[0] = AV13tipo_tarifa ;
         new web.gettipodetarifa(remoteHandle, context).execute( AV10CliCod, AV8EmpCod, AV17LiqNro, AV18LegNumero, (short)(0), "", "", GXv_char1) ;
         getempliqfer.this.AV13tipo_tarifa = GXv_char1[0] ;
         if ( GXutil.strcmp(AV13tipo_tarifa, "P") == 0 )
         {
            AV14mensualizadoEs = true ;
         }
      }
      /* Using cursor P01ET2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV10CliCod), Short.valueOf(AV8EmpCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1EmpCod = P01ET2_A1EmpCod[0] ;
         A3CliCod = P01ET2_A3CliCod[0] ;
         A1524EmpLiqFer = P01ET2_A1524EmpLiqFer[0] ;
         A1750EmpLiqFerJor = P01ET2_A1750EmpLiqFerJor[0] ;
         if ( AV14mensualizadoEs )
         {
            AV9EmpLiqFer = A1524EmpLiqFer ;
         }
         else
         {
            AV9EmpLiqFer = A1750EmpLiqFerJor ;
         }
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP6[0] = getempliqfer.this.AV9EmpLiqFer;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV13tipo_tarifa = "" ;
      GXv_char1 = new String[1] ;
      scmdbuf = "" ;
      P01ET2_A1EmpCod = new short[1] ;
      P01ET2_A3CliCod = new int[1] ;
      P01ET2_A1524EmpLiqFer = new boolean[] {false} ;
      P01ET2_A1750EmpLiqFerJor = new boolean[] {false} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getempliqfer__default(),
         new Object[] {
             new Object[] {
            P01ET2_A1EmpCod, P01ET2_A3CliCod, P01ET2_A1524EmpLiqFer, P01ET2_A1750EmpLiqFerJor
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV11LegClase ;
   private short AV8EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV10CliCod ;
   private int AV17LiqNro ;
   private int AV18LegNumero ;
   private int A3CliCod ;
   private String AV12LegModTra ;
   private String AV13tipo_tarifa ;
   private String GXv_char1[] ;
   private String scmdbuf ;
   private boolean AV9EmpLiqFer ;
   private boolean AV14mensualizadoEs ;
   private boolean A1524EmpLiqFer ;
   private boolean A1750EmpLiqFerJor ;
   private boolean[] aP6 ;
   private IDataStoreProvider pr_default ;
   private short[] P01ET2_A1EmpCod ;
   private int[] P01ET2_A3CliCod ;
   private boolean[] P01ET2_A1524EmpLiqFer ;
   private boolean[] P01ET2_A1750EmpLiqFerJor ;
}

final  class getempliqfer__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01ET2", "SELECT EmpCod, CliCod, EmpLiqFer, EmpLiqFerJor FROM Empresa WHERE CliCod = ? and EmpCod = ? ORDER BY CliCod, EmpCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
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
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
      }
   }

}

