package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class parentescohijo extends GXProcedure
{
   public parentescohijo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( parentescohijo.class ), "" );
   }

   public parentescohijo( int remoteHandle ,
                          ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 )
   {
      parentescohijo.this.aP1 = new String[] {""};
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
      parentescohijo.this.AV8CliCod = aP0;
      parentescohijo.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_char1 = AV11hijoPalabra ;
      GXv_char2[0] = GXt_char1 ;
      new web.hijopalabra(remoteHandle, context).execute( AV8CliCod, GXv_char2) ;
      parentescohijo.this.GXt_char1 = GXv_char2[0] ;
      AV11hijoPalabra = GXt_char1 ;
      AV14GXLvl2 = (byte)(0) ;
      /* Using cursor P00LH2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), AV11hijoPalabra});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A313ParDescrip = P00LH2_A313ParDescrip[0] ;
         A3CliCod = P00LH2_A3CliCod[0] ;
         A30ParCod = P00LH2_A30ParCod[0] ;
         AV14GXLvl2 = (byte)(1) ;
         AV9ParCod = A30ParCod ;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( AV14GXLvl2 == 0 )
      {
         /* Using cursor P00LH3 */
         pr_default.execute(1, new Object[] {Integer.valueOf(AV8CliCod)});
         while ( (pr_default.getStatus(1) != 101) )
         {
            A3CliCod = P00LH3_A3CliCod[0] ;
            A30ParCod = P00LH3_A30ParCod[0] ;
            AV9ParCod = A30ParCod ;
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
            pr_default.readNext(1);
         }
         pr_default.close(1);
      }
      if ( (GXutil.strcmp("", AV9ParCod)==0) )
      {
         AV9ParCod = "2" ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = parentescohijo.this.AV9ParCod;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9ParCod = "" ;
      AV11hijoPalabra = "" ;
      GXt_char1 = "" ;
      GXv_char2 = new String[1] ;
      scmdbuf = "" ;
      P00LH2_A313ParDescrip = new String[] {""} ;
      P00LH2_A3CliCod = new int[1] ;
      P00LH2_A30ParCod = new String[] {""} ;
      A313ParDescrip = "" ;
      A30ParCod = "" ;
      P00LH3_A3CliCod = new int[1] ;
      P00LH3_A30ParCod = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.parentescohijo__default(),
         new Object[] {
             new Object[] {
            P00LH2_A313ParDescrip, P00LH2_A3CliCod, P00LH2_A30ParCod
            }
            , new Object[] {
            P00LH3_A3CliCod, P00LH3_A30ParCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV14GXLvl2 ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int A3CliCod ;
   private String AV9ParCod ;
   private String AV11hijoPalabra ;
   private String GXt_char1 ;
   private String GXv_char2[] ;
   private String scmdbuf ;
   private String A30ParCod ;
   private String A313ParDescrip ;
   private String[] aP1 ;
   private IDataStoreProvider pr_default ;
   private String[] P00LH2_A313ParDescrip ;
   private int[] P00LH2_A3CliCod ;
   private String[] P00LH2_A30ParCod ;
   private int[] P00LH3_A3CliCod ;
   private String[] P00LH3_A30ParCod ;
}

final  class parentescohijo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00LH2", "SELECT ParDescrip, CliCod, ParCod FROM Parentesco WHERE CliCod = ? and ParDescrip = ( ?) ORDER BY CliCod, ParDescrip ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P00LH3", "SELECT CliCod, ParCod FROM Parentesco WHERE CliCod = ? ORDER BY CliCod, ParCod DESC  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
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
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
      }
   }

}

