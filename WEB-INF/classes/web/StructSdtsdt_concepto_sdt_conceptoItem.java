package web ;
import com.genexus.*;

public final  class StructSdtsdt_concepto_sdt_conceptoItem implements Cloneable, java.io.Serializable
{
   public StructSdtsdt_concepto_sdt_conceptoItem( )
   {
      this( -1, new ModelContext( StructSdtsdt_concepto_sdt_conceptoItem.class ));
   }

   public StructSdtsdt_concepto_sdt_conceptoItem( int remoteHandle ,
                                                  ModelContext context )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Concodigo = "" ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conrangocant = "" ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip = "" ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conformula = "" ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Convalorgen = new java.math.BigDecimal(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Contipoliqganancias = "" ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conobservacion = "" ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conformulaobs2 = "" ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Tipoconcod = "" ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Subtipoconcod1 = "" ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Subtipoconcod2 = "" ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conformulaexpl = "" ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Concondicion = "" ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Concondcodigo = "" ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conprereq = "" ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Concodafip = "" ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conceptoconvecodigo = "" ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Motivosegreso_N = (byte)(1) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Tipoliquidacion_N = (byte)(1) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Convenios_N = (byte)(1) ;
   }

   public Object clone()
   {
      Object cloned = null;
      try
      {
         cloned = super.clone();
      }catch (CloneNotSupportedException e){ ; }
      return cloned;
   }

   public String getConcodigo( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Concodigo ;
   }

   public void setConcodigo( String value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Concodigo = value ;
   }

   public String getConrangocant( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conrangocant ;
   }

   public void setConrangocant( String value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conrangocant = value ;
   }

   public boolean getConedienrec( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conedienrec ;
   }

   public void setConedienrec( boolean value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conedienrec = value ;
   }

   public boolean getConusado( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conusado ;
   }

   public void setConusado( boolean value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conusado = value ;
   }

   public java.util.Vector<web.StructSdtsdt_concepto_sdt_conceptoItem_MotEgrItem> getMotivosegreso( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Motivosegreso ;
   }

   public void setMotivosegreso( java.util.Vector<web.StructSdtsdt_concepto_sdt_conceptoItem_MotEgrItem> value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Motivosegreso_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Motivosegreso = value ;
   }

   public boolean getConretganpropor( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conretganpropor ;
   }

   public void setConretganpropor( boolean value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conretganpropor = value ;
   }

   public byte getConaplicgan( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conaplicgan ;
   }

   public void setConaplicgan( byte value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conaplicgan = value ;
   }

   public boolean getConrecalcular( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conrecalcular ;
   }

   public void setConrecalcular( boolean value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conrecalcular = value ;
   }

   public String getCondescrip( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip ;
   }

   public void setCondescrip( String value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip = value ;
   }

   public boolean getConhabilitado( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conhabilitado ;
   }

   public void setConhabilitado( boolean value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conhabilitado = value ;
   }

   public byte getContipo( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Contipo ;
   }

   public void setContipo( byte value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Contipo = value ;
   }

   public int getConorden( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conorden ;
   }

   public void setConorden( int value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conorden = value ;
   }

   public boolean getConcanti( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Concanti ;
   }

   public void setConcanti( boolean value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Concanti = value ;
   }

   public boolean getConvaluni( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Convaluni ;
   }

   public void setConvaluni( boolean value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Convaluni = value ;
   }

   public boolean getConimporte( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conimporte ;
   }

   public void setConimporte( boolean value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conimporte = value ;
   }

   public short getConvigencia( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Convigencia ;
   }

   public void setConvigencia( short value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Convigencia = value ;
   }

   public String getConformula( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conformula ;
   }

   public void setConformula( String value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conformula = value ;
   }

   public java.math.BigDecimal getConvalorgen( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Convalorgen ;
   }

   public void setConvalorgen( java.math.BigDecimal value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Convalorgen = value ;
   }

   public short getConformulaamigable( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conformulaamigable ;
   }

   public void setConformulaamigable( short value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conformulaamigable = value ;
   }

   public String getContipoliqganancias( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Contipoliqganancias ;
   }

   public void setContipoliqganancias( String value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Contipoliqganancias = value ;
   }

   public String getConobservacion( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conobservacion ;
   }

   public void setConobservacion( String value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conobservacion = value ;
   }

   public String getConformulaobs2( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conformulaobs2 ;
   }

   public void setConformulaobs2( String value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conformulaobs2 = value ;
   }

   public boolean getConvariable( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Convariable ;
   }

   public void setConvariable( boolean value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Convariable = value ;
   }

   public boolean getConforeditable( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conforeditable ;
   }

   public void setConforeditable( boolean value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conforeditable = value ;
   }

   public boolean getConsegunpla( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Consegunpla ;
   }

   public void setConsegunpla( boolean value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Consegunpla = value ;
   }

   public java.util.Vector<web.StructSdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem> getTipoliquidacion( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Tipoliquidacion ;
   }

   public void setTipoliquidacion( java.util.Vector<web.StructSdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem> value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Tipoliquidacion_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Tipoliquidacion = value ;
   }

   public String getTipoconcod( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Tipoconcod ;
   }

   public void setTipoconcod( String value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Tipoconcod = value ;
   }

   public String getSubtipoconcod1( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Subtipoconcod1 ;
   }

   public void setSubtipoconcod1( String value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Subtipoconcod1 = value ;
   }

   public String getSubtipoconcod2( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Subtipoconcod2 ;
   }

   public void setSubtipoconcod2( String value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Subtipoconcod2 = value ;
   }

   public String getConformulaexpl( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conformulaexpl ;
   }

   public void setConformulaexpl( String value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conformulaexpl = value ;
   }

   public short getContipoorden( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Contipoorden ;
   }

   public void setContipoorden( short value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Contipoorden = value ;
   }

   public long getConordejec( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conordejec ;
   }

   public void setConordejec( long value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conordejec = value ;
   }

   public boolean getConobliga( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conobliga ;
   }

   public void setConobliga( boolean value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conobliga = value ;
   }

   public boolean getConobligasisac( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conobligasisac ;
   }

   public void setConobligasisac( boolean value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conobligasisac = value ;
   }

   public String getConcondicion( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Concondicion ;
   }

   public void setConcondicion( String value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Concondicion = value ;
   }

   public String getConcondcodigo( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Concondcodigo ;
   }

   public void setConcondcodigo( String value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Concondcodigo = value ;
   }

   public String getConprereq( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conprereq ;
   }

   public void setConprereq( String value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conprereq = value ;
   }

   public java.util.Vector<web.StructSdtsdt_concepto_sdt_conceptoItem_ConveniosItem> getConvenios( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Convenios ;
   }

   public void setConvenios( java.util.Vector<web.StructSdtsdt_concepto_sdt_conceptoItem_ConveniosItem> value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Convenios_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Convenios = value ;
   }

   public boolean getConmostrarpos( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conmostrarpos ;
   }

   public void setConmostrarpos( boolean value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conmostrarpos = value ;
   }

   public byte getConadeldescu( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conadeldescu ;
   }

   public void setConadeldescu( byte value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conadeldescu = value ;
   }

   public short getApliigg( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Apliigg ;
   }

   public void setApliigg( short value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Apliigg = value ;
   }

   public byte getConnumero( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Connumero ;
   }

   public void setConnumero( byte value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Connumero = value ;
   }

   public byte getConsipaapo( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Consipaapo ;
   }

   public void setConsipaapo( byte value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Consipaapo = value ;
   }

   public byte getConsipacont( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Consipacont ;
   }

   public void setConsipacont( byte value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Consipacont = value ;
   }

   public byte getConinssjypapo( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Coninssjypapo ;
   }

   public void setConinssjypapo( byte value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Coninssjypapo = value ;
   }

   public byte getConinssjypcont( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Coninssjypcont ;
   }

   public void setConinssjypcont( byte value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Coninssjypcont = value ;
   }

   public byte getConobrasocapo( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conobrasocapo ;
   }

   public void setConobrasocapo( byte value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conobrasocapo = value ;
   }

   public byte getConobrasoccont( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conobrasoccont ;
   }

   public void setConobrasoccont( byte value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conobrasoccont = value ;
   }

   public byte getConfonsolredapo( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Confonsolredapo ;
   }

   public void setConfonsolredapo( byte value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Confonsolredapo = value ;
   }

   public byte getConfonsolredcont( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Confonsolredcont ;
   }

   public void setConfonsolredcont( byte value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Confonsolredcont = value ;
   }

   public byte getConrenateaapo( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conrenateaapo ;
   }

   public void setConrenateaapo( byte value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conrenateaapo = value ;
   }

   public byte getConrenateacont( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conrenateacont ;
   }

   public void setConrenateacont( byte value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conrenateacont = value ;
   }

   public byte getConasigfamcont( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conasigfamcont ;
   }

   public void setConasigfamcont( byte value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conasigfamcont = value ;
   }

   public byte getConfonnacempcont( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Confonnacempcont ;
   }

   public void setConfonnacempcont( byte value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Confonnacempcont = value ;
   }

   public byte getConleyrietrabcont( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conleyrietrabcont ;
   }

   public void setConleyrietrabcont( byte value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conleyrietrabcont = value ;
   }

   public byte getConregdifapo( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conregdifapo ;
   }

   public void setConregdifapo( byte value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conregdifapo = value ;
   }

   public byte getConregespapo( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conregespapo ;
   }

   public void setConregespapo( byte value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conregespapo = value ;
   }

   public byte getConsacdeven( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Consacdeven ;
   }

   public void setConsacdeven( byte value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Consacdeven = value ;
   }

   public byte getConbasefer( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbasefer ;
   }

   public void setConbasefer( byte value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbasefer = value ;
   }

   public byte getConbaseferprom( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaseferprom ;
   }

   public void setConbaseferprom( byte value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaseferprom = value ;
   }

   public byte getConbasehorext( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbasehorext ;
   }

   public void setConbasehorext( byte value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbasehorext = value ;
   }

   public byte getConbasehorextprom( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbasehorextprom ;
   }

   public void setConbasehorextprom( byte value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbasehorextprom = value ;
   }

   public byte getConbaselic( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaselic ;
   }

   public void setConbaselic( byte value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaselic = value ;
   }

   public byte getConbaselicprom( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaselicprom ;
   }

   public void setConbaselicprom( byte value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaselicprom = value ;
   }

   public byte getConbaseosdif( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaseosdif ;
   }

   public void setConbaseosdif( byte value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaseosdif = value ;
   }

   public byte getConbaseaus( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaseaus ;
   }

   public void setConbaseaus( byte value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaseaus = value ;
   }

   public byte getConbaseausprom( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaseausprom ;
   }

   public void setConbaseausprom( byte value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaseausprom = value ;
   }

   public String getConcodafip( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Concodafip ;
   }

   public void setConcodafip( String value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Concodafip = value ;
   }

   public short getConceptopais( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conceptopais ;
   }

   public void setConceptopais( short value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conceptopais = value ;
   }

   public String getConceptoconvecodigo( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conceptoconvecodigo ;
   }

   public void setConceptoconvecodigo( String value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conceptoconvecodigo = value ;
   }

   public byte getConbasepres( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbasepres ;
   }

   public void setConbasepres( byte value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbasepres = value ;
   }

   public byte getConbaseant( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaseant ;
   }

   public void setConbaseant( byte value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaseant = value ;
   }

   public boolean getConerrorsicero( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conerrorsicero ;
   }

   public void setConerrorsicero( boolean value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conerrorsicero = value ;
   }

   public int getClicod( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Clicod ;
   }

   public void setClicod( int value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Clicod = value ;
   }

   public boolean getConpuenov( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conpuenov ;
   }

   public void setConpuenov( boolean value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conpuenov = value ;
   }

   public int getConrelsec( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conrelsec ;
   }

   public void setConrelsec( int value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conrelsec = value ;
   }

   protected byte gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conaplicgan ;
   protected byte gxTv_Sdtsdt_concepto_sdt_conceptoItem_Contipo ;
   protected byte gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conadeldescu ;
   protected byte gxTv_Sdtsdt_concepto_sdt_conceptoItem_Connumero ;
   protected byte gxTv_Sdtsdt_concepto_sdt_conceptoItem_Consipaapo ;
   protected byte gxTv_Sdtsdt_concepto_sdt_conceptoItem_Consipacont ;
   protected byte gxTv_Sdtsdt_concepto_sdt_conceptoItem_Coninssjypapo ;
   protected byte gxTv_Sdtsdt_concepto_sdt_conceptoItem_Coninssjypcont ;
   protected byte gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conobrasocapo ;
   protected byte gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conobrasoccont ;
   protected byte gxTv_Sdtsdt_concepto_sdt_conceptoItem_Confonsolredapo ;
   protected byte gxTv_Sdtsdt_concepto_sdt_conceptoItem_Confonsolredcont ;
   protected byte gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conrenateaapo ;
   protected byte gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conrenateacont ;
   protected byte gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conasigfamcont ;
   protected byte gxTv_Sdtsdt_concepto_sdt_conceptoItem_Confonnacempcont ;
   protected byte gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conleyrietrabcont ;
   protected byte gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conregdifapo ;
   protected byte gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conregespapo ;
   protected byte gxTv_Sdtsdt_concepto_sdt_conceptoItem_Consacdeven ;
   protected byte gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbasefer ;
   protected byte gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaseferprom ;
   protected byte gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbasehorext ;
   protected byte gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbasehorextprom ;
   protected byte gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaselic ;
   protected byte gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaselicprom ;
   protected byte gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaseosdif ;
   protected byte gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaseaus ;
   protected byte gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaseausprom ;
   protected byte gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbasepres ;
   protected byte gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaseant ;
   protected byte gxTv_Sdtsdt_concepto_sdt_conceptoItem_Motivosegreso_N ;
   protected byte gxTv_Sdtsdt_concepto_sdt_conceptoItem_Tipoliquidacion_N ;
   protected byte gxTv_Sdtsdt_concepto_sdt_conceptoItem_Convenios_N ;
   protected byte gxTv_Sdtsdt_concepto_sdt_conceptoItem_N ;
   protected short gxTv_Sdtsdt_concepto_sdt_conceptoItem_Convigencia ;
   protected short gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conformulaamigable ;
   protected short gxTv_Sdtsdt_concepto_sdt_conceptoItem_Contipoorden ;
   protected short gxTv_Sdtsdt_concepto_sdt_conceptoItem_Apliigg ;
   protected short gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conceptopais ;
   protected int gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conorden ;
   protected int gxTv_Sdtsdt_concepto_sdt_conceptoItem_Clicod ;
   protected int gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conrelsec ;
   protected long gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conordejec ;
   protected String gxTv_Sdtsdt_concepto_sdt_conceptoItem_Concodigo ;
   protected String gxTv_Sdtsdt_concepto_sdt_conceptoItem_Contipoliqganancias ;
   protected String gxTv_Sdtsdt_concepto_sdt_conceptoItem_Tipoconcod ;
   protected String gxTv_Sdtsdt_concepto_sdt_conceptoItem_Subtipoconcod1 ;
   protected String gxTv_Sdtsdt_concepto_sdt_conceptoItem_Subtipoconcod2 ;
   protected String gxTv_Sdtsdt_concepto_sdt_conceptoItem_Concondicion ;
   protected String gxTv_Sdtsdt_concepto_sdt_conceptoItem_Concondcodigo ;
   protected String gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conprereq ;
   protected String gxTv_Sdtsdt_concepto_sdt_conceptoItem_Concodafip ;
   protected String gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conceptoconvecodigo ;
   protected boolean gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conedienrec ;
   protected boolean gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conusado ;
   protected boolean gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conretganpropor ;
   protected boolean gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conrecalcular ;
   protected boolean gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conhabilitado ;
   protected boolean gxTv_Sdtsdt_concepto_sdt_conceptoItem_Concanti ;
   protected boolean gxTv_Sdtsdt_concepto_sdt_conceptoItem_Convaluni ;
   protected boolean gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conimporte ;
   protected boolean gxTv_Sdtsdt_concepto_sdt_conceptoItem_Convariable ;
   protected boolean gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conforeditable ;
   protected boolean gxTv_Sdtsdt_concepto_sdt_conceptoItem_Consegunpla ;
   protected boolean gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conobliga ;
   protected boolean gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conobligasisac ;
   protected boolean gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conmostrarpos ;
   protected boolean gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conerrorsicero ;
   protected boolean gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conpuenov ;
   protected String gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conformula ;
   protected String gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conobservacion ;
   protected String gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conformulaobs2 ;
   protected String gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conformulaexpl ;
   protected String gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conrangocant ;
   protected String gxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip ;
   protected java.math.BigDecimal gxTv_Sdtsdt_concepto_sdt_conceptoItem_Convalorgen ;
   protected java.util.Vector<web.StructSdtsdt_concepto_sdt_conceptoItem_MotEgrItem> gxTv_Sdtsdt_concepto_sdt_conceptoItem_Motivosegreso=null ;
   protected java.util.Vector<web.StructSdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem> gxTv_Sdtsdt_concepto_sdt_conceptoItem_Tipoliquidacion=null ;
   protected java.util.Vector<web.StructSdtsdt_concepto_sdt_conceptoItem_ConveniosItem> gxTv_Sdtsdt_concepto_sdt_conceptoItem_Convenios=null ;
}

