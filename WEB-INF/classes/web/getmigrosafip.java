package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getmigrosafip extends GXProcedure
{
   public getmigrosafip( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getmigrosafip.class ), "" );
   }

   public getmigrosafip( int remoteHandle ,
                         ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 )
   {
      getmigrosafip.this.aP3 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        String[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             String[] aP3 )
   {
      getmigrosafip.this.AV12CliCod = aP0;
      getmigrosafip.this.AV8EmpCod = aP1;
      getmigrosafip.this.AV10MigrLegNumero = aP2;
      getmigrosafip.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P00MK2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV12CliCod), Short.valueOf(AV8EmpCod), Integer.valueOf(AV10MigrLegNumero)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A87MigrLegNumero = P00MK2_A87MigrLegNumero[0] ;
         A1EmpCod = P00MK2_A1EmpCod[0] ;
         A3CliCod = P00MK2_A3CliCod[0] ;
         A634MigrLegOSAfip = P00MK2_A634MigrLegOSAfip[0] ;
         AV9MigrLegOSAfip = A634MigrLegOSAfip ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = getmigrosafip.this.AV9MigrLegOSAfip;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9MigrLegOSAfip = "" ;
      scmdbuf = "" ;
      P00MK2_A87MigrLegNumero = new int[1] ;
      P00MK2_A1EmpCod = new short[1] ;
      P00MK2_A3CliCod = new int[1] ;
      P00MK2_A634MigrLegOSAfip = new String[] {""} ;
      A634MigrLegOSAfip = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getmigrosafip__default(),
         new Object[] {
             new Object[] {
            P00MK2_A87MigrLegNumero, P00MK2_A1EmpCod, P00MK2_A3CliCod, P00MK2_A634MigrLegOSAfip
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV8EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV12CliCod ;
   private int AV10MigrLegNumero ;
   private int A87MigrLegNumero ;
   private int A3CliCod ;
   private String AV9MigrLegOSAfip ;
   private String scmdbuf ;
   private String A634MigrLegOSAfip ;
   private String[] aP3 ;
   private IDataStoreProvider pr_default ;
   private int[] P00MK2_A87MigrLegNumero ;
   private short[] P00MK2_A1EmpCod ;
   private int[] P00MK2_A3CliCod ;
   private String[] P00MK2_A634MigrLegOSAfip ;
}

final  class getmigrosafip__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00MK2", "SELECT MigrLegNumero, EmpCod, CliCod, MigrLegOSAfip FROM importacion_legajo WHERE CliCod = ? and EmpCod = ? and MigrLegNumero = ? ORDER BY CliCod, EmpCod, MigrLegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
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

