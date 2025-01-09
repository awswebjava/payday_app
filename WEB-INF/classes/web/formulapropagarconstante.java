package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class formulapropagarconstante extends GXProcedure
{
   public formulapropagarconstante( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( formulapropagarconstante.class ), "" );
   }

   public formulapropagarconstante( int remoteHandle ,
                                    ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        String aP2 ,
                        String aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             String aP2 ,
                             String aP3 )
   {
      formulapropagarconstante.this.AV8CliCod = aP0;
      formulapropagarconstante.this.AV18modificarSoloPropios = aP1;
      formulapropagarconstante.this.AV16OldPalabra = aP2;
      formulapropagarconstante.this.AV17Palabra = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV9CliPaiCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.clientegetpais(remoteHandle, context).execute( AV8CliCod, GXv_int2) ;
      formulapropagarconstante.this.GXt_int1 = GXv_int2[0] ;
      AV9CliPaiCod = GXt_int1 ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           Short.valueOf(AV18modificarSoloPropios) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Integer.valueOf(AV8CliCod) ,
                                           Short.valueOf(A4CliPaiCod) ,
                                           Short.valueOf(AV9CliPaiCod) ,
                                           Boolean.valueOf(A747ClienteSistema) } ,
                                           new int[]{
                                           TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.BOOLEAN
                                           }
      });
      /* Using cursor P00JR2 */
      pr_default.execute(0, new Object[] {Short.valueOf(AV9CliPaiCod), Integer.valueOf(AV8CliCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A747ClienteSistema = P00JR2_A747ClienteSistema[0] ;
         A3CliCod = P00JR2_A3CliCod[0] ;
         A4CliPaiCod = P00JR2_A4CliPaiCod[0] ;
         n4CliPaiCod = P00JR2_n4CliPaiCod[0] ;
         A148ConFormula = P00JR2_A148ConFormula[0] ;
         n148ConFormula = P00JR2_n148ConFormula[0] ;
         A26ConCodigo = P00JR2_A26ConCodigo[0] ;
         A747ClienteSistema = P00JR2_A747ClienteSistema[0] ;
         A4CliPaiCod = P00JR2_A4CliPaiCod[0] ;
         n4CliPaiCod = P00JR2_n4CliPaiCod[0] ;
         if ( GXutil.strSearch( A148ConFormula, AV16OldPalabra, 1) != 0 )
         {
            AV15ConFormula = A148ConFormula ;
            A148ConFormula = GXutil.strReplace( A148ConFormula, AV16OldPalabra, AV17Palabra) ;
            n148ConFormula = false ;
            new web.grabarhistorico(remoteHandle, context).execute( A3CliCod, A26ConCodigo, AV15ConFormula, A148ConFormula, 0, false) ;
         }
         /* Using cursor P00JR3 */
         pr_default.execute(1, new Object[] {Boolean.valueOf(n148ConFormula), A148ConFormula, Integer.valueOf(A3CliCod), A26ConCodigo});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Concepto");
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "formulapropagarconstante");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      GXv_int2 = new short[1] ;
      scmdbuf = "" ;
      P00JR2_A747ClienteSistema = new boolean[] {false} ;
      P00JR2_A3CliCod = new int[1] ;
      P00JR2_A4CliPaiCod = new short[1] ;
      P00JR2_n4CliPaiCod = new boolean[] {false} ;
      P00JR2_A148ConFormula = new String[] {""} ;
      P00JR2_n148ConFormula = new boolean[] {false} ;
      P00JR2_A26ConCodigo = new String[] {""} ;
      A148ConFormula = "" ;
      A26ConCodigo = "" ;
      AV15ConFormula = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.formulapropagarconstante__default(),
         new Object[] {
             new Object[] {
            P00JR2_A747ClienteSistema, P00JR2_A3CliCod, P00JR2_A4CliPaiCod, P00JR2_n4CliPaiCod, P00JR2_A148ConFormula, P00JR2_n148ConFormula, P00JR2_A26ConCodigo
            }
            , new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV18modificarSoloPropios ;
   private short AV9CliPaiCod ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short A4CliPaiCod ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int A3CliCod ;
   private String AV16OldPalabra ;
   private String AV17Palabra ;
   private String scmdbuf ;
   private String A26ConCodigo ;
   private boolean A747ClienteSistema ;
   private boolean n4CliPaiCod ;
   private boolean n148ConFormula ;
   private String A148ConFormula ;
   private String AV15ConFormula ;
   private IDataStoreProvider pr_default ;
   private boolean[] P00JR2_A747ClienteSistema ;
   private int[] P00JR2_A3CliCod ;
   private short[] P00JR2_A4CliPaiCod ;
   private boolean[] P00JR2_n4CliPaiCod ;
   private String[] P00JR2_A148ConFormula ;
   private boolean[] P00JR2_n148ConFormula ;
   private String[] P00JR2_A26ConCodigo ;
}

final  class formulapropagarconstante__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P00JR2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          short AV18modificarSoloPropios ,
                                          int A3CliCod ,
                                          int AV8CliCod ,
                                          short A4CliPaiCod ,
                                          short AV9CliPaiCod ,
                                          boolean A747ClienteSistema )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int3 = new byte[2];
      Object[] GXv_Object4 = new Object[2];
      scmdbuf = "SELECT T2.ClienteSistema, T1.CliCod, T2.CliPaiCod, T1.ConFormula, T1.ConCodigo FROM (Concepto T1 INNER JOIN Cliente T2 ON T2.CliCod = T1.CliCod)" ;
      addWhere(sWhereString, "(T2.CliPaiCod = ?)");
      addWhere(sWhereString, "(T2.ClienteSistema = FALSE)");
      if ( ( AV18modificarSoloPropios == ( 1 )) )
      {
         addWhere(sWhereString, "(T1.CliCod = ?)");
      }
      else
      {
         GXv_int3[1] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.CliCod, T1.ConCodigo" ;
      scmdbuf += " FOR UPDATE OF T1, T1" ;
      GXv_Object4[0] = scmdbuf ;
      GXv_Object4[1] = GXv_int3 ;
      return GXv_Object4 ;
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
                  return conditional_P00JR2(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).shortValue() , ((Number) dynConstraints[1]).intValue() , ((Number) dynConstraints[2]).intValue() , ((Number) dynConstraints[3]).shortValue() , ((Number) dynConstraints[4]).shortValue() , ((Boolean) dynConstraints[5]).booleanValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00JR2", "scmdbuf",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P00JR3", "SAVEPOINT gxupdate;UPDATE Concepto SET ConFormula=?  WHERE CliCod = ? AND ConCodigo = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((String[]) buf[4])[0] = rslt.getLongVarchar(4);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((String[]) buf[6])[0] = rslt.getString(5, 10);
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
                  stmt.setShort(sIdx, ((Number) parms[2]).shortValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[3]).intValue());
               }
               return;
            case 1 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.LONGVARCHAR );
               }
               else
               {
                  stmt.setNLongVarchar(1, (String)parms[1]);
               }
               stmt.setInt(2, ((Number) parms[2]).intValue());
               stmt.setString(3, (String)parms[3], 10);
               return;
      }
   }

}

