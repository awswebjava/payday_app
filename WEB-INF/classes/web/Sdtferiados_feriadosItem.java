package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdtferiados_feriadosItem extends GxUserType
{
   public Sdtferiados_feriadosItem( )
   {
      this(  new ModelContext(Sdtferiados_feriadosItem.class));
   }

   public Sdtferiados_feriadosItem( ModelContext context )
   {
      super( context, "Sdtferiados_feriadosItem");
   }

   public Sdtferiados_feriadosItem( int remoteHandle ,
                                    ModelContext context )
   {
      super( remoteHandle, context, "Sdtferiados_feriadosItem");
   }

   public Sdtferiados_feriadosItem( StructSdtferiados_feriadosItem struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "motivo") )
            {
               gxTv_Sdtferiados_feriadosItem_Motivo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "tipo") )
            {
               gxTv_Sdtferiados_feriadosItem_Tipo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "info") )
            {
               gxTv_Sdtferiados_feriadosItem_Info = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "dia") )
            {
               gxTv_Sdtferiados_feriadosItem_Dia = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "mes") )
            {
               gxTv_Sdtferiados_feriadosItem_Mes = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "id") )
            {
               gxTv_Sdtferiados_feriadosItem_Id = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "original") )
            {
               gxTv_Sdtferiados_feriadosItem_Original = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "religion") )
            {
               gxTv_Sdtferiados_feriadosItem_Religion = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "origen") )
            {
               gxTv_Sdtferiados_feriadosItem_Origen = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "convenio") )
            {
               gxTv_Sdtferiados_feriadosItem_Convenio = oReader.getValue() ;
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
         sName = "feriados.feriadosItem" ;
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
      oWriter.writeElement("motivo", gxTv_Sdtferiados_feriadosItem_Motivo);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("tipo", gxTv_Sdtferiados_feriadosItem_Tipo);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("info", gxTv_Sdtferiados_feriadosItem_Info);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("dia", GXutil.trim( GXutil.strNoRound( gxTv_Sdtferiados_feriadosItem_Dia, 10, 5)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("mes", GXutil.trim( GXutil.strNoRound( gxTv_Sdtferiados_feriadosItem_Mes, 10, 5)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("id", gxTv_Sdtferiados_feriadosItem_Id);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("original", gxTv_Sdtferiados_feriadosItem_Original);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("religion", gxTv_Sdtferiados_feriadosItem_Religion);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("origen", gxTv_Sdtferiados_feriadosItem_Origen);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("convenio", gxTv_Sdtferiados_feriadosItem_Convenio);
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
      AddObjectProperty("motivo", gxTv_Sdtferiados_feriadosItem_Motivo, false, false);
      AddObjectProperty("tipo", gxTv_Sdtferiados_feriadosItem_Tipo, false, false);
      AddObjectProperty("info", gxTv_Sdtferiados_feriadosItem_Info, false, false);
      AddObjectProperty("dia", gxTv_Sdtferiados_feriadosItem_Dia, false, false);
      AddObjectProperty("mes", gxTv_Sdtferiados_feriadosItem_Mes, false, false);
      AddObjectProperty("id", gxTv_Sdtferiados_feriadosItem_Id, false, false);
      AddObjectProperty("original", gxTv_Sdtferiados_feriadosItem_Original, false, false);
      AddObjectProperty("religion", gxTv_Sdtferiados_feriadosItem_Religion, false, false);
      AddObjectProperty("origen", gxTv_Sdtferiados_feriadosItem_Origen, false, false);
      AddObjectProperty("convenio", gxTv_Sdtferiados_feriadosItem_Convenio, false, false);
   }

   public String getgxTv_Sdtferiados_feriadosItem_Motivo( )
   {
      return gxTv_Sdtferiados_feriadosItem_Motivo ;
   }

   public void setgxTv_Sdtferiados_feriadosItem_Motivo( String value )
   {
      gxTv_Sdtferiados_feriadosItem_N = (byte)(0) ;
      gxTv_Sdtferiados_feriadosItem_Motivo = value ;
   }

   public String getgxTv_Sdtferiados_feriadosItem_Tipo( )
   {
      return gxTv_Sdtferiados_feriadosItem_Tipo ;
   }

   public void setgxTv_Sdtferiados_feriadosItem_Tipo( String value )
   {
      gxTv_Sdtferiados_feriadosItem_N = (byte)(0) ;
      gxTv_Sdtferiados_feriadosItem_Tipo = value ;
   }

   public String getgxTv_Sdtferiados_feriadosItem_Info( )
   {
      return gxTv_Sdtferiados_feriadosItem_Info ;
   }

   public void setgxTv_Sdtferiados_feriadosItem_Info( String value )
   {
      gxTv_Sdtferiados_feriadosItem_N = (byte)(0) ;
      gxTv_Sdtferiados_feriadosItem_Info = value ;
   }

   public java.math.BigDecimal getgxTv_Sdtferiados_feriadosItem_Dia( )
   {
      return gxTv_Sdtferiados_feriadosItem_Dia ;
   }

   public void setgxTv_Sdtferiados_feriadosItem_Dia( java.math.BigDecimal value )
   {
      gxTv_Sdtferiados_feriadosItem_N = (byte)(0) ;
      gxTv_Sdtferiados_feriadosItem_Dia = value ;
   }

   public java.math.BigDecimal getgxTv_Sdtferiados_feriadosItem_Mes( )
   {
      return gxTv_Sdtferiados_feriadosItem_Mes ;
   }

   public void setgxTv_Sdtferiados_feriadosItem_Mes( java.math.BigDecimal value )
   {
      gxTv_Sdtferiados_feriadosItem_N = (byte)(0) ;
      gxTv_Sdtferiados_feriadosItem_Mes = value ;
   }

   public String getgxTv_Sdtferiados_feriadosItem_Id( )
   {
      return gxTv_Sdtferiados_feriadosItem_Id ;
   }

   public void setgxTv_Sdtferiados_feriadosItem_Id( String value )
   {
      gxTv_Sdtferiados_feriadosItem_N = (byte)(0) ;
      gxTv_Sdtferiados_feriadosItem_Id = value ;
   }

   public String getgxTv_Sdtferiados_feriadosItem_Original( )
   {
      return gxTv_Sdtferiados_feriadosItem_Original ;
   }

   public void setgxTv_Sdtferiados_feriadosItem_Original( String value )
   {
      gxTv_Sdtferiados_feriadosItem_N = (byte)(0) ;
      gxTv_Sdtferiados_feriadosItem_Original = value ;
   }

   public String getgxTv_Sdtferiados_feriadosItem_Religion( )
   {
      return gxTv_Sdtferiados_feriadosItem_Religion ;
   }

   public void setgxTv_Sdtferiados_feriadosItem_Religion( String value )
   {
      gxTv_Sdtferiados_feriadosItem_N = (byte)(0) ;
      gxTv_Sdtferiados_feriadosItem_Religion = value ;
   }

   public String getgxTv_Sdtferiados_feriadosItem_Origen( )
   {
      return gxTv_Sdtferiados_feriadosItem_Origen ;
   }

   public void setgxTv_Sdtferiados_feriadosItem_Origen( String value )
   {
      gxTv_Sdtferiados_feriadosItem_N = (byte)(0) ;
      gxTv_Sdtferiados_feriadosItem_Origen = value ;
   }

   public String getgxTv_Sdtferiados_feriadosItem_Convenio( )
   {
      return gxTv_Sdtferiados_feriadosItem_Convenio ;
   }

   public void setgxTv_Sdtferiados_feriadosItem_Convenio( String value )
   {
      gxTv_Sdtferiados_feriadosItem_N = (byte)(0) ;
      gxTv_Sdtferiados_feriadosItem_Convenio = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_Sdtferiados_feriadosItem_Motivo = "" ;
      gxTv_Sdtferiados_feriadosItem_N = (byte)(1) ;
      gxTv_Sdtferiados_feriadosItem_Tipo = "" ;
      gxTv_Sdtferiados_feriadosItem_Info = "" ;
      gxTv_Sdtferiados_feriadosItem_Dia = DecimalUtil.ZERO ;
      gxTv_Sdtferiados_feriadosItem_Mes = DecimalUtil.ZERO ;
      gxTv_Sdtferiados_feriadosItem_Id = "" ;
      gxTv_Sdtferiados_feriadosItem_Original = "" ;
      gxTv_Sdtferiados_feriadosItem_Religion = "" ;
      gxTv_Sdtferiados_feriadosItem_Origen = "" ;
      gxTv_Sdtferiados_feriadosItem_Convenio = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_Sdtferiados_feriadosItem_N ;
   }

   public web.Sdtferiados_feriadosItem Clone( )
   {
      return (web.Sdtferiados_feriadosItem)(clone()) ;
   }

   public void setStruct( web.StructSdtferiados_feriadosItem struct )
   {
      setgxTv_Sdtferiados_feriadosItem_Motivo(struct.getMotivo());
      setgxTv_Sdtferiados_feriadosItem_Tipo(struct.getTipo());
      setgxTv_Sdtferiados_feriadosItem_Info(struct.getInfo());
      setgxTv_Sdtferiados_feriadosItem_Dia(struct.getDia());
      setgxTv_Sdtferiados_feriadosItem_Mes(struct.getMes());
      setgxTv_Sdtferiados_feriadosItem_Id(struct.getId());
      setgxTv_Sdtferiados_feriadosItem_Original(struct.getOriginal());
      setgxTv_Sdtferiados_feriadosItem_Religion(struct.getReligion());
      setgxTv_Sdtferiados_feriadosItem_Origen(struct.getOrigen());
      setgxTv_Sdtferiados_feriadosItem_Convenio(struct.getConvenio());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtferiados_feriadosItem getStruct( )
   {
      web.StructSdtferiados_feriadosItem struct = new web.StructSdtferiados_feriadosItem ();
      struct.setMotivo(getgxTv_Sdtferiados_feriadosItem_Motivo());
      struct.setTipo(getgxTv_Sdtferiados_feriadosItem_Tipo());
      struct.setInfo(getgxTv_Sdtferiados_feriadosItem_Info());
      struct.setDia(getgxTv_Sdtferiados_feriadosItem_Dia());
      struct.setMes(getgxTv_Sdtferiados_feriadosItem_Mes());
      struct.setId(getgxTv_Sdtferiados_feriadosItem_Id());
      struct.setOriginal(getgxTv_Sdtferiados_feriadosItem_Original());
      struct.setReligion(getgxTv_Sdtferiados_feriadosItem_Religion());
      struct.setOrigen(getgxTv_Sdtferiados_feriadosItem_Origen());
      struct.setConvenio(getgxTv_Sdtferiados_feriadosItem_Convenio());
      return struct ;
   }

   protected byte gxTv_Sdtferiados_feriadosItem_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected java.math.BigDecimal gxTv_Sdtferiados_feriadosItem_Dia ;
   protected java.math.BigDecimal gxTv_Sdtferiados_feriadosItem_Mes ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_Sdtferiados_feriadosItem_Motivo ;
   protected String gxTv_Sdtferiados_feriadosItem_Tipo ;
   protected String gxTv_Sdtferiados_feriadosItem_Info ;
   protected String gxTv_Sdtferiados_feriadosItem_Id ;
   protected String gxTv_Sdtferiados_feriadosItem_Original ;
   protected String gxTv_Sdtferiados_feriadosItem_Religion ;
   protected String gxTv_Sdtferiados_feriadosItem_Origen ;
   protected String gxTv_Sdtferiados_feriadosItem_Convenio ;
}

