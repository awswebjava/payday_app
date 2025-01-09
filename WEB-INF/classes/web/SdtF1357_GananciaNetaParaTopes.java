package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtF1357_GananciaNetaParaTopes extends GxUserType
{
   public SdtF1357_GananciaNetaParaTopes( )
   {
      this(  new ModelContext(SdtF1357_GananciaNetaParaTopes.class));
   }

   public SdtF1357_GananciaNetaParaTopes( ModelContext context )
   {
      super( context, "SdtF1357_GananciaNetaParaTopes");
   }

   public SdtF1357_GananciaNetaParaTopes( int remoteHandle ,
                                          ModelContext context )
   {
      super( remoteHandle, context, "SdtF1357_GananciaNetaParaTopes");
   }

   public SdtF1357_GananciaNetaParaTopes( StructSdtF1357_GananciaNetaParaTopes struct )
   {
      this();
      setStruct(struct);
   }

   private static java.util.HashMap mapper = new java.util.HashMap();
   static
   {
   }

   public String getJsonMap( String value )
   {
      return (String) mapper.get(value);
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "F1357LRGravada") )
            {
               gxTv_SdtF1357_GananciaNetaParaTopes_F1357lrgravada = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "DescuentosDeLey") )
            {
               gxTv_SdtF1357_GananciaNetaParaTopes_Descuentosdeley = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "F1357LDGSeguro") )
            {
               gxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgseguro = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "F1357LDGSeguMixto") )
            {
               gxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgsegumixto = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "F1357LDGRetPriv") )
            {
               gxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgretpriv = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "F1357LDGCuotapartes") )
            {
               gxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgcuotapartes = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "F1357LDGSepelio") )
            {
               gxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgsepelio = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "F1357LDGRodado") )
            {
               gxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgrodado = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "F1357LDGOblig") )
            {
               gxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgoblig = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "F1357LDGHipoteca") )
            {
               gxTv_SdtF1357_GananciaNetaParaTopes_F1357ldghipoteca = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "F1357LDGSGR") )
            {
               gxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgsgr = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "F1357LDGDomes") )
            {
               gxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgdomes = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "F1357LDGAlquiler") )
            {
               gxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgalquiler = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "F1357LDGViaticos") )
            {
               gxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgviaticos = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "F1357LDGIndu") )
            {
               gxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgindu = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "F1357LDGOtras") )
            {
               gxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgotras = DecimalUtil.stringToDec( oReader.getValue()) ;
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
         sName = "F1357_GananciaNetaParaTopes" ;
      }
      if ( (GXutil.strcmp("", sNameSpace)==0) )
      {
         sNameSpace = "PayDay" ;
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
      oWriter.writeElement("F1357LRGravada", GXutil.trim( GXutil.strNoRound( gxTv_SdtF1357_GananciaNetaParaTopes_F1357lrgravada, 16, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("DescuentosDeLey", GXutil.trim( GXutil.strNoRound( gxTv_SdtF1357_GananciaNetaParaTopes_Descuentosdeley, 16, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("F1357LDGSeguro", GXutil.trim( GXutil.strNoRound( gxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgseguro, 16, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("F1357LDGSeguMixto", GXutil.trim( GXutil.strNoRound( gxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgsegumixto, 16, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("F1357LDGRetPriv", GXutil.trim( GXutil.strNoRound( gxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgretpriv, 16, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("F1357LDGCuotapartes", GXutil.trim( GXutil.strNoRound( gxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgcuotapartes, 16, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("F1357LDGSepelio", GXutil.trim( GXutil.strNoRound( gxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgsepelio, 16, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("F1357LDGRodado", GXutil.trim( GXutil.strNoRound( gxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgrodado, 16, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("F1357LDGOblig", GXutil.trim( GXutil.strNoRound( gxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgoblig, 16, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("F1357LDGHipoteca", GXutil.trim( GXutil.strNoRound( gxTv_SdtF1357_GananciaNetaParaTopes_F1357ldghipoteca, 16, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("F1357LDGSGR", GXutil.trim( GXutil.strNoRound( gxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgsgr, 16, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("F1357LDGDomes", GXutil.trim( GXutil.strNoRound( gxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgdomes, 16, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("F1357LDGAlquiler", GXutil.trim( GXutil.strNoRound( gxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgalquiler, 16, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("F1357LDGViaticos", GXutil.trim( GXutil.strNoRound( gxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgviaticos, 16, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("F1357LDGIndu", GXutil.trim( GXutil.strNoRound( gxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgindu, 16, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("F1357LDGOtras", GXutil.trim( GXutil.strNoRound( gxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgotras, 16, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeEndElement();
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
      AddObjectProperty("F1357LRGravada", GXutil.ltrim( GXutil.strNoRound( gxTv_SdtF1357_GananciaNetaParaTopes_F1357lrgravada, 16, 2)), false, false);
      AddObjectProperty("DescuentosDeLey", GXutil.ltrim( GXutil.strNoRound( gxTv_SdtF1357_GananciaNetaParaTopes_Descuentosdeley, 16, 2)), false, false);
      AddObjectProperty("F1357LDGSeguro", GXutil.ltrim( GXutil.strNoRound( gxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgseguro, 16, 2)), false, false);
      AddObjectProperty("F1357LDGSeguMixto", GXutil.ltrim( GXutil.strNoRound( gxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgsegumixto, 16, 2)), false, false);
      AddObjectProperty("F1357LDGRetPriv", GXutil.ltrim( GXutil.strNoRound( gxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgretpriv, 16, 2)), false, false);
      AddObjectProperty("F1357LDGCuotapartes", GXutil.ltrim( GXutil.strNoRound( gxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgcuotapartes, 16, 2)), false, false);
      AddObjectProperty("F1357LDGSepelio", GXutil.ltrim( GXutil.strNoRound( gxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgsepelio, 16, 2)), false, false);
      AddObjectProperty("F1357LDGRodado", GXutil.ltrim( GXutil.strNoRound( gxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgrodado, 16, 2)), false, false);
      AddObjectProperty("F1357LDGOblig", GXutil.ltrim( GXutil.strNoRound( gxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgoblig, 16, 2)), false, false);
      AddObjectProperty("F1357LDGHipoteca", GXutil.ltrim( GXutil.strNoRound( gxTv_SdtF1357_GananciaNetaParaTopes_F1357ldghipoteca, 16, 2)), false, false);
      AddObjectProperty("F1357LDGSGR", GXutil.ltrim( GXutil.strNoRound( gxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgsgr, 16, 2)), false, false);
      AddObjectProperty("F1357LDGDomes", GXutil.ltrim( GXutil.strNoRound( gxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgdomes, 16, 2)), false, false);
      AddObjectProperty("F1357LDGAlquiler", GXutil.ltrim( GXutil.strNoRound( gxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgalquiler, 16, 2)), false, false);
      AddObjectProperty("F1357LDGViaticos", GXutil.ltrim( GXutil.strNoRound( gxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgviaticos, 16, 2)), false, false);
      AddObjectProperty("F1357LDGIndu", GXutil.ltrim( GXutil.strNoRound( gxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgindu, 16, 2)), false, false);
      AddObjectProperty("F1357LDGOtras", GXutil.ltrim( GXutil.strNoRound( gxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgotras, 16, 2)), false, false);
   }

   public java.math.BigDecimal getgxTv_SdtF1357_GananciaNetaParaTopes_F1357lrgravada( )
   {
      return gxTv_SdtF1357_GananciaNetaParaTopes_F1357lrgravada ;
   }

   public void setgxTv_SdtF1357_GananciaNetaParaTopes_F1357lrgravada( java.math.BigDecimal value )
   {
      gxTv_SdtF1357_GananciaNetaParaTopes_N = (byte)(0) ;
      gxTv_SdtF1357_GananciaNetaParaTopes_F1357lrgravada = value ;
   }

   public java.math.BigDecimal getgxTv_SdtF1357_GananciaNetaParaTopes_Descuentosdeley( )
   {
      return gxTv_SdtF1357_GananciaNetaParaTopes_Descuentosdeley ;
   }

   public void setgxTv_SdtF1357_GananciaNetaParaTopes_Descuentosdeley( java.math.BigDecimal value )
   {
      gxTv_SdtF1357_GananciaNetaParaTopes_N = (byte)(0) ;
      gxTv_SdtF1357_GananciaNetaParaTopes_Descuentosdeley = value ;
   }

   public java.math.BigDecimal getgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgseguro( )
   {
      return gxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgseguro ;
   }

   public void setgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgseguro( java.math.BigDecimal value )
   {
      gxTv_SdtF1357_GananciaNetaParaTopes_N = (byte)(0) ;
      gxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgseguro = value ;
   }

   public java.math.BigDecimal getgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgsegumixto( )
   {
      return gxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgsegumixto ;
   }

   public void setgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgsegumixto( java.math.BigDecimal value )
   {
      gxTv_SdtF1357_GananciaNetaParaTopes_N = (byte)(0) ;
      gxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgsegumixto = value ;
   }

   public java.math.BigDecimal getgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgretpriv( )
   {
      return gxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgretpriv ;
   }

   public void setgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgretpriv( java.math.BigDecimal value )
   {
      gxTv_SdtF1357_GananciaNetaParaTopes_N = (byte)(0) ;
      gxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgretpriv = value ;
   }

   public java.math.BigDecimal getgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgcuotapartes( )
   {
      return gxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgcuotapartes ;
   }

   public void setgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgcuotapartes( java.math.BigDecimal value )
   {
      gxTv_SdtF1357_GananciaNetaParaTopes_N = (byte)(0) ;
      gxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgcuotapartes = value ;
   }

   public java.math.BigDecimal getgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgsepelio( )
   {
      return gxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgsepelio ;
   }

   public void setgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgsepelio( java.math.BigDecimal value )
   {
      gxTv_SdtF1357_GananciaNetaParaTopes_N = (byte)(0) ;
      gxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgsepelio = value ;
   }

   public java.math.BigDecimal getgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgrodado( )
   {
      return gxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgrodado ;
   }

   public void setgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgrodado( java.math.BigDecimal value )
   {
      gxTv_SdtF1357_GananciaNetaParaTopes_N = (byte)(0) ;
      gxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgrodado = value ;
   }

   public java.math.BigDecimal getgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgoblig( )
   {
      return gxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgoblig ;
   }

   public void setgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgoblig( java.math.BigDecimal value )
   {
      gxTv_SdtF1357_GananciaNetaParaTopes_N = (byte)(0) ;
      gxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgoblig = value ;
   }

   public java.math.BigDecimal getgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldghipoteca( )
   {
      return gxTv_SdtF1357_GananciaNetaParaTopes_F1357ldghipoteca ;
   }

   public void setgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldghipoteca( java.math.BigDecimal value )
   {
      gxTv_SdtF1357_GananciaNetaParaTopes_N = (byte)(0) ;
      gxTv_SdtF1357_GananciaNetaParaTopes_F1357ldghipoteca = value ;
   }

   public java.math.BigDecimal getgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgsgr( )
   {
      return gxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgsgr ;
   }

   public void setgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgsgr( java.math.BigDecimal value )
   {
      gxTv_SdtF1357_GananciaNetaParaTopes_N = (byte)(0) ;
      gxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgsgr = value ;
   }

   public java.math.BigDecimal getgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgdomes( )
   {
      return gxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgdomes ;
   }

   public void setgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgdomes( java.math.BigDecimal value )
   {
      gxTv_SdtF1357_GananciaNetaParaTopes_N = (byte)(0) ;
      gxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgdomes = value ;
   }

   public java.math.BigDecimal getgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgalquiler( )
   {
      return gxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgalquiler ;
   }

   public void setgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgalquiler( java.math.BigDecimal value )
   {
      gxTv_SdtF1357_GananciaNetaParaTopes_N = (byte)(0) ;
      gxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgalquiler = value ;
   }

   public java.math.BigDecimal getgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgviaticos( )
   {
      return gxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgviaticos ;
   }

   public void setgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgviaticos( java.math.BigDecimal value )
   {
      gxTv_SdtF1357_GananciaNetaParaTopes_N = (byte)(0) ;
      gxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgviaticos = value ;
   }

   public java.math.BigDecimal getgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgindu( )
   {
      return gxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgindu ;
   }

   public void setgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgindu( java.math.BigDecimal value )
   {
      gxTv_SdtF1357_GananciaNetaParaTopes_N = (byte)(0) ;
      gxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgindu = value ;
   }

   public java.math.BigDecimal getgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgotras( )
   {
      return gxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgotras ;
   }

   public void setgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgotras( java.math.BigDecimal value )
   {
      gxTv_SdtF1357_GananciaNetaParaTopes_N = (byte)(0) ;
      gxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgotras = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtF1357_GananciaNetaParaTopes_F1357lrgravada = DecimalUtil.ZERO ;
      gxTv_SdtF1357_GananciaNetaParaTopes_N = (byte)(1) ;
      gxTv_SdtF1357_GananciaNetaParaTopes_Descuentosdeley = DecimalUtil.ZERO ;
      gxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgseguro = DecimalUtil.ZERO ;
      gxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgsegumixto = DecimalUtil.ZERO ;
      gxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgretpriv = DecimalUtil.ZERO ;
      gxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgcuotapartes = DecimalUtil.ZERO ;
      gxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgsepelio = DecimalUtil.ZERO ;
      gxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgrodado = DecimalUtil.ZERO ;
      gxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgoblig = DecimalUtil.ZERO ;
      gxTv_SdtF1357_GananciaNetaParaTopes_F1357ldghipoteca = DecimalUtil.ZERO ;
      gxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgsgr = DecimalUtil.ZERO ;
      gxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgdomes = DecimalUtil.ZERO ;
      gxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgalquiler = DecimalUtil.ZERO ;
      gxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgviaticos = DecimalUtil.ZERO ;
      gxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgindu = DecimalUtil.ZERO ;
      gxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgotras = DecimalUtil.ZERO ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtF1357_GananciaNetaParaTopes_N ;
   }

   public web.SdtF1357_GananciaNetaParaTopes Clone( )
   {
      return (web.SdtF1357_GananciaNetaParaTopes)(clone()) ;
   }

   public void setStruct( web.StructSdtF1357_GananciaNetaParaTopes struct )
   {
      setgxTv_SdtF1357_GananciaNetaParaTopes_F1357lrgravada(struct.getF1357lrgravada());
      setgxTv_SdtF1357_GananciaNetaParaTopes_Descuentosdeley(struct.getDescuentosdeley());
      setgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgseguro(struct.getF1357ldgseguro());
      setgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgsegumixto(struct.getF1357ldgsegumixto());
      setgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgretpriv(struct.getF1357ldgretpriv());
      setgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgcuotapartes(struct.getF1357ldgcuotapartes());
      setgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgsepelio(struct.getF1357ldgsepelio());
      setgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgrodado(struct.getF1357ldgrodado());
      setgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgoblig(struct.getF1357ldgoblig());
      setgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldghipoteca(struct.getF1357ldghipoteca());
      setgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgsgr(struct.getF1357ldgsgr());
      setgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgdomes(struct.getF1357ldgdomes());
      setgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgalquiler(struct.getF1357ldgalquiler());
      setgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgviaticos(struct.getF1357ldgviaticos());
      setgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgindu(struct.getF1357ldgindu());
      setgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgotras(struct.getF1357ldgotras());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtF1357_GananciaNetaParaTopes getStruct( )
   {
      web.StructSdtF1357_GananciaNetaParaTopes struct = new web.StructSdtF1357_GananciaNetaParaTopes ();
      struct.setF1357lrgravada(getgxTv_SdtF1357_GananciaNetaParaTopes_F1357lrgravada());
      struct.setDescuentosdeley(getgxTv_SdtF1357_GananciaNetaParaTopes_Descuentosdeley());
      struct.setF1357ldgseguro(getgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgseguro());
      struct.setF1357ldgsegumixto(getgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgsegumixto());
      struct.setF1357ldgretpriv(getgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgretpriv());
      struct.setF1357ldgcuotapartes(getgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgcuotapartes());
      struct.setF1357ldgsepelio(getgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgsepelio());
      struct.setF1357ldgrodado(getgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgrodado());
      struct.setF1357ldgoblig(getgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgoblig());
      struct.setF1357ldghipoteca(getgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldghipoteca());
      struct.setF1357ldgsgr(getgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgsgr());
      struct.setF1357ldgdomes(getgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgdomes());
      struct.setF1357ldgalquiler(getgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgalquiler());
      struct.setF1357ldgviaticos(getgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgviaticos());
      struct.setF1357ldgindu(getgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgindu());
      struct.setF1357ldgotras(getgxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgotras());
      return struct ;
   }

   protected byte gxTv_SdtF1357_GananciaNetaParaTopes_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected java.math.BigDecimal gxTv_SdtF1357_GananciaNetaParaTopes_F1357lrgravada ;
   protected java.math.BigDecimal gxTv_SdtF1357_GananciaNetaParaTopes_Descuentosdeley ;
   protected java.math.BigDecimal gxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgseguro ;
   protected java.math.BigDecimal gxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgsegumixto ;
   protected java.math.BigDecimal gxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgretpriv ;
   protected java.math.BigDecimal gxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgcuotapartes ;
   protected java.math.BigDecimal gxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgsepelio ;
   protected java.math.BigDecimal gxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgrodado ;
   protected java.math.BigDecimal gxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgoblig ;
   protected java.math.BigDecimal gxTv_SdtF1357_GananciaNetaParaTopes_F1357ldghipoteca ;
   protected java.math.BigDecimal gxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgsgr ;
   protected java.math.BigDecimal gxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgdomes ;
   protected java.math.BigDecimal gxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgalquiler ;
   protected java.math.BigDecimal gxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgviaticos ;
   protected java.math.BigDecimal gxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgindu ;
   protected java.math.BigDecimal gxTv_SdtF1357_GananciaNetaParaTopes_F1357ldgotras ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
}

