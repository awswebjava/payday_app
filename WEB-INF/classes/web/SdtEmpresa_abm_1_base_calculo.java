package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtEmpresa_abm_1_base_calculo extends GxSilentTrnSdt
{
   public SdtEmpresa_abm_1_base_calculo( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(SdtEmpresa_abm_1_base_calculo.class));
   }

   public SdtEmpresa_abm_1_base_calculo( int remoteHandle ,
                                         ModelContext context )
   {
      super( remoteHandle, context, "SdtEmpresa_abm_1_base_calculo");
      initialize( remoteHandle) ;
   }

   public SdtEmpresa_abm_1_base_calculo( int remoteHandle ,
                                         StructSdtEmpresa_abm_1_base_calculo struct )
   {
      this(remoteHandle);
      setStruct(struct);
   }

   public SdtEmpresa_abm_1_base_calculo( )
   {
      super( new ModelContext(SdtEmpresa_abm_1_base_calculo.class), "SdtEmpresa_abm_1_base_calculo");
      initialize( ) ;
   }

   private static java.util.HashMap mapper = new java.util.HashMap();
   static
   {
   }

   public String getJsonMap( String value )
   {
      return (String) mapper.get(value);
   }

   public Object[][] GetBCKey( )
   {
      return (Object[][])(new Object[][]{new Object[]{"EmpBaseClaseLeg", byte.class}, new Object[]{"EmpBaseTipo", String.class}, new Object[]{"EmpBaseCod1", String.class}, new Object[]{"EmpBaseCod2", String.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "base_calculo");
      metadata.set("BT", "Empresabase_calculo");
      metadata.set("PK", "[ \"EmpBaseClaseLeg\",\"EmpBaseTipo\",\"EmpBaseCod1\",\"EmpBaseCod2\" ]");
      metadata.set("FKList", "[ { \"FK\":[ \"CliCod\" ],\"FKMap\":[  ] },{ \"FK\":[ \"CliCod\",\"EmpCod\" ],\"FKMap\":[  ] } ]");
      metadata.set("AllowInsert", "True");
      metadata.set("AllowUpdate", "True");
      metadata.set("AllowDelete", "True");
      return metadata ;
   }

   public short readxml( com.genexus.xml.XMLReader oReader ,
                         String sName )
   {
      short GXSoapError = 1;
      formatError = false ;
      sTagName = oReader.getName() ;
      if ( oReader.getIsSimple() == 0 )
      {
         GXSoapError = oReader.read() ;
         nOutParmCount = (short)(0) ;
         while ( ( ( GXutil.strcmp(oReader.getName(), sTagName) != 0 ) || ( oReader.getNodeType() == 1 ) ) && ( GXSoapError > 0 ) )
         {
            readOk = (short)(0) ;
            readElement = false ;
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpBaseClaseLeg") )
            {
               gxTv_SdtEmpresa_abm_1_base_calculo_Empbaseclaseleg = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpBaseTipo") )
            {
               gxTv_SdtEmpresa_abm_1_base_calculo_Empbasetipo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpBaseCod1") )
            {
               gxTv_SdtEmpresa_abm_1_base_calculo_Empbasecod1 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpBaseCod2") )
            {
               gxTv_SdtEmpresa_abm_1_base_calculo_Empbasecod2 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpBasePlus") )
            {
               gxTv_SdtEmpresa_abm_1_base_calculo_Empbaseplus = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_SdtEmpresa_abm_1_base_calculo_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Modified") )
            {
               gxTv_SdtEmpresa_abm_1_base_calculo_Modified = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_SdtEmpresa_abm_1_base_calculo_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpBaseClaseLeg_Z") )
            {
               gxTv_SdtEmpresa_abm_1_base_calculo_Empbaseclaseleg_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpBaseTipo_Z") )
            {
               gxTv_SdtEmpresa_abm_1_base_calculo_Empbasetipo_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpBaseCod1_Z") )
            {
               gxTv_SdtEmpresa_abm_1_base_calculo_Empbasecod1_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpBaseCod2_Z") )
            {
               gxTv_SdtEmpresa_abm_1_base_calculo_Empbasecod2_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpBasePlus_Z") )
            {
               gxTv_SdtEmpresa_abm_1_base_calculo_Empbaseplus_Z = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( ! readElement )
            {
               readOk = (short)(1) ;
               GXSoapError = oReader.read() ;
            }
            nOutParmCount = (short)(nOutParmCount+1) ;
            if ( ( readOk == 0 ) || formatError )
            {
               context.globals.sSOAPErrMsg += "Error reading " + sTagName + GXutil.newLine( ) ;
               context.globals.sSOAPErrMsg += "Message: " + oReader.readRawXML() ;
               GXSoapError = (short)(nOutParmCount*-1) ;
            }
         }
      }
      return GXSoapError ;
   }

   public void writexml( com.genexus.xml.XMLWriter oWriter ,
                         String sName ,
                         String sNameSpace )
   {
      writexml(oWriter, sName, sNameSpace, true);
   }

   public void writexml( com.genexus.xml.XMLWriter oWriter ,
                         String sName ,
                         String sNameSpace ,
                         boolean sIncludeState )
   {
      if ( (GXutil.strcmp("", sName)==0) )
      {
         sName = "Empresa_abm_1.base_calculo" ;
      }
      oWriter.writeStartElement(sName);
      if ( GXutil.strcmp(GXutil.left( sNameSpace, 10), "[*:nosend]") != 0 )
      {
         oWriter.writeAttribute("xmlns", sNameSpace);
      }
      else
      {
         sNameSpace = GXutil.right( sNameSpace, GXutil.len( sNameSpace)-10) ;
      }
      oWriter.writeElement("EmpBaseClaseLeg", GXutil.trim( GXutil.str( gxTv_SdtEmpresa_abm_1_base_calculo_Empbaseclaseleg, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpBaseTipo", gxTv_SdtEmpresa_abm_1_base_calculo_Empbasetipo);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpBaseCod1", gxTv_SdtEmpresa_abm_1_base_calculo_Empbasecod1);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpBaseCod2", gxTv_SdtEmpresa_abm_1_base_calculo_Empbasecod2);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpBasePlus", GXutil.trim( GXutil.strNoRound( gxTv_SdtEmpresa_abm_1_base_calculo_Empbaseplus, 6, 4)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", gxTv_SdtEmpresa_abm_1_base_calculo_Mode);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("Modified", GXutil.trim( GXutil.str( gxTv_SdtEmpresa_abm_1_base_calculo_Modified, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_SdtEmpresa_abm_1_base_calculo_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpBaseClaseLeg_Z", GXutil.trim( GXutil.str( gxTv_SdtEmpresa_abm_1_base_calculo_Empbaseclaseleg_Z, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpBaseTipo_Z", gxTv_SdtEmpresa_abm_1_base_calculo_Empbasetipo_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpBaseCod1_Z", gxTv_SdtEmpresa_abm_1_base_calculo_Empbasecod1_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpBaseCod2_Z", gxTv_SdtEmpresa_abm_1_base_calculo_Empbasecod2_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpBasePlus_Z", GXutil.trim( GXutil.strNoRound( gxTv_SdtEmpresa_abm_1_base_calculo_Empbaseplus_Z, 6, 4)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
      }
      oWriter.writeEndElement();
   }

   public long getnumericvalue( String value )
   {
      if ( GXutil.notNumeric( value) )
      {
         formatError = true ;
      }
      return GXutil.lval( value) ;
   }

   public void tojson( )
   {
      tojson( true) ;
   }

   public void tojson( boolean includeState )
   {
      tojson( includeState, true) ;
   }

   public void tojson( boolean includeState ,
                       boolean includeNonInitialized )
   {
      AddObjectProperty("EmpBaseClaseLeg", gxTv_SdtEmpresa_abm_1_base_calculo_Empbaseclaseleg, false, includeNonInitialized);
      AddObjectProperty("EmpBaseTipo", gxTv_SdtEmpresa_abm_1_base_calculo_Empbasetipo, false, includeNonInitialized);
      AddObjectProperty("EmpBaseCod1", gxTv_SdtEmpresa_abm_1_base_calculo_Empbasecod1, false, includeNonInitialized);
      AddObjectProperty("EmpBaseCod2", gxTv_SdtEmpresa_abm_1_base_calculo_Empbasecod2, false, includeNonInitialized);
      AddObjectProperty("EmpBasePlus", gxTv_SdtEmpresa_abm_1_base_calculo_Empbaseplus, false, includeNonInitialized);
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_SdtEmpresa_abm_1_base_calculo_Mode, false, includeNonInitialized);
         AddObjectProperty("Modified", gxTv_SdtEmpresa_abm_1_base_calculo_Modified, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_SdtEmpresa_abm_1_base_calculo_Initialized, false, includeNonInitialized);
         AddObjectProperty("EmpBaseClaseLeg_Z", gxTv_SdtEmpresa_abm_1_base_calculo_Empbaseclaseleg_Z, false, includeNonInitialized);
         AddObjectProperty("EmpBaseTipo_Z", gxTv_SdtEmpresa_abm_1_base_calculo_Empbasetipo_Z, false, includeNonInitialized);
         AddObjectProperty("EmpBaseCod1_Z", gxTv_SdtEmpresa_abm_1_base_calculo_Empbasecod1_Z, false, includeNonInitialized);
         AddObjectProperty("EmpBaseCod2_Z", gxTv_SdtEmpresa_abm_1_base_calculo_Empbasecod2_Z, false, includeNonInitialized);
         AddObjectProperty("EmpBasePlus_Z", gxTv_SdtEmpresa_abm_1_base_calculo_Empbaseplus_Z, false, includeNonInitialized);
      }
   }

   public void updateDirties( web.SdtEmpresa_abm_1_base_calculo sdt )
   {
      if ( sdt.IsDirty("EmpBaseClaseLeg") )
      {
         gxTv_SdtEmpresa_abm_1_base_calculo_N = (byte)(0) ;
         gxTv_SdtEmpresa_abm_1_base_calculo_Empbaseclaseleg = sdt.getgxTv_SdtEmpresa_abm_1_base_calculo_Empbaseclaseleg() ;
      }
      if ( sdt.IsDirty("EmpBaseTipo") )
      {
         gxTv_SdtEmpresa_abm_1_base_calculo_N = (byte)(0) ;
         gxTv_SdtEmpresa_abm_1_base_calculo_Empbasetipo = sdt.getgxTv_SdtEmpresa_abm_1_base_calculo_Empbasetipo() ;
      }
      if ( sdt.IsDirty("EmpBaseCod1") )
      {
         gxTv_SdtEmpresa_abm_1_base_calculo_N = (byte)(0) ;
         gxTv_SdtEmpresa_abm_1_base_calculo_Empbasecod1 = sdt.getgxTv_SdtEmpresa_abm_1_base_calculo_Empbasecod1() ;
      }
      if ( sdt.IsDirty("EmpBaseCod2") )
      {
         gxTv_SdtEmpresa_abm_1_base_calculo_N = (byte)(0) ;
         gxTv_SdtEmpresa_abm_1_base_calculo_Empbasecod2 = sdt.getgxTv_SdtEmpresa_abm_1_base_calculo_Empbasecod2() ;
      }
      if ( sdt.IsDirty("EmpBasePlus") )
      {
         gxTv_SdtEmpresa_abm_1_base_calculo_N = (byte)(0) ;
         gxTv_SdtEmpresa_abm_1_base_calculo_Empbaseplus = sdt.getgxTv_SdtEmpresa_abm_1_base_calculo_Empbaseplus() ;
      }
   }

   public byte getgxTv_SdtEmpresa_abm_1_base_calculo_Empbaseclaseleg( )
   {
      return gxTv_SdtEmpresa_abm_1_base_calculo_Empbaseclaseleg ;
   }

   public void setgxTv_SdtEmpresa_abm_1_base_calculo_Empbaseclaseleg( byte value )
   {
      gxTv_SdtEmpresa_abm_1_base_calculo_N = (byte)(0) ;
      gxTv_SdtEmpresa_abm_1_base_calculo_Modified = (short)(1) ;
      SetDirty("Empbaseclaseleg");
      gxTv_SdtEmpresa_abm_1_base_calculo_Empbaseclaseleg = value ;
   }

   public String getgxTv_SdtEmpresa_abm_1_base_calculo_Empbasetipo( )
   {
      return gxTv_SdtEmpresa_abm_1_base_calculo_Empbasetipo ;
   }

   public void setgxTv_SdtEmpresa_abm_1_base_calculo_Empbasetipo( String value )
   {
      gxTv_SdtEmpresa_abm_1_base_calculo_N = (byte)(0) ;
      gxTv_SdtEmpresa_abm_1_base_calculo_Modified = (short)(1) ;
      SetDirty("Empbasetipo");
      gxTv_SdtEmpresa_abm_1_base_calculo_Empbasetipo = value ;
   }

   public String getgxTv_SdtEmpresa_abm_1_base_calculo_Empbasecod1( )
   {
      return gxTv_SdtEmpresa_abm_1_base_calculo_Empbasecod1 ;
   }

   public void setgxTv_SdtEmpresa_abm_1_base_calculo_Empbasecod1( String value )
   {
      gxTv_SdtEmpresa_abm_1_base_calculo_N = (byte)(0) ;
      gxTv_SdtEmpresa_abm_1_base_calculo_Modified = (short)(1) ;
      SetDirty("Empbasecod1");
      gxTv_SdtEmpresa_abm_1_base_calculo_Empbasecod1 = value ;
   }

   public String getgxTv_SdtEmpresa_abm_1_base_calculo_Empbasecod2( )
   {
      return gxTv_SdtEmpresa_abm_1_base_calculo_Empbasecod2 ;
   }

   public void setgxTv_SdtEmpresa_abm_1_base_calculo_Empbasecod2( String value )
   {
      gxTv_SdtEmpresa_abm_1_base_calculo_N = (byte)(0) ;
      gxTv_SdtEmpresa_abm_1_base_calculo_Modified = (short)(1) ;
      SetDirty("Empbasecod2");
      gxTv_SdtEmpresa_abm_1_base_calculo_Empbasecod2 = value ;
   }

   public java.math.BigDecimal getgxTv_SdtEmpresa_abm_1_base_calculo_Empbaseplus( )
   {
      return gxTv_SdtEmpresa_abm_1_base_calculo_Empbaseplus ;
   }

   public void setgxTv_SdtEmpresa_abm_1_base_calculo_Empbaseplus( java.math.BigDecimal value )
   {
      gxTv_SdtEmpresa_abm_1_base_calculo_N = (byte)(0) ;
      gxTv_SdtEmpresa_abm_1_base_calculo_Modified = (short)(1) ;
      SetDirty("Empbaseplus");
      gxTv_SdtEmpresa_abm_1_base_calculo_Empbaseplus = value ;
   }

   public String getgxTv_SdtEmpresa_abm_1_base_calculo_Mode( )
   {
      return gxTv_SdtEmpresa_abm_1_base_calculo_Mode ;
   }

   public void setgxTv_SdtEmpresa_abm_1_base_calculo_Mode( String value )
   {
      gxTv_SdtEmpresa_abm_1_base_calculo_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_SdtEmpresa_abm_1_base_calculo_Mode = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_base_calculo_Mode_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_base_calculo_Mode = "" ;
      SetDirty("Mode");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_base_calculo_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtEmpresa_abm_1_base_calculo_Modified( )
   {
      return gxTv_SdtEmpresa_abm_1_base_calculo_Modified ;
   }

   public void setgxTv_SdtEmpresa_abm_1_base_calculo_Modified( short value )
   {
      gxTv_SdtEmpresa_abm_1_base_calculo_N = (byte)(0) ;
      SetDirty("Modified");
      gxTv_SdtEmpresa_abm_1_base_calculo_Modified = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_base_calculo_Modified_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_base_calculo_Modified = (short)(0) ;
      SetDirty("Modified");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_base_calculo_Modified_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtEmpresa_abm_1_base_calculo_Initialized( )
   {
      return gxTv_SdtEmpresa_abm_1_base_calculo_Initialized ;
   }

   public void setgxTv_SdtEmpresa_abm_1_base_calculo_Initialized( short value )
   {
      gxTv_SdtEmpresa_abm_1_base_calculo_N = (byte)(0) ;
      gxTv_SdtEmpresa_abm_1_base_calculo_Modified = (short)(1) ;
      SetDirty("Initialized");
      gxTv_SdtEmpresa_abm_1_base_calculo_Initialized = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_base_calculo_Initialized_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_base_calculo_Initialized = (short)(0) ;
      SetDirty("Initialized");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_base_calculo_Initialized_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtEmpresa_abm_1_base_calculo_Empbaseclaseleg_Z( )
   {
      return gxTv_SdtEmpresa_abm_1_base_calculo_Empbaseclaseleg_Z ;
   }

   public void setgxTv_SdtEmpresa_abm_1_base_calculo_Empbaseclaseleg_Z( byte value )
   {
      gxTv_SdtEmpresa_abm_1_base_calculo_N = (byte)(0) ;
      gxTv_SdtEmpresa_abm_1_base_calculo_Modified = (short)(1) ;
      SetDirty("Empbaseclaseleg_Z");
      gxTv_SdtEmpresa_abm_1_base_calculo_Empbaseclaseleg_Z = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_base_calculo_Empbaseclaseleg_Z_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_base_calculo_Empbaseclaseleg_Z = (byte)(0) ;
      SetDirty("Empbaseclaseleg_Z");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_base_calculo_Empbaseclaseleg_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtEmpresa_abm_1_base_calculo_Empbasetipo_Z( )
   {
      return gxTv_SdtEmpresa_abm_1_base_calculo_Empbasetipo_Z ;
   }

   public void setgxTv_SdtEmpresa_abm_1_base_calculo_Empbasetipo_Z( String value )
   {
      gxTv_SdtEmpresa_abm_1_base_calculo_N = (byte)(0) ;
      gxTv_SdtEmpresa_abm_1_base_calculo_Modified = (short)(1) ;
      SetDirty("Empbasetipo_Z");
      gxTv_SdtEmpresa_abm_1_base_calculo_Empbasetipo_Z = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_base_calculo_Empbasetipo_Z_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_base_calculo_Empbasetipo_Z = "" ;
      SetDirty("Empbasetipo_Z");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_base_calculo_Empbasetipo_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtEmpresa_abm_1_base_calculo_Empbasecod1_Z( )
   {
      return gxTv_SdtEmpresa_abm_1_base_calculo_Empbasecod1_Z ;
   }

   public void setgxTv_SdtEmpresa_abm_1_base_calculo_Empbasecod1_Z( String value )
   {
      gxTv_SdtEmpresa_abm_1_base_calculo_N = (byte)(0) ;
      gxTv_SdtEmpresa_abm_1_base_calculo_Modified = (short)(1) ;
      SetDirty("Empbasecod1_Z");
      gxTv_SdtEmpresa_abm_1_base_calculo_Empbasecod1_Z = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_base_calculo_Empbasecod1_Z_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_base_calculo_Empbasecod1_Z = "" ;
      SetDirty("Empbasecod1_Z");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_base_calculo_Empbasecod1_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtEmpresa_abm_1_base_calculo_Empbasecod2_Z( )
   {
      return gxTv_SdtEmpresa_abm_1_base_calculo_Empbasecod2_Z ;
   }

   public void setgxTv_SdtEmpresa_abm_1_base_calculo_Empbasecod2_Z( String value )
   {
      gxTv_SdtEmpresa_abm_1_base_calculo_N = (byte)(0) ;
      gxTv_SdtEmpresa_abm_1_base_calculo_Modified = (short)(1) ;
      SetDirty("Empbasecod2_Z");
      gxTv_SdtEmpresa_abm_1_base_calculo_Empbasecod2_Z = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_base_calculo_Empbasecod2_Z_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_base_calculo_Empbasecod2_Z = "" ;
      SetDirty("Empbasecod2_Z");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_base_calculo_Empbasecod2_Z_IsNull( )
   {
      return false ;
   }

   public java.math.BigDecimal getgxTv_SdtEmpresa_abm_1_base_calculo_Empbaseplus_Z( )
   {
      return gxTv_SdtEmpresa_abm_1_base_calculo_Empbaseplus_Z ;
   }

   public void setgxTv_SdtEmpresa_abm_1_base_calculo_Empbaseplus_Z( java.math.BigDecimal value )
   {
      gxTv_SdtEmpresa_abm_1_base_calculo_N = (byte)(0) ;
      gxTv_SdtEmpresa_abm_1_base_calculo_Modified = (short)(1) ;
      SetDirty("Empbaseplus_Z");
      gxTv_SdtEmpresa_abm_1_base_calculo_Empbaseplus_Z = value ;
   }

   public void setgxTv_SdtEmpresa_abm_1_base_calculo_Empbaseplus_Z_SetNull( )
   {
      gxTv_SdtEmpresa_abm_1_base_calculo_Empbaseplus_Z = DecimalUtil.ZERO ;
      SetDirty("Empbaseplus_Z");
   }

   public boolean getgxTv_SdtEmpresa_abm_1_base_calculo_Empbaseplus_Z_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtEmpresa_abm_1_base_calculo_N = (byte)(1) ;
      gxTv_SdtEmpresa_abm_1_base_calculo_Empbasetipo = "" ;
      gxTv_SdtEmpresa_abm_1_base_calculo_Empbasecod1 = "" ;
      gxTv_SdtEmpresa_abm_1_base_calculo_Empbasecod2 = "" ;
      gxTv_SdtEmpresa_abm_1_base_calculo_Empbaseplus = DecimalUtil.ZERO ;
      gxTv_SdtEmpresa_abm_1_base_calculo_Mode = "" ;
      gxTv_SdtEmpresa_abm_1_base_calculo_Empbasetipo_Z = "" ;
      gxTv_SdtEmpresa_abm_1_base_calculo_Empbasecod1_Z = "" ;
      gxTv_SdtEmpresa_abm_1_base_calculo_Empbasecod2_Z = "" ;
      gxTv_SdtEmpresa_abm_1_base_calculo_Empbaseplus_Z = DecimalUtil.ZERO ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtEmpresa_abm_1_base_calculo_N ;
   }

   public web.SdtEmpresa_abm_1_base_calculo Clone( )
   {
      return (web.SdtEmpresa_abm_1_base_calculo)(clone()) ;
   }

   public void setStruct( web.StructSdtEmpresa_abm_1_base_calculo struct )
   {
      setgxTv_SdtEmpresa_abm_1_base_calculo_Empbaseclaseleg(struct.getEmpbaseclaseleg());
      setgxTv_SdtEmpresa_abm_1_base_calculo_Empbasetipo(struct.getEmpbasetipo());
      setgxTv_SdtEmpresa_abm_1_base_calculo_Empbasecod1(struct.getEmpbasecod1());
      setgxTv_SdtEmpresa_abm_1_base_calculo_Empbasecod2(struct.getEmpbasecod2());
      setgxTv_SdtEmpresa_abm_1_base_calculo_Empbaseplus(struct.getEmpbaseplus());
      setgxTv_SdtEmpresa_abm_1_base_calculo_Mode(struct.getMode());
      setgxTv_SdtEmpresa_abm_1_base_calculo_Modified(struct.getModified());
      setgxTv_SdtEmpresa_abm_1_base_calculo_Initialized(struct.getInitialized());
      setgxTv_SdtEmpresa_abm_1_base_calculo_Empbaseclaseleg_Z(struct.getEmpbaseclaseleg_Z());
      setgxTv_SdtEmpresa_abm_1_base_calculo_Empbasetipo_Z(struct.getEmpbasetipo_Z());
      setgxTv_SdtEmpresa_abm_1_base_calculo_Empbasecod1_Z(struct.getEmpbasecod1_Z());
      setgxTv_SdtEmpresa_abm_1_base_calculo_Empbasecod2_Z(struct.getEmpbasecod2_Z());
      setgxTv_SdtEmpresa_abm_1_base_calculo_Empbaseplus_Z(struct.getEmpbaseplus_Z());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtEmpresa_abm_1_base_calculo getStruct( )
   {
      web.StructSdtEmpresa_abm_1_base_calculo struct = new web.StructSdtEmpresa_abm_1_base_calculo ();
      struct.setEmpbaseclaseleg(getgxTv_SdtEmpresa_abm_1_base_calculo_Empbaseclaseleg());
      struct.setEmpbasetipo(getgxTv_SdtEmpresa_abm_1_base_calculo_Empbasetipo());
      struct.setEmpbasecod1(getgxTv_SdtEmpresa_abm_1_base_calculo_Empbasecod1());
      struct.setEmpbasecod2(getgxTv_SdtEmpresa_abm_1_base_calculo_Empbasecod2());
      struct.setEmpbaseplus(getgxTv_SdtEmpresa_abm_1_base_calculo_Empbaseplus());
      struct.setMode(getgxTv_SdtEmpresa_abm_1_base_calculo_Mode());
      struct.setModified(getgxTv_SdtEmpresa_abm_1_base_calculo_Modified());
      struct.setInitialized(getgxTv_SdtEmpresa_abm_1_base_calculo_Initialized());
      struct.setEmpbaseclaseleg_Z(getgxTv_SdtEmpresa_abm_1_base_calculo_Empbaseclaseleg_Z());
      struct.setEmpbasetipo_Z(getgxTv_SdtEmpresa_abm_1_base_calculo_Empbasetipo_Z());
      struct.setEmpbasecod1_Z(getgxTv_SdtEmpresa_abm_1_base_calculo_Empbasecod1_Z());
      struct.setEmpbasecod2_Z(getgxTv_SdtEmpresa_abm_1_base_calculo_Empbasecod2_Z());
      struct.setEmpbaseplus_Z(getgxTv_SdtEmpresa_abm_1_base_calculo_Empbaseplus_Z());
      return struct ;
   }

   private byte gxTv_SdtEmpresa_abm_1_base_calculo_Empbaseclaseleg ;
   private byte gxTv_SdtEmpresa_abm_1_base_calculo_N ;
   private byte gxTv_SdtEmpresa_abm_1_base_calculo_Empbaseclaseleg_Z ;
   private short gxTv_SdtEmpresa_abm_1_base_calculo_Modified ;
   private short gxTv_SdtEmpresa_abm_1_base_calculo_Initialized ;
   private short readOk ;
   private short nOutParmCount ;
   private java.math.BigDecimal gxTv_SdtEmpresa_abm_1_base_calculo_Empbaseplus ;
   private java.math.BigDecimal gxTv_SdtEmpresa_abm_1_base_calculo_Empbaseplus_Z ;
   private String gxTv_SdtEmpresa_abm_1_base_calculo_Empbasetipo ;
   private String gxTv_SdtEmpresa_abm_1_base_calculo_Empbasecod1 ;
   private String gxTv_SdtEmpresa_abm_1_base_calculo_Empbasecod2 ;
   private String gxTv_SdtEmpresa_abm_1_base_calculo_Mode ;
   private String gxTv_SdtEmpresa_abm_1_base_calculo_Empbasetipo_Z ;
   private String gxTv_SdtEmpresa_abm_1_base_calculo_Empbasecod1_Z ;
   private String gxTv_SdtEmpresa_abm_1_base_calculo_Empbasecod2_Z ;
   private String sTagName ;
   private boolean readElement ;
   private boolean formatError ;
}

