package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getplanmedico extends GXProcedure
{
   public getplanmedico( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getplanmedico.class ), "" );
   }

   public getplanmedico( int remoteHandle ,
                         ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              String aP1 ,
                              String[] aP2 )
   {
      getplanmedico.this.aP3 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        String[] aP2 ,
                        boolean[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             String[] aP2 ,
                             boolean[] aP3 )
   {
      getplanmedico.this.AV11CliCod = aP0;
      getplanmedico.this.AV10PmedCod = aP1;
      getplanmedico.this.aP2 = aP2;
      getplanmedico.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P00MP2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV11CliCod), AV10PmedCod});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A12PmedCod = P00MP2_A12PmedCod[0] ;
         A3CliCod = P00MP2_A3CliCod[0] ;
         A319PmedDescrip = P00MP2_A319PmedDescrip[0] ;
         AV8PmedDescrip = A319PmedDescrip ;
         AV9existe = true ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = getplanmedico.this.AV8PmedDescrip;
      this.aP3[0] = getplanmedico.this.AV9existe;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8PmedDescrip = "" ;
      scmdbuf = "" ;
      P00MP2_A12PmedCod = new String[] {""} ;
      P00MP2_A3CliCod = new int[1] ;
      P00MP2_A319PmedDescrip = new String[] {""} ;
      A12PmedCod = "" ;
      A319PmedDescrip = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getplanmedico__default(),
         new Object[] {
             new Object[] {
            P00MP2_A12PmedCod, P00MP2_A3CliCod, P00MP2_A319PmedDescrip
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV11CliCod ;
   private int A3CliCod ;
   private String AV10PmedCod ;
   private String scmdbuf ;
   private String A12PmedCod ;
   private boolean AV9existe ;
   private String AV8PmedDescrip ;
   private String A319PmedDescrip ;
   private boolean[] aP3 ;
   private String[] aP2 ;
   private IDataStoreProvider pr_default ;
   private String[] P00MP2_A12PmedCod ;
   private int[] P00MP2_A3CliCod ;
   private String[] P00MP2_A319PmedDescrip ;
}

final  class getplanmedico__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00MP2", "SELECT PmedCod, CliCod, PmedDescrip FROM PlanMedico WHERE CliCod = ? and PmedCod = ( ?) ORDER BY CliCod, PmedCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
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
               stmt.setString(2, (String)parms[1], 20);
               return;
      }
   }

}

