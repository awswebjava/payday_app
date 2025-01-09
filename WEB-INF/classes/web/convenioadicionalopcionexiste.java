package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class convenioadicionalopcionexiste extends GXProcedure
{
   public convenioadicionalopcionexiste( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( convenioadicionalopcionexiste.class ), "" );
   }

   public convenioadicionalopcionexiste( int remoteHandle ,
                                         ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              short aP1 ,
                              String aP2 ,
                              String aP3 ,
                              short aP4 )
   {
      convenioadicionalopcionexiste.this.aP5 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
      return aP5[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        String aP2 ,
                        String aP3 ,
                        short aP4 ,
                        boolean[] aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             String aP2 ,
                             String aP3 ,
                             short aP4 ,
                             boolean[] aP5 )
   {
      convenioadicionalopcionexiste.this.AV12CliCod = aP0;
      convenioadicionalopcionexiste.this.AV11CliPaiConve = aP1;
      convenioadicionalopcionexiste.this.AV10CliConvenio = aP2;
      convenioadicionalopcionexiste.this.AV8ConveAdicod = aP3;
      convenioadicionalopcionexiste.this.AV13ConveAdiOpcCod = aP4;
      convenioadicionalopcionexiste.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           AV10CliConvenio ,
                                           AV8ConveAdicod ,
                                           A1565CliConvenio ,
                                           A996ConveAdicod ,
                                           Short.valueOf(A1011ConveAdiOpcCod) ,
                                           Short.valueOf(AV13ConveAdiOpcCod) ,
                                           Integer.valueOf(AV12CliCod) ,
                                           Short.valueOf(AV11CliPaiConve) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1564CliPaiConve) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT
                                           }
      });
      /* Using cursor P02092 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV12CliCod), Short.valueOf(AV11CliPaiConve), Short.valueOf(AV13ConveAdiOpcCod), AV10CliConvenio, AV8ConveAdicod});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1011ConveAdiOpcCod = P02092_A1011ConveAdiOpcCod[0] ;
         A996ConveAdicod = P02092_A996ConveAdicod[0] ;
         A1565CliConvenio = P02092_A1565CliConvenio[0] ;
         A1564CliPaiConve = P02092_A1564CliPaiConve[0] ;
         A3CliCod = P02092_A3CliCod[0] ;
         AV9existe = true ;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP5[0] = convenioadicionalopcionexiste.this.AV9existe;
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
      A1565CliConvenio = "" ;
      A996ConveAdicod = "" ;
      P02092_A1011ConveAdiOpcCod = new short[1] ;
      P02092_A996ConveAdicod = new String[] {""} ;
      P02092_A1565CliConvenio = new String[] {""} ;
      P02092_A1564CliPaiConve = new short[1] ;
      P02092_A3CliCod = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.convenioadicionalopcionexiste__default(),
         new Object[] {
             new Object[] {
            P02092_A1011ConveAdiOpcCod, P02092_A996ConveAdicod, P02092_A1565CliConvenio, P02092_A1564CliPaiConve, P02092_A3CliCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV11CliPaiConve ;
   private short AV13ConveAdiOpcCod ;
   private short A1011ConveAdiOpcCod ;
   private short A1564CliPaiConve ;
   private short Gx_err ;
   private int AV12CliCod ;
   private int A3CliCod ;
   private String AV10CliConvenio ;
   private String AV8ConveAdicod ;
   private String scmdbuf ;
   private String A1565CliConvenio ;
   private String A996ConveAdicod ;
   private boolean AV9existe ;
   private boolean[] aP5 ;
   private IDataStoreProvider pr_default ;
   private short[] P02092_A1011ConveAdiOpcCod ;
   private String[] P02092_A996ConveAdicod ;
   private String[] P02092_A1565CliConvenio ;
   private short[] P02092_A1564CliPaiConve ;
   private int[] P02092_A3CliCod ;
}

final  class convenioadicionalopcionexiste__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P02092( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV10CliConvenio ,
                                          String AV8ConveAdicod ,
                                          String A1565CliConvenio ,
                                          String A996ConveAdicod ,
                                          short A1011ConveAdiOpcCod ,
                                          short AV13ConveAdiOpcCod ,
                                          int AV12CliCod ,
                                          short AV11CliPaiConve ,
                                          int A3CliCod ,
                                          short A1564CliPaiConve )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int1 = new byte[5];
      Object[] GXv_Object2 = new Object[2];
      scmdbuf = "SELECT ConveAdiOpcCod, ConveAdicod, CliConvenio, CliPaiConve, CliCod FROM convenio_adicionalalicuotas" ;
      addWhere(sWhereString, "(CliCod = ? and CliPaiConve = ?)");
      addWhere(sWhereString, "(ConveAdiOpcCod = ?)");
      if ( ! (GXutil.strcmp("", AV10CliConvenio)==0) )
      {
         addWhere(sWhereString, "(CliConvenio = ( ?))");
      }
      else
      {
         GXv_int1[3] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV8ConveAdicod)==0) )
      {
         addWhere(sWhereString, "(ConveAdicod = ( ?))");
      }
      else
      {
         GXv_int1[4] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, CliPaiConve" ;
      GXv_Object2[0] = scmdbuf ;
      GXv_Object2[1] = GXv_int1 ;
      return GXv_Object2 ;
   }

   public Object [] getDynamicStatement( int cursor ,
                                         ModelContext context ,
                                         int remoteHandle ,
                                         com.genexus.IHttpContext httpContext ,
                                         Object [] dynConstraints )
   {
      switch ( cursor )
      {
            case 0 :
                  return conditional_P02092(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] , (String)dynConstraints[2] , (String)dynConstraints[3] , ((Number) dynConstraints[4]).shortValue() , ((Number) dynConstraints[5]).shortValue() , ((Number) dynConstraints[6]).intValue() , ((Number) dynConstraints[7]).shortValue() , ((Number) dynConstraints[8]).intValue() , ((Number) dynConstraints[9]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02092", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      short sIdx;
      switch ( cursor )
      {
            case 0 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[5]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[6]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[7]).shortValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[8], 20);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[9], 20);
               }
               return;
      }
   }

}

