package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getprimerclienteconvenio extends GXProcedure
{
   public getprimerclienteconvenio( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getprimerclienteconvenio.class ), "" );
   }

   public getprimerclienteconvenio( int remoteHandle ,
                                    ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 )
   {
      getprimerclienteconvenio.this.aP1 = new String[] {""};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( int aP0 ,
                        String[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( int aP0 ,
                             String[] aP1 )
   {
      getprimerclienteconvenio.this.AV9CliCod = aP0;
      getprimerclienteconvenio.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01HG2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV9CliCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1639CliConveHab = P01HG2_A1639CliConveHab[0] ;
         A3CliCod = P01HG2_A3CliCod[0] ;
         A1565CliConvenio = P01HG2_A1565CliConvenio[0] ;
         A1564CliPaiConve = P01HG2_A1564CliPaiConve[0] ;
         AV8CliConvenio = A1565CliConvenio ;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( (GXutil.strcmp("", AV8CliConvenio)==0) )
      {
         /* Using cursor P01HG3 */
         pr_default.execute(1, new Object[] {Integer.valueOf(AV9CliCod)});
         while ( (pr_default.getStatus(1) != 101) )
         {
            A3CliCod = P01HG3_A3CliCod[0] ;
            A1565CliConvenio = P01HG3_A1565CliConvenio[0] ;
            A1564CliPaiConve = P01HG3_A1564CliPaiConve[0] ;
            AV8CliConvenio = A1565CliConvenio ;
            pr_default.readNext(1);
         }
         pr_default.close(1);
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = getprimerclienteconvenio.this.AV8CliConvenio;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8CliConvenio = "" ;
      scmdbuf = "" ;
      P01HG2_A1639CliConveHab = new boolean[] {false} ;
      P01HG2_A3CliCod = new int[1] ;
      P01HG2_A1565CliConvenio = new String[] {""} ;
      P01HG2_A1564CliPaiConve = new short[1] ;
      A1565CliConvenio = "" ;
      P01HG3_A3CliCod = new int[1] ;
      P01HG3_A1565CliConvenio = new String[] {""} ;
      P01HG3_A1564CliPaiConve = new short[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getprimerclienteconvenio__default(),
         new Object[] {
             new Object[] {
            P01HG2_A1639CliConveHab, P01HG2_A3CliCod, P01HG2_A1565CliConvenio, P01HG2_A1564CliPaiConve
            }
            , new Object[] {
            P01HG3_A3CliCod, P01HG3_A1565CliConvenio, P01HG3_A1564CliPaiConve
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short A1564CliPaiConve ;
   private short Gx_err ;
   private int AV9CliCod ;
   private int A3CliCod ;
   private String AV8CliConvenio ;
   private String scmdbuf ;
   private String A1565CliConvenio ;
   private boolean A1639CliConveHab ;
   private String[] aP1 ;
   private IDataStoreProvider pr_default ;
   private boolean[] P01HG2_A1639CliConveHab ;
   private int[] P01HG2_A3CliCod ;
   private String[] P01HG2_A1565CliConvenio ;
   private short[] P01HG2_A1564CliPaiConve ;
   private int[] P01HG3_A3CliCod ;
   private String[] P01HG3_A1565CliConvenio ;
   private short[] P01HG3_A1564CliPaiConve ;
}

final  class getprimerclienteconvenio__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01HG2", "SELECT CliConveHab, CliCod, CliConvenio, CliPaiConve FROM ClienteConvenios WHERE (CliCod = ?) AND (CliConveHab = TRUE) ORDER BY CliCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01HG3", "SELECT CliCod, CliConvenio, CliPaiConve FROM ClienteConvenios WHERE CliCod = ? ORDER BY CliCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((boolean[]) buf[0])[0] = rslt.getBoolean(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((short[]) buf[2])[0] = rslt.getShort(3);
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
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
      }
   }

}

