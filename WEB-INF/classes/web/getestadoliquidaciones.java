package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getestadoliquidaciones extends GXProcedure
{
   public getestadoliquidaciones( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getestadoliquidaciones.class ), "" );
   }

   public getestadoliquidaciones( int remoteHandle ,
                                  ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             GXSimpleCollection<Integer> aP2 )
   {
      getestadoliquidaciones.this.aP3 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        GXSimpleCollection<Integer> aP2 ,
                        String[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             GXSimpleCollection<Integer> aP2 ,
                             String[] aP3 )
   {
      getestadoliquidaciones.this.AV15CliCod = aP0;
      getestadoliquidaciones.this.AV11EmpCod = aP1;
      getestadoliquidaciones.this.AV8liquidaciones_generadas = aP2;
      getestadoliquidaciones.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( AV8liquidaciones_generadas.size() > 0 )
      {
         AV10i = (short)(1) ;
         while ( AV10i <= AV8liquidaciones_generadas.size() )
         {
            AV12LiqNro = ((Number) AV8liquidaciones_generadas.elementAt(-1+AV10i)).intValue() ;
            AV18GXLvl5 = (byte)(0) ;
            /* Using cursor P00OP2 */
            pr_default.execute(0, new Object[] {Integer.valueOf(AV15CliCod), Short.valueOf(AV11EmpCod), Integer.valueOf(AV12LiqNro)});
            while ( (pr_default.getStatus(0) != 101) )
            {
               A31LiqNro = P00OP2_A31LiqNro[0] ;
               A1EmpCod = P00OP2_A1EmpCod[0] ;
               A3CliCod = P00OP2_A3CliCod[0] ;
               A278LiqEstado = P00OP2_A278LiqEstado[0] ;
               AV18GXLvl5 = (byte)(1) ;
               if ( A278LiqEstado == 2 )
               {
                  AV13cantError = (short)(AV13cantError+1) ;
               }
               /* Exiting from a For First loop. */
               if (true) break;
            }
            pr_default.close(0);
            if ( AV18GXLvl5 == 0 )
            {
               AV13cantError = (short)(AV13cantError+1) ;
            }
            AV10i = (short)(AV10i+1) ;
         }
         if ( AV13cantError > 0 )
         {
            if ( AV8liquidaciones_generadas.size() == 1 )
            {
               AV14error = httpContext.getMessage( "Liquidación generada con error", "") ;
            }
            else
            {
               if ( AV13cantError == AV8liquidaciones_generadas.size() )
               {
                  AV14error = httpContext.getMessage( "Las liquidaciones se generaron con error", "") ;
               }
               else
               {
                  AV14error = GXutil.trim( GXutil.str( AV13cantError, 4, 0)) + httpContext.getMessage( " liquidaciones se generaron con error", "") ;
               }
            }
         }
         else
         {
         }
      }
      else
      {
         AV14error = httpContext.getMessage( "No se generó ninguna liquidación", "") ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = getestadoliquidaciones.this.AV14error;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV14error = "" ;
      scmdbuf = "" ;
      P00OP2_A31LiqNro = new int[1] ;
      P00OP2_A1EmpCod = new short[1] ;
      P00OP2_A3CliCod = new int[1] ;
      P00OP2_A278LiqEstado = new byte[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getestadoliquidaciones__default(),
         new Object[] {
             new Object[] {
            P00OP2_A31LiqNro, P00OP2_A1EmpCod, P00OP2_A3CliCod, P00OP2_A278LiqEstado
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV18GXLvl5 ;
   private byte A278LiqEstado ;
   private short AV11EmpCod ;
   private short AV10i ;
   private short A1EmpCod ;
   private short AV13cantError ;
   private short Gx_err ;
   private int AV15CliCod ;
   private int AV12LiqNro ;
   private int A31LiqNro ;
   private int A3CliCod ;
   private String scmdbuf ;
   private String AV14error ;
   private GXSimpleCollection<Integer> AV8liquidaciones_generadas ;
   private String[] aP3 ;
   private IDataStoreProvider pr_default ;
   private int[] P00OP2_A31LiqNro ;
   private short[] P00OP2_A1EmpCod ;
   private int[] P00OP2_A3CliCod ;
   private byte[] P00OP2_A278LiqEstado ;
}

final  class getestadoliquidaciones__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00OP2", "SELECT LiqNro, EmpCod, CliCod, LiqEstado FROM Liquidacion WHERE CliCod = ? and EmpCod = ? and LiqNro = ? ORDER BY CliCod, EmpCod, LiqNro ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
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
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
      }
   }

}

