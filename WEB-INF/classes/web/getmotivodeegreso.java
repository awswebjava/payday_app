package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getmotivodeegreso extends GXProcedure
{
   public getmotivodeegreso( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getmotivodeegreso.class ), "" );
   }

   public getmotivodeegreso( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              String aP1 ,
                              String aP2 )
   {
      getmotivodeegreso.this.aP3 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        String aP2 ,
                        boolean[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             String aP2 ,
                             boolean[] aP3 )
   {
      getmotivodeegreso.this.AV8CliCod = aP0;
      getmotivodeegreso.this.AV9MegCodigo = aP1;
      getmotivodeegreso.this.AV11MegDescrip = aP2;
      getmotivodeegreso.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV10existe = false ;
      /* Using cursor P021E2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), AV9MegCodigo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A11MegCodigo = P021E2_A11MegCodigo[0] ;
         A3CliCod = P021E2_A3CliCod[0] ;
         A300MegDescrip = P021E2_A300MegDescrip[0] ;
         AV11MegDescrip = A300MegDescrip ;
         AV10existe = true ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = getmotivodeegreso.this.AV10existe;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      scmdbuf = "" ;
      P021E2_A11MegCodigo = new String[] {""} ;
      P021E2_A3CliCod = new int[1] ;
      P021E2_A300MegDescrip = new String[] {""} ;
      A11MegCodigo = "" ;
      A300MegDescrip = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getmotivodeegreso__default(),
         new Object[] {
             new Object[] {
            P021E2_A11MegCodigo, P021E2_A3CliCod, P021E2_A300MegDescrip
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV8CliCod ;
   private int A3CliCod ;
   private String AV9MegCodigo ;
   private String scmdbuf ;
   private String A11MegCodigo ;
   private boolean AV10existe ;
   private String AV11MegDescrip ;
   private String A300MegDescrip ;
   private boolean[] aP3 ;
   private IDataStoreProvider pr_default ;
   private String[] P021E2_A11MegCodigo ;
   private int[] P021E2_A3CliCod ;
   private String[] P021E2_A300MegDescrip ;
}

final  class getmotivodeegreso__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P021E2", "SELECT MegCodigo, CliCod, MegDescrip FROM MotivoEgreso WHERE CliCod = ? and MegCodigo = ( ?) ORDER BY CliCod, MegCodigo ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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

