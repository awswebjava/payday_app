package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtConcepto_MotivosEgreso extends GxSilentTrnSdt
{
   public SdtConcepto_MotivosEgreso( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(SdtConcepto_MotivosEgreso.class));
   }

   public SdtConcepto_MotivosEgreso( int remoteHandle ,
                                     ModelContext context )
   {
      super( remoteHandle, context, "SdtConcepto_MotivosEgreso");
      initialize( remoteHandle) ;
   }

   public SdtConcepto_MotivosEgreso( int remoteHandle ,
                                     StructSdtConcepto_MotivosEgreso struct )
   {
      this(remoteHandle);
      setStruct(struct);
   }

   public SdtConcepto_MotivosEgreso( )
   {
      super( new ModelContext(SdtConcepto_MotivosEgreso.class), "SdtConcepto_MotivosEgreso");
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
      return (Object[][])(new Object[][]{new Object[]{"MegCodigo", String.class}, new Object[]{"ConMegSec", short.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "MotivosEgreso");
      metadata.set("BT", "ConceptoMotivosEgreso");
      metadata.set("PK", "[ \"MegCodigo\",\"ConMegSec\" ]");
      metadata.set("FKList", "[ { \"FK\":[ \"CliCod\",\"ConCodigo\" ],\"FKMap\":[  ] },{ \"FK\":[ \"CliCod\",\"MegCodigo\" ],\"FKMap\":[  ] } ]");
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "MegCodigo") )
            {
               gxTv_SdtConcepto_MotivosEgreso_Megcodigo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConMegSec") )
            {
               gxTv_SdtConcepto_MotivosEgreso_Conmegsec = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MegPreaTipo") )
            {
               gxTv_SdtConcepto_MotivosEgreso_Megpreatipo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConMegMeses") )
            {
               gxTv_SdtConcepto_MotivosEgreso_Conmegmeses = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConMegDura") )
            {
               gxTv_SdtConcepto_MotivosEgreso_Conmegdura = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConMegPropor") )
            {
               gxTv_SdtConcepto_MotivosEgreso_Conmegpropor = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_SdtConcepto_MotivosEgreso_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Modified") )
            {
               gxTv_SdtConcepto_MotivosEgreso_Modified = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_SdtConcepto_MotivosEgreso_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MegCodigo_Z") )
            {
               gxTv_SdtConcepto_MotivosEgreso_Megcodigo_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConMegSec_Z") )
            {
               gxTv_SdtConcepto_MotivosEgreso_Conmegsec_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MegPreaTipo_Z") )
            {
               gxTv_SdtConcepto_MotivosEgreso_Megpreatipo_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConMegMeses_Z") )
            {
               gxTv_SdtConcepto_MotivosEgreso_Conmegmeses_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConMegDura_Z") )
            {
               gxTv_SdtConcepto_MotivosEgreso_Conmegdura_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConMegPropor_Z") )
            {
               gxTv_SdtConcepto_MotivosEgreso_Conmegpropor_Z = DecimalUtil.stringToDec( oReader.getValue()) ;
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
         sName = "Concepto.MotivosEgreso" ;
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
      oWriter.writeElement("MegCodigo", gxTv_SdtConcepto_MotivosEgreso_Megcodigo);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConMegSec", GXutil.trim( GXutil.str( gxTv_SdtConcepto_MotivosEgreso_Conmegsec, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MegPreaTipo", gxTv_SdtConcepto_MotivosEgreso_Megpreatipo);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConMegMeses", GXutil.trim( GXutil.str( gxTv_SdtConcepto_MotivosEgreso_Conmegmeses, 2, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConMegDura", gxTv_SdtConcepto_MotivosEgreso_Conmegdura);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConMegPropor", GXutil.trim( GXutil.strNoRound( gxTv_SdtConcepto_MotivosEgreso_Conmegpropor, 6, 4)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", gxTv_SdtConcepto_MotivosEgreso_Mode);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("Modified", GXutil.trim( GXutil.str( gxTv_SdtConcepto_MotivosEgreso_Modified, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_SdtConcepto_MotivosEgreso_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("MegCodigo_Z", gxTv_SdtConcepto_MotivosEgreso_Megcodigo_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConMegSec_Z", GXutil.trim( GXutil.str( gxTv_SdtConcepto_MotivosEgreso_Conmegsec_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("MegPreaTipo_Z", gxTv_SdtConcepto_MotivosEgreso_Megpreatipo_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConMegMeses_Z", GXutil.trim( GXutil.str( gxTv_SdtConcepto_MotivosEgreso_Conmegmeses_Z, 2, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConMegDura_Z", gxTv_SdtConcepto_MotivosEgreso_Conmegdura_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConMegPropor_Z", GXutil.trim( GXutil.strNoRound( gxTv_SdtConcepto_MotivosEgreso_Conmegpropor_Z, 6, 4)));
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
      AddObjectProperty("MegCodigo", gxTv_SdtConcepto_MotivosEgreso_Megcodigo, false, includeNonInitialized);
      AddObjectProperty("ConMegSec", gxTv_SdtConcepto_MotivosEgreso_Conmegsec, false, includeNonInitialized);
      AddObjectProperty("MegPreaTipo", gxTv_SdtConcepto_MotivosEgreso_Megpreatipo, false, includeNonInitialized);
      AddObjectProperty("ConMegMeses", gxTv_SdtConcepto_MotivosEgreso_Conmegmeses, false, includeNonInitialized);
      AddObjectProperty("ConMegDura", gxTv_SdtConcepto_MotivosEgreso_Conmegdura, false, includeNonInitialized);
      AddObjectProperty("ConMegPropor", gxTv_SdtConcepto_MotivosEgreso_Conmegpropor, false, includeNonInitialized);
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_SdtConcepto_MotivosEgreso_Mode, false, includeNonInitialized);
         AddObjectProperty("Modified", gxTv_SdtConcepto_MotivosEgreso_Modified, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_SdtConcepto_MotivosEgreso_Initialized, false, includeNonInitialized);
         AddObjectProperty("MegCodigo_Z", gxTv_SdtConcepto_MotivosEgreso_Megcodigo_Z, false, includeNonInitialized);
         AddObjectProperty("ConMegSec_Z", gxTv_SdtConcepto_MotivosEgreso_Conmegsec_Z, false, includeNonInitialized);
         AddObjectProperty("MegPreaTipo_Z", gxTv_SdtConcepto_MotivosEgreso_Megpreatipo_Z, false, includeNonInitialized);
         AddObjectProperty("ConMegMeses_Z", gxTv_SdtConcepto_MotivosEgreso_Conmegmeses_Z, false, includeNonInitialized);
         AddObjectProperty("ConMegDura_Z", gxTv_SdtConcepto_MotivosEgreso_Conmegdura_Z, false, includeNonInitialized);
         AddObjectProperty("ConMegPropor_Z", gxTv_SdtConcepto_MotivosEgreso_Conmegpropor_Z, false, includeNonInitialized);
      }
   }

   public void updateDirties( web.SdtConcepto_MotivosEgreso sdt )
   {
      if ( sdt.IsDirty("MegCodigo") )
      {
         gxTv_SdtConcepto_MotivosEgreso_N = (byte)(0) ;
         gxTv_SdtConcepto_MotivosEgreso_Megcodigo = sdt.getgxTv_SdtConcepto_MotivosEgreso_Megcodigo() ;
      }
      if ( sdt.IsDirty("ConMegSec") )
      {
         gxTv_SdtConcepto_MotivosEgreso_N = (byte)(0) ;
         gxTv_SdtConcepto_MotivosEgreso_Conmegsec = sdt.getgxTv_SdtConcepto_MotivosEgreso_Conmegsec() ;
      }
      if ( sdt.IsDirty("MegPreaTipo") )
      {
         gxTv_SdtConcepto_MotivosEgreso_N = (byte)(0) ;
         gxTv_SdtConcepto_MotivosEgreso_Megpreatipo = sdt.getgxTv_SdtConcepto_MotivosEgreso_Megpreatipo() ;
      }
      if ( sdt.IsDirty("ConMegMeses") )
      {
         gxTv_SdtConcepto_MotivosEgreso_N = (byte)(0) ;
         gxTv_SdtConcepto_MotivosEgreso_Conmegmeses = sdt.getgxTv_SdtConcepto_MotivosEgreso_Conmegmeses() ;
      }
      if ( sdt.IsDirty("ConMegDura") )
      {
         gxTv_SdtConcepto_MotivosEgreso_N = (byte)(0) ;
         gxTv_SdtConcepto_MotivosEgreso_Conmegdura = sdt.getgxTv_SdtConcepto_MotivosEgreso_Conmegdura() ;
      }
      if ( sdt.IsDirty("ConMegPropor") )
      {
         gxTv_SdtConcepto_MotivosEgreso_N = (byte)(0) ;
         gxTv_SdtConcepto_MotivosEgreso_Conmegpropor = sdt.getgxTv_SdtConcepto_MotivosEgreso_Conmegpropor() ;
      }
   }

   public String getgxTv_SdtConcepto_MotivosEgreso_Megcodigo( )
   {
      return gxTv_SdtConcepto_MotivosEgreso_Megcodigo ;
   }

   public void setgxTv_SdtConcepto_MotivosEgreso_Megcodigo( String value )
   {
      gxTv_SdtConcepto_MotivosEgreso_N = (byte)(0) ;
      gxTv_SdtConcepto_MotivosEgreso_Modified = (short)(1) ;
      SetDirty("Megcodigo");
      gxTv_SdtConcepto_MotivosEgreso_Megcodigo = value ;
   }

   public short getgxTv_SdtConcepto_MotivosEgreso_Conmegsec( )
   {
      return gxTv_SdtConcepto_MotivosEgreso_Conmegsec ;
   }

   public void setgxTv_SdtConcepto_MotivosEgreso_Conmegsec( short value )
   {
      gxTv_SdtConcepto_MotivosEgreso_N = (byte)(0) ;
      gxTv_SdtConcepto_MotivosEgreso_Modified = (short)(1) ;
      SetDirty("Conmegsec");
      gxTv_SdtConcepto_MotivosEgreso_Conmegsec = value ;
   }

   public String getgxTv_SdtConcepto_MotivosEgreso_Megpreatipo( )
   {
      return gxTv_SdtConcepto_MotivosEgreso_Megpreatipo ;
   }

   public void setgxTv_SdtConcepto_MotivosEgreso_Megpreatipo( String value )
   {
      gxTv_SdtConcepto_MotivosEgreso_N = (byte)(0) ;
      gxTv_SdtConcepto_MotivosEgreso_Modified = (short)(1) ;
      SetDirty("Megpreatipo");
      gxTv_SdtConcepto_MotivosEgreso_Megpreatipo = value ;
   }

   public byte getgxTv_SdtConcepto_MotivosEgreso_Conmegmeses( )
   {
      return gxTv_SdtConcepto_MotivosEgreso_Conmegmeses ;
   }

   public void setgxTv_SdtConcepto_MotivosEgreso_Conmegmeses( byte value )
   {
      gxTv_SdtConcepto_MotivosEgreso_N = (byte)(0) ;
      gxTv_SdtConcepto_MotivosEgreso_Modified = (short)(1) ;
      SetDirty("Conmegmeses");
      gxTv_SdtConcepto_MotivosEgreso_Conmegmeses = value ;
   }

   public String getgxTv_SdtConcepto_MotivosEgreso_Conmegdura( )
   {
      return gxTv_SdtConcepto_MotivosEgreso_Conmegdura ;
   }

   public void setgxTv_SdtConcepto_MotivosEgreso_Conmegdura( String value )
   {
      gxTv_SdtConcepto_MotivosEgreso_N = (byte)(0) ;
      gxTv_SdtConcepto_MotivosEgreso_Modified = (short)(1) ;
      SetDirty("Conmegdura");
      gxTv_SdtConcepto_MotivosEgreso_Conmegdura = value ;
   }

   public java.math.BigDecimal getgxTv_SdtConcepto_MotivosEgreso_Conmegpropor( )
   {
      return gxTv_SdtConcepto_MotivosEgreso_Conmegpropor ;
   }

   public void setgxTv_SdtConcepto_MotivosEgreso_Conmegpropor( java.math.BigDecimal value )
   {
      gxTv_SdtConcepto_MotivosEgreso_N = (byte)(0) ;
      gxTv_SdtConcepto_MotivosEgreso_Modified = (short)(1) ;
      SetDirty("Conmegpropor");
      gxTv_SdtConcepto_MotivosEgreso_Conmegpropor = value ;
   }

   public String getgxTv_SdtConcepto_MotivosEgreso_Mode( )
   {
      return gxTv_SdtConcepto_MotivosEgreso_Mode ;
   }

   public void setgxTv_SdtConcepto_MotivosEgreso_Mode( String value )
   {
      gxTv_SdtConcepto_MotivosEgreso_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_SdtConcepto_MotivosEgreso_Mode = value ;
   }

   public void setgxTv_SdtConcepto_MotivosEgreso_Mode_SetNull( )
   {
      gxTv_SdtConcepto_MotivosEgreso_Mode = "" ;
      SetDirty("Mode");
   }

   public boolean getgxTv_SdtConcepto_MotivosEgreso_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtConcepto_MotivosEgreso_Modified( )
   {
      return gxTv_SdtConcepto_MotivosEgreso_Modified ;
   }

   public void setgxTv_SdtConcepto_MotivosEgreso_Modified( short value )
   {
      gxTv_SdtConcepto_MotivosEgreso_N = (byte)(0) ;
      SetDirty("Modified");
      gxTv_SdtConcepto_MotivosEgreso_Modified = value ;
   }

   public void setgxTv_SdtConcepto_MotivosEgreso_Modified_SetNull( )
   {
      gxTv_SdtConcepto_MotivosEgreso_Modified = (short)(0) ;
      SetDirty("Modified");
   }

   public boolean getgxTv_SdtConcepto_MotivosEgreso_Modified_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtConcepto_MotivosEgreso_Initialized( )
   {
      return gxTv_SdtConcepto_MotivosEgreso_Initialized ;
   }

   public void setgxTv_SdtConcepto_MotivosEgreso_Initialized( short value )
   {
      gxTv_SdtConcepto_MotivosEgreso_N = (byte)(0) ;
      gxTv_SdtConcepto_MotivosEgreso_Modified = (short)(1) ;
      SetDirty("Initialized");
      gxTv_SdtConcepto_MotivosEgreso_Initialized = value ;
   }

   public void setgxTv_SdtConcepto_MotivosEgreso_Initialized_SetNull( )
   {
      gxTv_SdtConcepto_MotivosEgreso_Initialized = (short)(0) ;
      SetDirty("Initialized");
   }

   public boolean getgxTv_SdtConcepto_MotivosEgreso_Initialized_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtConcepto_MotivosEgreso_Megcodigo_Z( )
   {
      return gxTv_SdtConcepto_MotivosEgreso_Megcodigo_Z ;
   }

   public void setgxTv_SdtConcepto_MotivosEgreso_Megcodigo_Z( String value )
   {
      gxTv_SdtConcepto_MotivosEgreso_N = (byte)(0) ;
      gxTv_SdtConcepto_MotivosEgreso_Modified = (short)(1) ;
      SetDirty("Megcodigo_Z");
      gxTv_SdtConcepto_MotivosEgreso_Megcodigo_Z = value ;
   }

   public void setgxTv_SdtConcepto_MotivosEgreso_Megcodigo_Z_SetNull( )
   {
      gxTv_SdtConcepto_MotivosEgreso_Megcodigo_Z = "" ;
      SetDirty("Megcodigo_Z");
   }

   public boolean getgxTv_SdtConcepto_MotivosEgreso_Megcodigo_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtConcepto_MotivosEgreso_Conmegsec_Z( )
   {
      return gxTv_SdtConcepto_MotivosEgreso_Conmegsec_Z ;
   }

   public void setgxTv_SdtConcepto_MotivosEgreso_Conmegsec_Z( short value )
   {
      gxTv_SdtConcepto_MotivosEgreso_N = (byte)(0) ;
      gxTv_SdtConcepto_MotivosEgreso_Modified = (short)(1) ;
      SetDirty("Conmegsec_Z");
      gxTv_SdtConcepto_MotivosEgreso_Conmegsec_Z = value ;
   }

   public void setgxTv_SdtConcepto_MotivosEgreso_Conmegsec_Z_SetNull( )
   {
      gxTv_SdtConcepto_MotivosEgreso_Conmegsec_Z = (short)(0) ;
      SetDirty("Conmegsec_Z");
   }

   public boolean getgxTv_SdtConcepto_MotivosEgreso_Conmegsec_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtConcepto_MotivosEgreso_Megpreatipo_Z( )
   {
      return gxTv_SdtConcepto_MotivosEgreso_Megpreatipo_Z ;
   }

   public void setgxTv_SdtConcepto_MotivosEgreso_Megpreatipo_Z( String value )
   {
      gxTv_SdtConcepto_MotivosEgreso_N = (byte)(0) ;
      gxTv_SdtConcepto_MotivosEgreso_Modified = (short)(1) ;
      SetDirty("Megpreatipo_Z");
      gxTv_SdtConcepto_MotivosEgreso_Megpreatipo_Z = value ;
   }

   public void setgxTv_SdtConcepto_MotivosEgreso_Megpreatipo_Z_SetNull( )
   {
      gxTv_SdtConcepto_MotivosEgreso_Megpreatipo_Z = "" ;
      SetDirty("Megpreatipo_Z");
   }

   public boolean getgxTv_SdtConcepto_MotivosEgreso_Megpreatipo_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtConcepto_MotivosEgreso_Conmegmeses_Z( )
   {
      return gxTv_SdtConcepto_MotivosEgreso_Conmegmeses_Z ;
   }

   public void setgxTv_SdtConcepto_MotivosEgreso_Conmegmeses_Z( byte value )
   {
      gxTv_SdtConcepto_MotivosEgreso_N = (byte)(0) ;
      gxTv_SdtConcepto_MotivosEgreso_Modified = (short)(1) ;
      SetDirty("Conmegmeses_Z");
      gxTv_SdtConcepto_MotivosEgreso_Conmegmeses_Z = value ;
   }

   public void setgxTv_SdtConcepto_MotivosEgreso_Conmegmeses_Z_SetNull( )
   {
      gxTv_SdtConcepto_MotivosEgreso_Conmegmeses_Z = (byte)(0) ;
      SetDirty("Conmegmeses_Z");
   }

   public boolean getgxTv_SdtConcepto_MotivosEgreso_Conmegmeses_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtConcepto_MotivosEgreso_Conmegdura_Z( )
   {
      return gxTv_SdtConcepto_MotivosEgreso_Conmegdura_Z ;
   }

   public void setgxTv_SdtConcepto_MotivosEgreso_Conmegdura_Z( String value )
   {
      gxTv_SdtConcepto_MotivosEgreso_N = (byte)(0) ;
      gxTv_SdtConcepto_MotivosEgreso_Modified = (short)(1) ;
      SetDirty("Conmegdura_Z");
      gxTv_SdtConcepto_MotivosEgreso_Conmegdura_Z = value ;
   }

   public void setgxTv_SdtConcepto_MotivosEgreso_Conmegdura_Z_SetNull( )
   {
      gxTv_SdtConcepto_MotivosEgreso_Conmegdura_Z = "" ;
      SetDirty("Conmegdura_Z");
   }

   public boolean getgxTv_SdtConcepto_MotivosEgreso_Conmegdura_Z_IsNull( )
   {
      return false ;
   }

   public java.math.BigDecimal getgxTv_SdtConcepto_MotivosEgreso_Conmegpropor_Z( )
   {
      return gxTv_SdtConcepto_MotivosEgreso_Conmegpropor_Z ;
   }

   public void setgxTv_SdtConcepto_MotivosEgreso_Conmegpropor_Z( java.math.BigDecimal value )
   {
      gxTv_SdtConcepto_MotivosEgreso_N = (byte)(0) ;
      gxTv_SdtConcepto_MotivosEgreso_Modified = (short)(1) ;
      SetDirty("Conmegpropor_Z");
      gxTv_SdtConcepto_MotivosEgreso_Conmegpropor_Z = value ;
   }

   public void setgxTv_SdtConcepto_MotivosEgreso_Conmegpropor_Z_SetNull( )
   {
      gxTv_SdtConcepto_MotivosEgreso_Conmegpropor_Z = DecimalUtil.ZERO ;
      SetDirty("Conmegpropor_Z");
   }

   public boolean getgxTv_SdtConcepto_MotivosEgreso_Conmegpropor_Z_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtConcepto_MotivosEgreso_Megcodigo = "" ;
      gxTv_SdtConcepto_MotivosEgreso_N = (byte)(1) ;
      gxTv_SdtConcepto_MotivosEgreso_Megpreatipo = "" ;
      gxTv_SdtConcepto_MotivosEgreso_Conmegdura = "" ;
      gxTv_SdtConcepto_MotivosEgreso_Conmegpropor = DecimalUtil.ZERO ;
      gxTv_SdtConcepto_MotivosEgreso_Mode = "" ;
      gxTv_SdtConcepto_MotivosEgreso_Megcodigo_Z = "" ;
      gxTv_SdtConcepto_MotivosEgreso_Megpreatipo_Z = "" ;
      gxTv_SdtConcepto_MotivosEgreso_Conmegdura_Z = "" ;
      gxTv_SdtConcepto_MotivosEgreso_Conmegpropor_Z = DecimalUtil.ZERO ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtConcepto_MotivosEgreso_N ;
   }

   public web.SdtConcepto_MotivosEgreso Clone( )
   {
      return (web.SdtConcepto_MotivosEgreso)(clone()) ;
   }

   public void setStruct( web.StructSdtConcepto_MotivosEgreso struct )
   {
      setgxTv_SdtConcepto_MotivosEgreso_Megcodigo(struct.getMegcodigo());
      setgxTv_SdtConcepto_MotivosEgreso_Conmegsec(struct.getConmegsec());
      setgxTv_SdtConcepto_MotivosEgreso_Megpreatipo(struct.getMegpreatipo());
      setgxTv_SdtConcepto_MotivosEgreso_Conmegmeses(struct.getConmegmeses());
      setgxTv_SdtConcepto_MotivosEgreso_Conmegdura(struct.getConmegdura());
      setgxTv_SdtConcepto_MotivosEgreso_Conmegpropor(struct.getConmegpropor());
      setgxTv_SdtConcepto_MotivosEgreso_Mode(struct.getMode());
      setgxTv_SdtConcepto_MotivosEgreso_Modified(struct.getModified());
      setgxTv_SdtConcepto_MotivosEgreso_Initialized(struct.getInitialized());
      setgxTv_SdtConcepto_MotivosEgreso_Megcodigo_Z(struct.getMegcodigo_Z());
      setgxTv_SdtConcepto_MotivosEgreso_Conmegsec_Z(struct.getConmegsec_Z());
      setgxTv_SdtConcepto_MotivosEgreso_Megpreatipo_Z(struct.getMegpreatipo_Z());
      setgxTv_SdtConcepto_MotivosEgreso_Conmegmeses_Z(struct.getConmegmeses_Z());
      setgxTv_SdtConcepto_MotivosEgreso_Conmegdura_Z(struct.getConmegdura_Z());
      setgxTv_SdtConcepto_MotivosEgreso_Conmegpropor_Z(struct.getConmegpropor_Z());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtConcepto_MotivosEgreso getStruct( )
   {
      web.StructSdtConcepto_MotivosEgreso struct = new web.StructSdtConcepto_MotivosEgreso ();
      struct.setMegcodigo(getgxTv_SdtConcepto_MotivosEgreso_Megcodigo());
      struct.setConmegsec(getgxTv_SdtConcepto_MotivosEgreso_Conmegsec());
      struct.setMegpreatipo(getgxTv_SdtConcepto_MotivosEgreso_Megpreatipo());
      struct.setConmegmeses(getgxTv_SdtConcepto_MotivosEgreso_Conmegmeses());
      struct.setConmegdura(getgxTv_SdtConcepto_MotivosEgreso_Conmegdura());
      struct.setConmegpropor(getgxTv_SdtConcepto_MotivosEgreso_Conmegpropor());
      struct.setMode(getgxTv_SdtConcepto_MotivosEgreso_Mode());
      struct.setModified(getgxTv_SdtConcepto_MotivosEgreso_Modified());
      struct.setInitialized(getgxTv_SdtConcepto_MotivosEgreso_Initialized());
      struct.setMegcodigo_Z(getgxTv_SdtConcepto_MotivosEgreso_Megcodigo_Z());
      struct.setConmegsec_Z(getgxTv_SdtConcepto_MotivosEgreso_Conmegsec_Z());
      struct.setMegpreatipo_Z(getgxTv_SdtConcepto_MotivosEgreso_Megpreatipo_Z());
      struct.setConmegmeses_Z(getgxTv_SdtConcepto_MotivosEgreso_Conmegmeses_Z());
      struct.setConmegdura_Z(getgxTv_SdtConcepto_MotivosEgreso_Conmegdura_Z());
      struct.setConmegpropor_Z(getgxTv_SdtConcepto_MotivosEgreso_Conmegpropor_Z());
      return struct ;
   }

   private byte gxTv_SdtConcepto_MotivosEgreso_N ;
   private byte gxTv_SdtConcepto_MotivosEgreso_Conmegmeses ;
   private byte gxTv_SdtConcepto_MotivosEgreso_Conmegmeses_Z ;
   private short gxTv_SdtConcepto_MotivosEgreso_Conmegsec ;
   private short gxTv_SdtConcepto_MotivosEgreso_Modified ;
   private short gxTv_SdtConcepto_MotivosEgreso_Initialized ;
   private short gxTv_SdtConcepto_MotivosEgreso_Conmegsec_Z ;
   private short readOk ;
   private short nOutParmCount ;
   private java.math.BigDecimal gxTv_SdtConcepto_MotivosEgreso_Conmegpropor ;
   private java.math.BigDecimal gxTv_SdtConcepto_MotivosEgreso_Conmegpropor_Z ;
   private String gxTv_SdtConcepto_MotivosEgreso_Megcodigo ;
   private String gxTv_SdtConcepto_MotivosEgreso_Megpreatipo ;
   private String gxTv_SdtConcepto_MotivosEgreso_Conmegdura ;
   private String gxTv_SdtConcepto_MotivosEgreso_Mode ;
   private String gxTv_SdtConcepto_MotivosEgreso_Megcodigo_Z ;
   private String gxTv_SdtConcepto_MotivosEgreso_Megpreatipo_Z ;
   private String gxTv_SdtConcepto_MotivosEgreso_Conmegdura_Z ;
   private String sTagName ;
   private boolean readElement ;
   private boolean formatError ;
}

