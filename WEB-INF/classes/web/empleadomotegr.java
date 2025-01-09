package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class empleadomotegr extends GXProcedure
{
   public empleadomotegr( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( empleadomotegr.class ), "" );
   }

   public empleadomotegr( int remoteHandle ,
                          ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             String aP3 )
   {
      empleadomotegr.this.aP4 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4);
      return aP4[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        String aP3 ,
                        String[] aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             String aP3 ,
                             String[] aP4 )
   {
      empleadomotegr.this.AV13CliCod = aP0;
      empleadomotegr.this.AV14empcod = aP1;
      empleadomotegr.this.AV8LegNumero = aP2;
      empleadomotegr.this.AV12MegCodigo = aP3;
      empleadomotegr.this.aP4 = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV17GXLvl2 = (byte)(0) ;
      /* Using cursor P004V2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV13CliCod), Short.valueOf(AV14empcod), Integer.valueOf(AV8LegNumero), AV12MegCodigo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1583LegMegCodigo = P004V2_A1583LegMegCodigo[0] ;
         n1583LegMegCodigo = P004V2_n1583LegMegCodigo[0] ;
         A6LegNumero = P004V2_A6LegNumero[0] ;
         A1EmpCod = P004V2_A1EmpCod[0] ;
         A3CliCod = P004V2_A3CliCod[0] ;
         AV17GXLvl2 = (byte)(1) ;
         AV10tiene = "1" ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      if ( AV17GXLvl2 == 0 )
      {
         AV10tiene = "0" ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP4[0] = empleadomotegr.this.AV10tiene;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10tiene = "" ;
      scmdbuf = "" ;
      P004V2_A1583LegMegCodigo = new String[] {""} ;
      P004V2_n1583LegMegCodigo = new boolean[] {false} ;
      P004V2_A6LegNumero = new int[1] ;
      P004V2_A1EmpCod = new short[1] ;
      P004V2_A3CliCod = new int[1] ;
      A1583LegMegCodigo = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.empleadomotegr__default(),
         new Object[] {
             new Object[] {
            P004V2_A1583LegMegCodigo, P004V2_n1583LegMegCodigo, P004V2_A6LegNumero, P004V2_A1EmpCod, P004V2_A3CliCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV17GXLvl2 ;
   private short AV14empcod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV13CliCod ;
   private int AV8LegNumero ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private String AV12MegCodigo ;
   private String AV10tiene ;
   private String scmdbuf ;
   private String A1583LegMegCodigo ;
   private boolean n1583LegMegCodigo ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private String[] P004V2_A1583LegMegCodigo ;
   private boolean[] P004V2_n1583LegMegCodigo ;
   private int[] P004V2_A6LegNumero ;
   private short[] P004V2_A1EmpCod ;
   private int[] P004V2_A3CliCod ;
}

final  class empleadomotegr__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P004V2", "SELECT LegMegCodigo, LegNumero, EmpCod, CliCod FROM Legajo WHERE (CliCod = ? and EmpCod = ? and LegNumero = ?) AND (LegMegCodigo = ( ?)) ORDER BY CliCod, EmpCod, LegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((int[]) buf[2])[0] = rslt.getInt(2);
               ((short[]) buf[3])[0] = rslt.getShort(3);
               ((int[]) buf[4])[0] = rslt.getInt(4);
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
               stmt.setString(4, (String)parms[3], 20);
               return;
      }
   }

}

