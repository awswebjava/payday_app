package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class newempreligiondefault extends GXProcedure
{
   public newempreligiondefault( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( newempreligiondefault.class ), "" );
   }

   public newempreligiondefault( int remoteHandle ,
                                 ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( int aP0 ,
                             short aP1 )
   {
      newempreligiondefault.this.AV9CliCod = aP0;
      newempreligiondefault.this.AV8EmpCod = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /*
         INSERT RECORD ON TABLE Empresanolaborables_religion

      */
      A3CliCod = AV9CliCod ;
      A1EmpCod = AV8EmpCod ;
      GXt_char1 = A1237EmpReligion ;
      GXv_char2[0] = GXt_char1 ;
      new web.religiondefault(remoteHandle, context).execute( AV9CliCod, GXv_char2) ;
      newempreligiondefault.this.GXt_char1 = GXv_char2[0] ;
      A1237EmpReligion = GXt_char1 ;
      /* Using cursor P01RP2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1237EmpReligion});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("Empresanolaborables_religion");
      if ( (pr_default.getStatus(0) == 1) )
      {
         Gx_err = (short)(1) ;
         Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
      }
      else
      {
         Gx_err = (short)(0) ;
         Gx_emsg = "" ;
      }
      /* End Insert */
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "newempreligiondefault");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      A1237EmpReligion = "" ;
      GXt_char1 = "" ;
      GXv_char2 = new String[1] ;
      Gx_emsg = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.newempreligiondefault__default(),
         new Object[] {
             new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV8EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV9CliCod ;
   private int GX_INS146 ;
   private int A3CliCod ;
   private String A1237EmpReligion ;
   private String GXt_char1 ;
   private String GXv_char2[] ;
   private String Gx_emsg ;
   private IDataStoreProvider pr_default ;
}

final  class newempreligiondefault__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P01RP2", "SAVEPOINT gxupdate;INSERT INTO Empresanolaborables_religion(CliCod, EmpCod, EmpReligion) VALUES(?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
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
               stmt.setString(3, (String)parms[2], 20);
               return;
      }
   }

}

