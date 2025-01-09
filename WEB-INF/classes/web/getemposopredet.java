package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getemposopredet extends GXProcedure
{
   public getemposopredet( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getemposopredet.class ), "" );
   }

   public getemposopredet( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             boolean aP2 )
   {
      getemposopredet.this.aP3 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        boolean aP2 ,
                        String[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             boolean aP2 ,
                             String[] aP3 )
   {
      getemposopredet.this.AV8CliCod = aP0;
      getemposopredet.this.AV9EmpCod = aP1;
      getemposopredet.this.AV11forzar = aP2;
      getemposopredet.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01W02 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), Short.valueOf(AV9EmpCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1EmpCod = P01W02_A1EmpCod[0] ;
         A3CliCod = P01W02_A3CliCod[0] ;
         A1965EmpOsoCod = P01W02_A1965EmpOsoCod[0] ;
         n1965EmpOsoCod = P01W02_n1965EmpOsoCod[0] ;
         AV10EmpOsoCod = A1965EmpOsoCod ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      if ( AV11forzar )
      {
         if ( (GXutil.strcmp("", AV10EmpOsoCod)==0) )
         {
            AV10EmpOsoCod = "4-0080-0" ;
         }
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = getemposopredet.this.AV10EmpOsoCod;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10EmpOsoCod = "" ;
      scmdbuf = "" ;
      P01W02_A1EmpCod = new short[1] ;
      P01W02_A3CliCod = new int[1] ;
      P01W02_A1965EmpOsoCod = new String[] {""} ;
      P01W02_n1965EmpOsoCod = new boolean[] {false} ;
      A1965EmpOsoCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getemposopredet__default(),
         new Object[] {
             new Object[] {
            P01W02_A1EmpCod, P01W02_A3CliCod, P01W02_A1965EmpOsoCod, P01W02_n1965EmpOsoCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV9EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int A3CliCod ;
   private String AV10EmpOsoCod ;
   private String scmdbuf ;
   private String A1965EmpOsoCod ;
   private boolean AV11forzar ;
   private boolean n1965EmpOsoCod ;
   private String[] aP3 ;
   private IDataStoreProvider pr_default ;
   private short[] P01W02_A1EmpCod ;
   private int[] P01W02_A3CliCod ;
   private String[] P01W02_A1965EmpOsoCod ;
   private boolean[] P01W02_n1965EmpOsoCod ;
}

final  class getemposopredet__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01W02", "SELECT EmpCod, CliCod, EmpOsoCod FROM Empresa WHERE CliCod = ? and EmpCod = ? ORDER BY CliCod, EmpCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
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

