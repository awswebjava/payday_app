package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getplanmedicopordescrip extends GXProcedure
{
   public getplanmedicopordescrip( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getplanmedicopordescrip.class ), "" );
   }

   public getplanmedicopordescrip( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              String aP1 ,
                              String[] aP2 )
   {
      getplanmedicopordescrip.this.aP3 = new boolean[] {false};
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
      getplanmedicopordescrip.this.AV11CliCod = aP0;
      getplanmedicopordescrip.this.AV8PmedDescrip = aP1;
      getplanmedicopordescrip.this.aP2 = aP2;
      getplanmedicopordescrip.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P00LY2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV11CliCod), AV8PmedDescrip});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A682PmedDescripSinAc = P00LY2_A682PmedDescripSinAc[0] ;
         A3CliCod = P00LY2_A3CliCod[0] ;
         A12PmedCod = P00LY2_A12PmedCod[0] ;
         AV10PmedCod = A12PmedCod ;
         AV9existe = true ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = getplanmedicopordescrip.this.AV10PmedCod;
      this.aP3[0] = getplanmedicopordescrip.this.AV9existe;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10PmedCod = "" ;
      scmdbuf = "" ;
      P00LY2_A682PmedDescripSinAc = new String[] {""} ;
      P00LY2_A3CliCod = new int[1] ;
      P00LY2_A12PmedCod = new String[] {""} ;
      A682PmedDescripSinAc = "" ;
      A12PmedCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getplanmedicopordescrip__default(),
         new Object[] {
             new Object[] {
            P00LY2_A682PmedDescripSinAc, P00LY2_A3CliCod, P00LY2_A12PmedCod
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
   private String A682PmedDescripSinAc ;
   private boolean[] aP3 ;
   private String[] aP2 ;
   private IDataStoreProvider pr_default ;
   private String[] P00LY2_A682PmedDescripSinAc ;
   private int[] P00LY2_A3CliCod ;
   private String[] P00LY2_A12PmedCod ;
}

final  class getplanmedicopordescrip__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00LY2", "SELECT PmedDescripSinAc, CliCod, PmedCod FROM PlanMedico WHERE (CliCod = ?) AND (PmedDescripSinAc = ( ?)) ORDER BY CliCod  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
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
               stmt.setVarchar(2, (String)parms[1], 30);
               return;
      }
   }

}

